/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import DTOS.ClienteDTO;
import DTOS.TablaClienteDTO;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.NegocioException;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.IClienteDAO;
import Persistencia.IConexionBD;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jack Murrieta
 */
public class frmAnalisisCliente extends javax.swing.JFrame {

    private IClienteNegocio clienteNegocio;

    /**
     *
     * @param clienteNegocio
     */
    public frmAnalisisCliente(IClienteNegocio clienteNegocio) {
        this.clienteNegocio = clienteNegocio;
        initComponents();
        setTitle("Capturar Análisis Cliente"); // Cambia el título del JFrame
        llenarTablaClientes();
    }

    private void llenarTablaClientes() {
        try {
            List<TablaClienteDTO> clientesLista = clienteNegocio.buscarClientes();

            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento"});

            for (TablaClienteDTO cliente : clientesLista) {
                modelo.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento()
                });
            }

            jTableClientes.setModel(modelo);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener los clientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        int filaSeleccionada = jTableClientes.getSelectedRow();
        
        if (filaSeleccionada >= 0) {
            int clienteId = (int) jTableClientes.getValueAt(filaSeleccionada, 0);
            JOptionPane.showMessageDialog(this, "Cliente seleccionado con ID: " + clienteId);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                                     

    private void btnAdminitrarClientesRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        frmMenuAdmin menu = new frmMenuAdmin();
        menu.setVisible(true);
        this.dispose();
    }                                                             

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        btnSeleccionarCliente = new javax.swing.JButton();
        btnAdminitrarClientesRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Buscar Cliente por ID:");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(evt -> btnBuscarClienteActionPerformed(evt));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento"}
        ));
        jScrollPane1.setViewportView(jTableClientes);

        btnSeleccionarCliente.setText("Seleccionar");
        btnSeleccionarCliente.addActionListener(evt -> btnSeleccionarClienteActionPerformed(evt));

        btnAdminitrarClientesRegresar.setText("Regresar");
        btnAdminitrarClientesRegresar.addActionListener(evt -> btnAdminitrarClientesRegresarActionPerformed(evt));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdminitrarClientesRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminitrarClientesRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        try {
            int id = Integer.parseInt(txtBuscarCliente.getText());
            ClienteDTO cliente = clienteNegocio.buscarPorId(id);
            if (cliente != null) {
                DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
                modelo.setRowCount(0);
                modelo.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }                                                
    
    private javax.swing.JButton btnAdminitrarClientesRegresar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField txtBuscarCliente;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IConexionBD conexionBD = new ConexionBD();
            IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
            IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);

            frmAnalisisCliente frame = new frmAnalisisCliente(clienteNegocio);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }
}


