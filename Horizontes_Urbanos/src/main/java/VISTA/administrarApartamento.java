/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

/**
 *
 * @author juanc
 */
public class administrarApartamento extends javax.swing.JFrame {

    /**
     * Creates new form administrarApartamento
     */
    public administrarApartamento() {
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
        txtArea1 = new javax.swing.JTextField();
        txtTipoUnidad1 = new javax.swing.JTextField();
        txtTipoUnidad = new javax.swing.JTextField();
        txtNumeroApartamento = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        btnGuardarApartamento = new javax.swing.JButton();
        txtValorApartamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArea1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 230, 30));

        txtTipoUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUnidad1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 290, 30));

        txtTipoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUnidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 290, 30));

        txtNumeroApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 290, 30));

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        jPanel1.add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 290, 30));

        btnGuardarApartamento.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarApartamento.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarApartamento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarApartamento.setText("Guardar");
        btnGuardarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 110, 40));

        txtValorApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearApartamento.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 910, 510));

        jTabbedPane1.addTab("crearApartamento", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número apartamento", "Valor apartamento", "Tipo unidad", "Área", "Matrícula", "Fecha escritura"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 530, 190));

        jButton1.setBackground(new java.awt.Color(49, 134, 181));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 100, 30));

        jButton2.setBackground(new java.awt.Color(49, 134, 181));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarApartamento.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, -1, -1));

        jTabbedPane1.addTab("gestionarApartamento", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroApartamentoActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void btnGuardarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarApartamentoActionPerformed

        btnGuardarApartamento.setEnabled(false);

        int numeroApartamento = Integer.parseInt(txtNumeroApartamento.getText());
        int valorApartamento = Integer.parseInt(txtValorApartamento.getText());
        String tipoUnidad = txtTipoUnidad.getText();
        double area = Double.parseDouble(txtArea.getText());
        String matricula = txtMatricula.getText();
        Date fechaEscritura = getFechaDesdeTextField();

        Apartamento apartamento = new Apartamento();
        apartamento.setNum_apartamento(numeroApartamento);
        apartamento.setValor_apartamento(valorApartamento);
        apartamento.setTipo_unidad(tipoUnidad);
        apartamento.setArea(area);
        apartamento.setMatricula(matricula);
        apartamento.setFecha_escritura(fechaEscritura);
        apartamento.setTorre(torreActual);
        apartamento.setVenta(null);

        torreActual.getListaApartamentos().add(apartamento);

        gestiApto.guardar(apartamento);

        JOptionPane optionPane = new JOptionPane("Se guardo");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Guardado Exitoso");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        menuAdmin menuAdmin = new menuAdmin();
        menuAdmin.setVisible(true);
        menuAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnGuardarApartamento.setEnabled(true);
    }//GEN-LAST:event_btnGuardarApartamentoActionPerformed

    private void txtTipoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUnidadActionPerformed

    private void txtValorApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorApartamentoActionPerformed

    private void txtArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArea1ActionPerformed

    private void txtTipoUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUnidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUnidad1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarApartamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtArea1;
    private javax.swing.JTextField txtNumeroApartamento;
    private javax.swing.JTextField txtTipoUnidad;
    private javax.swing.JTextField txtTipoUnidad1;
    private javax.swing.JTextField txtValorApartamento;
    // End of variables declaration//GEN-END:variables
}
