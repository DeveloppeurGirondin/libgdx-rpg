package com.developpeurgirondin.screens;

import static com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.developpeurgirondin.MyDemoGame;
import com.developpeurgirondin.entities.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * @author developpeurgirondin.
 */
public class GameScreen implements Screen {

    public static final int TILE_SIZE = 16;
    private MyDemoGame game;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Character player;
    private List<Character> pnjList;
    TiledMapTileLayer collisionLayer;
    TiledMapTileLayer detailLayer;
    TiledMapTileLayer fondLayer;
    TiledMapTileLayer overHeadLayer;
    private Stage stage;
    private Label texte;
    private boolean spacePressed = false;

    public GameScreen(MyDemoGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        TmxMapLoader loader = new TmxMapLoader();//création du loader de carte
        map = loader.load("maps/map1.tmx");//chargement de la carte
        renderer = new OrthogonalTiledMapRenderer(map);//création du renderer
        camera = new OrthographicCamera(640, 480);//taille du viewPort
        camera.position.set(1024, 400, 0);//position de la caméra dansle monde 2D...centrée sur la carte (640*640) !!
        player = new Character("graphics/characters/player2.txt", "player2");
        player.setPosition(new Vector2(1024, 400));
        player.setWidth(32f);
        player.setHeight(32f);

        stage = new Stage();

        pnjList = new ArrayList<Character>();
        Character pnj1 = new Character("graphics/characters/player1.txt", "player1");
        pnj1.setPosition(new Vector2(450, 400));
        pnj1.setWidth(32f);
        pnj1.setHeight(32f);
        pnj1.setFacing(Character.Facing.Bottom);
        pnjList.add(pnj1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        collisionLayer = (TiledMapTileLayer) map.getLayers().get(2);
        detailLayer = (TiledMapTileLayer) map.getLayers().get(1);
        fondLayer = (TiledMapTileLayer) map.getLayers().get(0);
        overHeadLayer = (TiledMapTileLayer) map.getLayers().get(3);


        Batch batch;
        batch = renderer.getBatch();
        batch.begin();
        /**** dessine le terrain ***/
        renderer.renderTileLayer(fondLayer);//rendu de la carte
        renderer.renderTileLayer(detailLayer);//rendu de la carte
        renderer.renderTileLayer(collisionLayer);//rendu de la carte

        /**** dessine les pnj ***/
        for (Character pnj : pnjList) {
            pnj.draw(batch);
        }
        /**** dessine le joueur ***/
        if (player.getState().equals(Character.State.Walking)) {
            player.setStateTime(player.getStateTime() + Gdx.graphics.getDeltaTime());
        } else {
            player.setStateTime(0f);
        }
        player.draw(batch);
        batch.end();


        camera.update();//important sinon pas de prise en compte des input camera !!
        renderer.setView(camera);//on indique la caméra utilisée pour coupler les systèmes de coordonnées

        /**** Prise en charge du zoom ****/
        if (Gdx.input.isKeyPressed(Keys.PLUS)) {
            camera.zoom -= 0.01;
        }
        if (Gdx.input.isKeyPressed(Keys.NUMPAD_9)) {
            camera.zoom += 0.01;
        }
        /*********** Prise en compte de l'input du joueur******/
        inputPlayer();

        batch = renderer.getBatch();
        batch.begin();
        renderer.renderTileLayer(overHeadLayer);//rendu des elements au premier plan
        batch.end();

        if (spacePressed) {
            texte = new Label("Salut, je suis un PNJ et je ne sais pas quoi dire alors presse entrer.", new Label.LabelStyle(new BitmapFont(), new Color(Color.LIGHT_GRAY)));
            texte.setPosition((this.camera.viewportWidth / 2)- texte.getWidth()/2, (this.camera.viewportHeight/2)-texte.getHeight()/2);
            stage.addActor(texte);
            Texture background = new Texture(Gdx.files.internal("graphics/background/parchemin.png"));
            stage.getBatch().begin();
            stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());//corrige sans caméra !!
            stage.getBatch().end();

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
            if (Gdx.input.isKeyPressed(Keys.ENTER)) {
                spacePressed = false;
            }
        }

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
        renderer.dispose();
        map.dispose();
    }

    public void inputPlayer() {

        /**** commandes du joueur *****/
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            player.walking(2, Character.Facing.Top);
            camera.translate(0, 2, 0);
            if (player.isInCollisionWithLayer(collisionLayer, pnjList, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Top);
                camera.translate(0, -2, 0);
            }
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            player.walking(2, Character.Facing.Bottom);
            camera.translate(0, -2, 0);
            if (player.isInCollisionWithLayer(collisionLayer, pnjList, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Bottom);
                camera.translate(0, 2, 0);
            }
        } else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.walking(2, Character.Facing.Left);
            camera.translate(-2, 0, 0);
            if (player.isInCollisionWithLayer(collisionLayer, pnjList, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Left);
                camera.translate(2, 0, 0);
            }
            player.setFacing(Character.Facing.Left);
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.walking(2, Character.Facing.Right);
            camera.translate(2, 0, 0);
            if (player.isInCollisionWithLayer(collisionLayer, pnjList, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Right);
                camera.translate(-2, 0, 0);
            }
            player.setFacing(Character.Facing.Right);
        } else {
            if (Gdx.input.isKeyPressed(Keys.SPACE) && !spacePressed) {
                if (player.isFacingPNJ(pnjList)) {
                    spacePressed = true;


                }
            }

            player.standing();
        }
    }

}
