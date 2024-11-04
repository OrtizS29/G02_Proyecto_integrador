
package VISTA.admin;

import CONTROLADOR.GestionarApartamento;
import Modelo.entities.Apartamento;
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
 * @author Santiago
 */
public class EditarApartamento extends javax.swing.JFrame {

    private GestionarApartamento gestiApto;
    private Apartamento apto;
    
    public EditarApartamento(int id_apto) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiApto = new GestionarApartamento(factory);
        initComponents();
        cargarDatos(id_apto);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroApartamento = new javax.swing.JTextField();
        txtValorApartamento = new javax.swing.JTextField();
        txtTipoUnidad = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtFechaEscritura = new javax.swing.JTextField();
        btnGuardarApartamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 290, 30));

        txtValorApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 290, 30));

        txtTipoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtTipoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 290, 30));

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        getContentPane().add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 290, 30));

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 290, 30));

        txtFechaEscritura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEscrituraActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaEscritura, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 200, 30));

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

    private void txtValorApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorApartamentoActionPerformed

    private void txtTipoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUnidadActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtFechaEscrituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEscrituraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEscrituraActionPerformed

    private void btnGuardarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarApartamentoActionPerformed

        btnGuardarApartamento.setEnabled(false);

        int numeroApartamento = Integer.parseInt(txtNumeroApartamento.getText());
        int valorApartamento = Integer.parseInt(txtValorApartamento.getText());
        String tipoUnidad = txtTipoUnidad.getText();
        double area = Double.parseDouble(txtArea.getText().replace(",", "."));
        String matricula = txtMatricula.getText();
        Date fechaEscritura = getFechaDesdeTextField();

        try {
            gestiApto.editarApto(apto,numeroApartamento,valorApartamento,tipoUnidad,area,matricula,fechaEscritura);
        } catch (Exception ex) {
            Logger.getLogger(EditarApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        menuAdmin menuAdmin = new menuAdmin();
        menuAdmin.setVisible(true);
        menuAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnGuardarApartamento.setEnabled(true);
    }//GEN-LAST:event_btnGuardarApartamentoActionPerformed

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

    private void cargarDatos(int id_apto) {
        
        this.apto = gestiApto.buscarPorId(id_apto);
        
        txtNumeroApartamento.setText(String.valueOf(apto.getNum_apartamento()));
        txtValorApartamento.setText(String.valueOf(apto.getValor_apartamento()));
        txtTipoUnidad.setText(apto.getTipo_unidad());
        txtArea.setText(String.format("%.2f",apto.getArea()));
        txtMatricula.setText(apto.getMatricula());
        
        //Pasar de String a Date
        if(apto.getFecha_escritura() != null){
            SimpleDateFormat fort = new SimpleDateFormat("yyyy-MM-dd");
            txtFechaEscritura.setText(fort.format(apto.getFecha_escritura()));
            //Si no es nulo muestra el text file
            txtFechaEscritura.setVisible(true);
        }//Si esta vacio no muestra el text file para digitar
        else{txtFechaEscritura.setVisible(false);}
    }

    public Date getFechaDesdeTextField(){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String a =txtFechaEscritura.getText();
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
