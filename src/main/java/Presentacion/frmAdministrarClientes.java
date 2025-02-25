/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOS.ClienteDTO;
import DTOS.GuardarClienteDTO;
import DTOS.TablaClienteDTO;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.NegocioException;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.IClienteDAO;
import Persistencia.IConexionBD;
import Utilerias.RenderTabla;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riosr
 */
public class frmAdministrarClientes extends javax.swing.JFrame {

    private IClienteNegocio clienteNegocio;

    /**
     *
     * @param clienteNegocio
     */
    public frmAdministrarClientes(IClienteNegocio clienteNegocio) {
        this.clienteNegocio = clienteNegocio;
        initComponents();
        llenarTablaClientes();

    }

    private void llenarTablaClientes() {
        try {
            List<TablaClienteDTO> clientesLista = clienteNegocio.buscarClientes();

            DefaultTableModel modelo = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento", "Editar", "Eliminar"});

            for (TablaClienteDTO clientes : clientesLista) {
                

                JButton[] btn = generarBotones(clientes.getIdCliente());
                modelo.addRow(new Object[]{
                    clientes.getIdCliente(),
                    clientes.getNombres(),
                    clientes.getApellidoPaterno(),
                    clientes.getApellidoMaterno(),
                    clientes.getFechaNacimiento(),
                    btn[0],
                    btn[1]
                });
            }

            jTableClientes.setModel(modelo);
            jTableClientes.getColumn("Editar").setCellRenderer(new RenderTabla());
            jTableClientes.getColumn("Eliminar").setCellRenderer(new RenderTabla());
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener los clientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JButton[] generarBotones(int clienteId) {

        JButton btnEditar = new JButton("Editar");
        btnEditar.setName("M");
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setName("E");

        return new JButton[]{btnEditar, btnEliminar};
    }

    private void obtenerDatos(ClienteDTO cliente) {
        //esto llena los datos del buscar
        DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
        modelo.setRowCount(0);

        JButton[] botones = generarBotones(cliente.getId());

        modelo.addRow(new Object[]{
            cliente.getId(),
            cliente.getNombres(),
            cliente.getApellidoPaterno(),
            cliente.getApellidoMaterno(),
            cliente.getFechaNacimiento(),
            botones[0],
            botones[1]
        });
    }

    /**
     *
     * @param cliente
     */
    public void validarBuscarCliente(ClienteDTO cliente) {
        if (cliente != null) {
            obtenerDatos(cliente);
        } else {
            JOptionPane.showMessageDialog(this, "No existe un cliente con el ID ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void editarCliente(int clienteId) {
        try {
            ClienteDTO cliente = clienteNegocio.buscarPorId(clienteId);
            if (cliente != null) {
                
                this.dispose();
                frmDatosCliente frmEditar = new frmDatosCliente(clienteNegocio, cliente);
                frmEditar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al editar el alumno: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCliente(int clienteId) {
        try {
            // Buscar el cliente por ID para obtener su nombre
            ClienteDTO cliente = clienteNegocio.buscarPorId(clienteId);

            if (cliente != null) {

                int opcion = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de que desea eliminar al cliente " + cliente.getNombres() + "?",
                        "Confirmación de eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                // Si el usuario confirma la eliminación
                if (opcion == JOptionPane.YES_OPTION) {
                    // Llamar al servicio o negocio para eliminar el cliente por ID
                    ClienteDTO eliminado = clienteNegocio.eliminar(clienteId);

                    if (eliminado == null) {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        llenarTablaClientes();

                    }
                } else {
                    // Si el usuario cancela, no se hace nada
                    JOptionPane.showMessageDialog(this, "Eliminación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAdministrarClientesNuevoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        btnAdminitrarClientesRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Buscar Cliente por ID:");

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Administrar Clientes");

        btnAdministrarClientesNuevoCliente.setText("Nuevo Cliente");
        btnAdministrarClientesNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarClientesNuevoClienteActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento", "Editar", "Eliminar"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        btnAdminitrarClientesRegresar.setText("Regresar");
        btnAdminitrarClientesRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminitrarClientesRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnAdministrarClientesNuevoCliente)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addContainerGap(284, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAdminitrarClientesRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarClientesNuevoCliente)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdminitrarClientesRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed

    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try {
            int id = Integer.parseInt(txtBuscarCliente.getText());

            ClienteDTO cliente = clienteNegocio.buscarPorId(id);
            this.validarBuscarCliente(cliente);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAdministrarClientesNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarClientesNuevoClienteActionPerformed
        // Ocultar la ventana actual
        this.setVisible(false);

        // Crear la conexión y negocio del cliente (si ya tienes una instancia, úsala en lugar de crear una nueva)
        IConexionBD conexionBD = new ConexionBD();
        ClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);

        // Crear y mostrar el nuevo frame pasando el objeto clienteNegocio
        frmDatosCliente frmDatosCliente = new frmDatosCliente(clienteNegocio);
        frmDatosCliente.setVisible(true);
        
    }//GEN-LAST:event_btnAdministrarClientesNuevoClienteActionPerformed

    private void btnAdminitrarClientesRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminitrarClientesRegresarActionPerformed
        frmMenuAdmin m = new frmMenuAdmin();
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAdminitrarClientesRegresarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        int column = this.jTableClientes.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.jTableClientes.getRowHeight();

        if (row < this.jTableClientes.getRowCount() && row >= 0 && column < this.jTableClientes.getColumnCount() && column >= 0) {
            Object value = this.jTableClientes.getValueAt(row, column);

            if (value instanceof JButton) {
                JButton boton = (JButton) value;
                int clienteId = (int) this.jTableClientes.getValueAt(row, 0);

                if (boton.getText().equals("Editar")) {
                    editarCliente(clienteId);
                } else if (boton.getText().equals("Eliminar")) {
                    eliminarCliente(clienteId);
                }
            }
        }
    }//GEN-LAST:event_jTableClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarClientesNuevoCliente;
    private javax.swing.JButton btnAdminitrarClientesRegresar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
