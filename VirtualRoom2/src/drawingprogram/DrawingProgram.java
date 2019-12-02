package drawingprogram;

/**
 * This is the harness that runs the ITIS 1213 Assignment4 Drawing Program
 *
 * @author Nathan Janus 
 * @version 4/23/2018
 * based on the work of clatulip
 */
public class DrawingProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a DrawingModel class to store all the stuff being drawn
        DrawingModel myModel = new DrawingModel();
        // Create the GUI window, pass it the model, so it knows what to draw
        DrawingWindow myWindow = new DrawingWindow(myModel);
        // Make the window visible
        myWindow.setVisible(true);
    }

}
