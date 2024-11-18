
package VISTA.asesor;

import CONTROLADOR.calcularIntereses;
import CONTROLADOR.gestionar.GestionarApartamento;
import CONTROLADOR.gestionar.GestionarVenta;
import Modelo.entities.Apartamento;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class SeleccionarAptoVenta extends javax.swing.JFrame {

    GestionarVenta gestiVenta;
    GestionarApartamento gestiApto;
    Venta ventaActual;
    BigDecimal precio_base = new BigDecimal("0.00"); 
    calcularIntereses calcularIntereses;
    
    public SeleccionarAptoVenta(Venta ventaActual) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiVenta = new GestionarVenta(factory);
        this.gestiApto = new GestionarApartamento(factory);
        this.ventaActual = ventaActual;
        this.calcularIntereses = new calcularIntereses();
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
        tablaMostrarAptosNoVendidos = new javax.swing.JTable();
        btnGuardarAptos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarAptosNoVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMostrarAptosNoVendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMostrarAptosNoVendidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaMostrarAptosNoVendidos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 350));

        btnGuardarAptos.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAptos.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAptos.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAptos.setText("Guardar Aptos");
        btnGuardarAptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAptosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarAptos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seleccionarAptoVenta.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMostrarAptosNoVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMostrarAptosNoVendidosMouseClicked

       if(ventaActual.getId_venta() == null){
            JOptionPane.showMessageDialog(this, "Primero debe guardar la venta.");
            return;
        }
        
        ventaActual = gestiVenta.buscarPorId(ventaActual.getId_venta());
        int[] filasSeleccionadas = tablaMostrarAptosNoVendidos.getSelectedRows();
        
        
        for (int fila : filasSeleccionadas) {
            Long id_apto = (Long) tablaMostrarAptosNoVendidos.getValueAt(fila,2);
            Apartamento apto = gestiApto.buscarPorId(id_apto);
            
            if (ventaActual.getListaApartamentos().contains(apto)) {
                JOptionPane.showMessageDialog(this, "Este apartamento ya está seleccionado para esta venta.");
                return;
            }
            
            if (apto.getVenta() == null) {
                apto.setFecha_escritura(ventaActual.getFecha());
                apto.setVenta(ventaActual);
                ventaActual.getListaApartamentos().add(apto);
                Long valor =apto.getValor_apartamento();
                BigDecimal valorApartamentoDecimal = new BigDecimal(valor);
                precio_base=precio_base.add(valorApartamentoDecimal); 
            }else{JOptionPane.showMessageDialog(this, "Este apartamento ya está seleccionado para esta venta.");
}
            
            try {
                gestiApto.editar(apto);
            } catch (Exception ex) {
                Logger.getLogger(administrarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tablaMostrarAptosNoVendidosMouseClicked

    private void btnGuardarAptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAptosActionPerformed

        if (ventaActual.getId_venta() == null) {
            JOptionPane.showMessageDialog(this, "Primero debe guardar la venta.");
            return;
        }

        ventaActual = gestiVenta.buscarPorId(ventaActual.getId_venta());
        ventaActual.setPrecio_base(precio_base);

        int numero_cuotas = ventaActual.getNumero_coutas();
        BigDecimal precio_base = ventaActual.getPrecio_base();
        Long sub_ministerio = ventaActual.getCliente().getSubsidio_ministerio();
        String sisben = ventaActual.getCliente().getSisben();

        if(numero_cuotas>1){
            BigDecimal precio_final = calcularIntereses.calcularPrecioFinal(precio_base,numero_cuotas,sisben,sub_ministerio);  
            ventaActual.setPrecio_final(precio_final);
            if(sub_ministerio != null){
                BigDecimal subMinDecimal = new BigDecimal(sub_ministerio);
                ventaActual.setIntereses(precio_final.subtract(precio_base).add(subMinDecimal));
            }else{
                ventaActual.setIntereses(precio_final.subtract(precio_base));
            }
        }else{
            if(sisben.equals("SI")){
                BigDecimal subMinDecimal = new BigDecimal(sub_ministerio);
                ventaActual.setPrecio_final(precio_base.subtract(subMinDecimal));
            }else{ventaActual.setPrecio_final(precio_base);}
        }

        for(Apartamento apto : ventaActual.getListaApartamentos()){
            try {
                gestiApto.editar(apto);
            } catch (Exception ex) {
                Logger.getLogger(administrarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            gestiVenta.editar(ventaActual);
            JOptionPane.showMessageDialog(this, "Venta y apartamentos guardados correctamente.");
        } catch (Exception ex) {
            Logger.getLogger(administrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        pagoPrimeraCuota pagoPrimeraCuo = new pagoPrimeraCuota(ventaActual);
        pagoPrimeraCuo.setVisible(true);
        pagoPrimeraCuo.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGuardarAptosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTablaAptosVendi();
    }//GEN-LAST:event_formWindowOpened

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAptos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaMostrarAptosNoVendidos;
    // End of variables declaration//GEN-END:variables
    
    private void cargarTablaAptosVendi() {
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        String titulos[] = {"Nombre Proyecto","Num Torre","Id_apto","Num Apto","Valor Apto","Matricula"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Apartamento> listaAptosNoVendidos = gestiVenta.obtenerAptosNoVendidos();
        
        
        if(listaAptosNoVendidos != null){
            for(Apartamento apartamento: listaAptosNoVendidos){
                Object[] objeto ={apartamento.getTorre().getProyecto().getNombre_proyecto(),
                apartamento.getTorre().getNumero_torre(),apartamento.getId_apartamento(),
                apartamento.getNum_apartamento(),
                apartamento.getValor_apartamento(),apartamento.getMatricula()};
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaMostrarAptosNoVendidos.setModel(modeloTabla);
        tablaMostrarAptosNoVendidos.getTableHeader().setReorderingAllowed(false);
        tablaMostrarAptosNoVendidos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        TableColumnModel columnModel = tablaMostrarAptosNoVendidos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(80);  
        columnModel.getColumn(2).setPreferredWidth(60);  
        columnModel.getColumn(3).setPreferredWidth(80);  
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(120); 
        
        // Ocultar la columna del ID
        columnModel.getColumn(2).setMinWidth(0);
        columnModel.getColumn(2).setMaxWidth(0);
        columnModel.getColumn(2).setWidth(0);
        
        tablaMostrarAptosNoVendidos.setRowHeight(30); 
        tablaMostrarAptosNoVendidos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
    }

}

