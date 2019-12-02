package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This is the class for oval drawing
 * 
 * @author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
 */
public class Oval extends Shape {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int topLeftX;
    private int topLeftY;
    private int width;
    private int height;
    private Color lineColor;
    private Color fillColor;
    
   /**
    * constructor 
    * 
    *  @param startX int x coordinate at first end
     * @param startY int y coordinate at first end
     * @param endX int x coordinate at the other end
     * @param endY int y coordinate at the other end
     * @param color Color for the line
    */
    public Oval(int startX, int startY, int endX, int endY, Color color, Color fillColor) {

        this.fillColor = fillColor;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lineColor = color;

        // calculations for the rectangle, since it needs to know top left and width/height
        topLeftX = Math.min(startX, endX);
        topLeftY = Math.min(startY, endY);
        width = Math.abs(startX - endX);
        height = Math.abs(startY - endY);

    }
    /**
     * Draws the oval
     *
     * @param g2d The graphics context needed for drawing
     */
    public void draw(Graphics2D g2d) {
        // draw solid rectangle first
        g2d.setColor(fillColor);
        g2d.fillOval(topLeftX, topLeftY, width, height);
        // draw outline rectangle on top
        g2d.setColor(lineColor);
        g2d.drawOval(topLeftX, topLeftY, width, height);
    }
    /**
     * This static method is used to draw a oval without creating a oval object
     * It is used while the user is dragging the mouse, in order to show the
     * line in real-time
     *
     * @param g2d The graphics context needed for drawing
     * @param x1 int x coordinate at one end
     * @param y1 int y coordinate at one end
     * @param x2 int x coordinate at the other end
     * @param y2 int y coordinate at the other end
     * @param color Color for line
     */
    public static void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color lc, Color fc) {
        // draw solid rectangle first
        g2d.setColor(fc);
        g2d.fillOval(
                Math.min(x1, x2),
                Math.min(y1, y2),
                Math.abs(x1 - x2),
                Math.abs(y1 - y2));
        // draw outline on top
        g2d.setColor(lc);
        g2d.drawOval(
                Math.min(x1, x2),
                Math.min(y1, y2),
                Math.abs(x1 - x2),
                Math.abs(y1 - y2));

    }
}
