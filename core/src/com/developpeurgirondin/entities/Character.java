package com.developpeurgirondin.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

/**
 * @author developpeurgirondin.
 */
public class Character{

    public enum State {
        Standing, Walking
    }

    public enum Facing {
        Top, Bottom, Left, Right,
    }

    /**
     *     State of character (standing, walking, attacking, etc).
     */
    private State state;
    /**
     * Facing of character (top, bottom, left, right).
     */
    private Facing facing;
    /**
     * StateTime to know wich sprite display of animation.
     */
    private float stateTime;
    /**
     * The position of the character.
     */
    private Vector2 position;
    /**
     * The width of the sprite of the character.
     */
    private float width;
    /**
     * The height of the sprite of the character.
     */
    private float height;

    /**
     * The TextureAtlas of the spritesheet.
      */
    private TextureAtlas atlas;
    /**
     * The texture of the spritesheet described ine the textureatlas.
     */
    private TextureRegion characterSpriteSheet;
    /**
     * The table of sprites in the spritesheet.
     */
    private TextureRegion[][] characterSpriteSheetTable;
    /**
     * The animation of character when walking bottom.
     */
    private Animation characterWalkingBottom;
    /**
     * The animation of character when walking top.
     */
    private Animation characterWalkingTop;
    /**
     * The animation of character when walking left.
     */
    private Animation characterWalkingLeft;
    /**
     * The animation of character when walking right.
     */
    private Animation characterWalkingRight;
    /**
     * The current animation.
     */
    private Animation currentAnimation;

    public Character(String pathToCharacterPicture, String atlasRegion) {
        position = new Vector2();
        state = State.Standing;
        facing = Facing.Bottom;
        //create a new instance of our TextureAtlas
        atlas = new TextureAtlas(pathToCharacterPicture);
        //set our hero TextureRegion to the hero sprite in the atlas
        characterSpriteSheet = atlas.findRegion(atlasRegion);
        //split the frames, each frame is 100 x 150 pixels
        characterSpriteSheetTable = characterSpriteSheet.split(32, 32);
        //since there's only one row, we only get first array
        characterWalkingBottom = new Animation(0.3f, characterSpriteSheetTable[0]);
        characterWalkingLeft = new Animation(0.3f, characterSpriteSheetTable[1]);
        characterWalkingRight = new Animation(0.3f, characterSpriteSheetTable[2]);
        characterWalkingTop = new Animation(0.3f, characterSpriteSheetTable[3]);

        currentAnimation = characterWalkingBottom;
        stateTime = 0f;
    }

    public void walking(int moveDistance, Facing facing) {
        this.setState(State.Walking);
        this.facing = facing;
        switch (facing) {
            case Top:
                this.position.y = this.position.y + moveDistance;
                this.currentAnimation = characterWalkingTop;
                break;
            case Bottom:
                this.position.y = this.position.y - moveDistance;
                this.currentAnimation = characterWalkingBottom;
                break;
            case Left:
                this.position.x = this.position.x - moveDistance;
                this.currentAnimation = characterWalkingLeft;
                break;
            case Right:
                this.position.x = this.position.x + moveDistance;
                this.currentAnimation = characterWalkingRight;
                break;
        }

    }

    public void standing() {
        this.state = State.Standing;
    }

    public void draw(Batch batch) {
        batch.draw(currentAnimation.getKeyFrame(stateTime, true), this.position.x, this.position.y);//on dessine le joueur
    }

    public boolean isInCollisionWithLayer(TiledMapTileLayer collisionLayer, final int TILE_SIZE) {
        boolean isCollision = false;
        Vector2 basgauche = new Vector2(this.position.x / TILE_SIZE, this.position.y / TILE_SIZE);
        Vector2 basdroite = new Vector2((this.position.x + this.width / 2) / TILE_SIZE, this.position.y / TILE_SIZE);
        Vector2 hautgauche = new Vector2(this.position.x / TILE_SIZE, (this.position.y + this.height / 2) / TILE_SIZE);
        Vector2 hautdroite = new Vector2((this.position.x + this.width / 2) / TILE_SIZE, (this.position.y +this.height / 2) / TILE_SIZE);

        if(collisionLayer.getCell((int) (basgauche.x), (int) (basgauche.y)) != null) {
            isCollision = true;
        }
        if(collisionLayer.getCell((int) (basdroite.x), (int) (basdroite.y)) != null) {
            isCollision = true;
        }
        if(collisionLayer.getCell((int) (hautgauche.x), (int) (hautgauche.y)) != null) {
            isCollision = true;
        }
        if(collisionLayer.getCell((int) (hautdroite.x), (int) (hautdroite.y)) != null) {
            isCollision = true;
        }
        return isCollision;
    }

    /**
     * ************************* Getters/Setters *****************************
     */
    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }


}
