
package VISTA.asesor;

/**
 *
 * @author juanc,Santiago
 */
public class administrarPago extends javax.swing.JFrame {

    /**
     * Creates new form administrarPago
     */
    public administrarPago() {
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
        txtFechaPago = new javax.swing.JTextField();
        txtValorPago = new javax.swing.JTextField();
        btnGuardarPago = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarPago = new javax.swing.JTable();
        btnEliminarPago = new javax.swing.JButton();
        btnEditarPago = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPagoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 370, 30));

        txtValorPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorPagoActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 370, 30));

        btnGuardarPago.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarPago.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPago.setText("Guardar");
        btnGuardarPago.setBorder(null);
        btnGuardarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPagoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 90, 40));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrarPago.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        jTabbedPane1.addTab("registar pago", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarPago);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 600, 280));

        btnEliminarPago.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarPago.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPago.setText("Eliminar");
        btnEliminarPago.setBorder(null);
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 90, 40));

        btnEditarPago.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarPago.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPago.setText("Editar");
        btnEditarPago.setBorder(null);
        btnEditarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPagoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarPago.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 475));

        jTabbedPane1.addTab("gestionar pago", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 910, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnEditarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarPagoActionPerformed

    private void btnGuardarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarPagoActionPerformed

    private void txtFechaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPagoActionPerformed

    private void txtValorPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPagoActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPago;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.JButton btnGuardarPago;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarPago;
    private javax.swing.JTextField txtFechaPago;
    private javax.swing.JTextField txtValorPago;
    // End of variables declaration//GEN-END:variables
}
