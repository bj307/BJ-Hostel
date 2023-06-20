/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe utilitária com métodos para limpar telas e verificar inputs em componentes Swing.
 * @author 2020101202010138
 */
public class Util {

    /**
     * Limpa os campos de texto de um JFrame.
     *
     * @param container O JFrame cujos campos de texto serão limpos.
     */
    public void LimpaTelaFrame(JFrame container) {
        Component components[] = container.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
    /**
     * Limpa os campos de texto de um JPanel.
     *
     * @param container O JPanel cujos campos de texto serão limpos.
     */
    public void LimpaTelaPanel(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
    /**
     * Verifica se todos os campos de texto de um JFrame estão preenchidos.
     *
     * @param container O JFrame cujos campos de texto serão verificados.
     * @return true se todos os campos estiverem preenchidos, false caso contrário.
     */
    public boolean VerificaInput(JFrame container) {
        Component components[] = container.getContentPane().getComponents();
        boolean input = true;
        for (Component component : components) {
            if (component instanceof JTextField) {
                if (((JTextField) component).getText().equals("") || ((JTextField) component).getText().equals(" ") || ((JTextField) component).getText().equals(null)) {
                    input = false;
                }
            }
        }
        return input;
    }
}
