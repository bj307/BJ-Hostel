/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectBD;
import model.ServicoDisponivel;

/**
 *
 * @author kaior
 */
public class ServicoDisponivelDAO {

    private Connection con;

    public ServicoDisponivelDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarServico(ServicoDisponivel servico) {
        try {
            String sql = "insert into tb_servicosdisponivel (nome, preco) values (?,?)";
            PreparedStatement state = con.prepareStatement(sql);

            state.setString(1, servico.getNome());
            state.setDouble(2, servico.getPreco());
            state.execute();
            state.close();

            System.out.println("Servico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }

    public List<ServicoDisponivel> listarServico() {
        try {
            List<ServicoDisponivel> lista = new ArrayList<>();

            String sql = "select * from tb_servicosdisponivel";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                ServicoDisponivel s = new ServicoDisponivel();
                s.setId(result.getInt("id"));
                s.setNome(result.getString("nome"));
                s.setPreco(result.getDouble("preco"));

                lista.add(s);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public ServicoDisponivel buscarServicoNome(String n) {
        try {
            String nome = n;
            ServicoDisponivel s = new ServicoDisponivel();
            String sql = "SELECT * FROM tb_servicosdisponivel WHERE nome = '" + nome + "'";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            if (result.next()) {
                s.setId(result.getInt("id"));
                s.setNome(result.getString("nome"));
                s.setPreco(result.getDouble("preco"));
            }

            return s;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public ServicoDisponivel buscarServicoId(int n) {
        try {
            int id = n;
            ServicoDisponivel s = new ServicoDisponivel();
            String sql = "select * from tb_servicosdisponivel where id = " + id;
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            if (result.next()) {
                s.setId(result.getInt("id"));
                s.setNome(result.getString("nome"));
                s.setPreco(result.getDouble("preco"));
            }

            return s;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
}
