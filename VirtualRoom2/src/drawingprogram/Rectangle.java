package drawingprogram;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class that draws the rectangle
 * 
 * @author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
 */
public class Rectangle extends Shape {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int topLeftX;
    private int topLeftY;
    private int width;
    private int height;
    //private Color lineColor;
    private Color fillColor;

    /**
     * Constructor to build a rectangle
     *
     * @param startX The top left X coordinate
     * @param startY The top left Y coordinate
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The outline color of the rectangle
     * @param fillColor the color that fills the shape
     */
    public Rectangle(int startX, int startY, int endX, int endY, Color color, Color fillColor) {

        this.fillColor = fillColor;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        //this.lineColor = color;

        // calculations for the rectangle, since it needs to know top left and width/height
        topLeftX = Math.min(startX, endX);
        topLeftY = Math.min(startY, endY);
        width = Math.abs(startX - endX);
        height = Math.abs(startY - endY);

    }

    /**
     * Draws the rectangle
     *
     * @param g2d The graphics context needed for drawing
     */
    public void draw(Graphics2D g2d) {
        // draw solid rectangle first
        g2d.setColor(fillColor);
        g2d.fillRect(topLeftX, topLeftY, width, height);
        // draw outline rectangle on top
        g2d.setColor(fillColor);
        g2d.drawRect(topLeftX, topLeftY, width, height);
    }

    /**
     * This static method is used to draw a rectangle before an actual rectangle
     * object is created It is used to give the user interactive feedback as
     * they are dragging the cursor
     *
     * @param g2d The graphics context needed for drawing
     * @param x1 int x coordinate from where mouse pressed down
     * @param y1 int y coordinate from where mouse pressed down
     * @param x2 int x coordinate from where mouse released
     * @param y2 int y coordinate from where mouse released
     * @param lc Color for line color
     * @param fc Color for fill color
     */
    public static void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color lc, Color fc) {
        // draw solid rectangle first
        g2d.setColor(fc);
        g2d.fillRect(
                Math.min(x1, x2),
                Math.min(y1, y2),
                Math.abs(x1 - x2),
                Math.abs(y1 - y2));
        // draw outline on top
        g2d.setColor(lc);
        g2d.drawRect(
                Math.min(x1, x2),
                Math.min(y1, y2),
                Math.abs(x1 - x2),
                Math.abs(y1 - y2));

    }
}
