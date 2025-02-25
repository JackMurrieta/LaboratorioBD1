/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOS.PruebaAnalisisDTO;
import Entidades.CategoriaEntidad;
import Negocio.CategoriasNegocio;
import Negocio.ICategoriasNegocio;
import Negocio.IParametrosEvaluacionNegocio;
import Negocio.IPruebaAnalisisNegocio;
import Negocio.NegocioException;
import Negocio.ParametrosEvaluacionNegocio;
import Negocio.PruebaAnalisisNegocio;
import Persistencia.CategoriasDAO;
import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.ParametrosEvaluacionDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oribi
 */
public class frmAdministrarPruebas extends javax.swing.JFrame {
  
    /**
     *
     */
    public PruebaAnalisisDTO pruebaCrear;
    private final IConexionBD conexion; // Conexión única a BD

    /**
     *
     */
    public frmAdministrarPruebas() {
        initComponents();
        this.pruebaCrear=null;
        this.conexion = new ConexionBD(); // Crear solo UNA conexión
        cargarCategorias();
    }

    private void cargarCategorias() {
       try {
           CategoriasDAO categoriasDAO = new  CategoriasDAO(conexion);
            List<CategoriaEntidad> categorias = categoriasDAO.obtenerCategorias();
            ComboBoxCategoria.removeAllItems();
            if (categorias != null && !categorias.isEmpty()) {
                for (CategoriaEntidad categoria : categorias) {
                    ComboBoxCategoria.addItem(categoria.getNombre());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay categorías disponibles.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegistrarPrueba = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        ComboBoxCategoria = new javax.swing.JComboBox<>();
        NombrePrueba = new javax.swing.JLabel();
        texfieldNombrePrueba = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregarParametros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        RegistrarPrueba.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RegistrarPrueba.setText("Registrar Prueba ");

        Categoria.setText("Categoria:");

        ComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCategoriaActionPerformed(evt);
            }
        });

        NombrePrueba.setText("Nombre de la prueba");

        texfieldNombrePrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldNombrePruebaActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregarParametros.setText("Agregar parametros");
        btnAgregarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarParametrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(RegistrarPrueba))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(Categoria)
                                .addGap(32, 32, 32)
                                .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(NombrePrueba)
                                .addGap(18, 18, 18)
                                .addComponent(texfieldNombrePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegistrarPrueba)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Categoria)
                    .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texfieldNombrePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombrePrueba))
                .addGap(30, 30, 30)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgregarParametros, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCategoriaActionPerformed

    }//GEN-LAST:event_ComboBoxCategoriaActionPerformed

    private void texfieldNombrePruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldNombrePruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texfieldNombrePruebaActionPerformed

    private void btnAgregarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarParametrosActionPerformed

        if (texfieldNombrePrueba.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Evitar continuar si los datos son inválidos
        }

        if (this.pruebaCrear == null) {
            JOptionPane.showMessageDialog(this, "Debe guardar la prueba antes de agregar parámetros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        frmAgregarParametros nuevaVentana = new frmAgregarParametros(this.pruebaCrear.getIdPruebaAnalisis());
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarParametrosActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String nombrePrueba = texfieldNombrePrueba.getText().trim();
            String categoriaSeleccionada = (String) ComboBoxCategoria.getSelectedItem();

            if (nombrePrueba.isEmpty() || categoriaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            CategoriasDAO categoriasDAO = new  CategoriasDAO(conexion);
            int idCategoria = categoriasDAO.obtenerCategorias().stream()
                    .filter(c -> c.getNombre().equalsIgnoreCase(categoriaSeleccionada))
                    .map(CategoriaEntidad::getIdCategoria)
                    .findFirst()
                    .orElse(-1);

            if (idCategoria == -1) {
                JOptionPane.showMessageDialog(this, "Error al obtener el ID de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            IPruebaAnalisisNegocio pruebaAnalisisNegocio = new PruebaAnalisisNegocio(conexion);
            // hacer dinamico el idLaboratorio en la prueba a insertar
            PruebaAnalisisDTO nuevaPrueba = new PruebaAnalisisDTO(nombrePrueba, idCategoria, 3);
            // Guardar en BD y obtener ID generado
            PruebaAnalisisDTO pruebaGuardada = pruebaAnalisisNegocio.registrarPrueba(nuevaPrueba);
            if (pruebaGuardada != null) {
                this.pruebaCrear = pruebaGuardada; // Asignar la prueba guardada
                JOptionPane.showMessageDialog(this, "Prueba guardada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la prueba.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        // TODO add your handling code here:
        frmMenuAdmin m = new frmMenuAdmin();
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdministrarPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IConexionBD conexion = new ConexionBD();
                Connection conn = null;
                new frmAdministrarPruebas( ).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Categoria;
    private javax.swing.JComboBox<String> ComboBoxCategoria;
    private javax.swing.JLabel NombrePrueba;
    private javax.swing.JLabel RegistrarPrueba;
    private javax.swing.JButton btnAgregarParametros;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField texfieldNombrePrueba;
    // End of variables declaration//GEN-END:variables
}
