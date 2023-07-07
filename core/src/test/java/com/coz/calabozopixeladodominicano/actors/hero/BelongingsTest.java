package com.coz.calabozopixeladodominicano.actors.hero;

import static org.junit.jupiter.api.Assertions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.coz.calabozopixeladodominicano.CalabozoPixeladoDominicano;
import com.coz.calabozopixeladodominicano.desktop.DesktopLauncher;
import com.coz.calabozopixeladodominicano.desktop.DesktopLauncher.Title;
import com.coz.calabozopixeladodominicano.desktop.DesktopLauncher.BasePath;
import com.coz.calabozopixeladodominicano.sprites.ItemSpriteSheet;
import com.coz.calabozopixeladodominicano.desktop.DesktopPlatformSupport;
import com.watabou.noosa.Game;
import com.watabou.utils.FileUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BelongingsTest {
    Lwjgl3Application app = null;
    CalabozoPixeladoDominicano CPD = null;

    @BeforeEach
    void setUp () {
        Game.version = System.getProperty("Specification-Version");
        DesktopLauncher launcher = new DesktopLauncher();
        Title title = launcher.new Title();
        BasePath basePath = launcher.new BasePath(title.getTitle());
        FileUtils.setDefaultFileProperties( basePath.getFileType(), basePath.getPath() );
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        CPD = new CalabozoPixeladoDominicano(new DesktopPlatformSupport());
        app = new Lwjgl3Application(CPD, config);
        CPD.destroy();
        app.exit();
    }

    @AfterEach
    void tearDown () {
        /*Gdx.app.postRunnable(new Runnable() {
            public void run () {
                app.exit();
                System.exit(-1);
                Gdx.app.postRunnable(this);
            }
        });*/
    }

    @Test
    void can_get_backpack_image() {
        int image = ItemSpriteSheet.BACKPACK;
    }
}