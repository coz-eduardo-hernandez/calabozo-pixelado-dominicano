package com.coz.calabozopixeladodominicano.actors.hero;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.coz.calabozopixeladodominicano.CalabozoPixeladoDominicano;
//import com.coz.calabozopixeladodominicano.desktop.DesktopLauncher.SpecificationTitle;
//import com.coz.calabozopixeladodominicano.desktop.DesktopLauncher.BasePath;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class BelongingsUTest {
    Lwjgl3Application app = null;
    CalabozoPixeladoDominicano CPD = null;

    @BeforeEach
    void setUp () {
        /*Game.version = System.getProperty("Specification-Version");
        DesktopLauncher launcher = new DesktopLauncher();
        SpecificationTitle title = launcher.new SpecificationTitle();
        BasePath basePath = launcher.new BasePath(title.getSpecTitle());
        FileUtils.setDefaultFileProperties( basePath.getFileType(), basePath.getPath() );
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        CPD = new CalabozoPixeladoDominicano(new DesktopPlatformSupport());
        app = new Lwjgl3Application(CPD, config);
        CPD.destroy();
        app.exit();*/
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

    /*@Test
    void can_get_backpack_image() {
        //int image = ItemSpriteSheet.BACKPACK;
    }*/
}