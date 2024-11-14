
package VISTA.asesor;

import CONTROLADOR.SessionManager;
import CONTROLADOR.gestionar.GestionarPago;
import Modelo.entities.Asesor;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc,Santiago
 */
public class pagoPrimeraCuota extends javax.swing.JFrame {

    GestionarPago gestiPago;
    Asesor asesorLogueado = SessionManager.getAsesorActual();
    Venta ventaActual;
    
    public pagoPrimeraCuota(Venta ventaActual) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiPago = new GestionarPago(factory);
        this.ventaActual = ventaActual;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValorPago = new javax.swing.JTextField();
        txtFechaPago = new javax.swing.JTextField();
        btnGuardarPago = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtValorPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorPagoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 280, 30));
        getContentPane().add(txtFechaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 280, 30));

        btnGuardarPago.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarPago.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPago.setText("Pagar");
        btnGuardarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pagoPrimeraCuota.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPagoActionPerformed

        btnGuardarPago.setEnabled(false);
        
        Date fecha = getFechaDesdeTxt();
        Long valorCal = ventaActual.getPrecio_final()/ventaActual.getNumero_coutas();
        txtValorPago.setText(valorCal.toString());
        Long valor_pago = valorCal;
        
        Pago pago = new Pago();
        pago.setFecha(fecha);
        pago.setValor_pago(valor_pago);
        
        pago.setAsesor(asesorLogueado);
        pago.setCliente(ventaActual.getCliente()); 
        pago.setVenta(ventaActual);
        
        ventaActual.getListaPagos().add(pago);
        asesorLogueado.getListaPagos().add(pago);
        ventaActual.getCliente().getListaPagos().add(pago);
        
        try {
            gestiPago.guardar(pago);
        } catch (Exception ex) {
            Logger.getLogger(pagoPrimeraCuota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        masesor.setLocationRelativeTo(null);
        this.dispose();
        
        btnGuardarPago.setEnabled(true);
    }//GEN-LAST:event_btnGuardarPagoActionPerformed

    private void txtValorPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPagoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtFechaPago;
    private javax.swing.JTextField txtValorPago;
    // End of variables declaration//GEN-END:variables

    private Date getFechaDesdeTxt() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String a = txtFechaPago.getText();
        if(a==null || a.isEmpty()){
            return null;
        }
        else{
            try {
                java.util.Date utilDate = formato.parse(a);
                return new Date(utilDate.getTime());
            } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Debe ser yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            }
        }
    }
}
