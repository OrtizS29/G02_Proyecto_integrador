/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA.admin;

/**
 *
 * @author CLAUDIA
 */
public class AdministrarAsesor extends javax.swing.JFrame {

    /**
     * Creates new form AdministrarAsesor
     */
    public AdministrarAsesor() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtCorreoAsesor = new javax.swing.JTextField();
        txtNombreAsesor1 = new javax.swing.JTextField();
        txtCedulaAsesor1 = new javax.swing.JTextField();
        txtDireccionAsesor1 = new javax.swing.JTextField();
        txtCorreoAsesor1 = new javax.swing.JTextField();
        btnSiguienteAsesor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardarAsesor = new javax.swing.JButton();
        btnGuardarAsesor1 = new javax.swing.JButton();
        btnGuardarAsesor2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreoAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 290, 30));

        txtNombreAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAsesor1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreAsesor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 290, 30));

        txtCedulaAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaAsesor1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaAsesor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 290, 30));

        txtDireccionAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionAsesor1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccionAsesor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 290, 30));

        txtCorreoAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoAsesor1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoAsesor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 290, 30));

        btnSiguienteAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteAsesor.setText("Siguiente");
        btnSiguienteAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguienteAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 110, 40));

        jTabbedPane1.addTab("Registrar Asesor", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 620, 310));

        btnGuardarAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAsesor.setText("Eliminar");
        btnGuardarAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsesorActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 110, 40));

        btnGuardarAsesor1.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAsesor1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAsesor1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAsesor1.setText("Agregar");
        btnGuardarAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsesor1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarAsesor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 110, 40));

        btnGuardarAsesor2.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAsesor2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAsesor2.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAsesor2.setText("Editar");
        btnGuardarAsesor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsesor2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarAsesor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 110, 40));

        jTabbedPane1.addTab("Gestionar Asesor", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoAsesorActionPerformed

    private void txtNombreAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAsesor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAsesor1ActionPerformed

    private void txtCedulaAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaAsesor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaAsesor1ActionPerformed

    private void txtDireccionAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionAsesor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionAsesor1ActionPerformed

    private void txtCorreoAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoAsesor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoAsesor1ActionPerformed

    private void btnSiguienteAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAsesorActionPerformed

        btnSiguienteAsesor.setEnabled(false);

        

        btnSiguienteAsesor.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteAsesorActionPerformed

    private void btnGuardarAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsesorActionPerformed

        btnGuardarAsesor.setEnabled(false);

        btnGuardarAsesor.setEnabled(true);
    }//GEN-LAST:event_btnGuardarAsesorActionPerformed

    private void btnGuardarAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsesor1ActionPerformed

        btnGuardarAsesor.setEnabled(false);

        btnGuardarAsesor.setEnabled(true);
    }//GEN-LAST:event_btnGuardarAsesor1ActionPerformed

    private void btnGuardarAsesor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsesor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarAsesor2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAsesor;
    private javax.swing.JButton btnGuardarAsesor1;
    private javax.swing.JButton btnGuardarAsesor2;
    private javax.swing.JButton btnSiguienteAsesor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCedulaAsesor1;
    private javax.swing.JTextField txtCorreoAsesor;
    private javax.swing.JTextField txtCorreoAsesor1;
    private javax.swing.JTextField txtDireccionAsesor1;
    private javax.swing.JTextField txtNombreAsesor1;
    // End of variables declaration//GEN-END:variables
}
