/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import model.Evento;

/**
 * EventoUni é um painel que exibe as informações de um evento específico
 *
 * @author kaior
 */
public class EventoUni extends javax.swing.JPanel {

    Evento evento;

    /**
     * Construtor da classe EventoUni. Cria a interface gráfica do painel e
     * exibe as informações do evento fornecido.
     *
     * @param e o objeto Evento contendo as informações do evento a ser exibido
     */
    public EventoUni(Evento e) {
        initComponents();
        this.evento = e;
        nomeEvento.setText(evento.getNomeEvento());
        capacidadeEvento.setText(String.valueOf(evento.getCapacidadeEvento()));
        localEvento.setText(evento.getLocalEvento());
        dataEvento.setText(evento.getData());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        nomeEvento = new javax.swing.JTextField();
        dataEvento = new javax.swing.JTextField();
        capacidadeEvento = new javax.swing.JTextField();
        localEvento = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });

        nomeEvento.setEditable(false);
        nomeEvento.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        nomeEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nomeEventoMouseReleased(evt);
            }
        });

        dataEvento.setEditable(false);
        dataEvento.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        capacidadeEvento.setEditable(false);
        capacidadeEvento.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        localEvento.setEditable(false);
        localEvento.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(nomeEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(capacidadeEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(localEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dataEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(capacidadeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(localEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased

    }//GEN-LAST:event_jPanel4MouseReleased

    private void nomeEventoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeEventoMouseReleased
        //clicou no nome da pessoa

    }//GEN-LAST:event_nomeEventoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capacidadeEvento;
    private javax.swing.JTextField dataEvento;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField localEvento;
    private javax.swing.JTextField nomeEvento;
    // End of variables declaration//GEN-END:variables
}
