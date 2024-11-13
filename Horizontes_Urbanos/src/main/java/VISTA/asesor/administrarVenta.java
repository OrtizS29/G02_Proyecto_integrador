
package VISTA.asesor;

import CONTROLADOR.SessionManager;
import CONTROLADOR.calcularIntereses;
import CONTROLADOR.gestionar.GestionarApartamento;
import CONTROLADOR.gestionar.GestionarVenta;
import Modelo.entities.Apartamento;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juanc,Santiago
 */
public class administrarVenta extends javax.swing.JFrame {

    Cliente clienteSeleccionado;
    GestionarVenta gestiVenta;
    GestionarApartamento gestiApto;
    Asesor asesorLogueado = SessionManager.getAsesorActual();
    Long precio_base=0L;
    private Long idVentaActual;
    private Venta ventaActual;
    calcularIntereses calcularIntereses;
    
    public administrarVenta(Cliente clienteSeleccionado) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiVenta = new GestionarVenta(factory);
        this.gestiApto = new GestionarApartamento(factory);
        this.clienteSeleccionado = clienteSeleccionado;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNumeroCoutas = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();
        btnGuardarAptos = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMostrarAptosNoVendidos = new javax.swing.JTable();
        lbClienteActual = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarVenta = new javax.swing.JTable();
        btnEliminarVenta = new javax.swing.JButton();
        btnEditarVenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroCoutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCoutasActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroCoutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 370, 30));

        txtFechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaVentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 370, 30));

        btnGuardarAptos.setBackground(new java.awt.Color(49, 134, 181));
        btnGuardarAptos.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarAptos.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAptos.setText("Guardar Aptos");
        btnGuardarAptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAptosActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarAptos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 130, 40));

        btnSiguiente.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Guardar Venta");
        btnSiguiente.setBorder(null);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 100, 40));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 370, 160));

        lbClienteActual.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbClienteActual.setForeground(new java.awt.Color(255, 255, 255));
        lbClienteActual.setText("ClienteActual");
        jPanel1.add(lbClienteActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrarVenta.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        jTabbedPane1.addTab("Registrar venta", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMostrarVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 660, 330));

        btnEliminarVenta.setBackground(new java.awt.Color(49, 134, 181));
        btnEliminarVenta.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.setBorder(null);
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 100, 40));

        btnEditarVenta.setBackground(new java.awt.Color(49, 134, 181));
        btnEditarVenta.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEditarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarVenta.setText("Editar");
        btnEditarVenta.setBorder(null);
        btnEditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 90, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestionarVenta.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jTabbedPane1.addTab("Gestionar venta", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarVentaActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void txtNumeroCoutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCoutasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCoutasActionPerformed

    private void txtFechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaVentaActionPerformed

    private void btnGuardarAptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAptosActionPerformed

        if (idVentaActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe guardar la venta.");
            return;
        }
        
        ventaActual = gestiVenta.buscarPorId(idVentaActual);
        ventaActual.setPrecio_base(precio_base);
        
        int numero_cuotas = ventaActual.getNumero_coutas();
        Long precio_base = ventaActual.getPrecio_base();
        
        if(numero_cuotas>1){
            Long precio_final = calcularIntereses.calcularPrecioFinal(precio_base,numero_cuotas);
            ventaActual.setPrecio_final(precio_final);
            ventaActual.setIntereses(precio_final-precio_base);
        }else{
            ventaActual.setPrecio_final(precio_base);
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
        
        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGuardarAptosActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        btnSiguiente.setEnabled(false);
        Date fecha = getFechaDesdeTxt();
        int numeroCoutas = Integer.parseInt(txtNumeroCoutas.getText());
        
        Venta venta = new Venta();
        venta.setFecha(fecha);
        venta.setNumero_coutas(numeroCoutas);
        //El intereres es igual al numero de coutas
        
        venta.setListaApartamentos(new ArrayList<Apartamento>());
        venta.setListaPagos(new ArrayList<Pago>());
        venta.setListaDeuda(new ArrayList<Deuda>());
        venta.setAsesor(asesorLogueado);
        venta.setCliente(clienteSeleccionado);
        
        //Datos falsos
        venta.setPrecio_base(0L);
        venta.setPrecio_final(0L);
        venta.setIntereses(0L);
        
        try {
            gestiVenta.guardar(venta);
            pasarIdVenta(venta.getId_venta());
        } catch (Exception ex) {
            Logger.getLogger(administrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane optionPane = new JOptionPane("Venta Guardada Correctamente");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Guardado Exitoso");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        
        btnSiguiente.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
      
        this.lbClienteActual.setText(clienteSeleccionado.getNombre());
        
        cargarTabla();
        cargarTablaAptosVendi();
    }//GEN-LAST:event_formWindowOpened

    private void tablaMostrarAptosNoVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMostrarAptosNoVendidosMouseClicked
        
        if(idVentaActual == null){
            JOptionPane.showMessageDialog(this, "Primero debe guardar la venta.");
            return;
        }
        
        ventaActual = gestiVenta.buscarPorId(idVentaActual);
        int[] filasSeleccionadas = tablaMostrarAptosNoVendidos.getSelectedRows();
        
        
        for (int fila : filasSeleccionadas) {
            Long id_apto = (Long) tablaMostrarAptosNoVendidos.getValueAt(fila,2);
            Apartamento apto = gestiApto.buscarPorId(id_apto);
            
            
            apto.setFecha_escritura(ventaActual.getFecha());
            apto.setVenta(ventaActual);
            ventaActual.getListaApartamentos().add(apto);
            Long valor =apto.getValor_apartamento();
            precio_base+=valor;
                
            
            try {
                gestiApto.editar(apto);
            } catch (Exception ex) {
                Logger.getLogger(administrarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tablaMostrarAptosNoVendidosMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        btnGuardarAptos.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        this.dispose();

        btnGuardarAptos.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarVenta;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnGuardarAptos;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbClienteActual;
    private javax.swing.JTable tablaMostrarAptosNoVendidos;
    private javax.swing.JTable tablaMostrarVenta;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtNumeroCoutas;
    // End of variables declaration//GEN-END:variables

    private Date getFechaDesdeTxt() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String a = txtFechaVenta.getText();
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
    
    private void cargarTabla() {
       
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        
        String titulos[] = {"Precio Final","Num Coutas","Fecha Escritura","Valor Apto"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List<Venta> listaVentas = gestiVenta.traerVentas();
        
        if(listaVentas != null){
            for(Venta venta: listaVentas){
                for(Apartamento apto:venta.getListaApartamentos()){
                    Object[] objeto ={apto.getVenta().getPrecio_final(),apto.getVenta().getNumero_coutas(),
                    apto.getFecha_escritura(),apto.getValor_apartamento()};
                    modeloTabla.addRow(objeto);
                }    
            }
        }
        
        tablaMostrarVenta.setModel(modeloTabla);
        tablaMostrarAptosNoVendidos.getTableHeader().setReorderingAllowed(false);
    }

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
        columnModel.getColumn(0).setPreferredWidth(150); // Nombre Proyecto
        columnModel.getColumn(1).setPreferredWidth(80);  // Num Torre
        columnModel.getColumn(2).setPreferredWidth(60);  // Id_apto
        columnModel.getColumn(3).setPreferredWidth(80);  // Num Apto
        columnModel.getColumn(4).setPreferredWidth(100); // Valor Apto
        columnModel.getColumn(5).setPreferredWidth(120); // Matricula
    }

    private void pasarIdVenta(Long id_venta) {
        this.idVentaActual = id_venta; 
    } 
}
