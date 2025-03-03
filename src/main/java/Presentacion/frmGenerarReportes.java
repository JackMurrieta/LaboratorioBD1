/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

/**
 *
 * @author riosr
 */
public class frmGenerarReportes extends javax.swing.JPanel {

    /**
     * Creates new form frmGenerarReportes
     */
    public frmGenerarReportes() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarReporteDetallado = new javax.swing.JButton();
        btnGenerarReporteResumido = new javax.swing.JButton();
        btnGenerarReporteRegresar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Generar Reportes");

        btnGenerarReporteDetallado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarReporteDetallado.setText("Reporte Detalldo");
        btnGenerarReporteDetallado.setToolTipText("");
        btnGenerarReporteDetallado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteDetalladoActionPerformed(evt);
            }
        });

        btnGenerarReporteResumido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarReporteResumido.setText("Reporte Resumido");
        btnGenerarReporteResumido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteResumidoActionPerformed(evt);
            }
        });

        btnGenerarReporteRegresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerarReporteRegresar.setText("Regresar");
        btnGenerarReporteRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporteDetallado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporteResumido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnGenerarReporteRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnGenerarReporteDetallado)
                .addGap(90, 90, 90)
                .addComponent(btnGenerarReporteResumido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(btnGenerarReporteRegresar)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteDetalladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteDetalladoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmGenerarReporteDetallado generarReporteDetalladoFrame = new frmGenerarReporteDetallado();
        generarReporteDetalladoFrame.setVisible(true);
    }//GEN-LAST:event_btnGenerarReporteDetalladoActionPerformed

    private void btnGenerarReporteResumidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteResumidoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmGenerarReporteResumido generarReporteResumidoFrame = new frmGenerarReporteResumido();
        generarReporteResumidoFrame.setVisible(true);
    }//GEN-LAST:event_btnGenerarReporteResumidoActionPerformed

    private void btnGenerarReporteRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteRegresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmMenuAdmin menuPrincipalFrame = new frmMenuAdmin();
        menuPrincipalFrame.setVisible(true);
    }//GEN-LAST:event_btnGenerarReporteRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporteDetallado;
    private javax.swing.JButton btnGenerarReporteRegresar;
    private javax.swing.JButton btnGenerarReporteResumido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
