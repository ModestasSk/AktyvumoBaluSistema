/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import ds.AktyvumoBaluSistema;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pc
 */
public class DestytojoExport extends javax.swing.JDialog {
    private AktyvumoBaluSistema abs;
    /**
     * Creates new form DestytojoExport
     */
    public DestytojoExport(java.awt.Frame parent, AktyvumoBaluSistema ab) {
        super(parent, true);
        initComponents();
        abs = ab;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        patvirtinti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Failo pavadinimas:");

        patvirtinti.setText("Patvirtinti");
        patvirtinti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patvirtintiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patvirtinti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patvirtinti))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patvirtintiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patvirtintiActionPerformed
          try {
            File file = new File(jTextField1.getText() + ".txt");
            FileWriter fw = new FileWriter(file);
            for (Object o : abs.getDestytojai()) {
                fw.write("" + o + "\n");
            }
            fw.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_patvirtintiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton patvirtinti;
    // End of variables declaration//GEN-END:variables
}