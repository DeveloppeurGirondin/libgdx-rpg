package com.developpeurgirondin.ui.buttons.homepage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.developpeurgirondin.ui.buttons.ButtonConstants;

/**
 * @author developpeurgirondin.
 */
public class HomePageButton extends Actor {

    /**
     * Le style du bouton *
     */
    private TextButton.TextButtonStyle style;
    /**
     * Les images du bouton sur les différentes actions *
     */
    private Texture btnUp, btnDown, btnChecked;
    /**
     * Le bouton *
     */
    private TextButton button;

    public HomePageButton(String text) {
        btnUp = new Texture(Gdx.files.internal(ButtonConstants.PATH_HOMEPAGE_BUTTON_IMG));
        btnDown = new Texture(Gdx.files.internal(ButtonConstants.PATH_HOMEPAGE_BUTTON_DOWN_IMG));
        btnChecked = new Texture(Gdx.files.internal(ButtonConstants.PATH_HOMEPAGE_BUTTON_IMG));
        this.style = new TextButton.TextButtonStyle(
                new TextureRegionDrawable(new TextureRegion(btnUp)),
                new TextureRegionDrawable(new TextureRegion(btnDown)),
                new TextureRegionDrawable(new TextureRegion(btnChecked)),
                new BitmapFont());

        style.over = new TextureRegionDrawable(new TextureRegion(btnDown));
        this.button = new TextButton(text, style);
    }

    public Table right() {
        return button.right();
    }

    public Table top() {
        return button.top();
    }

    @Override
    public boolean fire(Event event) {
        return button.fire(event);
    }

    @Override
    public boolean notify(Event event, boolean capture) {
        return button.notify(event, capture);
    }

    @Override
    public boolean remove() {
        return button.remove();
    }

    @Override
    public void setPosition(float x, float y) {
        this.button.setPosition(x, y);
    }

    @Override
    public void setPosition(float x, float y, int alignment) {
        button.setPosition(x, y, alignment);
    }

    @Override
    public void moveBy(float x, float y) {
        button.moveBy(x, y);
    }

    @Override
    public float getWidth() {
        return button.getWidth();
    }

    @Override
    public void setWidth(float width) {
        button.setWidth(width);
    }

    @Override
    public float getHeight() {
        return button.getHeight();
    }

    @Override
    public void setHeight(float height) {
        button.setHeight(height);
    }

    @Override
    public float getTop() {
        return button.getTop();
    }

    @Override
    public float getRight() {
        return button.getRight();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.button.draw(batch, parentAlpha);
        super.draw(batch, parentAlpha);
    }

    @Override
    public String toString() {
        return button.toString();
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return button.hit(x, y, touchable);
    }

    @Override
    public void setDebug(boolean enabled) {
        button.setDebug(enabled);
    }

    @Override
    public Table debug() {
        return button.debug();
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        button.drawDebug(shapes);
    }

    @Override
    public void act(float delta) {
        button.act(delta);
    }

    @Override
    public void clear() {
        button.clear();
    }

    @Override
    public void setSize(float width, float height) {
        button.setSize(width, height);
    }

    @Override
    public void sizeBy(float size) {
        button.sizeBy(size);
    }

    @Override
    public void sizeBy(float width, float height) {
        button.sizeBy(width, height);
    }

    @Override
    public void setBounds(float x, float y, float width, float height) {
        button.setBounds(x, y, width, height);
    }

    @Override
    public float getOriginX() {
        return button.getOriginX();
    }

    @Override
    public void setOriginX(float originX) {
        button.setOriginX(originX);
    }

    @Override
    public float getOriginY() {
        return button.getOriginY();
    }

    @Override
    public void setOriginY(float originY) {
        button.setOriginY(originY);
    }

    @Override
    public void setOrigin(float originX, float originY) {
        button.setOrigin(originX, originY);
    }

    @Override
    public void setOrigin(int alignment) {
        button.setOrigin(alignment);
    }

    @Override
    public float getScaleX() {
        return button.getScaleX();
    }

    @Override
    public void setScaleX(float scaleX) {
        button.setScaleX(scaleX);
    }

    @Override
    public float getScaleY() {
        return button.getScaleY();
    }

    @Override
    public void setScaleY(float scaleY) {
        button.setScaleY(scaleY);
    }

    @Override
    public void setScale(float scaleXY) {
        button.setScale(scaleXY);
    }

    @Override
    public void setScale(float scaleX, float scaleY) {
        button.setScale(scaleX, scaleY);
    }

    @Override
    public void scaleBy(float scale) {
        button.scaleBy(scale);
    }

    @Override
    public void scaleBy(float scaleX, float scaleY) {
        button.scaleBy(scaleX, scaleY);
    }

