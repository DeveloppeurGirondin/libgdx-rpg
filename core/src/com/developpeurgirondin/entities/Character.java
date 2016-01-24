package com.developpeurgirondin.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * @author developpeurgirondin.
 */
public class Character {

    public boolean isFacingPNJ(List<Character> pnjList) {
        if(this.facing.equals(Facing.Top)) {
            for (Character pnj : pnjList) {
                if (this.position.y >= pnj.position.y-pnj.height && this.position.y <= (pnj.position.y +pnj.height+ 20)) {
                    System.out.println("Y ok");
                    System.out.println("this.position.y : " + this.position.y);
                    System.out.println("pnj.position.y : " + pnj.position.y);
                    System.out.println("pnj.height : " + pnj.height);
                    if(this.position.x >= pnj.position.x-20 && this.position.x <= (pnj.position.x+pnj.width+20)) {
                        System.out.println("X ok");
                        return true;
                    } else {
                        System.out.println("X ko");
                    }
                } else {
                    System.out.println("Y ko");
                    System.out.println("this.position.y : " + this.position.y);
                    System.out.println("pnj.position.y : " + pnj.position.y);
                    System.out.println("pnj.height : " + pnj.height);
                }
            }
        }

        return false;
    }

    public enum State {
        Standing, Walking
    }

    public enum Facing {
        Top, Bottom, Left, Right,
    }

    /**
     * State of character (standing, walking, attacking, etc).
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
        //split the frames
        characterSpriteSheetTable = characterSpriteSheet.split(32, 32);
        //since there's only one row, we only get first array
        characterWalkingBottom = new Animation(0.15f, characterSpriteSheetTable[0]);
        characterWalkingLeft = new Animation(0.15f, characterSpriteSheetTable[1]);
        characterWalkingRight = new Animation(0.15f, characterSpriteSheetTable[2]);
        characterWalkingTop = new Animation(0.15f, characterSpriteSheetTable[3]);

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

    public boolean isInCollisionWithLayer(TiledMapTileLayer collisionLayer, List<Character> listPnj, final int TILE_SIZE) {
        boolean isCollision = false;
        // Recuperation des coins de collision du personnage du joueur
        Vector2 basgauche = new Vector2(this.position.x / TILE_SIZE, this.position.y / TILE_SIZE);
        Vector2 basdroite = new Vector2((this.position.x + this.width / 2) / TILE_SIZE, this.position.y / TILE_SIZE);
        Vector2 hautgauche = new Vector2(this.position.x / TILE_SIZE, (this.position.y + this.height / 2) / TILE_SIZE);
        Vector2 hautdroite = new Vector2((this.position.x + this.width / 2) / TILE_SIZE, (this.position.y + this.height / 2) / TILE_SIZE);

        //Si collision avec un element du decor
        if (collisionLayer.getCell((int) (basgauche.x), (int) (basgauche.y)) != null) {
            isCollision = true;
        }
        if (collisionLayer.getCell((int) (basdroite.x), (int) (basdroite.y)) != null) {
            isCollision = true;
        }
        if (collisionLayer.getCell((int) (hautgauche.x), (int) (hautgauche.y)) != null) {
            isCollision = true;
        }
        if (collisionLayer.getCell((int) (hautdroite.x), (int) (hautdroite.y)) != null) {
            isCollision = true;
        }
        //Si pas de collision detectee, recherche d'une collision avec un PNJ
        if (!isCollision) {
            for (Character pnj : listPnj) {

                Vector2 pnjBasdroite = new Vector2(pnj.position.x + pnj.width, pnj.position.y + pnj.width);
                Vector2 pnjHautgauche = new Vector2(pnj.position.x, pnj.position.y);

                hautgauche = new Vector2(this.position.x+10, this.position.y);
                hautdroite = new Vector2(this.position.x-10+this.width, this.position.y);
                basgauche = new Vector2(this.position.x+10, this.position.y+this.height-10);
                basdroite = new Vector2(this.position.x-10+this.width, this.position.y + this.height-10);


                // On verifie si un des coins est dans l'aire d'un PNJ
                if (hautgauche.x >= pnjHautgauche.x && hautgauche.x <= pnjBasdroite.x && hautgauche.y >= pnjHautgauche.y && hautgauche.y <= pnjBasdroite.y) {
                    isCollision = true;
                }
                if (hautdroite.x >= pnjHautgauche.x && hautdroite.x <= pnjBasdroite.x && hautdroite.y >= pnjHautgauche.y && hautdroite.y <= pnjBasdroite.y) {
                    isCollision = true;
                }
                if (basgauche.x >= pnjHautgauche.x && basgauche.x <= pnjBasdroite.x && basgauche.y >= pnjHautgauche.y && basgauche.y <= pnjBasdroite.y) {
                    isCollision = true;
                }
                if (basdroite.x >= pnjHautgauche.x && basdroite.x <= pnjBasdroite.x && basdroite.y >= pnjHautgauche.y && basdroite.y <= pnjBasdroite.y) {
                    isCollision = true;
                }

            }
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
