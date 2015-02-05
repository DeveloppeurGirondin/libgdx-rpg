package com.developpeurgirondin.ui.buttons.homepage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;
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


    public void setStyle(Button.ButtonStyle style) {
        button.setStyle(style);
    }

    public float getPadBottom() {
        return button.getPadBottom();
    }

    public Table right() {
        return button.right();
    }

    public Table pad(float top, float left, float bottom, float right) {
        return button.pad(top, left, bottom, right);
    }

    public void setSkin(Skin skin) {
        button.setSkin(skin);
    }

    public boolean hasChildren() {
        return button.hasChildren();
    }

    public boolean isTransform() {
        return button.isTransform();
    }

    public void clearChildren() {
        button.clearChildren();
    }

    public boolean isChecked() {
        return button.isChecked();
    }

    public Table debugTable() {
        return button.debugTable();
    }

    public Table padTop(float padTop) {
        return button.padTop(padTop);
    }

    public float getPadLeft() {
        return button.getPadLeft();
    }

    public void invalidate() {
        button.invalidate();
    }

    public Table bottom() {
        return button.bottom();
    }

    public float getPrefWidth() {
        return button.getPrefWidth();
    }

    public Table center() {
        return button.center();
    }

    public Table padTop(Value padTop) {
        return button.padTop(padTop);
    }

    public Cell add() {
        return button.add();
    }

    public Table left() {
        return button.left();
    }

    public Drawable getBackground() {
        return button.getBackground();
    }

    public Value getPadRightValue() {
        return button.getPadRightValue();
    }

    public void setTransform(boolean transform) {
        button.setTransform(transform);
    }

    public float getPadX() {
        return button.getPadX();
    }

    public Table pad(float pad) {
        return button.pad(pad);
    }

    public boolean isPressed() {
        return button.isPressed();
    }

    public float getPadY() {
        return button.getPadY();
    }

    public Table background(String drawableName) {
        return button.background(drawableName);
    }

    public Table padBottom(float padBottom) {
        return button.padBottom(padBottom);
    }

    public float getMinWidth() {
        return button.getMinWidth();
    }

    public void addActorBefore(Actor actorBefore, Actor actor) {
        button.addActorBefore(actorBefore, actor);
    }

    public Table debug(Table.Debug debug) {
        return button.debug(debug);
    }

    public Value getPadBottomValue() {
        return button.getPadBottomValue();
    }

    public void add(Actor... actors) {
        button.add(actors);
    }

    public Vector2 localToDescendantCoordinates(Actor descendant, Vector2 localCoords) {
        return button.localToDescendantCoordinates(descendant, localCoords);
    }

    public float getPadTop() {
        return button.getPadTop();
    }

    public float getMaxHeight() {
        return button.getMaxHeight();
    }

    public Value getPadTopValue() {
        return button.getPadTopValue();
    }

    public void setCullingArea(Rectangle cullingArea) {
        button.setCullingArea(cullingArea);
    }

    public ClickListener getClickListener() {
        return button.getClickListener();
    }

    public void setText(String text) {
        button.setText(text);
    }

    public Table debugAll() {
        return button.debugAll();
    }

    public Cell<Label> add(String text) {
        return button.add(text);
    }

    public boolean isOver() {
        return button.isOver();
    }

    public Table padRight(Value padRight) {
        return button.padRight(padRight);
    }

    public Value getPadLeftValue() {
        return button.getPadLeftValue();
    }

    public void addActor(Actor actor) {
        button.addActor(actor);
    }

    public Cell columnDefaults(int column) {
        return button.columnDefaults(column);
    }

    public void reset() {
        button.reset();
    }

    public Table debugCell() {
        return button.debugCell();
    }

    public void setRound(boolean round) {
        button.setRound(round);
    }

    public boolean needsLayout() {
        return button.needsLayout();
    }

    public boolean getClip() {
        return button.getClip();
    }

    public boolean swapActor(int first, int second) {
        return button.swapActor(first, second);
    }

    public void pack() {
        button.pack();
    }

    public void setChecked(boolean isChecked) {
        button.setChecked(isChecked);
    }

    public Table pad(Value top, Value left, Value bottom, Value right) {
        return button.pad(top, left, bottom, right);
    }

    public void print() {
        button.print();
    }

    public void toggle() {
        button.toggle();
    }

    public Array<Cell> getCells() {
        return button.getCells();
    }

    public ButtonGroup getButtonGroup() {
        return button.getButtonGroup();
    }

    public <T extends Actor> Cell<T> getCell(T actor) {
        return button.getCell(actor);
    }

    public void addActorAfter(Actor actorAfter, Actor actor) {
        button.addActorAfter(actorAfter, actor);
    }

    public <T extends Actor> T findActor(String name) {
        return button.findActor(name);
    }

    public Table pad(Value pad) {
        return button.pad(pad);
    }

    public Table top() {
        return button.top();
    }

    public int getRows() {
        return button.getRows();
    }

    public int getRow(float y) {
        return button.getRow(y);
    }

    public void setLayoutEnabled(boolean enabled) {
        button.setLayoutEnabled(enabled);
    }

    public Table background(Drawable background) {
        return button.background(background);
    }

    public Cell row() {
        return button.row();
    }

    public void setFillParent(boolean fillParent) {
        button.setFillParent(fillParent);
    }

    public void setDebug(boolean enabled, boolean recursively) {
        button.setDebug(enabled, recursively);
    }

    public float getMinHeight() {
        return button.getMinHeight();
    }

    public void layout() {
        button.layout();
    }

    public Cell defaults() {
        return button.defaults();
    }

    public void invalidateHierarchy() {
        button.invalidateHierarchy();
    }

    public Table align(int align) {
        return button.align(align);
    }

    public float getPadRight() {
        return button.getPadRight();
    }

    public boolean swapActor(Actor first, Actor second) {
        return button.swapActor(first, second);
    }

    public int getAlign() {
        return button.getAlign();
    }

    public Table padBottom(Value padBottom) {
        return button.padBottom(padBottom);
    }

    public void addActorAt(int index, Actor actor) {
        button.addActorAt(index, actor);
    }

    public TextButton.TextButtonStyle getStyle() {
        return button.getStyle();
    }

    public Table padRight(float padRight) {
        return button.padRight(padRight);
    }

    public boolean removeActor(Actor actor) {
        return button.removeActor(actor);
    }

    public Table.Debug getTableDebug() {
        return button.getTableDebug();
    }

    public boolean isDisabled() {
        return button.isDisabled();
    }

    public Table debugActor() {
        return button.debugActor();
    }

    public void setDisabled(boolean isDisabled) {
        button.setDisabled(isDisabled);
    }

    public Label getLabel() {
        return button.getLabel();
    }

    public void setClip(boolean enabled) {
        button.setClip(enabled);
    }

    public Cell<Label> add(String text, String labelStyleName) {
        return button.add(text, labelStyleName);
    }

    public void setBackground(Drawable background) {
        button.setBackground(background);
    }

    public SnapshotArray<Actor> getChildren() {
        return button.getChildren();
    }

    public Cell<Label> add(String text, String fontName, String colorName) {
        return button.add(text, fontName, colorName);
    }

    public Cell<Stack> stack(Actor... actors) {
        return button.stack(actors);
    }

    public int getColumns() {
        return button.getColumns();
    }

    public Cell<Label> add(String text, String fontName, Color color) {
        return button.add(text, fontName, color);
    }

    public float getMaxWidth() {
        return button.getMaxWidth();
    }

    public Cell getLabelCell() {
        return button.getLabelCell();
    }

    public CharSequence getText() {
        return button.getText();
    }

    public float getPrefHeight() {
        return button.getPrefHeight();
    }

    public void setBackground(String drawableName) {
        button.setBackground(drawableName);
    }

    public Table padLeft(Value padLeft) {
        return button.padLeft(padLeft);
    }

    public Table padLeft(float padLeft) {
        return button.padLeft(padLeft);
    }

    public <T extends Actor> Cell<T> add(T actor) {
        return button.add(actor);
    }

    public void validate() {
        button.validate();
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
