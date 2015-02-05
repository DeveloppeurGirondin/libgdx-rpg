package com.developpeurgirondin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.developpeurgirondin.MyDemoGame;
import com.developpeurgirondin.ui.buttons.homepage.HomePageButton;

/**
 * @author developpeurgirondin.
 */
public class HomeScreen implements Screen{

    private MyDemoGame game;
    private Stage stage;
    private Texture background;
    private Music music;
    private HomePageButton playButton;
    private HomePageButton optionsButton;
    private HomePageButton quitButton;
    private Label title;
    Preferences preferences;
    public HomeScreen(MyDemoGame g) {
        game = g;
        preferences = Gdx.app.getPreferences("preferences");
        preferences.putBoolean("musicEnabled", true);
        preferences.flush();
    }

    @Override
    public void show() {
        background = new Texture(Gdx.files.internal("graphics/background/homepage_background.jpg"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        playBackgroundMusic();
        createTitle();
        createButtons();
        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(quitButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        preferences = Gdx.app.getPreferences("preferences");
        if(!preferences.getBoolean("musicEnabled")&&  music.isPlaying()) {
            music.pause();
        } else if(! music.isPlaying() && preferences.getBoolean("musicEnabled")) {
            music.play();
        }
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());//corrige sans caméra !!
        stage.getBatch().end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void playBackgroundMusic() {
        preferences = Gdx.app.getPreferences("preferences");
        if (music == null) {
            music = Gdx.audio.newMusic(Gdx.files.internal("audio/BGM/MIST002.ogg"));
            music.setLooping(true);
        }
        if(preferences.getBoolean("musicEnabled")) {
            music.play();
        }
    }

    private void createTitle() {
        title = new Label("Nom du jeu sans nom", new Label.LabelStyle(new BitmapFont(), new Color(Color.WHITE)));
        title.setPosition(250, 450);
    }

    private void createButtons() {
        createPlayButton();
        createOptionsButton(this);
        createQuitButton();
    }

    private void createPlayButton() {
        playButton = new HomePageButton("Jouer");
        playButton.setPosition(235, 350);
        playButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
                music.dispose();
                return false;
            }
        });
    }

    private void createOptionsButton(final HomeScreen homeScreen) {
        optionsButton = new HomePageButton("Options");
        optionsButton.setPosition(235, 250);
        optionsButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionsScreen(game, homeScreen));
                return false;
            }
        });
    }

    private void createQuitButton() {
        quitButton = new HomePageButton("Quitter");
        quitButton.setPosition(235, 150);
        quitButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return false;
            }
        });
    }

    public Music getMusic() {
        return music;
    }
}
