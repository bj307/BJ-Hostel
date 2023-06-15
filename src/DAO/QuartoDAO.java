/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectBD;
import model.Quarto;

/**
 *
 * @author kaior
 */
public class QuartoDAO {
    
    private Connection con;
    
    public QuartoDAO() {
        this.con = new ConnectBD().getConnection();
    }
    
    public void cadastrarQuarto(Quarto quarto) {
        try {
            String sql = "intert into tb_quartos (tipo_quarto, num_camas, descricao, preco, tamanho) values (?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setString(1, quarto.getTipo());
            state.setInt(2,quarto.getCamas());
            state.setString(3,quarto.getDescricao());
            state.setDouble(4,quarto.getPreco());
            state.setDouble(5,quarto.getTamanho());
            
            state.execute();
            state.close();

            System.out.println("Quarto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }
}
