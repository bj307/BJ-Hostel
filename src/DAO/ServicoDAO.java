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
import model.Servico;

/**
 *
 * @author kaior
 */
public class ServicoDAO {

    private Connection con;

    public ServicoDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarServico(Servico servico, Hospedagem hospedagem) {
        try {
            String sql = "insert into tb_servicos (servicoDisponivelId, data, quantidade, preco, status) values (?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);

            state.setInt(1, servico.getServicoDisponivel().getId());
            state.setString(2, servico.getData());
            state.setInt(3, servico.getQuantidade());
            state.setDouble(4, servico.getPreco());
            state.setString(5, servico.getStatus());
            state.execute();
            state.close();

            ResultSet generatedKeys = state.getGeneratedKeys();
            int idServico;
            if (generatedKeys.next()) {
                idServico = generatedKeys.getInt(1);

                String sqlHospedagemServico = "insert into hospedagem_servico (id_servico, id_hospedagem) VALUES (?,?)";
                PreparedStatement stateHospServ = con.prepareStatement(sqlHospedagemServico);
                stateHospServ.setInt(1, idServico);
                stateHospServ.setInt(2, hospedagem.getId());
                stateHospServ.execute();
            }

            System.out.println("Servico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO::::: " + e);
        }
    }

    public List<Servico> listarServico() {
        try {
            List<Servico> lista = new ArrayList<>();

            String sql = "select * from tb_servicos";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                Servico s = new Servico();
                ServicoDisponivelDAO sdao = new ServicoDisponivelDAO();
                
                s.setId(result.getInt("id"));
                s.setServicoDisponivel(sdao.buscarServicoId(result.getInt("servicoDisponivelId")));
                s.setData(result.getString("data"));
                s.setQuantidade(result.getInt("quantidade"));
                s.setPreco(result.getDouble("preco_servico"));
                s.setStatus(result.getString("status"));

                lista.add(s);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
}
