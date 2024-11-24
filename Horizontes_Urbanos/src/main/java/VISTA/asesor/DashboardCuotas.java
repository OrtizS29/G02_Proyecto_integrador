
package VISTA.asesor;

import CONTROLADOR.gestionar.GestionarDeuda;
import CONTROLADOR.gestionar.GestionarVenta;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Santiago
 */
public class DashboardCuotas extends javax.swing.JFrame {

    Cliente clienteSeleccionado;
    GestionarVenta gestiVenta;
    GestionarDeuda gestiDeuda;;
    
    
    public DashboardCuotas(Cliente clienteSeleccionado) {
         I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiVenta = new GestionarVenta(factory);
        this.gestiDeuda = new GestionarDeuda(factory);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarCuotasP = new javax.swing.JTable();
        btnMenuV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMostrarCuotasPV = new javax.swing.JTable();
        btnMenuCV = new javax.swing.JButton();
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

        tablaMostrarCuotasP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarCuotasP);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 870, 290));

        btnMenuV.setBackground(new java.awt.Color(49, 134, 181));
        btnMenuV.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenuV.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuV.setText("Menu");
        btnMenuV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuVActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenuV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coutasPorVencer.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jTabbedPane1.addTab("Coutas Por Vencer", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarCuotasPV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaMostrarCuotasPV);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 930, 300));

        btnMenuCV.setBackground(new java.awt.Color(49, 134, 181));
        btnMenuCV.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenuCV.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuCV.setText("Menu");
        btnMenuCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuCVActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenuCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coutasYaVencidas.jpeg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jTabbedPane1.addTab("Cuotas Vencidas", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuVActionPerformed

        btnMenuV.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        masesor.setLocationRelativeTo(null);
        this.dispose();

        btnMenuV.setEnabled(true);
    }//GEN-LAST:event_btnMenuVActionPerformed

    private void btnMenuCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuCVActionPerformed
        
        btnMenuCV.setEnabled(true);
        
        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        masesor.setLocationRelativeTo(null);
        this.dispose();
        
        btnMenuCV.setEnabled(true);
        
    }//GEN-LAST:event_btnMenuCVActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTablaCoutasPorVencer();
        cargarTablaCoutasVencidas();
    }//GEN-LAST:event_formWindowOpened

    private void cargarTablaCoutasPorVencer() {
       
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Id Pago","Valor Pago","Fecha Pago","Precio Total",
            "Num Coutas","Num pagos"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        Long ced = clienteSeleccionado.getCedula();
        List<Venta> listaVentas = gestiVenta.obtenerVentaCliente(ced);
        
        if(listaVentas != null){
            for(Venta venta: listaVentas){
                for(Pago pago : venta.getListaPagos()){
                    int numero_pagos = gestiVenta.contarNPagos(venta.getId_venta());
                    Object[] objeto ={
                    pago.getId_pago(),
                    pago.getValor_pago(),
                    pago.getFecha(),
                    venta.getPrecio_final(),
                    venta.getNumero_coutas(),
                    numero_pagos
                    };
                    modeloTabla.addRow(objeto);
                }
            }
        }
        
        tablaMostrarCuotasP.setModel(modeloTabla);
        tablaMostrarCuotasP.setRowHeight(30);
        
        TableColumnModel columnModel = tablaMostrarCuotasP.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarCuotasP.getTableHeader().setReorderingAllowed(false);
        
        tablaMostrarCuotasP.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    private void cargarTablaCoutasVencidas() {
       
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Id Venta","Precio Total","Intereses","Num Coutas","Fecha","Num pagos",
            "Fecha Deuda","Valor Deuda"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        Long ced = clienteSeleccionado.getCedula();
        List<Venta> listaVentas = gestiVenta.obtenerVentaCliente(ced);
        
        if(listaVentas != null){
            for(Venta venta: listaVentas){
                Long id_venta = venta.getId_venta();
                List<Deuda> listaDeudas = gestiDeuda.traerVentaDeuda(id_venta);
                    for (Deuda deuda : listaDeudas) {
                        int numero_pagos = gestiVenta.contarNPagos(venta.getId_venta());
                        Object[] objeto ={venta.getId_venta(),
                        venta.getPrecio_final(),
                        venta.getIntereses(),
                        venta.getNumero_coutas(),
                        venta.getFecha(),
                        numero_pagos,
                        deuda.getFecha_inicia_deuda(),
                        deuda.getValor()};
                        modeloTabla.addRow(objeto);
                    }          
            }
        }
        
        tablaMostrarCuotasPV.setModel(modeloTabla);
        tablaMostrarCuotasPV.setRowHeight(30);
        
        TableColumnModel columnModel = tablaMostrarCuotasPV.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        
        tablaMostrarCuotasPV.getTableHeader().setReorderingAllowed(false);
        
        tablaMostrarCuotasPV.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuCV;
    private javax.swing.JButton btnMenuV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaMostrarCuotasP;
    private javax.swing.JTable tablaMostrarCuotasPV;
    // End of variables declaration//GEN-END:variables
}