/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectBD;
import model.Evento;
import model.Hospedagem;

/**
 *
 * @author 2020101202010138
 */
public class EventoDAO {

    private Connection con;

    public EventoDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarEvento(Evento evento) {
        try {
            String sql = "insert into tb_eventos (nome_evento, data_evento, local_evento, capacidade_evento) "
                    + "values (?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);

            state.setString(1, evento.getNomeEvento());
            state.setString(2, evento.getData());
            state.setString(3, evento.getLocalEvento());
            state.setInt(4, evento.getCapacidadeEvento());

            state.execute();
            state.close();

            System.out.println("Evento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }

    public List<Evento> listarEvento() {
        try {
            List<Evento> lista = new ArrayList<>();

            String sql = "select * from tb_eventos";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                Evento e = new Evento();
                e.setCapacidadeEvento(result.getInt("capacidade_evento"));
                e.setData(result.getString("data_evento"));
                e.setLocalEvento(result.getString("local_evento"));
                e.setNomeEvento(result.getString("nome_evento"));
                lista.add(e);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public List<Evento> listarEventoSH(int i) {
        try {
            int id = i;
            List<Evento> lista = new ArrayList<>();
            String sql = "select * from hospedagem_evento where hospedagem_id = " + id;

            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();

            while (result.next()) {
                String sql2 = "select * from tb_eventos where id = " + result.getInt("evento_id");
                PreparedStatement state2 = con.prepareStatement(sql2);
                ResultSet result2 = state2.executeQuery();
                while (result2.next()) {
                    Evento e = new Evento();
                    e.setId(result2.getInt("id"));
                    e.setNomeEvento(result2.getString("nome_evento"));
                    e.setData(result2.getString("data_evento"));
                    e.setLocalEvento(result2.getString("local_evento"));
                    e.setCapacidadeEvento(result2.getInt("capacidade_evento"));

                    lista.add(e);
                }
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public int buscarPessoasEvento(int i) {
        try {
            int id = i;
            String sql = "select * from hospedagem_evento where evento_id = " + id;
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();
            int numPessoas = 0;
            if (result.next()) {
                numPessoas = result.getInt("num_pessoas");
            }
            return numPessoas;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return 0;
        }
    }
    
    public Evento buscarPorNome(String n) {
        try {
            String nome = n;
            Evento e = new Evento();
            String sql = "select * from tb_eventos where nome_evento = '" + nome + "'";
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();
            if (result.next()) {
                e.setId(result.getInt("id"));
                e.setNomeEvento(result.getString("nome_evento"));
                e.setLocalEvento(result.getString("local_evento"));
                e.setData(result.getString("data_evento"));
                e.setCapacidadeEvento(result.getInt("capacidade_evento"));
            }
            return e;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public void addEventoHosp(Evento ev, Hospedagem hp, int num) {
        try {
            int pessoas = num;
            String sql = "insert into hospedagem_evento (hospedagem_id, evento_id, num_pessoas) values (?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setInt(1, hp.getId());
            state.setInt(2, ev.getId());
            state.setInt(3, pessoas);
            state.execute();
            state.close();
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
        }
    }
}
