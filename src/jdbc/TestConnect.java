/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

/**
 *
 * @author kaior
 */
public class TestConnect {
    
    public static void main(String[] args) {
        try {
            new ConnectBD().getConnection();
            System.out.println("Conectado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Não conectado.");
        }
    }
    
}
