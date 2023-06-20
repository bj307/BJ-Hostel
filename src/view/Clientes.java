/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Controller.ClienteController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 * Painel responsável por exibir a lista de clientes.
 *
 * @author kaior
 */
public class Clientes extends javax.swing.JPanel {

    /**
     * Construtor.
     */
    public Clientes() {
        initComponents();
        tableCliente.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * Atualiza a lista de clientes cadastrados.
     */
    public void atualizaTabela() {
        ClienteController cc = new ClienteController();
        List<Cliente> lista = cc.listarCliente();
        DefaultTableModel clientesTb = (DefaultTableModel) tableCliente.getModel();
        clientesTb.setNumRows(0);
        for (Cliente c : lista) {
            clientesTb.addRow(new Object[]{
                c.getCpf(),
                c.getNome(),
                c.getDataNasc(),
                c.getCelular(),
                c.getCidade(),
                c.getEstado()
            });
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
        novoCliente = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1281, 749));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        jLabel1.setText("Clientes");

        novoCliente.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        novoCliente.setText("Novo cliente");
        novoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        novoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                novoClienteMouseReleased(evt);
            }
        });

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Data de nascimento", "Celular", "Cidade", "UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableClienteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novoCliente)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(novoCliente))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(30, 30, 30))
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

    private void novoClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novoClienteMouseReleased
        //abre form novo cliente
        CadCliente cadCliente = new CadCliente(this);
        cadCliente.setVisible(true);
    }//GEN-LAST:event_novoClienteMouseReleased

    private void tableClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseReleased
        //clicou nem uma linha da tabela
        ClienteDetalhes clienteDetalhes = new ClienteDetalhes();
        clienteDetalhes.setVisible(true);
        ClienteController cc = new ClienteController();
        Cliente c;
        c = cc.buscarClienteCpf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 0).toString());
        clienteDetalhes.lerCliente(c, this);
    }//GEN-LAST:event_tableClienteMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel novoCliente;
    private javax.swing.JTable tableCliente;
    // End of variables declaration//GEN-END:variables
}
