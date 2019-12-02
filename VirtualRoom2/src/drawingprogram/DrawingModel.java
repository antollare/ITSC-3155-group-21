package drawingprogram;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 * This model holds everything that the user has added to the canvas, and keeps
 * track of the current state (i.e. selected color and shape, etc.)
 *
 * @author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
 */
public class DrawingModel {

    // array to hold the shapes
    private ArrayList<Shape> shapes = new ArrayList<>();
    //array to hold the undone shapes
    private ArrayList<Shape> undShapes = new ArrayList<>();

    // enumerated type that defines the different shapes that can be drawn
    public enum ShapeType {
        RECT, OVAL, TRI
    }

    // currently selected shape and color
    private ShapeType currentShape;
    private Color lineColor;
    private Color fillColor;

    // variables to make drawing real-time interactive
    private boolean mouseDown; // is the mouse pressed down?
    private int startX; // x coord where mouse pressed down
    private int startY; // y coord where mouse pressed down
    private int currentX; // currentX pos
    private int currentY; // currentY pos
    private boolean isFill = false; //returns true if the color being chosen is the fill color and returns false if it is the line color
    /**
     * Returns the value of isFill
     * @return boolean
     */
    public boolean getIsFill()
    {
        return isFill;
    }
    /**
     * sets the value of the isFull boolean
     * @param b 
     */
    public void setIsFill(boolean b)
    {
        isFill = b;
    }

    //constructor
    public DrawingModel() {
        currentShape = ShapeType.RECT;
        lineColor = Color.BLACK;
        fillColor = Color.BLACK;
        mouseDown = false;
        currentX = 0;
        currentY = 0;
    }
    /**
     * This method is used to remove a shape from the picture and the array shapes 
     * and then adds the removed shape to the undShape array so we can put the shape back when we need it.
     */
    public void remove()
    {
        undShapes.add(shapes.get(shapes.size() - 1));
        shapes.remove(shapes.size() - 1);
    }
    /**
     * removes the last undone shape from the undShapes array
     */
    public void removeUndShape()
    {
            undShapes.remove(undShapes.size() -1);
    }
    /**
     * Returns the array of undone shapes
     * @return ArrayList<Shape>
     */
    public ArrayList<Shape> getUndShapes()
    {
        return undShapes;
    }
    /**
     * adds a new shape to the shapes array that holds all the shapes 
     * @param shape 
     */
    public void addNewShape(Shape shape) {
        shapes.add(shape);
    }
    /**
     * returns the shapes arrayList
     * @return ArrayList<Shape>
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Removes all shapes the user has drawn
     */
    public void clearModel() {
        shapes.clear();
    }

    /**
     * Returns the currently selected shape type (what the user would draw if
     * they clicked and dragged).
     *
     * @return ShapeType
     */
    public ShapeType getCurrentShape() {
        return currentShape;
    }

    /**
     * Sets the current shape type (what the user will draw if they click and
     * drag)
     *
     * @param currentShape
     */
    public void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }

    /**
     * Returns the current lineColor for drawing
     *
     * @return Color
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Sets the current lineColor for drawing
     *
     * @param lineColor Color
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Allows you to check whether user has their mouse pressed down
     *
     * @return boolean true if mouse is down
     */
    public boolean isMouseDown() {
        return mouseDown;
    }

    /**
     * Sets the mouseDown to true or false
     *
     * @param mouseDown boolean true if mouse button is pressed down
     */
    public void setMouseDown(boolean mouseDown) {
        this.mouseDown = mouseDown;
    }

    /**
     * Returns current x coordinate of cursor
     *
     * @return int x coord
     */
    public int getCurrentX() {
        return currentX;
    }

    /**
     * Sets the current X coord of cursor
     *
     * @param currentX int x coord
     */
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    /**
     * Returns current y coordinate of cursor
     *
     * @return int y coord
     */
    public int getCurrentY() {
        return currentY;
    }

    /**
     * Sets the current y coordinate of cursor
     *
     * @param currentY int y coord
     */
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    /**
     * Returns the x coordinate where the mouse was pressed down
     *
     * @return int x coord
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Set the x coordinate of where the mouse was pressed down
     *
     * @param startX int x coordinate
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Returns the y coordinate of where the mouse was pressed down
     *
     * @return int y
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Set the y coordinate of where the mouse was pressed down
     *
     * @param startY int y coord
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Returns the current fill color for drawing
     *
     * @return Color fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Sets the current fill color for drawing
     *
     * @param fillColor Color
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

}