    @Override
    public float getRotation() {
        return button.getRotation();
    }

    @Override
    public void setRotation(float degrees) {
        button.setRotation(degrees);
    }

    @Override
    public void rotateBy(float amountInDegrees) {
        button.rotateBy(amountInDegrees);
    }

    @Override
    public void setColor(Color color) {
        button.setColor(color);
    }

    @Override
    public void setColor(float r, float g, float b, float a) {
        button.setColor(r, g, b, a);
    }

    @Override
    public Color getColor() {
        return button.getColor();
    }

    @Override
    public String getName() {
        return button.getName();
    }

    @Override
    public void setName(String name) {
        button.setName(name);
    }

    @Override
    public void toFront() {
        button.toFront();
    }

    @Override
    public void toBack() {
        button.toBack();
    }

    @Override
    public void setZIndex(int index) {
        button.setZIndex(index);
    }

    @Override
    public int getZIndex() {
        return button.getZIndex();
    }

    @Override
    public boolean clipBegin() {
        return button.clipBegin();
    }

    @Override
    public boolean clipBegin(float x, float y, float width, float height) {
        return button.clipBegin(x, y, width, height);
    }

    @Override
    public void clipEnd() {
        button.clipEnd();
    }

    @Override
    public Vector2 screenToLocalCoordinates(Vector2 screenCoords) {
        return button.screenToLocalCoordinates(screenCoords);
    }

    @Override
    public Vector2 stageToLocalCoordinates(Vector2 stageCoords) {
        return button.stageToLocalCoordinates(stageCoords);
    }

    @Override
    public Vector2 localToStageCoordinates(Vector2 localCoords) {
        return button.localToStageCoordinates(localCoords);
    }

    @Override
    public Vector2 localToParentCoordinates(Vector2 localCoords) {
        return button.localToParentCoordinates(localCoords);
    }

    @Override
    public Vector2 localToAscendantCoordinates(Actor ascendant, Vector2 localCoords) {
        return button.localToAscendantCoordinates(ascendant, localCoords);
    }

    @Override
    public Vector2 parentToLocalCoordinates(Vector2 parentCoords) {
        return button.parentToLocalCoordinates(parentCoords);
    }

    @Override
    public boolean getDebug() {
        return button.getDebug();
    }

    @Override
    public boolean addListener(EventListener listener) {
        return button.addListener(listener);
    }

    @Override
    public Array<EventListener> getListeners() {
        return button.getListeners();
    }

    @Override
    public boolean removeListener(EventListener listener) {
        return button.removeListener(listener);
    }

    @Override
    public boolean addCaptureListener(EventListener listener) {
        return button.addCaptureListener(listener);
    }

    @Override
    public boolean removeCaptureListener(EventListener listener) {
        return button.removeCaptureListener(listener);
    }

    @Override
    public void addAction(Action action) {
        button.addAction(action);
    }

    @Override
    public Array<EventListener> getCaptureListeners() {
        return button.getCaptureListeners();
    }

    @Override
    public void removeAction(Action action) {
        button.removeAction(action);
    }

    @Override
    public Array<Action> getActions() {
        return button.getActions();
    }

    @Override
    public void clearActions() {
        button.clearActions();
    }

    @Override
    public void clearListeners() {
        button.clearListeners();
    }

    @Override
    public Stage getStage() {
        return button.getStage();
    }

    @Override
    public boolean isDescendantOf(Actor actor) {
        return button.isDescendantOf(actor);
    }

    @Override
    public boolean isAscendantOf(Actor actor) {
        return button.isAscendantOf(actor);
    }

    @Override
    public boolean hasParent() {
        return button.hasParent();
    }

    @Override
    public Group getParent() {
        return button.getParent();
    }


    @Override
    public boolean isTouchable() {
        return button.isTouchable();
    }

    @Override
    public Touchable getTouchable() {
        return button.getTouchable();
    }

    @Override
    public void setTouchable(Touchable touchable) {
        button.setTouchable(touchable);
    }

    @Override
    public boolean isVisible() {
        return button.isVisible();
    }

    @Override
    public void setVisible(boolean visible) {
        button.setVisible(visible);
    }

    @Override
    public Object getUserObject() {
        return button.getUserObject();
    }

    @Override
    public float getX() {
        return button.getX();
    }

    @Override
    public void setUserObject(Object userObject) {
        button.setUserObject(userObject);
    }

    @Override
    public float getX(int alignment) {
        return button.getX(alignment);
    }

    @Override
    public void setX(float x) {
        button.setX(x);
    }

    @Override
    public float getY() {
        return button.getY();
    }

    @Override
    public float getY(int alignment) {
        return button.getY(alignment);
    }

    @Override
    public void setY(float y) {
        button.setY(y);
    }
}
