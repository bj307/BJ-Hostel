/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.CardLayout;

/**
 *
 * @author kaior
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard2
     */

    Home home = new Home();
    Clientes cliente = new Clientes();
    Eventos evento = new Eventos();
    Quartos quarto = new Quartos();
    Servicos servico = new Servicos();
    Hospedagens hospedagem = new Hospedagens();
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
        this.setTitle("BJ HOSTEL");
        this.setLocationRelativeTo(null);
        
        jPanelVaria.setLayout(new CardLayout());
        jPanelVaria.add(home, "home");
        jPanelVaria.add(cliente, "clientes");
        jPanelVaria.add(evento, "eventos");
        jPanelVaria.add(quarto, "quartos");
        jPanelVaria.add(servico, "servicos");
        jPanelVaria.add(hospedagem, "hospedagens");
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "home");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelVaria = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inicio = new javax.swing.JLabel();
        reservas = new javax.swing.JLabel();
        clientes = new javax.swing.JLabel();
        quartos = new javax.swing.JLabel();
        eventos = new javax.swing.JLabel();
        servicos = new javax.swing.JLabel();
        cadFuncionario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(61, 61, 61));
        setPreferredSize(new java.awt.Dimension(1500, 900));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanelVaria.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVaria.setPreferredSize(new java.awt.Dimension(400, 800));

        javax.swing.GroupLayout jPanelVariaLayout = new javax.swing.GroupLayout(jPanelVaria);
        jPanelVaria.setLayout(jPanelVariaLayout);
        jPanelVariaLayout.setHorizontalGroup(
            jPanelVariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanelVariaLayout.setVerticalGroup(
            jPanelVariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelVaria);

        jPanel1.setBackground(new java.awt.Color(61, 61, 61));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hotel.png"))); // NOI18N

        inicio.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        inicio.setText("Inicio");
        inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inicioMouseReleased(evt);
            }
        });

        reservas.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        reservas.setText("Hospedagens");
        reservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reservasMouseReleased(evt);
            }
        });

        clientes.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        clientes.setText("Clientes");
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientesMouseReleased(evt);
            }
        });

        quartos.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        quartos.setText("Quartos");
        quartos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quartos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                quartosMouseReleased(evt);
            }
        });

        eventos.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        eventos.setText("Eventos");
        eventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eventosMouseReleased(evt);
            }
        });

        servicos.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        servicos.setText("Serviços");
        servicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        servicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                servicosMouseReleased(evt);
            }
        });

        cadFuncionario.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        cadFuncionario.setText("Funcionários");
        cadFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicio)
                    .addComponent(reservas)
                    .addComponent(clientes)
                    .addComponent(quartos)
                    .addComponent(eventos)
                    .addComponent(servicos)
                    .addComponent(cadFuncionario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(46, 46, 46)
                .addComponent(inicio)
                .addGap(30, 30, 30)
                .addComponent(reservas)
                .addGap(30, 30, 30)
                .addComponent(clientes)
                .addGap(30, 30, 30)
                .addComponent(quartos)
                .addGap(30, 30, 30)
                .addComponent(eventos)
                .addGap(30, 30, 30)
                .addComponent(servicos)
                .addGap(30, 30, 30)
                .addComponent(cadFuncionario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(61, 61, 61));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMouseReleased
        //abrir pagina de clientes
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "clientes");
        cliente.atualizaTabela();
    }//GEN-LAST:event_clientesMouseReleased

    private void inicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseReleased
        //abrir pagina de inicio
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "home");
    }//GEN-LAST:event_inicioMouseReleased

    private void eventosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventosMouseReleased
        //abrir pagina de eventos
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "eventos");
        evento.atualizaLista();
    }//GEN-LAST:event_eventosMouseReleased

    private void quartosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quartosMouseReleased
        //abrir pagina de quartos
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "quartos");
        quarto.atualizaTabela();
    }//GEN-LAST:event_quartosMouseReleased

    private void servicosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicosMouseReleased
        //abrir pagina de serviços
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "servicos");
        servico.atualizaTabela();
        //servico.atualizaCard();
    }//GEN-LAST:event_servicosMouseReleased

    private void reservasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservasMouseReleased
        //abre pagina de hospedagens
        CardLayout cl = (CardLayout) (jPanelVaria.getLayout());
        cl.show(jPanelVaria, "hospedagens");
        hospedagem.atualizaTabela();
    }//GEN-LAST:event_reservasMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        IntelliJTheme.setup(Setup.class.getResourceAsStream("/Gradianto_deep_ocean.theme.json"));
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cadFuncionario;
    private javax.swing.JLabel clientes;
    private javax.swing.JLabel eventos;
    private javax.swing.JLabel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelVaria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quartos;
    private javax.swing.JLabel reservas;
    private javax.swing.JLabel servicos;
    // End of variables declaration//GEN-END:variables
}
