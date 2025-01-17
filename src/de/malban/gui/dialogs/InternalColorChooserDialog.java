/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.malban.gui.dialogs;

import de.malban.config.Configuration;
import de.malban.gui.components.ModalInternalFrame;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author malban
 */
public class InternalColorChooserDialog extends javax.swing.JPanel {

    /**
     * Creates new form InternalFrameColorChooser
     */
    public InternalColorChooserDialog() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooser = new de.malban.gui.dialogs.ColorChooserComponent();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        jButtonCancel.setText("cancel");

        jButtonOk.setText("select");
        jButtonOk.setName("create"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.malban.gui.dialogs.ColorChooserComponent chooser;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    // End of variables declaration//GEN-END:variables
    public static Color showDialog(String title)
    {
        return showDialog(title, null);
    }
    ModalInternalFrame modelDialog;
    public static Color showDialog(String title, Color col)
    {
        JFrame frame = Configuration.getConfiguration().getMainFrame();
        InternalColorChooserDialog panel = new InternalColorChooserDialog();
        ArrayList<JButton> eb= new ArrayList<JButton>();
        eb.add(panel.jButtonOk);
        eb.add(panel.jButtonCancel);
        ModalInternalFrame modal = new ModalInternalFrame(title, frame.getRootPane(), frame, panel,null, null , eb);
        if (col != null)
            panel.chooser.setColor(col);
        modal.setResizable(true);
        panel.modelDialog = modal;
        modal.setVisible(true);

        String result = modal.getNamedExit();
        if ((result.equals("create")) || (modal.isManualOkExit()))
        {
            return panel.chooser.getColor();
        }
        return null;
    }


}
