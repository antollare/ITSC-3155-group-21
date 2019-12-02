package drawingprogram;

/**
 *
 * @author Nathan Janus 
 * @version 4/23/2018
 */
public class ColorPicker extends javax.swing.JFrame {
    DrawingModel myModel;
    /**
     * Creates new form ColorPicker
     */
    public ColorPicker(DrawingModel model) {
        myModel = model;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorChooser = new javax.swing.JColorChooser();
        cancelButton = new javax.swing.JToggleButton();
        chooseButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        chooseButton.setText("Choose");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chooseButton)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(chooseButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * when the cancel button is clicked it just disposes of the frame 
     * and doesn't change anything
     * @param evt 
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    /**
     * sets the color of the object
     * @param evt 
     */
    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        myModel.setFillColor(colorChooser.getColor());
        myModel.setLineColor(colorChooser.getColor());
        this.dispose();
    }//GEN-LAST:event_chooseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cancelButton;
    private javax.swing.JToggleButton chooseButton;
    private javax.swing.JColorChooser colorChooser;
    // End of variables declaration//GEN-END:variables
}
