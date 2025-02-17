/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2023 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.coz.calabozopixeladodominicano.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Preferences;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.coz.calabozopixeladodominicano.SPDSettings;
import com.coz.calabozopixeladodominicano.CalabozoPixeladoDominicano;
import com.coz.calabozopixeladodominicano.services.news.News;
import com.coz.calabozopixeladodominicano.services.news.NewsImpl;
import com.coz.calabozopixeladodominicano.services.updates.UpdateImpl;
import com.coz.calabozopixeladodominicano.services.updates.Updates;
import com.watabou.noosa.Game;
import com.watabou.utils.CPDExceptionManager;
import com.watabou.utils.FileUtils;
import com.watabou.utils.Point;

import org.lwjgl.util.tinyfd.TinyFileDialogs;

import java.awt.Desktop;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

/**
 * Punto de entrada para abrir el juego en plataformas de escritorio
 */
public final class DesktopLauncher {

	/**
	 * Localización de los datos modificables (como las grabaciones) en el formato que usa libgdx
	 */
	private final class BasePath {
		private String path = "";
		private Files.FileType fileType = null;

		/**
		 * Constructor de BasePath
		 * @param spec_title título de especificación del JAR
		 */
		public BasePath(final String spec_title){
			//if I were implementing this from scratch I would use the full implementation title for saves
			// (e.g. /.shatteredpixel/shatteredpixeldungeon), but we have too much existing save
			// date to worry about transferring at this point.
			String vendor = DesktopLauncher.class.getPackage().getImplementationTitle();
			if (vendor == null) {
				vendor = System.getProperty("Implementation-Title");
			}
			vendor = vendor.split("\\.")[1];

			if (SharedLibraryLoader.isWindows) {
				if (System.getProperties().getProperty("os.name").equals("Windows XP")) {
					path = "Application Data/." + vendor + "/" + spec_title + "/";
				} else {
					path = "AppData/Roaming/." + vendor + "/" + spec_title + "/";
				}
				fileType = Files.FileType.External;
			} else if (SharedLibraryLoader.isMac) {
				path = "Library/Application Support/" + spec_title + "/";
				fileType = Files.FileType.External;
			} else if (SharedLibraryLoader.isLinux) {
				String XDGHome = System.getenv("XDG_DATA_HOME");
				if (XDGHome == null) XDGHome = System.getProperty("user.home") + "/.local/share";

				String titleLinux = spec_title.toLowerCase(Locale.ROOT).replace(" ", "-");
				path = XDGHome + "/." + vendor + "/" + titleLinux + "/";

				fileType = Files.FileType.Absolute;
			}
		}
		public String getPath(){
			return path;
		}

		public Files.FileType getFileType(){
			return fileType;
		}
	}

	/**
	 * Título de especificación generado incluso cuando no hay un manifiesto
	 */
	private final class SpecificationTitle{
		/**
		 * Obtiene el título de especificación del paquete
		 * <p>
		 * Si no está disponible el título de especificación desde el paquete, se toma de un propiedad especificada
		 * por el sistema de construcción de la applicación
		 * @return título de especificación
		 */
		public String getSpecTitle(){
			if (DesktopLauncher.class.getPackage().getSpecificationTitle() == null){
				return System.getProperty("Specification-Title");
			} else {
				return DesktopLauncher.class.getPackage().getSpecificationTitle();
			}
		}
	}

