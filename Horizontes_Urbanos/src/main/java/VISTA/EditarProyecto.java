/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROLADOR.GestionarProyecto;
import Modelo.entities.Proyecto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class EditarProyecto extends javax.swing.JFrame {

    private int id_proyecto;
    private GestionarProyecto gestiProyecto;
    private Proyecto proyect;
    
    public EditarProyecto(int id_proyecto) {
        this.gestiProyecto = new GestionarProyecto();
        initComponents();
        cargarDatos(id_proyecto);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreProyecto = new javax.swing.JTextField();
        txtNumeroDeTorres = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(txtNumeroDeTorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 290, 30));

        btnGuardar.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProyectoActionPerformed

    private void txtNumeroDeTorresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeTorresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeTorresActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        btnGuardar.setEnabled(false);

        String nombreProyecto = txtNombreProyecto.getText();
        int numeroTorres = Integer.parseInt(txtNumeroDeTorres.getText());
        
        try {
            gestiProyecto.editarProyecto(proyect,nombreProyecto, numeroTorres);
        } catch (Exception ex) {
            Logger.getLogger(EditarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //poner mensaje de que salio bien
        
        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        this.dispose();

        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtNumeroDeTorres;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos(int id_proyecto) {
        
        this.proyect = gestiProyecto.buscarPorId(id_proyecto);
        
        txtNombreProyecto.setText(proyect.getNombre_proyecto());
        //Agarra el String y lo pasa a int a numero
        txtNumeroDeTorres.setText(String.valueOf(proyect.getNumero_torres()));

    }
    
    
}
