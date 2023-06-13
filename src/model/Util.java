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
 *
 * @author 2020101202010138
 */
public class Util {

    public void LimpaTelaFrame(JFrame container) {
        Component components[] = container.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
    public void LimpaTelaPanel(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
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