	public static void main (String[] args) {

		if (!DesktopLaunchValidator.verifyValidJVMState(args)){
			return;
		}

		//detection for FreeBSD (which is equivalent to linux for us)
		//TODO might want to merge request this to libGDX
		if (System.getProperty("os.name").contains("FreeBSD")) {
			SharedLibraryLoader.isLinux = true;
			//this overrides incorrect values set in SharedLibraryLoader's static initializer
			SharedLibraryLoader.isIos = false;
			SharedLibraryLoader.is64Bit = System.getProperty("os.arch").contains("64") || System.getProperty("os.arch").startsWith("armv8");
		}

		DesktopLauncher launcher = new DesktopLauncher();
		SpecificationTitle title = launcher.new SpecificationTitle();

		//TODO: maybe this would be better suited for the CPDExceptionHandler

		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				CPDExceptionManager.report(throwable);
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				throwable.printStackTrace(pw);
				pw.flush();
				String exceptionMsg = sw.toString();

				//shorten/simplify exception message to make it easier to fit into a message box
				exceptionMsg = exceptionMsg.replaceAll("\\(.*:([0-9]*)\\)", "($1)");
				exceptionMsg = exceptionMsg.replace("com.coz.calabozopixeladodominicano.", "");
				exceptionMsg = exceptionMsg.replace("com.watabou.", "");
				exceptionMsg = exceptionMsg.replace("com.badlogic.gdx.", "");
				exceptionMsg = exceptionMsg.replace("\t", "  "); //shortens length of tabs

				//replace ' and " with similar equivalents as tinyfd hates them for some reason
				exceptionMsg = exceptionMsg.replace('\'', '’');
				exceptionMsg = exceptionMsg.replace('"', '”');

				if (exceptionMsg.length() > 1000){
					exceptionMsg = exceptionMsg.substring(0, 1000) + "...";
				}

				if (exceptionMsg.contains("Couldnt create window")){
					TinyFileDialogs.tinyfd_messageBox(title.getSpecTitle() + " Has Crashed!",
							title + " was not able to initialize its graphics display, sorry about that!\n\n" +
									"This usually happens when your graphics card does not support OpenGL 2.0+, or has misconfigured graphics drivers.\n\n" +
									"If you are certain the game should be working on your computer, feel free to " +
									"fill a bug report at https://github.com/coz-eduardo-hernandez/calabozo-pixelado-dominicano/issues\n\n" +
									"version: " + Game.version, "ok", "error", false);
				} else {
					TinyFileDialogs.tinyfd_messageBox(title.getSpecTitle() + " Has Crashed!",
							title + " has run into an error it cannot recover from and has crashed, sorry about that!\n\n" +
									"If you could, please fill a bug report at https://github" +
									".com/coz-eduardo-hernandez/calabozo-pixelado-dominicano/issues\n\n" +
									"version: " + Game.version + "\n" +
									exceptionMsg,
							"ok", "error", false);
				}
				System.exit(1);
			}
		});
		
		Game.version = DesktopLauncher.class.getPackage().getSpecificationVersion();
		if (Game.version == null) {
			Game.version = System.getProperty("Specification-Version");
		}
		
		try {
			Game.versionCode = Integer.parseInt(DesktopLauncher.class.getPackage().getImplementationVersion());
		} catch (NumberFormatException e) {
			Game.versionCode = Integer.parseInt(System.getProperty("Implementation-Version"));
		}

		if (UpdateImpl.supportsUpdates()){
			Updates.service = UpdateImpl.getUpdateService();
		}
		if (NewsImpl.supportsNews()){
			News.service = NewsImpl.getNewsService();
		}
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		
		config.setTitle( title.getSpecTitle() );

		BasePath basePath = launcher.new BasePath(title.getSpecTitle());

		config.setPreferencesConfig( basePath.getPath(), basePath.getFileType() );
		SPDSettings.set( new Lwjgl3Preferences( new Lwjgl3FileHandle(basePath.getPath() + SPDSettings.DEFAULT_PREFS_FILE,
				basePath.getFileType()) ));
		FileUtils.setDefaultFileProperties( basePath.getFileType(), basePath.getPath() );
		
		config.setWindowSizeLimits( 720, 400, -1, -1 );
		Point p = SPDSettings.windowResolution();
		config.setWindowedMode( p.x, p.y );

		config.setMaximized(SPDSettings.windowMaximized());

		//going fullscreen on launch is still buggy on macOS, so game enters it slightly later
		if (SPDSettings.fullscreen() && !SharedLibraryLoader.isMac) {
			config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		}
		
		//records whether window is maximized or not for settings
		DesktopWindowListener listener = new DesktopWindowListener();
		config.setWindowListener( listener );
		
		config.setWindowIcon("icons/icon_16.png", "icons/icon_32.png", "icons/icon_48.png",
				"icons/icon_64.png", "icons/icon_128.png", "icons/icon_256.png");

		new Lwjgl3Application(new CalabozoPixeladoDominicano(new DesktopPlatformSupport()), config);
	}
}
