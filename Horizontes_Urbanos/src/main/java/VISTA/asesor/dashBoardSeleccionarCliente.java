
package VISTA.asesor;

import CONTROLADOR.gestionar.GestionarCliente;
import Modelo.entities.Cliente;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanc,Santiago
 */
public class dashBoardSeleccionarCliente extends javax.swing.JFrame {

    GestionarCliente gestiCliente;
    
    public dashBoardSeleccionarCliente() {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiCliente = new GestionarCliente(factory);
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

        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMostrarClientes = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 610, 280));

        btnMenu.setBackground(new java.awt.Color(49, 134, 181));
        btnMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 110, 40));

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
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dashBoardCliente.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMostrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMostrarClientesMouseClicked
        
        
    }//GEN-LAST:event_tablaMostrarClientesMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        btnMenu.setEnabled(false);

        menuAsesor masesor = new menuAsesor();
        masesor.setVisible(true);
        this.dispose();

        btnMenu.setEnabled(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        if(tablaMostrarClientes.getRowCount() > 0){
            if(tablaMostrarClientes.getSelectedRow() != -1){
                
                Long ced_cliente = Long.parseLong(String.valueOf(tablaMostrarClientes.getValueAt(tablaMostrarClientes.getSelectedRow(), 0)));

                Cliente clienteSeleccionado = gestiCliente.buscarPorId(ced_cliente);
                
                DashboardCuotas dcoutas = new DashboardCuotas(clienteSeleccionado);
                dcoutas.setVisible(true);
                dcoutas.setLocationRelativeTo(null);
                this.dispose();
                
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaMostrarClientes;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        
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
}
