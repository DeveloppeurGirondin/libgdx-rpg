package com.developpeurgirondin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.developpeurgirondin.MyDemoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "RPG - LibGdx apprentissage";
        config.useGL30 = false;
        config.width = 640;
        config.height = 480;
        config.resizable = false;
		new LwjglApplication(new MyDemoGame(), config);
	}
}
