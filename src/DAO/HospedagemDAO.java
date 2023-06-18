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
import model.Hospedagem;

/**
 *
 * @author kaior
 */
public class HospedagemDAO {

    private Connection con;

    public HospedagemDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarHospedagem(Hospedagem hospedagem) {
        try {
            String sql = "insert into tb_hospedagens (id_cliente, quarto_id, data_checkin, data_checkout, num_hospedes, placa_veiculo, total) "
                    + "values (?,?,?,?,?,?,?)";

            PreparedStatement state = con.prepareStatement(sql);

            state.setInt(1, hospedagem.getCliente().getId());
            state.setInt(2, hospedagem.getQuarto().getId());
            state.setDate(3, new java.sql.Date(hospedagem.getCheckin().getTime()));
            state.setDate(4, null);
            state.setInt(5, hospedagem.getnHospedes());
            state.setString(6, hospedagem.getPlaca());
            state.setDouble(7, hospedagem.getTotal());

            state.execute();
            state.close();

            System.out.println("Hospedagem cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }

    public List<Hospedagem> listarHospedagem() {
        try {
            List<Hospedagem> lista = new ArrayList<>();

            String sql = "select * from tb_hospedagens";
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();

            while (result.next()) {
                Hospedagem h = new Hospedagem();
                ClienteDAO cdao = new ClienteDAO();
                QuartoDAO qdao = new QuartoDAO();
                h.setId(result.getInt("id"));
                h.setCliente(cdao.buscarClienteId(result.getInt("id_cliente")));
                h.setQuarto(qdao.buscarQuartoId(result.getInt("quarto_id")));
                h.setCheckin(result.getDate("data_checkin"));
                h.setCheckout(result.getDate("data_checkout"));
                h.setnHospedes(result.getInt("num_hospedes"));
                h.setPlaca(result.getString("placa_veiculo"));
                h.setTotal(result.getDouble("total"));

                lista.add(h);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public Hospedagem buscaHospedagemId(int i) {
        try {
            int id = i;
            Hospedagem h = new Hospedagem();
            String sql = "select * from tb_hospedagens where id = " + id;
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();
            
            if (result.next()) {
                ClienteDAO cdao = new ClienteDAO();
                QuartoDAO qdao = new QuartoDAO();
                h.setId(result.getInt("id"));
                h.setCliente(cdao.buscarClienteId(result.getInt("id_cliente")));
                h.setQuarto(qdao.buscarQuartoId(result.getInt("quarto_id")));
                h.setCheckin(result.getDate("data_checkin"));
                h.setCheckout(result.getDate("data_checkout"));
                h.setnHospedes(result.getInt("num_hospedes"));
                h.setPlaca(result.getString("placa_veiculo"));
                h.setTotal(result.getDouble("total"));
            }
            return h;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public void atualizarHospedagem(Hospedagem hospedagem) {
        try {
            String sql = "update tb_hospedagens set id_cliente=?, quarto_id=?, data_checkin=?, data_checkout=?, num_hospedes=?, placa_veiculo=?, total=? where id =?";
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setInt(1, hospedagem.getCliente().getId());
            state.setInt(2, hospedagem.getQuarto().getId());
            state.setDate(3, new java.sql.Date(hospedagem.getCheckin().getTime()));
            state.setDate(4, null);
            state.setInt(5, hospedagem.getnHospedes());
            state.setString(6, hospedagem.getPlaca());
            state.setDouble(7, hospedagem.getTotal());
            state.setInt(8, hospedagem.getId());
            
            state.execute();
            state.close();
            System.out.println("Hospedagem atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
        }
    }
}
