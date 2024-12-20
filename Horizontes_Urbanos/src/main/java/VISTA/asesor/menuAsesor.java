/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA.asesor;

import Modelo.ConexionORACLE;
import VISTA.Login;

/**
 *
 * @author CLAUDIA
 */
public class menuAsesor extends javax.swing.JFrame {
    
    public menuAsesor() {
        initComponents();
        //setSize(912, 510);
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

        btnSalirAsesor = new javax.swing.JButton();
        btnAdministrarVenta = new javax.swing.JButton();
        btnAdministrarPago = new javax.swing.JButton();
        btnAdministrarCliente = new javax.swing.JButton();
        btnAdministrarDeuda = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalirAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnSalirAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSalirAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirAsesor.setText("Salir");
        btnSalirAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalirAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        btnAdministrarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAdministrarVenta.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarVenta.setText("ADMINISTRAR VENTA");
        btnAdministrarVenta.setBorderPainted(false);
        btnAdministrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 190, 40));

        btnAdministrarPago.setBackground(new java.awt.Color(255, 255, 255));
        btnAdministrarPago.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarPago.setText("ADMINISTRAR PAGO");
        btnAdministrarPago.setBorderPainted(false);
        btnAdministrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 190, 40));

        btnAdministrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnAdministrarCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarCliente.setText("ADMINISTRAR CLIENTE");
        btnAdministrarCliente.setBorderPainted(false);
        btnAdministrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 180, 40));

        btnAdministrarDeuda.setBackground(new java.awt.Color(255, 255, 255));
        btnAdministrarDeuda.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarDeuda.setText("ADMINISTRAR DEUDA");
        btnAdministrarDeuda.setBorderPainted(false);
        btnAdministrarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarDeudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 190, 50));

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDashboard.setText("DASHBOARD");
        btnDashboard.setBorderPainted(false);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menuAsesorA.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAsesorActionPerformed

        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirAsesorActionPerformed

    private void btnAdministrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarVentaActionPerformed
        
        ventaSeleccionarCliente ventaSelectCliente = new ventaSeleccionarCliente();
        ventaSelectCliente.setVisible(true);
        ventaSelectCliente.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarVentaActionPerformed

    private void btnAdministrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarPagoActionPerformed
        
        pagoSeleccionarClienteYVenta pagoSelectClienteVenta = new pagoSeleccionarClienteYVenta();
        pagoSelectClienteVenta.setVisible(true);
        pagoSelectClienteVenta.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarPagoActionPerformed

    private void btnAdministrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarClienteActionPerformed
        
        administrarCliente adminCliente = new administrarCliente();
        adminCliente.setVisible(true);
        adminCliente.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarClienteActionPerformed

    private void btnAdministrarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarDeudaActionPerformed

        deudaSeleccionarClienteYVenta deuSelectCYV = new deudaSeleccionarClienteYVenta();
        deuSelectCYV.setVisible(true);
        deuSelectCYV.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarDeudaActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
       
        dashBoardSeleccionarCliente dSelectCliente = new dashBoardSeleccionarCliente();
        dSelectCliente.setVisible(true);
        dSelectCliente.setLocationRelativeTo(null);
        this.dispose();
        
        
    }//GEN-LAST:event_btnDashboardActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarCliente;
    private javax.swing.JButton btnAdministrarDeuda;
    private javax.swing.JButton btnAdministrarPago;
    private javax.swing.JButton btnAdministrarVenta;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnSalirAsesor;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
