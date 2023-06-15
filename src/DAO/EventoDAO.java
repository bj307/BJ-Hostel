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
import model.Evento;

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
            state.setString(2, evento.getData().toString());
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
        } catch (Exception e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
}
