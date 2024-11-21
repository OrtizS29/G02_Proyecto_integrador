
package VISTA.admin;

import CONTROLADOR.gestionar.GestionarAsesor;
import CONTROLADOR.gestionar.GestionarUsuario;
import Modelo.entities.Asesor;
import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class EditarAsesor extends javax.swing.JFrame {

    GestionarAsesor gestiAsesor;
    GestionarUsuario gestiUsuario;
    private Asesor asesor;
    private Usuario usuario;
    
    public EditarAsesor(Long ced_asesor) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiAsesor = new GestionarAsesor(factory);
        this.gestiUsuario = new GestionarUsuario(factory);
        initComponents();
        cargaDatos(ced_asesor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreAsesor = new javax.swing.JTextField();
        txtCedulaAsesor = new javax.swing.JTextField();
        txtDireccionAsesor = new javax.swing.JTextField();
        txtCorreoAsesorReg = new javax.swing.JTextField();
        txtContraseñaAsesor = new javax.swing.JTextField();
        btnGuardarAsesor = new javax.swing.JButton();
        txtUsuarioAsesor = new javax.swing.JTextField();
        txtTelefonoAsesorReg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 290, 20));

        txtCedulaAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedulaAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 290, -1));

        txtDireccionAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccionAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 290, 20));

        txtCorreoAsesorReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoAsesorRegActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreoAsesorReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 290, 20));

        txtContraseñaAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtContraseñaAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 290, 20));

        btnGuardarAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAsesor.setText("Guardar");
        btnGuardarAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 110, 40));

        txtUsuarioAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuarioAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 290, 20));

        txtTelefonoAsesorReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoAsesorRegActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefonoAsesorReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 290, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editarAsesor.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsesorActionPerformed

        btnGuardarAsesor.setEnabled(false);
        
        String nombreAsesor = txtNombreAsesor.getText();
        Long cedulaAsesor = Long.parseLong(txtCedulaAsesor.getText());
        String direccionAsesor = txtDireccionAsesor.getText();
        String correoAsesor = txtCorreoAsesorReg.getText();
        Long telefonoAsesor = Long.parseLong(txtTelefonoAsesorReg.getText());
        String UsuarioAse = txtUsuarioAsesor.getText();
        String Contraseña = txtContraseñaAsesor.getText();
        
        
        
        
        try {
            gestiAsesor.editar(asesor, cedulaAsesor, nombreAsesor, direccionAsesor,correoAsesor,telefonoAsesor);
        } catch (Exception ex) {
            Logger.getLogger(EditarAsesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gestiUsuario.editar(usuario, UsuarioAse, Contraseña);
        } catch (Exception ex) {
            Logger.getLogger(EditarAsesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        mAdmin.setLocationRelativeTo(null);
        this.dispose();
        
        btnGuardarAsesor.setEnabled(true);
    }//GEN-LAST:event_btnGuardarAsesorActionPerformed

    private void txtNombreAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAsesorActionPerformed

    private void txtCedulaAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaAsesorActionPerformed

    private void txtDireccionAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionAsesorActionPerformed

    private void txtCorreoAsesorRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoAsesorRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoAsesorRegActionPerformed

    private void txtContraseñaAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaAsesorActionPerformed

    private void txtUsuarioAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioAsesorActionPerformed

    private void txtTelefonoAsesorRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoAsesorRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoAsesorRegActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAsesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCedulaAsesor;
    private javax.swing.JTextField txtContraseñaAsesor;
    private javax.swing.JTextField txtCorreoAsesorReg;
    private javax.swing.JTextField txtDireccionAsesor;
    private javax.swing.JTextField txtNombreAsesor;
    private javax.swing.JTextField txtTelefonoAsesorReg;
    private javax.swing.JTextField txtUsuarioAsesor;
    // End of variables declaration//GEN-END:variables

    private void cargaDatos(Long ced_asesor) {
        this.asesor = gestiAsesor.buscarPorId(ced_asesor);
        this.usuario = gestiUsuario.obtenerAsesorCed(ced_asesor);
        
        txtNombreAsesor.setText(asesor.getNombre());
        
        txtCedulaAsesor.setText(String.valueOf(asesor.getCedula()));
        txtCedulaAsesor.setEditable(false);
        
        txtDireccionAsesor.setText(asesor.getDireccion());
        txtCorreoAsesorReg.setText(asesor.getCorreo());
        txtTelefonoAsesorReg.setText(String.valueOf(asesor.getTelefono()));
        txtUsuarioAsesor.setText(usuario.getUsuario());
        txtContraseñaAsesor.setText(usuario.getContraseña());
    }
}
