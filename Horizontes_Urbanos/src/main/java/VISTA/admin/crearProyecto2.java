
package VISTA.admin;

import CONTROLADOR.gestionar.GestionarProyecto;
import CONTROLADOR.gestionar.GestionarTorre;
import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.factory.PersistenciaFactory_inyect;
import java.util.ArrayList;

/**
 *
 * @author juanc,Santiago
 */
public class crearProyecto2 extends javax.swing.JFrame {
    
    GestionarTorre gestiTorre;
    GestionarProyecto gestiProyecto;
    Proyecto proyectoActual;
    /**
     * Creates new form crearProyecto2
     */
    public crearProyecto2(GestionarProyecto gestiProyecto,Proyecto proyectoActual) {
        I_PersistenciaFactory factory = new PersistenciaFactory_inyect();
        this.gestiTorre = new GestionarTorre(factory);
        this.gestiProyecto = gestiProyecto;
        this.proyectoActual = proyectoActual;
        initComponents();
        setSize(912, 510); 
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSiguienteCrearTorre = new javax.swing.JButton();
        txtNumeroTorre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSiguienteCrearTorre.setBackground(new java.awt.Color(49, 134, 181));
        btnSiguienteCrearTorre.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSiguienteCrearTorre.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCrearTorre.setText("Siguiente");
        btnSiguienteCrearTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCrearTorreActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguienteCrearTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 110, 40));

        txtNumeroTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroTorreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crearProyecto-Torre.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroTorreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroTorreActionPerformed

    private void btnSiguienteCrearTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCrearTorreActionPerformed
        
        btnSiguienteCrearTorre.setEnabled(false);
        
        int numeroTorre = Integer.parseInt(txtNumeroTorre.getText());
        
        Torre torre = new Torre();
        torre.setNumero_torre(numeroTorre);
        torre.setProyecto(proyectoActual);
        torre.setListaApartamentos(new ArrayList<Apartamento>());
        
        //añade la torre a la lista torre del proyecto que cree anteriormente
        proyectoActual.getListaTorres().add(torre);
        Torre torreActual = gestiTorre.guardar(torre);
        
        crearProyecto3 crearProyectoApt = new crearProyecto3(gestiTorre,torreActual);
        crearProyectoApt.setVisible(true);
        crearProyectoApt.setLocationRelativeTo(null);
        this.dispose();
        
        btnSiguienteCrearTorre.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteCrearTorreActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguienteCrearTorre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNumeroTorre;
    // End of variables declaration//GEN-END:variables
}
