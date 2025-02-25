/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOS.ParametrosDTO;
import DTOS.PruebaAnalisisDTO;
import Negocio.IParametrosEvaluacionNegocio;
import Negocio.NegocioException;
import Negocio.ParametrosEvaluacionNegocio;
import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.ParametrosEvaluacionDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oribi
 */
public class frmAgregarParametros extends javax.swing.JFrame {

    private IParametrosEvaluacionNegocio parametrosNegocio;
    private int idPruebaCreada;
    private DefaultTableModel modeloTabla;
    private final IConexionBD conexion; // Conexión única a BD

    /**
     *
     * @param idPruebaCreada
     */
    public frmAgregarParametros(int idPruebaCreada) {
        initComponents();
        this.idPruebaCreada = idPruebaCreada;
        this.conexion = new ConexionBD();

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Parametro");
        modeloTabla.addColumn("Rango");
        jTable1.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AgregarParametros = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        Parametros = new javax.swing.JLabel();
        TextFieldParametros = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        texfieldRango = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        AgregarParametros.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AgregarParametros.setText("Agregar Parametros");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        Parametros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Parametros.setText("Parametros:");

        TextFieldParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldParametrosActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre ", "Rango", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Rango:");

        texfieldRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldRangoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Parametros)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(texfieldRango, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TextFieldParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(AgregarParametros)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(AgregarParametros)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parametros))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(texfieldRango, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldParametrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldParametrosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String parametro = TextFieldParametros.getText();
        String rango = texfieldRango.getText();
        if (!parametro.isEmpty() || !rango.isEmpty()) {
            try {
                // Registrar el parámetro en la base de datos
                //error aqui parametro es nulo
                ParametrosDTO paramDTO = new ParametrosDTO(parametro, rango, this.idPruebaCreada);
                ParametrosEvaluacionDAO paramDAO = new ParametrosEvaluacionDAO(conexion);
                parametrosNegocio = new ParametrosEvaluacionNegocio(paramDAO);
                ParametrosDTO paramGuardado = parametrosNegocio.registrarParametro(paramDTO);

                // Agregar el parámetro y su rango en la tabla
                modeloTabla.addRow(new Object[]{paramGuardado.getNombre(), paramGuardado.getRango()});

                // Limpiar el campo de texto después de agregar el parámetro
                TextFieldParametros.setText("");
                texfieldRango.setText("");
            } catch (NegocioException ex) {
                Logger.getLogger(frmAgregarParametros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El campo de parámetro está vacío");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        frmAdministrarPruebas mainFrame = new frmAdministrarPruebas();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void texfieldRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texfieldRangoActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgregarParametros;
    private javax.swing.JLabel Parametros;
    private javax.swing.JTextField TextFieldParametros;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField texfieldRango;
    // End of variables declaration//GEN-END:variables
}
