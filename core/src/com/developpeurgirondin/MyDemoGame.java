package com.developpeurgirondin;

import com.badlogic.gdx.Game;
import com.developpeurgirondin.screens.HomeScreen;

/**
 * @author developpeurgirondin.
 */
public class MyDemoGame extends Game {

    @Override
    public void create() {
        setScreen(new HomeScreen(this));//Au lancement de notre jeu, le premier écran à s'afficher est le menu
    }
}
