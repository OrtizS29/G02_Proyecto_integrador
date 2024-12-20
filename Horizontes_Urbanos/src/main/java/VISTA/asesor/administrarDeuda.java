
package VISTA.asesor;

import CONTROLADOR.gestionar.GestionarDeuda;
import CONTROLADOR.gestionar.GestionarVenta;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author santiago
 */
public class administrarDeuda extends javax.swing.JFrame {

    Cliente clienteSeleccionado;
    Venta ventaSeleccionada;
    GestionarDeuda gestiDeuda;
    GestionarVenta gestiVenta;
    
    public administrarDeuda(Cliente clienteSeleccionado,Venta ventaSeleccionada) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiDeuda = new GestionarDeuda(factory);
        this.gestiVenta = new GestionarVenta(factory);
        this.ventaSeleccionada = ventaSeleccionada;
        this.clienteSeleccionado = clienteSeleccionado;
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
        btnMenu = new javax.swing.JButton();
        btnGuardarDeuda = new javax.swing.JButton();
        txtFechaDeuda = new javax.swing.JTextField();
        txtValorDeuda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarDeuda = new javax.swing.JTable();
        btnEliminarDeuda = new javax.swing.JButton();
        btnEditarDeuda = new javax.swing.JButton();
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

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 100, 40));

        btnGuardarDeuda.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarDeuda.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnGuardarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarDeuda.setText("Guardar");
        btnGuardarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDeudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 100, 40));

        txtFechaDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDeudaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 370, 30));

        txtValorDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDeudaActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 370, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrarPago.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        jTabbedPane1.addTab("Registrar Deuda", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarDeuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarDeuda);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 620, 350));

        btnEliminarDeuda.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarDeuda.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEliminarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarDeuda.setText("Eliminar");
        btnEliminarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDeudaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 110, 40));

        btnEditarDeuda.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarDeuda.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEditarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarDeuda.setText("Editar");
        btnEditarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDeudaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarClienteA.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jTabbedPane1.addTab("Gestionar Deuda", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        masesor.setLocationRelativeTo(null);
        this.dispose();
        
        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnGuardarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDeudaActionPerformed

        btnGuardarDeuda.setEnabled(false);
        
        int numero_pagos = gestiVenta.contarNPagos(ventaSeleccionada.getId_venta());
        int numero_deudas = gestiVenta.contarNDeudas(ventaSeleccionada.getId_venta());
        int suma = numero_pagos+numero_deudas;
        if( suma != ventaSeleccionada.getNumero_coutas()){
            Date fecha = getFechaDesdeTxt();
            BigDecimal valor_pago = new BigDecimal(txtValorDeuda.getText());

            Deuda deuda = new Deuda();
            deuda.setFecha_inicia_deuda(fecha);
            deuda.setValor(valor_pago);

            deuda.setVenta(ventaSeleccionada);

            ventaSeleccionada.getListaDeuda().add(deuda);


            try {
                gestiDeuda.guardar(deuda);
                gestiVenta.editar(ventaSeleccionada);
            } catch (Exception ex) {
                Logger.getLogger(administrarDeuda.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane optionPane = new JOptionPane("Deuda Guardada Correctamente");
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog("Guardado Exitoso");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            menuAsesor masesor = new menuAsesor();
            masesor.setVisible(true);
            masesor.setLocationRelativeTo(null);
            this.dispose();
        }
        else{
            JOptionPane optionPane = new JOptionPane("No se pueden agregar mas cuotas vencidas");
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("ERROR");
            dialog.setAlwaysOnTop(true);dialog.setVisible(true);btnGuardarDeuda.setEnabled(true);
            return;
        }
        
        btnGuardarDeuda.setEnabled(true);
        
    }//GEN-LAST:event_btnGuardarDeudaActionPerformed

    private void txtFechaDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDeudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDeudaActionPerformed

    private void txtValorDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDeudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDeudaActionPerformed

    private void btnEliminarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDeudaActionPerformed
        
        if(tablaMostrarDeuda.getRowCount() > 0){
            if(tablaMostrarDeuda.getSelectedRow() != -1){
                
                Long id_deuda = Long .parseLong(String.valueOf(tablaMostrarDeuda.getValueAt(tablaMostrarDeuda.getSelectedRow(), 0)));
               
                try {
                    gestiDeuda.borrar(id_deuda,ventaSeleccionada);
                } catch (Exception ex) {
                    Logger.getLogger(administrarDeuda.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane optionPane = new JOptionPane("Deuda Eliminada Correctamente");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Borrado Exitoso");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
        
        cargarTabla();
        
    }//GEN-LAST:event_btnEliminarDeudaActionPerformed

    private void btnEditarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDeudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarDeudaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private Date getFechaDesdeTxt() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String a = txtFechaDeuda.getText();
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarDeuda;
    private javax.swing.JButton btnEliminarDeuda;
    private javax.swing.JButton btnGuardarDeuda;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarDeuda;
    private javax.swing.JTextField txtFechaDeuda;
    private javax.swing.JTextField txtValorDeuda;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Id Deuda","Fecha","Valor","Numero Cuotas","Precio Total"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        
        Long id = ventaSeleccionada.getId_venta();
        List<Deuda> listaDeudas = gestiDeuda.traerVentaDeuda(id);
        
        if(listaDeudas != null){
            for(Deuda deuda: listaDeudas){
                Object[] objeto ={deuda.getId_deuda(),
                    deuda.getFecha_inicia_deuda(),
                    deuda.getValor(),
                    deuda.getVenta().getNumero_coutas(),
                    deuda.getVenta().getPrecio_final()};
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaMostrarDeuda.setModel(modeloTabla);
        tablaMostrarDeuda.setRowHeight(30);
        
        TableColumnModel columnModel = tablaMostrarDeuda.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarDeuda.getTableHeader().setReorderingAllowed(false);
        tablaMostrarDeuda.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }

}
