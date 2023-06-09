/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.EventoController;
import Controller.FaturaController;
import Controller.HospedagemController;
import Controller.QuartoController;
import Controller.ServicoController;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Evento;
import model.Hospedagem;
import model.Servico;

/**
 * HospedagemDetalhes é uma classe que representa a tela de detalhes de uma
 * hospedagem.
 *
 * @author kaior
 */
public class HospedagemDetalhes extends javax.swing.JFrame {

    ServicoController servicoController = new ServicoController();
    EventoController eventoController = new EventoController();
    HospedagemController hc = new HospedagemController();
    QuartoController qc = new QuartoController();
    ServicoController sc = new ServicoController();
    Hospedagem h;
    Hospedagens hs;

    /**
     * Construtor vazio da classe HospedagemDetalhes.
     */
    public HospedagemDetalhes() {
        initComponents();
    }

    /**
     * Cria a interface gráfica da tela de detalhes de hospedagem e configura as
     * propriedades iniciais.
     *
     * @param h : Objeto Hospedagens é a lista de hospedagens existentes.
     */
    public HospedagemDetalhes(Hospedagens h) {
        initComponents();
        this.hs = h;
        this.setTitle("Detalhes de hospedagem");
        this.setLocationRelativeTo(null);
    }

    /**
     * Atualiza a tabela de serviços com os serviços relacionados à hospedagem
     * atual.
     */
    public void atualizaTbServicos() {
        List<Servico> lista = servicoController.listarServicosHospedagem(h.getId());
        DefaultTableModel servicosTb = (DefaultTableModel) tbServico.getModel();
        servicosTb.setNumRows(0);
        for (Servico s : lista) {
            servicosTb.addRow(new Object[]{
                s.getServicoDisponivel().getNome(),
                s.getQuantidade(),
                s.getPreco()
            });
        }
    }

    /**
     * Verifica se a hospedagem possui data de checkout definida e atualiza a
     * interface de acordo.
     *
     * @param h : A hospedagem a ser verificada.
     * @return True se o checkout estiver definido, False caso contrário.
     */
    public boolean verificaCheckout(Hospedagem h) {
        if (h.getCheckout() != null) {
            checkout.setText(h.getCheckout().toString());
            btnCheckout.setVisible(false);
            addEvento.setEnabled(false);
            addServ.setEnabled(false);
            return true;
        } else {
            checkout.setText("");
            btnCheckout.setVisible(true);
            addEvento.setEnabled(true);
            addServ.setEnabled(true);
            return false;
        }
    }

    /**
     * Preenche a interface com os dados da hospedagem recebida.
     *
     * @param hospedagem : A hospedagem a ser exibida.
     */
    public void lerHospedagem(Hospedagem hospedagem) {
        this.h = hospedagem;
        nome.setText(h.getCliente().getNome());
        cpf.setText(h.getCliente().getCpf());
        checkin.setText(h.getCheckin().toString());
        verificaCheckout(h);
        idQuarto.setText(String.valueOf(h.getQuarto().getId()));
        tipoQuarto.setText(h.getQuarto().getTipo());
        hospedes.setText(String.valueOf(h.getnHospedes()));
        inputPlaca.setText(h.getPlaca());
        atualizaTbEventos();
        atualizaTbServicos();

    }

    /**
     * Atualiza a tabela de eventos com os eventos relacionados à hospedagem
     * atual.
     */
    public void atualizaTbEventos() {
        List<Evento> lista = eventoController.listarEventoHosp(h.getId());
        DefaultTableModel eventosTb = (DefaultTableModel) tbEvento.getModel();
        eventosTb.setNumRows(0);
        for (Evento e : lista) {
            eventosTb.addRow(new Object[]{
                e.getNomeEvento(),
                eventoController.buscarParticipantes(e.getId())
            });

        }
    }

    /**
     * Realiza o checkout da hospedagem atual.
     */
    public void realizaCheckout() {
        List<Servico> lista = sc.listarServicosHospedagem(h.getId());
        for (Servico s : lista) {
            if (s.getStatus().equals("Aberto")) {
                s.setStatus("Fechado");
                sc.atualizaServico(s);
            }
        }

        Calendar hoje = Calendar.getInstance();
        Date dataCheckout = hoje.getTime();
        h.setCheckout(dataCheckout);
        hc.atualizarHospedagem(h);
        btnCheckout.setVisible(false);
        addEvento.setEnabled(false);
        addServ.setEnabled(false);
        h.getQuarto().setStatus("desocupado");
        qc.atualizarQuarto(h.getQuarto());
        lerHospedagem(h);
        hs.atualizaTabela();

        new FaturaController().cadastrar(h);
    }

