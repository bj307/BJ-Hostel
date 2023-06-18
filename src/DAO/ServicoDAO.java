/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectBD;
import model.Cliente;
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

            HospedagemDAO hd = new HospedagemDAO();
            hd.atualizarHospedagem(hospedagem);

            String sql = "insert into tb_servicos (servicoDisponivelId, data, quantidade, preco, status) values (?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            state.setInt(1, servico.getServicoDisponivel().getId());
            state.setString(2, servico.getData());
            state.setInt(3, servico.getQuantidade());
            state.setDouble(4, servico.getPreco());
            state.setString(5, servico.getStatus());
            state.execute();

            ResultSet generatedKeys = state.getGeneratedKeys();
            int idServico;
            if (generatedKeys.next()) {
                idServico = generatedKeys.getInt(1);

                String sqlHospedagemServico = "insert into hospedagem_servico (servico_id, hospedagem_id) VALUES (?,?)";
                PreparedStatement stateHospServ = con.prepareStatement(sqlHospedagemServico);
                stateHospServ.setInt(1, idServico);
                stateHospServ.setInt(2, hospedagem.getId());
                stateHospServ.execute();
            }
            state.close();
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
                s.setPreco(result.getDouble("preco"));
                s.setStatus(result.getString("status"));

                lista.add(s);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public List<Servico> listarServicoH(int i) {
        try {
            int id = i;
            List<Servico> lista = new ArrayList<>();

            String sql = "select * from hospedagem_servico where hospedagem_id = " + id;
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {

                String sql2 = "select * from tb_servicos where id = " + result.getInt("servico_id");
                PreparedStatement state2 = con.prepareStatement(sql2);
                ResultSet result2 = state2.executeQuery();
                while (result2.next()) {
                    Servico s = new Servico();
                    ServicoDisponivelDAO sdao = new ServicoDisponivelDAO();

                    s.setId(result2.getInt("id"));
                    s.setServicoDisponivel(sdao.buscarServicoId(result2.getInt("servicoDisponivelId")));
                    s.setData(result2.getString("data"));
                    s.setQuantidade(result2.getInt("quantidade"));
                    s.setPreco(result2.getDouble("preco"));
                    s.setStatus(result2.getString("status"));

                    lista.add(s);
                }
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public Servico buscarId(int i) {
        try {
            int id = i;
            Servico s = new Servico();
            String sql = "select * from tb_servicos where id = " + id;
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();
            while (result.next()) {
                ServicoDisponivelDAO sdao = new ServicoDisponivelDAO();

                s.setId(result.getInt("id"));
                s.setServicoDisponivel(sdao.buscarServicoId(result.getInt("servicoDisponivelId")));
                s.setData(result.getString("data"));
                s.setQuantidade(result.getInt("quantidade"));
                s.setPreco(result.getDouble("preco"));
                s.setStatus(result.getString("status"));
            }
            return s;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public Cliente buscarIdhs(int i) {
        try {
            int id = i;
            Cliente c = new Cliente();
            String sql = "select * from hospedagem_servico where servico_id = " + id;
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet result = state.executeQuery();
            if (result.next()) {
                String sql2 = "select * from tb_hospedagens where id = " + result.getInt("hospedagem_id");
                PreparedStatement state2 = con.prepareStatement(sql2);
                ResultSet result2 = state2.executeQuery();
                if (result2.next()) {
                    String sql3 = "select * from tb_clientes where id = " + result2.getInt("id_cliente");
                    PreparedStatement state3 = con.prepareStatement(sql3);
                    ResultSet result3 = state3.executeQuery();
                    if (result3.next()) {
                        c.setId(result3.getInt("id"));
                        c.setNome(result3.getString("nome"));
                        c.setDataNasc(result3.getString("dataNasc"));
                        c.setRg(Integer.parseInt(result3.getString("rg")));
                        c.setCpf(result3.getString("cpf"));
                        c.setEmail(result3.getString("email"));
                        c.setCelular(result3.getString("celular"));
                        c.setCep(result3.getString("cep"));
                        c.setEndereco(result3.getString("endereco"));
                        c.setComplemento(result3.getString("complemento"));
                        c.setCidade(result3.getString("cidade"));
                        c.setEstado(result3.getString("estado"));
                    }
                }
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public void atualizaServico(Servico servico) {
        try {
            String sql = "update tb_servicos set servicoDisponivelId=?, data=?, quantidade=?, preco=?, status=? where id=?";
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setInt(1, servico.getServicoDisponivel().getId());
            state.setString(2, servico.getData());
            state.setInt(3, servico.getQuantidade());
            state.setDouble(4, servico.getPreco());
            state.setString(5, servico.getStatus());
            state.setInt(6, servico.getId());
            
            state.execute();
            state.close();
            System.out.println("Servico atualizado com sucesso!" + servico.getStatus());
        } catch (Exception e) {
        }
    }
}
