
package VISTA.admin;

import CONTROLADOR.gestionar.GestionarAsesor;
import Modelo.entities.Asesor;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author CLAUDIA
 */
public class administrarAsesor extends javax.swing.JFrame {

    GestionarAsesor gestiAsesor;
    
    public administrarAsesor() {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiAsesor = new GestionarAsesor(factory);
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
        txtTelefonoAsesorReg = new javax.swing.JTextField();
        txtNombreAsesor = new javax.swing.JTextField();
        txtCedulaAsesor = new javax.swing.JTextField();
        txtDireccionAsesor = new javax.swing.JTextField();
        txtCorreoAsesorReg = new javax.swing.JTextField();
        btnSiguienteAsesor = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarAsesor = new javax.swing.JTable();
        btnEliminarAsesor = new javax.swing.JButton();
        btnEditarAsesor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTelefonoAsesorReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoAsesorRegActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonoAsesorReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 290, 20));

        txtNombreAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 290, 20));

        txtCedulaAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 290, 20));

        txtDireccionAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccionAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 290, 20));

        txtCorreoAsesorReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoAsesorRegActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoAsesorReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 290, 20));

        btnSiguienteAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteAsesor.setText("Siguiente");
        btnSiguienteAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAsesorActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguienteAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 110, 40));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrarAsesor.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 430));

        jTabbedPane1.addTab("Registrar Asesor", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarAsesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarAsesor);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 680, 310));

        btnEliminarAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAsesor.setText("Eliminar");
        btnEliminarAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsesorActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, 40));

        btnEditarAsesor.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarAsesor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarAsesor.setText("Editar");
        btnEditarAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAsesorActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarAsesor.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Gestionar Asesor", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoAsesorRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoAsesorRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoAsesorRegActionPerformed

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

    private void btnSiguienteAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAsesorActionPerformed

        btnSiguienteAsesor.setEnabled(false);

        String nombreAsesor = txtNombreAsesor.getText();
        Long cedulaAsesor = Long.parseLong(txtCedulaAsesor.getText());
        String direccionAsesor = txtDireccionAsesor.getText();
        String correoAsesor = txtCorreoAsesorReg.getText();
        Long telefonoAsesor = Long.parseLong(txtTelefonoAsesorReg.getText());
        
        Asesor asesor = new Asesor();
        asesor.setNombre(nombreAsesor);
        asesor.setCedula(cedulaAsesor);
        asesor.setDireccion(direccionAsesor);
        asesor.setCorreo(correoAsesor);
        asesor.setTelefono(telefonoAsesor);
        asesor.setListaVentas(new ArrayList<Venta>());
        asesor.setListaPagos(new ArrayList<Pago>());
        
        Asesor asesorSelect = null;
        try {
            asesorSelect = gestiAsesor.guardar(asesor);
        } catch (Exception ex) {
            Logger.getLogger(administrarAsesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        UsuarioAsesor usuAsesor = new UsuarioAsesor(asesorSelect);
        usuAsesor.setVisible(true);
        usuAsesor.setLocationRelativeTo(null);
        this.dispose();

        btnSiguienteAsesor.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteAsesorActionPerformed

    private void btnEliminarAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsesorActionPerformed

        btnEliminarAsesor.setEnabled(false);

        if(tablaMostrarAsesor.getRowCount() > 0){
            if(tablaMostrarAsesor.getSelectedRow() != -1){
                
                Long ced_asesor = Long.parseLong(String.valueOf(tablaMostrarAsesor.getValueAt(tablaMostrarAsesor.getSelectedRow(), 0)));
               
                gestiAsesor.borrar(ced_asesor);
                
                JOptionPane optionPane = new JOptionPane("Asesor Eliminado Correctamente");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Borrado Exitoso");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
        
        cargarTabla();
        
        btnEliminarAsesor.setEnabled(true);
    }//GEN-LAST:event_btnEliminarAsesorActionPerformed

    private void btnEditarAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAsesorActionPerformed
        
        btnEditarAsesor.setEnabled(true);
        
        if(tablaMostrarAsesor.getRowCount() > 0){
            if(tablaMostrarAsesor.getSelectedRow() != -1){
                
                Long ced_asesor = Long.parseLong(String.valueOf(tablaMostrarAsesor.getValueAt(tablaMostrarAsesor.getSelectedRow(), 0)));
                
                
                EditarAsesor editAsesor = new EditarAsesor(ced_asesor);
                editAsesor.setVisible(true);
                editAsesor.setLocationRelativeTo(null);
                this.dispose();
            }
            else {
                JOptionPane optionPane = new JOptionPane("No seleccino ningun registro");optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error al editar");dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
        else{
            JOptionPane optionPane = new JOptionPane("La tabla esta vacia");optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("Error al editar");dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        
        
        btnEditarAsesor.setEnabled(true);
    }//GEN-LAST:event_btnEditarAsesorActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        mAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        
        cargarTabla();
        
            
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAsesor;
    private javax.swing.JButton btnEliminarAsesor;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguienteAsesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarAsesor;
    private javax.swing.JTextField txtCedulaAsesor;
    private javax.swing.JTextField txtCorreoAsesorReg;
    private javax.swing.JTextField txtDireccionAsesor;
    private javax.swing.JTextField txtNombreAsesor;
    private javax.swing.JTextField txtTelefonoAsesorReg;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Cedula","Nombre Asesor","Direccion","Correo","Telefono"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Asesor> listaAsesores = gestiAsesor.traerAsesores();

        for (Asesor asesor : listaAsesores) {
            Object[] objeto = {asesor.getCedula(), asesor.getNombre(), asesor.getDireccion(), 
                asesor.getCorreo(), asesor.getTelefono()};
            modeloTabla.addRow(objeto);
        }

        tablaMostrarAsesor.setModel(modeloTabla);
        tablaMostrarAsesor.getTableHeader().setReorderingAllowed(false);
        
        tablaMostrarAsesor.setRowHeight(30);
        tablaMostrarAsesor.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }
}

    