    public void verFatura(Hospedagem hp) {
        Fatura f = new Fatura();
        f.setVisible(true);
        f.preencherFatura(h.getCliente(), h);
    }
    
    public void modoCliente() {
        btnCheckout.setVisible(false);
        addEvento.setVisible(false);
        addServ.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        checkin = new javax.swing.JTextField();
        checkout = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idQuarto = new javax.swing.JTextField();
        tipoQuarto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        hospedes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputPlaca = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        addEvento = new javax.swing.JButton();
        addServ = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        scrollEvento = new javax.swing.JScrollPane();
        tbEvento = new javax.swing.JTable();
        scrollServico = new javax.swing.JScrollPane();
        tbServico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Detalhes da Hospedagem");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        jLabel3.setText("Nome");

        nome.setEditable(false);
        nome.setBackground(new java.awt.Color(28, 39, 57));
        nome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setText("CPF");

        checkin.setEditable(false);
        checkin.setBackground(new java.awt.Color(28, 39, 57));

        checkout.setEditable(false);
        checkout.setBackground(new java.awt.Color(28, 39, 57));

        jLabel5.setText("Data Check-In");

        jLabel6.setText("Data Check-Out");

        jLabel2.setText("ID Quarto");

        idQuarto.setEditable(false);
        idQuarto.setBackground(new java.awt.Color(28, 39, 57));

        tipoQuarto.setEditable(false);
        tipoQuarto.setBackground(new java.awt.Color(28, 39, 57));

        jLabel7.setText("Tipo do quarto");

        hospedes.setEditable(false);
        hospedes.setBackground(new java.awt.Color(28, 39, 57));

        jLabel8.setText("Nº de hospedes");

        inputPlaca.setEditable(false);
        inputPlaca.setBackground(new java.awt.Color(28, 39, 57));
        try {
            inputPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U U U # U # #")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputPlaca.setText("");

        jLabel9.setText("Placa do veículo");

        cpf.setEditable(false);
        cpf.setBackground(new java.awt.Color(28, 39, 57));
        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        addEvento.setText("Adicionar evento");
        addEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventoActionPerformed(evt);
            }
        });

        addServ.setText("Adicionar serviço");
        addServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServActionPerformed(evt);
            }
        });

        btnCheckout.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        btnCheckout.setText("Realizar Check-Out");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        tbEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evento", "Nº de participantes"
            }
        ));
        scrollEvento.setViewportView(tbEvento);

        tbServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do serviço", "Quantidade", "Valor total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollServico.setViewportView(tbServico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(75, 75, 75)
                        .addComponent(scrollServico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(hospedes))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inputPlaca)
                                        .addGap(18, 18, 18)
                                        .addComponent(addEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(127, 127, 127))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cpf)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(addServ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hospedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEvento)
                    .addComponent(addServ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollServico, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(scrollEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed

        realizaCheckout();
        int e = JOptionPane.showOptionDialog(null, "Checkout efetuado. Deseja ver a fatura?", "Check-Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Ver Fatura", "Sair"}, "Ver Fatura");
        if (e == JOptionPane.YES_OPTION) {
            System.out.println("Ver fatura");
            verFatura(h);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void addEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventoActionPerformed
        //abre tela adicionar evento
        AddEvento addEvento = new AddEvento(h, this, hs);
        addEvento.setVisible(true);
    }//GEN-LAST:event_addEventoActionPerformed

    private void addServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServActionPerformed
        //abre tela adicionar serviço
        CadServico cadServico = new CadServico(h, this, hs);
        cadServico.setVisible(true);
    }//GEN-LAST:event_addServActionPerformed

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
            java.util.logging.Logger.getLogger(HospedagemDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospedagemDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospedagemDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospedagemDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospedagemDetalhes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEvento;
    private javax.swing.JButton addServ;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JTextField checkin;
    private javax.swing.JTextField checkout;
    public javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField hospedes;
    private javax.swing.JTextField idQuarto;
    public javax.swing.JFormattedTextField inputPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField nome;
    private javax.swing.JScrollPane scrollEvento;
    private javax.swing.JScrollPane scrollServico;
    private javax.swing.JTable tbEvento;
    private javax.swing.JTable tbServico;
    private javax.swing.JTextField tipoQuarto;
    // End of variables declaration//GEN-END:variables
}
