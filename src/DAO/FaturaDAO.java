/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectBD;
import model.Fatura;
import model.Hospedagem;

/**
 *
 * @author kaior
 */
public class FaturaDAO {
    
    private Connection con;

    public FaturaDAO() {
        this.con = new ConnectBD().getConnection();
    }
    
    public void cadastrar(Fatura f) {
        try {
            String sql = "insert into fatura (cliente_id, hospedagem_id, total)"
                    + "values (?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setInt(1, f.getCliente().getId());
            state.setInt(2, f.getHospedagem().getId());
            state.setDouble(3, f.getTotal());
            
            state.execute();
            state.close();

            System.out.println("Fatura cadastrada com sucesso!");
            System.out.println("Fatura::::" + f.toString());
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }
    
    public Fatura buscarId(int i) {
        try {
            int id = i;
            Fatura f = new Fatura();
            return f;
        } catch (Exception e) {
            return null;
        }
    }
    
}
