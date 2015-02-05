package com.developpeurgirondin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.developpeurgirondin.MyDemoGame;
import com.developpeurgirondin.entities.Character;

import static com.badlogic.gdx.Input.Keys;

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
    TiledMapTileLayer collisionLayer;
    TiledMapTileLayer detailLayer;
    TiledMapTileLayer fondLayer;
    TiledMapTileLayer overHeadLayer;

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
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        collisionLayer = (TiledMapTileLayer) map.getLayers().get(2);
        detailLayer = (TiledMapTileLayer) map.getLayers().get(1);
        fondLayer = (TiledMapTileLayer) map.getLayers().get(0);
        overHeadLayer = (TiledMapTileLayer) map.getLayers().get(3);

        /**** dessine le joueur ***/
        Batch batch;
        batch = renderer.getBatch();
        batch.begin();
        renderer.renderTileLayer(fondLayer);//rendu de la carte
        renderer.renderTileLayer(detailLayer);//rendu de la carte
        renderer.renderTileLayer(collisionLayer);//rendu de la carte

        if(player.getState().equals(Character.State.Walking)) {
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
        /*********** tuile occupée par le joueur ******/
        inputPlayer();

        batch = renderer.getBatch();
        batch.begin();
        renderer.renderTileLayer(overHeadLayer);//rendu de la carte
        batch.end();
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
            camera.translate(0,2,0);
            if(player.isInCollisionWithLayer(collisionLayer,TILE_SIZE)) {
                player.walking(-2, Character.Facing.Top);
                camera.translate(0,-2,0);
            }
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            player.walking(2, Character.Facing.Bottom);
            camera.translate(0,-2,0);
            if(player.isInCollisionWithLayer(collisionLayer, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Bottom);
                camera.translate(0,2,0);
            }
        } else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.walking(2, Character.Facing.Left);
            camera.translate(-2,0,0);
            if(player.isInCollisionWithLayer(collisionLayer, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Left);
                camera.translate(2,0,0);
            }
            player.setFacing(Character.Facing.Left);
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.walking(2, Character.Facing.Right);
            camera.translate(2,0,0);
            if(player.isInCollisionWithLayer(collisionLayer, TILE_SIZE)) {
                player.walking(-2, Character.Facing.Right);
                camera.translate(-2,0,0);
            }
            player.setFacing(Character.Facing.Right);
        } else {
            player.standing();
        }
    }

}
