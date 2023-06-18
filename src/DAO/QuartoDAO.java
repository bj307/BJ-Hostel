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
            String sql = "insert into tb_quartos (tipo_quarto, num_camas, descricao, preco, tamanho, status) values (?,?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);

            state.setString(1, quarto.getTipo());
            state.setInt(2, quarto.getCamas());
            state.setString(3, quarto.getDescricao());
            state.setDouble(4, quarto.getPreco());
            state.setInt(5, quarto.getTamanho());
            state.setString(6, quarto.getStatus());

            state.execute();
            state.close();

            System.out.println("Quarto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }

    public List<Quarto> listarQuarto() {
        try {
            List<Quarto> lista = new ArrayList<>();

            String sql = "select * from tb_quartos";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                Quarto q = new Quarto();
                q.setId(result.getInt("id"));
                q.setTipo(result.getString("tipo_quarto"));
                q.setCamas(result.getInt("num_camas"));
                q.setPreco(result.getDouble("preco"));
                q.setTamanho(result.getInt("tamanho"));
                q.setDescricao(result.getString("descricao"));
                q.setStatus(result.getString("status"));

                lista.add(q);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public List<Quarto> listarQuartoDisponivel() {
        try {
            List<Quarto> lista = new ArrayList<>();

            String sql = "select * from tb_quartos where status = 'desocupado'";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                Quarto q = new Quarto();
                q.setId(result.getInt("id"));
                q.setTipo(result.getString("tipo_quarto"));
                q.setCamas(result.getInt("num_camas"));
                q.setPreco(result.getDouble("preco"));
                q.setTamanho(result.getInt("tamanho"));
                q.setDescricao(result.getString("descricao"));
                q.setStatus(result.getString("status"));

                lista.add(q);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public Quarto buscarQuartoId(int i) {
        try {
            int id = i;
            Quarto q = new Quarto();
            String sql = "select * from tb_quartos where id = " + id;
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();
            
            if (result.next()) {
                q.setId(result.getInt("id"));
                q.setTipo(result.getString("tipo_quarto"));
                q.setCamas(result.getInt("num_camas"));
                q.setDescricao(result.getString("descricao"));
                q.setPreco(result.getDouble("preco"));
                q.setTamanho(result.getInt("tamanho"));
                q.setStatus(result.getString("status"));
            }
            return q;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public Quarto buscarQuartoNome(String n) {
        try {
            String nome = n;
            Quarto q = new Quarto();
            String sql = "select * from tb_quartos where tipo_quarto = '" + nome + "' AND status = 'desocupado' LIMIT 1";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();
            
            if (result.next()) {
                q.setId(result.getInt("id"));
                q.setTipo(result.getString("tipo_quarto"));
                q.setCamas(result.getInt("num_camas"));
                q.setDescricao(result.getString("descricao"));
                q.setPreco(result.getDouble("preco"));
                q.setTamanho(result.getInt("tamanho"));
                q.setStatus(result.getString("status"));
            }
            return q;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public void atualizarQuarto(Quarto quarto) {
        try {
            String sql = "update tb_quartos set tipo_quarto=?, num_camas=?, descricao=?, preco=?, tamanho=?, status=? where id=?";
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setString(1, quarto.getTipo());
            state.setInt(2, quarto.getCamas());
            state.setString(3, quarto.getDescricao());
            state.setDouble(4, quarto.getPreco());
            state.setInt(5, quarto.getTamanho());
            state.setString(6, quarto.getStatus());
            state.setInt(7, quarto.getId());

            state.execute();
            state.close();

            System.out.println("Quarto atualizado com sucesso!" + quarto.getStatus());
        } catch (Exception e) {
        }
    }
}
