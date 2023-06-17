/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jdbc.ConnectBD;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kaior
 */
public class ClienteDAO {

    private Connection con;

    public ClienteDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            String sql = "insert into tb_clientes (nome, dataNasc, rg, cpf, email, celular, cep, endereco, complemento, cidade, estado) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);

            state.setString(1, cliente.getNome());
            state.setString(2, cliente.getDataNasc());
            state.setInt(3, cliente.getRg());
            state.setString(4, cliente.getCpf());
            state.setString(5, cliente.getEmail());
            state.setString(6, cliente.getCelular());
            state.setString(7, cliente.getCep());
            state.setString(8, cliente.getEndereco());
            state.setString(9, cliente.getComplemento());
            state.setString(10, cliente.getCidade());
            state.setString(11, cliente.getEstado());

            state.execute();
            state.close();

            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println("Dados do cliente: ");
            System.out.println(cliente.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente");
            System.out.println(e);
        }
    }

    public void atualizarCliente(Cliente cliente) {
        try {
            String sql = "update tb_clientes set nome=?, dataNasc=?, rg=?, cpf=?, email=?, celular=?, cep=?, endereco=?, complemento=?, cidade=?, estado=? where id =?";
            
            PreparedStatement state = con.prepareStatement(sql);

            state.setString(1, cliente.getNome());
            state.setString(2, cliente.getDataNasc());
            state.setInt(3, cliente.getRg());
            state.setString(4, cliente.getCpf());
            state.setString(5, cliente.getEmail());
            state.setString(6, cliente.getCelular());
            state.setString(7, cliente.getCep());
            state.setString(8, cliente.getEndereco());
            state.setString(9, cliente.getComplemento());
            state.setString(10, cliente.getCidade());
            state.setString(11, cliente.getEstado());
            state.setInt(12, cliente.getId());
            
            state.execute();
            state.close();

            System.out.println("Cliente alterado com sucesso!");
            System.out.println("Dados do cliente: ");
            System.out.println(cliente.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente");
            System.out.println(e);
        }
    }

    public void excluirCliente() {

    }

    public List<Cliente> listarCliente() {
        try {
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from tb_clientes";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            while (result.next()) {
                Cliente c = new Cliente();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setDataNasc(result.getString("dataNasc"));
                c.setRg(Integer.parseInt(result.getString("rg")));
                c.setCpf(result.getString("cpf"));
                c.setEmail(result.getString("email"));
                c.setCelular(result.getString("celular"));
                c.setCep(result.getString("cep"));
                c.setEndereco(result.getString("endereco"));
                c.setCidade(result.getString("cidade"));
                c.setEstado(result.getString("estado"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }

    public Cliente buscarClienteId(int i) {
        try {
            int id = i;
            Cliente c = new Cliente();
            String sql = "select * from tb_clientes where id = " + id;
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            if (result.next()) {
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setDataNasc(result.getString("dataNasc"));
                c.setRg(result.getInt("rg"));
                c.setCpf(result.getString("cpf"));
                c.setEmail(result.getString("email"));
                c.setCelular(result.getString("celular"));
                c.setCep(result.getString("cep"));
                c.setEndereco(result.getString("endereco"));
                c.setComplemento(result.getString("complemento"));
                c.setCidade(result.getString("cidade"));
                c.setEstado(result.getString("estado"));
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
    
    public Cliente buscarClienteCpf(String cp) {
        try {
            String cpf = cp;
            Cliente c = new Cliente();
            String sql = "select * from tb_clientes where cpf = '" + cpf + "'";
            PreparedStatement state = con.prepareStatement(sql);

            ResultSet result = state.executeQuery();

            if (result.next()) {
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setDataNasc(result.getString("dataNasc"));
                c.setRg(result.getInt("rg"));
                c.setCpf(result.getString("cpf"));
                c.setEmail(result.getString("email"));
                c.setCelular(result.getString("celular"));
                c.setCep(result.getString("cep"));
                c.setEndereco(result.getString("endereco"));
                c.setComplemento(result.getString("complemento"));
                c.setCidade(result.getString("cidade"));
                c.setEstado(result.getString("estado"));
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Erro:::: " + e);
            return null;
        }
    }
}
