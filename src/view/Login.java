/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Controller.FuncionarioController;
import Controller.ClienteController;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

/**
 * A classe Login é responsável por permitir que um funcionário faça login no
 * sistema fornecendo seu RG e senha.
 *
 * @author kaior
 */
public class Login extends javax.swing.JPanel {

    private int round = 50;
    Setup setup;

    /**
     * Construtor da classe Login.
     */
    public Login() {
    }

    /**
     * Construtor da classe Login que recebe uma instância de Setup. Cria a
     * interface gráfica da tela de login e configura as propriedades iniciais.
     *
     * @param setup : setup é a tela inicial que gerencia o login.
     */
    public Login(Setup setup) {
        initComponents();
        this.setup = setup;
        setOpaque(false);
        setVisible(true);
    }

    private boolean loginCliente() {
        String cpf;
        String senha;
        cpf = inputUser.getText();
        senha = inputPass.getText();
        ClienteController cc = new ClienteController();
        if (cc.login(cpf, senha)) {
            setup.setVisible(false);
            return true;
        }
        return false;
    }

    private boolean loginFun() {
        int rg;
        String senha;
        rg = Integer.parseInt(inputUser.getText());
        senha = inputPass.getText();
        FuncionarioController fc = new FuncionarioController();
        if (fc.login(rg, senha)) {
            setup.setVisible(false);
            return true;
        }
        return false;
    }

    /**
     * Tenta realizar o login de um funcionário com base nos dados fornecidos.
     *
     */
    public void realizaLogin() {
        try {
            if (loginCliente()) {
                return;
            } 
            if (loginFun()) {
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sai fora hacker");
            System.out.println(e + "::::::erro");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Paint p = new GradientPaint(0, 0, new Color(61, 61, 61, 255), 0, getHeight(), new Color(94, 94, 94, 255));

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(createRound());
        g2.setPaint(p);
        g2.fill(area);
        g2.dispose();

        super.paintComponent(g);
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    private Shape createRound() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, round);
        int roundY = Math.min(height, round);

        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, roundY / 2, width = roundX / 2, height = roundY / 2)));
        return area;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(50, 50);
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
        inputUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("valorax", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        inputUser.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel2.setText("Usuário");

        inputPass.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel3.setText("Senha");

        btnEntrar.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(inputUser)
                            .addComponent(jLabel3)
                            .addComponent(inputPass, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        realizaLogin();
    }//GEN-LAST:event_btnEntrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JTextField inputPass;
    private javax.swing.JTextField inputUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
