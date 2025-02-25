/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.IConexionBD;

/**
 *
 * @author oribi
 */
public class frmMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuAdmin
     */
    public frmMenuAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        btnAdministrarClientes = new javax.swing.JButton();
        btnAdministrarPruebas = new javax.swing.JButton();
        btnCapturaResultados = new javax.swing.JButton();
        btnPruebaAnalisis = new javax.swing.JButton();
        btnGenerarReportes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTitulo.setText("Laboratorio Clinico");

        btnAdministrarClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdministrarClientes.setText("Administrar Clientes");
        btnAdministrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarClientesActionPerformed(evt);
            }
        });

        btnAdministrarPruebas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdministrarPruebas.setText("Administrar Pruebas");
        btnAdministrarPruebas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarPruebasActionPerformed(evt);
            }
        });

        btnCapturaResultados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCapturaResultados.setText("Captura de Resultados");

        btnPruebaAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPruebaAnalisis.setText("Prueba Analisis");
        btnPruebaAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaAnalisisActionPerformed(evt);
            }
        });

        btnGenerarReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarReportes.setText("Generar Reportes");

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(labelTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdministrarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdministrarPruebas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCapturaResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(btnPruebaAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGenerarReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelTitulo)
                .addGap(29, 29, 29)
                .addComponent(btnAdministrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnAdministrarPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCapturaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPruebaAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarPruebasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarPruebasActionPerformed

        this.dispose();

        frmAdministrarPruebas n = new frmAdministrarPruebas();
        n.setVisible(true);
    }//GEN-LAST:event_btnAdministrarPruebasActionPerformed

    private void btnPruebaAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaAnalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPruebaAnalisisActionPerformed

    private void btnAdministrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarClientesActionPerformed
        // Ocultar la ventana actual
        this.dispose();

        // Crear la conexión y negocio del cliente (si ya tienes una instancia, úsala en lugar de crear una nueva)
        IConexionBD conexionBD = new ConexionBD();
        ClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);

        // Crear y mostrar el nuevo frame pasando el objeto clienteNegocio
        frmAdministrarClientes administrarClientesFrame = new frmAdministrarClientes(clienteNegocio);
        administrarClientesFrame.setVisible(true);
    }//GEN-LAST:event_btnAdministrarClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarClientes;
    private javax.swing.JButton btnAdministrarPruebas;
    private javax.swing.JButton btnCapturaResultados;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGenerarReportes;
    private javax.swing.JButton btnPruebaAnalisis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
