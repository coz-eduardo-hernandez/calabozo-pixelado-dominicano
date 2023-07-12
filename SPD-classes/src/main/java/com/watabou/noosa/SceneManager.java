package com.watabou.noosa;

import com.watabou.glwrap.Vertexbuffer;
import com.watabou.utils.Reflection;

public class SceneManager {
    private Class<? extends Scene> sceneClass;
    private Scene scene;

    private Scene requestedScene;

    private boolean requestedReset = true;

    private SceneChangeCallback onChange;

    public SceneManager(Class<? extends Scene> c){
        sceneClass = c;
    }

    public void pause(){
        if (scene != null) {
            scene.onPause();
        }
    }
    public void resetScene(){
        switchScene(sceneClass);
    }

    public void switchScene(Class<? extends Scene> c){
        switchScene(c, null);
    }

    public void switchScene(Class<? extends Scene> c, SceneChangeCallback callback){
        sceneClass = c;
        requestedReset = true;
        onChange = callback;
    }

    public void switchScene() {
        if (scene != null) {
            scene.destroy();
        }
        //clear any leftover vertex buffers
        Vertexbuffer.clear();
        scene = requestedScene;
        if (onChange != null) onChange.beforeCreate();
        scene.build();
        if (onChange != null) onChange.afterCreate();
        onChange = null;
    }

    public void update(final float ELAPSED){
        scene.update(ELAPSED);
    }

    public Scene scene(){
        return scene;
    }

    public void destroy(){
    	if (scene != null) {
			scene.destroy();
			scene = null;
		}

        sceneClass = null;
    }

    public void step(){
        if(requestedReset){
            requestedReset = false;

            requestedScene = Reflection.newInstance(sceneClass);
            if (requestedScene != null){
                switchScene();
            }
        }
    }

    public void draw(){
        if (scene != null) scene.draw();
    }

}
