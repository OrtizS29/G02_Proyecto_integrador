/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

/**
 *
 * @author juanc
 */
public class crearProyecto2 extends javax.swing.JFrame {

    /**
     * Creates new form crearProyecto2
     */
    public crearProyecto2() {
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

        btnSiguienteCrearProyecto = new javax.swing.JButton();
        txtNombreProyecto = new javax.swing.JTextField();
        txtNumeroDeTorres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSiguienteCrearProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteCrearProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteCrearProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCrearProyecto.setText("Siguiente");
        btnSiguienteCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCrearProyectoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguienteCrearProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 110, 40));

        txtNombreProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProyectoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 290, 30));

        txtNumeroDeTorres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeTorresActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroDeTorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProyectoActionPerformed

    private void txtNumeroDeTorresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeTorresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeTorresActionPerformed

    private void btnSiguienteCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCrearProyectoActionPerformed

    }//GEN-LAST:event_btnSiguienteCrearProyectoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguienteCrearProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtNumeroDeTorres;
    // End of variables declaration//GEN-END:variables
}
