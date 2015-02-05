package com.developpeurgirondin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.developpeurgirondin.MyDemoGame;
import com.developpeurgirondin.ui.buttons.ButtonConstants;
import com.developpeurgirondin.ui.buttons.homepage.HomePageButton;

/**
 * @author developpeurgirondin.
 */
public class OptionsScreen implements Screen {

    MyDemoGame game;
    HomeScreen homeScreen;
    private Stage stage;
    private Texture background;
    private Music music;
    private CheckBox playMusicCheckbox;
    private Label playMusicLabel;
    private HomePageButton backButton;
    Texture btnUnchecked, btnChecked;
    Preferences preferences;

    public OptionsScreen(MyDemoGame g, HomeScreen homeScreen) {
        game = g;
        this.homeScreen = homeScreen;
        music = homeScreen.getMusic();
    }

    @Override
    public void show() {
        background = new Texture(Gdx.files.internal("graphics/background/homepage_background.jpg"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        playMusicLabel = new Label("Options de jeu", new Label.LabelStyle(new BitmapFont(), new Color(Color.WHITE)));
        playMusicLabel.setPosition(240, 450);

        btnUnchecked = new Texture(Gdx.files.internal(ButtonConstants.PATH_HOMEPAGE_CHECKBOX_IMG));
        btnChecked = new Texture(Gdx.files.internal(ButtonConstants.PATH_HOMEPAGE_CHECKBOX_ON_IMG));
        playMusicCheckbox = new CheckBox("musique activee", new CheckBox.CheckBoxStyle(new TextureRegionDrawable(new TextureRegion(btnUnchecked)), new TextureRegionDrawable(new TextureRegion(btnChecked)), new BitmapFont(), Color.BLUE));
        playMusicCheckbox.setPosition(235, 250);
        playMusicCheckbox.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (playMusicCheckbox.isChecked()) {
                    playMusicCheckbox.setChecked(false);
                    music.pause();
                } else {
                    playMusicCheckbox.setChecked(true);
                    music.play();
                }
                preferences = Gdx.app.getPreferences("preferences");
                preferences.putBoolean("musicEnabled", playMusicCheckbox.isChecked());
                preferences.flush();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        backButton = new HomePageButton("Retour à l'écran titre");
        backButton.setPosition(230, 150);
        backButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(homeScreen);
                return false;
            }
        });

        stage.addActor(playMusicLabel);
        stage.addActor(playMusicCheckbox);
        stage.addActor(backButton);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());//corrige sans caméra !!
        stage.getBatch().end();

        preferences = Gdx.app.getPreferences("preferences");
        playMusicCheckbox.setChecked(preferences.getBoolean("musicEnabled"));
        preferences.flush();

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
}
