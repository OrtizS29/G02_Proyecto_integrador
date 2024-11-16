
package VISTA.asesor;

import CONTROLADOR.gestionar.GestionarCliente;
import CONTROLADOR.gestionar.GestionarVenta;
import Modelo.entities.Cliente;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juanc,Santiago
 */
public class pagoSeleccionarClienteYVenta extends javax.swing.JFrame {

    private Long cedClienteSeleccionado = 0L;
    private Long idVentaSeleccionado = 0L;
    GestionarCliente gestiCliente;
    GestionarVenta gestiVenta;
    
    public pagoSeleccionarClienteYVenta() {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiCliente = new GestionarCliente(factory);
        this.gestiVenta = new GestionarVenta(factory);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMostrarVentas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMostrarClientes = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMostrarVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMostrarVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaMostrarVentas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 520, 160));

        tablaMostrarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMostrarClientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaMostrarClientes);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 80, 520, 160));

        btnSiguiente.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorder(null);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, 40));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pagoA.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMostrarVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMostrarVentasMouseClicked
        
        if (tablaMostrarVentas.getRowCount() > 0 && tablaMostrarVentas.getSelectedRow() != -1) {
                //Proceso obtencion Id
                this.idVentaSeleccionado = Long.parseLong(String.valueOf(tablaMostrarVentas.getValueAt(tablaMostrarVentas.getSelectedRow(), 0)));  
        }

    }//GEN-LAST:event_tablaMostrarVentasMouseClicked

    private void tablaMostrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMostrarClientesMouseClicked
        
        if(tablaMostrarClientes.getRowCount() > 0){
            if(tablaMostrarClientes.getSelectedRow() != -1){

                this.cedClienteSeleccionado = Long.parseLong(String.valueOf(tablaMostrarClientes.getValueAt(tablaMostrarClientes.getSelectedRow(), 0)));

                ActualizarVenta(cedClienteSeleccionado);

            }
        }

    }//GEN-LAST:event_tablaMostrarClientesMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        btnSiguiente.setEnabled(false);
        
        Cliente clienteSeleccionado = gestiCliente.buscarPorId(cedClienteSeleccionado);
        Venta ventaSeleccionada = gestiVenta.buscarPorId(idVentaSeleccionado);
        
        if(ventaSeleccionada == null){
            JOptionPane optionPane = new JOptionPane("Cliente o Venta no encontrada");
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("ERROR");
            dialog.setAlwaysOnTop(true);dialog.setVisible(true);btnSiguiente.setEnabled(true);
            return;
        }
        
        //int numero_pagos = gestiVenta.contarNPagos(ventaSeleccionada.getId_venta());
        //if(numero_pagos < ventaSeleccionada.getNumero_coutas()){
            administrarPago adminPago = new administrarPago(clienteSeleccionado,ventaSeleccionada);
            adminPago.setVisible(true);
            adminPago.setLocationRelativeTo(null);
            this.dispose();
        //}else{
            //JOptionPane optionPane = new JOptionPane("Ya pagaste");
            //optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            //JDialog dialog = optionPane.createDialog("ERROR");
            //dialog.setAlwaysOnTop(true);dialog.setVisible(true);btnSiguiente.setEnabled(true);
            //return;
        //}
        
        btnSiguiente.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTablaClientes();
    }//GEN-LAST:event_formWindowOpened
 
    private void cargarTablaClientes() {
        
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Cedula","Nombre","Sisben"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Cliente> listaClientes = gestiCliente.traerClientes();
        
        for (Cliente cliente : listaClientes) {
            Object[] objeto = {cliente.getCedula(),cliente.getNombre(),cliente.getSisben()};
            modeloTabla.addRow(objeto);
        }
        tablaMostrarClientes.setModel(modeloTabla);
        tablaMostrarClientes.getTableHeader().setReorderingAllowed(false);
        
        tablaMostrarClientes.setRowHeight(30);
        tablaMostrarClientes.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    
    private void ActualizarVenta(Long cedClienteSeleccionado) {
        
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Id venta","Precio Total","Numero Coutas","Num Pagos"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Venta> listaVentas = gestiCliente.obtenerVentasCliente(cedClienteSeleccionado);
        
        if(listaVentas != null){
            
            Collections.sort(listaVentas, new Comparator<Venta>(){
                @Override
                public int compare(Venta v1, Venta v2) {
                    return Long.compare(v1.getId_venta(), v2.getId_venta());
                }
            });
            
            for(Venta venta: listaVentas){
                int numero_pagos = gestiVenta.contarNPagos(venta.getId_venta());
                Object[] objeto ={venta.getId_venta(),venta.getPrecio_final(),venta.getNumero_coutas(),
                numero_pagos};
                modeloTabla.addRow(objeto);
            }
            
            tablaMostrarVentas.setModel(modeloTabla);
            
            TableColumnModel columnModel = tablaMostrarVentas.getColumnModel();
            columnModel.getColumn(0).setMinWidth(0);
            columnModel.getColumn(0).setMaxWidth(0);
            columnModel.getColumn(0).setWidth(0);
            
            tablaMostrarVentas.setRowHeight(30);
            tablaMostrarVentas.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaMostrarClientes;
    private javax.swing.JTable tablaMostrarVentas;
    // End of variables declaration//GEN-END:variables

    
}
