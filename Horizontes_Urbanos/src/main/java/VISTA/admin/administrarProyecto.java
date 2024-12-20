
package VISTA.admin;

import VISTA.admin.EditarProyecto;
import CONTROLADOR.gestionar.GestionarProyecto;
import Modelo.entities.Administrador;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import Modelo.persistir.PersistirAdministrador;
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
public class administrarProyecto extends javax.swing.JFrame {
    PersistirAdministrador persistirAdmin;
    GestionarProyecto gestiProyecto;
    /**
     * Creates new form gestionarProyecto
     */
    public administrarProyecto() {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        persistirAdmin = new PersistirAdministrador();
        this.gestiProyecto = new GestionarProyecto(factory);
        initComponents();
        //setSize(909, 550); 
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnSiguienteCrearProyecto = new javax.swing.JButton();
        txtNombreProyecto = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarProyecto = new javax.swing.JTable();
        btnEliminarProyecto = new javax.swing.JButton();
        btnEditarProyecto = new javax.swing.JButton();
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

        btnSiguienteCrearProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteCrearProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteCrearProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCrearProyecto.setText("Siguiente");
        btnSiguienteCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCrearProyectoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguienteCrearProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 110, 40));

        txtNombreProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProyectoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 290, 30));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 480));

        jTabbedPane1.addTab("Crear Proyecto", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarProyecto);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 600, 270));

        btnEliminarProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProyecto.setText("Eliminar");
        btnEliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProyectoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 110, 40));

        btnEditarProyecto.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProyecto.setText("Editar");
        btnEditarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProyectoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarProyecto.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 490));

        jTabbedPane1.addTab("Gestionar Proyecto", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProyectoActionPerformed

    private void btnSiguienteCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCrearProyectoActionPerformed

        btnSiguienteCrearProyecto.setEnabled(false);
        
        Administrador administrador = null;
        try {
            administrador = persistirAdmin.obtener(68293849L);
        } catch (Exception ex) {
            Logger.getLogger(administrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nombreProyecto = txtNombreProyecto.getText();

        Proyecto nuevProyecto = new Proyecto();
        nuevProyecto.setNombre_proyecto(nombreProyecto);
        nuevProyecto.setAdministrador(administrador);
        nuevProyecto.setListaTorres(new ArrayList<Torre>());
        
        Proyecto proyectoActual = gestiProyecto.guardar(nuevProyecto);
        
        crearProyecto2 crearProyectoTorre = new crearProyecto2(gestiProyecto,proyectoActual);
        crearProyectoTorre.setVisible(true);
        crearProyectoTorre.setLocationRelativeTo(null);
        this.dispose();
        
        btnSiguienteCrearProyecto.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteCrearProyectoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            cargarTabla();
        } catch (Exception ex) {
            Logger.getLogger(administrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProyectoActionPerformed
        
        if(tablaMostrarProyecto.getRowCount() > 0){
            if(tablaMostrarProyecto.getSelectedRow() != -1){
                
                Long id_proyecto = Long .parseLong(String.valueOf(tablaMostrarProyecto.getValueAt(tablaMostrarProyecto.getSelectedRow(), 0)));
               
                gestiProyecto.borrar(id_proyecto);
                
                JOptionPane optionPane = new JOptionPane("Proyecto Eliminado Correctamente");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Borrado Exitoso");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
        
        try {
            cargarTabla();
        } catch (Exception ex) {
            Logger.getLogger(administrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarProyectoActionPerformed

    private void btnEditarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProyectoActionPerformed
        
        btnEditarProyecto.setEnabled(false);
        
        if(tablaMostrarProyecto.getRowCount() > 0){
            if(tablaMostrarProyecto.getSelectedRow() != -1){
                
                Long id_proyecto = Long.parseLong(String.valueOf(tablaMostrarProyecto.getValueAt(tablaMostrarProyecto.getSelectedRow(), 0)));
                
                EditarProyecto editProyecto = null;
                try {
                    editProyecto = new EditarProyecto(id_proyecto);
                } catch (Exception ex) {
                    Logger.getLogger(administrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
                editProyecto.setVisible(true);
                editProyecto.setLocationRelativeTo(null);
                this.dispose();
            }
            else {
                
            }
        }
        else{
        
        }
        
        btnEditarProyecto.setEnabled(true);
    }//GEN-LAST:event_btnEditarProyectoActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        mAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cargarTabla() throws Exception {

        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Numero Proyecto","Nombre Proyecto","Num Torres"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Proyecto> listaProyectos = gestiProyecto.obtenerProyectosAdmin();
        
        if(listaProyectos != null){
            
            Collections.sort(listaProyectos, new Comparator<Proyecto>(){
                @Override
                public int compare(Proyecto p1, Proyecto p2) {
                    return Long.compare(p1.getId_proyecto(), p2.getId_proyecto());
                }
            });
            
            for(Proyecto proyect: listaProyectos){
                int numero_torres = gestiProyecto.contarNTorres(proyect.getNombre_proyecto());
                
                Object[] objeto ={proyect.getId_proyecto(),proyect.getNombre_proyecto(),numero_torres};
                modeloTabla.addRow(objeto);
            }
        }
        tablaMostrarProyecto.setModel(modeloTabla);
        tablaMostrarProyecto.getTableHeader().setReorderingAllowed(false);
        
        TableColumnModel columnModel = tablaMostrarProyecto.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarProyecto.setRowHeight(30);
        tablaMostrarProyecto.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProyecto;
    private javax.swing.JButton btnEliminarProyecto;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguienteCrearProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    // End of variables declaration//GEN-END:variables
}
