/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROLADOR.GestionarApartamento;
import CONTROLADOR.GestionarTorre;
import Modelo.entities.Apartamento;
import Modelo.entities.Torre;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class crearProyecto3 extends javax.swing.JFrame {

    GestionarApartamento gestiApto;
    GestionarTorre gestiTorre;
    Torre torreActual;
    /**
     * Creates new form crearProyecto3
     */
    public crearProyecto3(GestionarTorre gestiTorre,Torre torreActual) {
        this.gestiApto = new GestionarApartamento();
        this.gestiTorre = gestiTorre;
        this.torreActual = torreActual;
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

        txtNumeroApartamento = new javax.swing.JTextField();
        txtValorApartamento = new javax.swing.JTextField();
        txtTipoUnidad = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtFechaEscritura = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        btnGuardarApartamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 290, 30));

        txtValorApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 290, 30));

        txtTipoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtTipoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 290, 30));

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        getContentPane().add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 290, 30));

        txtFechaEscritura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEscrituraActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaEscritura, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 240, 30));

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 290, 30));

        btnGuardarApartamento.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarApartamento.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarApartamento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarApartamento.setText("Guardar");
        btnGuardarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroApartamentoActionPerformed

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
        
        
        btnGuardarApartamento.setEnabled(true);
    }//GEN-LAST:event_btnGuardarApartamentoActionPerformed

    private void txtValorApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorApartamentoActionPerformed

    private void txtTipoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUnidadActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void txtFechaEscrituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEscrituraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEscrituraActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    /**
     * Metodo que convierte string en Date para guardarlo bien en la base de datos
     * @return Date
     */
    public Date getFechaDesdeTextField() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String a =txtFechaEscritura.getText();
        if(a==null){
            return null;
        }
            try {
                java.util.Date utilDate = formato.parse(a);
                return new Date(utilDate.getTime());
            } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Debe ser yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Retorna null si ocurre un error
        
    }
}
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarApartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtFechaEscritura;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNumeroApartamento;
    private javax.swing.JTextField txtTipoUnidad;
    private javax.swing.JTextField txtValorApartamento;
    // End of variables declaration//GEN-END:variables
}
