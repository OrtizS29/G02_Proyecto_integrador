/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA.asesor;

import CONTROLADOR.gestionar.GestionarCliente;
import Modelo.entities.Cliente;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class EditarCliente extends javax.swing.JFrame {

    private GestionarCliente gestiCliente;
    private Cliente cliente;
    
    public EditarCliente(Long ced_Cliente) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiCliente = new GestionarCliente(factory);
        initComponents();
        cargarDatos(ced_Cliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedulaCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        cmbSubsidio = new javax.swing.JComboBox<>();
        txtSubsidioMinisterio = new javax.swing.JTextField();
        txtCorreoCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCedulaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 320, 30));

        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 320, 30));

        txtDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 320, 30));

        cmbSubsidio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SI", "NO" }));
        cmbSubsidio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubsidioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSubsidio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 120, 30));

        txtSubsidioMinisterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubsidioMinisterioActionPerformed(evt);
            }
        });
        getContentPane().add(txtSubsidioMinisterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 320, 30));

        txtCorreoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 320, 30));

        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 320, 30));

        btnGuardarCliente.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.setBorder(null);
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editarCliente.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaClienteActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteActionPerformed

    private void cmbSubsidioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubsidioActionPerformed

        String sisben = (String) cmbSubsidio.getSelectedItem();
        if(sisben.equals("SI")){
            txtSubsidioMinisterio.setVisible(true);
        } else {
            txtSubsidioMinisterio.setVisible(false);
        }
    }//GEN-LAST:event_cmbSubsidioActionPerformed

    private void txtSubsidioMinisterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubsidioMinisterioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubsidioMinisterioActionPerformed

    private void txtCorreoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoClienteActionPerformed

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed

        btnGuardarCliente.setEnabled(false);

        Long cedulaCliente = Long.parseLong(txtCedulaCliente.getText());
        String nombreCliente = txtNombreCliente.getText();
        String direccionCliente = txtDireccionCliente.getText();
        String sisben = (String) cmbSubsidio.getSelectedItem();
        String correo = txtCorreoCliente.getText();
        Long telefono = Long.parseLong(txtTelefonoCliente.getText());
        Long sub = 0L;
        if (sisben.equals("SI") && !txtSubsidioMinisterio.getText().isEmpty()) {
            Long subsidioMinisterio = Long.parseLong(txtSubsidioMinisterio.getText());
            sub = subsidioMinisterio;
        }
        
        try {
            gestiCliente.editar(cliente,cedulaCliente,nombreCliente,direccionCliente,sisben,correo,telefono,sub);
        } catch (Exception ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        masesor.setLocationRelativeTo(null);
        this.dispose();

        btnGuardarCliente.setEnabled(true);
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JComboBox<String> cmbSubsidio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtSubsidioMinisterio;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos(Long ced_Cliente){
            
        this.cliente = gestiCliente.buscarPorId(ced_Cliente);
        
        txtCedulaCliente.setText(String.valueOf(cliente.getCedula()));
        txtNombreCliente.setText(cliente.getNombre());
        txtDireccionCliente.setText(cliente.getDireccion());
        
        cmbSubsidio.setSelectedItem(cliente.getSisben());
        
        txtSubsidioMinisterio.setText(String.valueOf(cliente.getSubsidio_ministerio()));
        
        txtCorreoCliente.setText(cliente.getCorreo());
        txtTelefonoCliente.setText(String.valueOf(cliente.getTelefono()));
    }

}
