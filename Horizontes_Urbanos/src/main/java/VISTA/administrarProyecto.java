/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import java.awt.event.ActionListener;

/**
 *
 * @author juanc
 */
public class administrarProyecto extends javax.swing.JFrame {

    /**
     * Creates new form gestionarProyecto
     */
    public administrarProyecto() {
        initComponents();
        setSize(912, 510); 
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnSiguienteCrearProyecto = new javax.swing.JButton();
        txtNumeroDeTorres = new javax.swing.JTextField();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSiguienteCrearProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteCrearProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteCrearProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCrearProyecto.setText("Siguiente");
        btnSiguienteCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCrearProyectoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguienteCrearProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 110, 40));

        txtNumeroDeTorres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeTorresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroDeTorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 290, 30));

        txtNombreProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProyectoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 480));

        jTabbedPane1.addTab("Crear Proyecto", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 480));

        jTabbedPane1.addTab("Gestionar Proyecto", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProyectoActionPerformed

    private void txtNumeroDeTorresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeTorresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeTorresActionPerformed

    private void btnSiguienteCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCrearProyectoActionPerformed

        btnSiguienteCrearProyecto.setEnabled(false);

        String nombreProyecto = txtNombreProyecto.getText();
        int numeroTorres = Integer.parseInt(txtNumeroDeTorres.getText());

        btnSiguienteCrearProyecto.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteCrearProyectoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguienteCrearProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtNumeroDeTorres;
    // End of variables declaration//GEN-END:variables
}
