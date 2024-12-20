
package VISTA.admin;

import VISTA.admin.EditarApartamento;
import CONTROLADOR.gestionar.GestionarApartamento;
import CONTROLADOR.gestionar.GestionarProyecto;
import CONTROLADOR.gestionar.GestionarTorre;
import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juanc
 */
public class administrarApartamento extends javax.swing.JFrame {

    GestionarProyecto gestiProyecto;
    GestionarTorre gestiTorre;
    GestionarApartamento gestiApto;
    Proyecto proyectoSeleccionado;
    Torre torreSeleccionada;
    
    public administrarApartamento(Proyecto proyectoSeleccionado,Torre torreSeleccionada) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiProyecto = new GestionarProyecto(factory);
        this.gestiTorre = new GestionarTorre(factory);
        this.gestiApto = new GestionarApartamento(factory);
        this.proyectoSeleccionado = proyectoSeleccionado;
        this.torreSeleccionada = torreSeleccionada;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtTipoUnidad = new javax.swing.JTextField();
        txtNumeroApartamento = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        btnGuardarApartamento = new javax.swing.JButton();
        txtValorApartamento = new javax.swing.JTextField();
        txtTorreActual = new javax.swing.JTextField();
        txtProyectoActual = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarApartamentos = new javax.swing.JTable();
        btnEditarApto = new javax.swing.JButton();
        btnEliminarApto = new javax.swing.JButton();
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

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 290, 30));

        txtTipoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUnidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 290, 30));

        txtNumeroApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 290, 30));

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        jPanel1.add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 290, 30));

        btnGuardarApartamento.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarApartamento.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarApartamento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarApartamento.setText("Guardar");
        btnGuardarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 110, 40));

        txtValorApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorApartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 290, 30));

        txtTorreActual.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtTorreActual.setText("TorreActual");
        txtTorreActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTorreActualActionPerformed(evt);
            }
        });
        jPanel1.add(txtTorreActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 140, 40));

        txtProyectoActual.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtProyectoActual.setText("ProyectoActual");
        txtProyectoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProyectoActualActionPerformed(evt);
            }
        });
        jPanel1.add(txtProyectoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, 40));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarTorreAC.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 500));

        jTabbedPane1.addTab("Crear Apartamento", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarApartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarApartamentos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 860, 350));

        btnEditarApto.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarApto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarApto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarApto.setText("Editar");
        btnEditarApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAptoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarApto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 110, 40));

        btnEliminarApto.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarApto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarApto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarApto.setText("Eliminar");
        btnEliminarApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAptoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarApto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarApartamento.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 500));

        jTabbedPane1.addTab("Gestionar Apartamento", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroApartamentoActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void btnGuardarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarApartamentoActionPerformed

        btnGuardarApartamento.setEnabled(false);

        int numeroApartamento = Integer.parseInt(txtNumeroApartamento.getText());
        Long valorApartamento = Long.parseLong(txtValorApartamento.getText());
        String tipoUnidad = txtTipoUnidad.getText();
        double area = Double.parseDouble(txtArea.getText());
        String matricula = txtMatricula.getText();
        

        Apartamento apartamento = new Apartamento();
        apartamento.setNum_apartamento(numeroApartamento);
        apartamento.setValor_apartamento(valorApartamento);
        apartamento.setTipo_unidad(tipoUnidad);
        apartamento.setArea(area);
        apartamento.setMatricula(matricula);
        apartamento.setTorre(torreSeleccionada);
        apartamento.setVenta(null);

        torreSeleccionada.getListaApartamentos().add(apartamento);

        gestiApto.guardar(apartamento);

        JOptionPane optionPane = new JOptionPane("Se guardo");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Guardado Exitoso");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        menuAdmin menuAdmin = new menuAdmin();
        menuAdmin.setVisible(true);
        menuAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnGuardarApartamento.setEnabled(true);
    }//GEN-LAST:event_btnGuardarApartamentoActionPerformed

    
    private void txtTipoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUnidadActionPerformed

    private void txtValorApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorApartamentoActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void btnEditarAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAptoActionPerformed
        
        btnEditarApto.setEnabled(false);
        
        if(tablaMostrarApartamentos.getRowCount() > 0){
            if(tablaMostrarApartamentos.getSelectedRow() != -1){
                
                Long id_apto = Long.parseLong(String.valueOf(tablaMostrarApartamentos.getValueAt(tablaMostrarApartamentos.getSelectedRow(), 0)));
                
                EditarApartamento editApto = new EditarApartamento(id_apto);
                editApto.setVisible(true);
                editApto.setLocationRelativeTo(null);
                this.dispose();
            }
            else {
                
            }
        }
        else{
        
        }
        
        btnEditarApto.setEnabled(true);
    }//GEN-LAST:event_btnEditarAptoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTabla();
        this.txtProyectoActual.setText(proyectoSeleccionado.getNombre_proyecto());
        this.txtTorreActual.setText(String.valueOf(torreSeleccionada.getNumero_torre()));
        this.txtProyectoActual.setEditable(false);
        this.txtTorreActual.setEditable(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAptoActionPerformed
        
        btnEliminarApto.setEnabled(false);
        
        if(tablaMostrarApartamentos.getRowCount() > 0){
            if(tablaMostrarApartamentos.getSelectedRow() != -1){
                
                Long id_apto = Long.parseLong(String.valueOf(tablaMostrarApartamentos.getValueAt(tablaMostrarApartamentos.getSelectedRow(), 0)));
                
                try {
                    boolean op = gestiApto.borrarA(id_apto,torreSeleccionada);
                    
                    if(op == true){
                        JOptionPane optionPane = new JOptionPane("Apartamento Eliminado Correctamente");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Borrado Exitoso");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                    else{
                        JOptionPane optionPane = new JOptionPane("No se puede eliminar el unico Apto de la torre");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Restriccion del sistema");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(administrarApartamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        cargarTabla();
        
        btnEliminarApto.setEnabled(true);
    }//GEN-LAST:event_btnEliminarAptoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTorreActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTorreActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTorreActualActionPerformed

    private void txtProyectoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProyectoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProyectoActualActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        btnMenu.setEnabled(false);

        menuAdmin mAdmin = new menuAdmin();
        mAdmin.setVisible(true);
        mAdmin.setLocationRelativeTo(null);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarApto;
    private javax.swing.JButton btnEliminarApto;
    private javax.swing.JButton btnGuardarApartamento;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarApartamentos;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNumeroApartamento;
    private javax.swing.JTextField txtProyectoActual;
    private javax.swing.JTextField txtTipoUnidad;
    private javax.swing.JTextField txtTorreActual;
    private javax.swing.JTextField txtValorApartamento;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla(){

        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Id Apto","Num Apto","Valor Apto","Tipo Unidad","Area","Matricula",
            "Fecha Escritura","Num Torre","Num Aptos","Nombre Proyecto","Num Torres"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        Long id_proyecto = proyectoSeleccionado.getId_proyecto();
        Long id = torreSeleccionada.getId_torre();
        List<Apartamento> listaApartamentos = gestiApto.obtenerApartamentoTorres(id);
        
        
        if(listaApartamentos != null){
            for(Apartamento apartamento: listaApartamentos){
                int numero_torres = gestiProyecto.contarNTorres(proyectoSeleccionado.getNombre_proyecto());
                int numero_apto = gestiTorre.contarNAptos(apartamento.getTorre().getNumero_torre(),id_proyecto);
                Object[] objeto ={apartamento.getId_apartamento(),apartamento.getNum_apartamento(),
                    apartamento.getValor_apartamento(),apartamento.getTipo_unidad(),apartamento.getArea(),
                    apartamento.getMatricula(),apartamento.getFecha_escritura(),
                    apartamento.getTorre().getNumero_torre(),numero_apto,
                    apartamento.getTorre().getProyecto().getNombre_proyecto(),numero_torres};
                modeloTabla.addRow(objeto);
            }
        }
        tablaMostrarApartamentos.setModel(modeloTabla);
        tablaMostrarApartamentos.getTableHeader().setReorderingAllowed(false);
        
        TableColumnModel columnModel = tablaMostrarApartamentos.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarApartamentos.setRowHeight(30);
        tablaMostrarApartamentos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }

}

