/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VISTA;

/**
 *
 * @author juanc
 */
public class menuAdmin extends javax.swing.JFrame {


    /**
     * Creates new form adminProyecto
     */
    public menuAdmin() {
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

        btnAdministrarProyecto = new javax.swing.JButton();
        btnAdministrarAsesor = new javax.swing.JButton();
        btnAdministrarApartamento = new javax.swing.JButton();
        btnAdministrarTorre = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdministrarProyecto.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarProyecto.setText("ADMINISTRAR PROYECTO");
        btnAdministrarProyecto.setBorder(null);
        btnAdministrarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarProyectoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 230, 40));

        btnAdministrarAsesor.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarAsesor.setText("ADMINISTRAR ASESOR");
        btnAdministrarAsesor.setBorder(null);
        btnAdministrarAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarAsesorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 210, 50));

        btnAdministrarApartamento.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarApartamento.setText("ADMINISTRAR APARTAMENTO");
        btnAdministrarApartamento.setBorder(null);
        btnAdministrarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarApartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 230, 40));

        btnAdministrarTorre.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdministrarTorre.setText("ADMINISTRAR TORRE");
        btnAdministrarTorre.setBorder(null);
        btnAdministrarTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarTorreActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 230, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sin título-5.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sin título-5.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sin título-5.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarTorreActionPerformed
        
        torreSeleccionarProyecto torreSelectProyecto = new torreSeleccionarProyecto();
        torreSelectProyecto.setVisible(true);
        torreSelectProyecto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdministrarTorreActionPerformed

    private void btnAdministrarAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarAsesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdministrarAsesorActionPerformed

    private void btnAdministrarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarProyectoActionPerformed
    
        administrarProyecto adminProyecto = new administrarProyecto();
        adminProyecto.setVisible(true);
        adminProyecto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdministrarProyectoActionPerformed

    private void btnAdministrarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdministrarApartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarApartamento;
    private javax.swing.JButton btnAdministrarAsesor;
    private javax.swing.JButton btnAdministrarProyecto;
    private javax.swing.JButton btnAdministrarTorre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
