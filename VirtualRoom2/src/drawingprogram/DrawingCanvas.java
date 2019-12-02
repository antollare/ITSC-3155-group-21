package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class creates a drawing canvas and extends JPanel We do this so that we
 * can override JPanel's paintComponent method, so we can control what is drawn
 *
 * @author Nathan Janus 
 * @version 4/23/2018
 * 
 * based on the work of clatulip
 */
public class DrawingCanvas extends JPanel {

    private DrawingModel myModel;

    /**
     * Constructor Set the background of the canvas to white
     */
    public DrawingCanvas() {
        this.setBackground(Color.WHITE);
    }

    /**
     * Need this so we can pass in the model
     *
     * @param model
     */
    public void setModel(DrawingModel model) {
        myModel = model;
    }

    protected void paintComponent(Graphics g) {
        // first, check to make sure we have a model, 
        // otherwise there is nothing to draw
        if (myModel != null) {
            super.paintComponent(g);
            // get the graphics context for drawing (don't change this)
            Graphics2D g2d = (Graphics2D) g.create();
            //one of the few things i changed in this class, This loop iterates 
            //through the shapes array and draws the specified shapes instead of how 
            //it was before where there were two seperate arrays for lines and rectanges 
            //that were itereated through
            ArrayList<Shape> shapes = myModel.getShapes();
            for (Shape s : shapes) {
                s.draw(g2d);
            }
            // see if user's mouse is down and is currently drawing
            // this is to show a shape while the user is drawing
            // interactive feedback is important
            // you can comment this section out and see what happens if you 
            // don't believe how important this is...
            if (myModel.isMouseDown()) {

                switch (myModel.getCurrentShape()) {
                    case RECT:
                        Rectangle.draw(g2d,
                                myModel.getStartX(),
                                myModel.getStartY(),
                                myModel.getCurrentX(),
                                myModel.getCurrentY(),
                                myModel.getLineColor(),
                                myModel.getFillColor()
                        );
                        break;
                        //I added this oval shape 
                    case OVAL:
                        Oval.draw(g2d, myModel.getStartX(),
                                myModel.getStartY(),
                                myModel.getCurrentX(),
                                myModel.getCurrentY(),
                                myModel.getLineColor(),
                                myModel.getFillColor()
                        );
                        break;
                        //I also added this triange shape
                    case TRI:
                        //new int[] {startX, endX, startX - (width)}, new int[] {startY, endY, endY}, 3
                        if(myModel.getCurrentX() > myModel.getStartX())
                        {
                            Triangle.draw(g2d,
                                    new int[]{myModel.getStartX(), myModel.getCurrentX(), myModel.getStartX() + (myModel.getStartX() - myModel.getCurrentX())},
                                    new int[]{myModel.getStartY(), myModel.getCurrentY(), myModel.getCurrentY()},
                                    3,
                                    myModel.getLineColor(),
                                    myModel.getFillColor());
                        }
                        else
                        {
                            Triangle.draw(g2d,
                                    new int[]{myModel.getStartX(), myModel.getCurrentX(), myModel.getStartX() + (myModel.getStartX() - myModel.getCurrentX())},
                                    new int[]{myModel.getStartY(), myModel.getCurrentY(), myModel.getCurrentY()},
                                    3,
                                    myModel.getLineColor(),
                                    myModel.getFillColor());
                        }
                                
                }
            }
            // done with drawing, get rid of graphics context (don't change this)
            g2d.dispose();
        }
    }

    public void update() {
        // this calls the parent class repaint method, 
        // which in turn forces the paintComponent method to be called
        repaint();
    }
}
