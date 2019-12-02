package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * This is the class that draws the triangels
 *
 *@author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
 */
public class Triangle extends Shape {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int width;
    private int height;
    private Color lineColor;
    private Color fillColor;

    /**
     * constructor
     * 
     * @param startX The top X coordinate
     * @param startY The top Y coordinate
     * @param width The width of the triangle
     * @param height The height of the triangle
     * @param color The outline color of the rectangle
     * @peram fillColor The color that fills the Shape
     */
    public Triangle(int startX, int startY, int endX, int endY, Color color, Color fillColor) {

        this.fillColor = fillColor;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lineColor = color;

        // calculations for the height and width of the triangle
        width = Math.abs(startX - endX);
        height = Math.abs(startY - endY);

    }
    /**
     * This draws the triangle
     * 
     * @param g2d the graphics content needed to draw it
     */
    public void draw(Graphics2D g2d) {
        //if the user drags the triangle to the right of the initial x coodinate
        if(endX > startX)
        {
            //creates the solid triangle 
            g2d.setColor(fillColor);
            g2d.fillPolygon(new int[]{startX, endX, startX - (width)}, new int[]{startY, endY, endY}, 3);
            //creates the hallow triangle
            g2d.setColor(lineColor);
            g2d.drawPolygon(new int[]{startX, endX, startX - (width)}, new int[]{startY, endY, endY}, 3);
        }
        //if the user drags the triangle to the left of the initial x coordinate
        else
        {
            //creates the solid triangle
            g2d.setColor(fillColor);
            g2d.fillPolygon(new int[]{startX, endX, startX + (width)}, new int[]{startY, endY, endY}, 3);
            //creates the hallow triangle
            g2d.setColor(lineColor);
            g2d.drawPolygon(new int[]{startX, endX, startX + (width)}, new int[]{startY, endY, endY}, 3);
        }
    }
    /**
     * This static method is used to draw a triangle before an actual triangle
     * object is created It is used to give the user interactive feedback as
     * they are dragging the cursor
     * 
     * @param g2d the graphics contend needed for the triangle
     * @param x1 this is the array of x coordinates needed to draw the triangle
     * @param y1 this is the array of y coordinates needed to draw the triangle
     * @param t this is the length of the array used to determine how many points the polygon has (in this case it always has 3)
     * @param lc this is the color of the line or the border of the triangle
     * @param fc this is the color of the fill or the inside of the triangle
     */
    public static void draw(Graphics2D g2d, int[] x1, int[] y1, int t, Color lc, Color fc) {
        // draw solid triangle first
        g2d.setColor(fc);
        g2d.fillPolygon(
                x1,
                y1,
                t);
        // draw outline on top
        g2d.setColor(lc);
        g2d.drawPolygon(
                x1,
                y1,
                t);

    }
}
