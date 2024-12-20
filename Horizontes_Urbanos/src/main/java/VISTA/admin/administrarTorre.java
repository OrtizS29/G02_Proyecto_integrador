/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA.admin;

import VISTA.admin.administrarProyecto;
import VISTA.admin.EditarTorre;
import CONTROLADOR.gestionar.GestionarProyecto;
import CONTROLADOR.gestionar.GestionarTorre;
import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juanc,Santiago
 */
public class administrarTorre extends javax.swing.JFrame {

    Proyecto proyectoSeleccionado;
    GestionarProyecto gestiProyecto;
    GestionarTorre gestiTorre;
    
    public administrarTorre(Proyecto proyectoSeleccionado) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiProyecto = new GestionarProyecto(factory);
        this.gestiTorre = new GestionarTorre(factory);
        this.proyectoSeleccionado = proyectoSeleccionado;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnSiguienteCrearProyecto = new javax.swing.JButton();
        txtNumeroTorre = new javax.swing.JTextField();
        txtProyectoActual = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminarProyecto = new javax.swing.JButton();
        btnEditarTorre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarTorre = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSiguienteCrearProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteCrearProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteCrearProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCrearProyecto.setText("Siguiente");
        btnSiguienteCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCrearProyectoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguienteCrearProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 100, 40));

        txtNumeroTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroTorreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 280, 30));

        txtProyectoActual.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtProyectoActual.setText("jTextField1");
        txtProyectoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProyectoActualActionPerformed(evt);
            }
        });
        jPanel1.add(txtProyectoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 210, 40));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 100, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearTorre.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        jTabbedPane1.addTab("Crear Torre", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProyecto.setText("Eliminar");
        btnEliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProyectoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 110, 40));

        btnEditarTorre.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarTorre.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarTorre.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTorre.setText("Editar");
        btnEditarTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTorreActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 110, 40));

        tablaMostrarTorre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarTorre);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 620, 320));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarTorre.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 510));

        jTabbedPane1.addTab("Gestionar Torre", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCrearProyectoActionPerformed
        btnSiguienteCrearProyecto.setEnabled(false);
        
        int numeroTorre = Integer.parseInt(txtNumeroTorre.getText());
        
        Torre torre = new Torre();
        torre.setNumero_torre(numeroTorre);
        torre.setProyecto(proyectoSeleccionado);
        torre.setListaApartamentos(new ArrayList<Apartamento>());
        
        //añade la torre a la lista torre del proyecto que cree anteriormente
        proyectoSeleccionado.getListaTorres().add(torre);
        Torre torreActual = gestiTorre.guardar(torre);
        
        crearTorre2 crearTorreSelect = new crearTorre2(torreActual);
        crearTorreSelect.setVisible(true);
        crearTorreSelect.setLocationRelativeTo(null);
        this.dispose();
        
        btnSiguienteCrearProyecto.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteCrearProyectoActionPerformed

    private void txtNumeroTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroTorreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroTorreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.txtProyectoActual.setText(proyectoSeleccionado.getNombre_proyecto());
        this.txtProyectoActual.setEditable(false);
        try {
            cargarTabla();
        } catch (Exception ex) {
            Logger.getLogger(administrarTorre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProyectoActionPerformed

        if(tablaMostrarTorre.getRowCount() > 0){
            if(tablaMostrarTorre.getSelectedRow() != -1){

                Long id_torre = Long.parseLong(String.valueOf(tablaMostrarTorre.getValueAt(tablaMostrarTorre.getSelectedRow(), 0)));

                try {
                    boolean op = gestiTorre.borrarT(proyectoSeleccionado,id_torre);
                    
                    if(op == true){
                        JOptionPane optionPane = new JOptionPane("Torre Eliminada Correctamente");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Borrado Exitoso");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                    else{
                        JOptionPane optionPane = new JOptionPane("No se puede eliminar la unica torre del proyecto");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Restriccion del sistema");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(administrarTorre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        try {
            cargarTabla();
        } catch (Exception ex) {
            Logger.getLogger(administrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEliminarProyectoActionPerformed

    private void cargarTabla() throws Exception {

        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Identificador Torre","Numero Torre","Numero Apartamentos","Nombre Proyecto",
            "Numero Torres Proyecto"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        Long id = proyectoSeleccionado.getId_proyecto();
        List<Torre> listaTorres = gestiTorre.obtenerTorresProyecto(id);
        
        if(listaTorres != null){
            
            Collections.sort(listaTorres, new Comparator<Torre>(){
                @Override
                public int compare(Torre t1, Torre t2) {
                    return Long.compare(t1.getId_torre(), t2.getId_torre());
                }
            });
            
            for(Torre torre: listaTorres){
                int numero_torres = gestiProyecto.contarNTorres(torre.getProyecto().getNombre_proyecto());
                int numero_apto = gestiTorre.contarNAptos(torre.getNumero_torre(),id);
                Object[] objeto ={torre.getId_torre(),torre.getNumero_torre(),numero_apto
                ,torre.getProyecto().getNombre_proyecto(),numero_torres};
                modeloTabla.addRow(objeto);
            }
        }
        tablaMostrarTorre.setModel(modeloTabla);
        tablaMostrarTorre.getTableHeader().setReorderingAllowed(false);
        
        TableColumnModel columnModel = tablaMostrarTorre.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarTorre.setRowHeight(30);
        tablaMostrarTorre.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    
    
    
    
    private void btnEditarTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTorreActionPerformed
        
         btnEditarTorre.setEnabled(false);
        
        if(tablaMostrarTorre.getRowCount() > 0){
            if(tablaMostrarTorre.getSelectedRow() != -1){
                
                Long id_torre = Long.parseLong(String.valueOf(tablaMostrarTorre.getValueAt(tablaMostrarTorre.getSelectedRow(), 0)));
                
                EditarTorre editTorre = new EditarTorre(id_torre);
                editTorre.setVisible(true);
                editTorre.setLocationRelativeTo(null);
                this.dispose();
            }
            else {
                
            }
        }
        else{
        
        }
        
        btnEditarTorre.setEnabled(true);
        
    }//GEN-LAST:event_btnEditarTorreActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        btnMenu.setEnabled(false);
        
        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        mAdmin.setLocationRelativeTo(null);
        this.dispose();
        
        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtProyectoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProyectoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProyectoActualActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarTorre;
    private javax.swing.JButton btnEliminarProyecto;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguienteCrearProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarTorre;
    private javax.swing.JTextField txtNumeroTorre;
    private javax.swing.JTextField txtProyectoActual;
    // End of variables declaration//GEN-END:variables
}
