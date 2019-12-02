package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/*
 * This is the abstarct shape class the controls the shapes
 *
 *@author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
*/
public abstract class Shape {
    public abstract void draw(Graphics2D g2d);
}
