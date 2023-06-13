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
/**
 *
 * @author kaior
 */
public class ClienteDAO {
    
    private Connection con;
    
    public ClienteDAO(){
        this.con = new ConnectBD().getConnection();
    }
    
    public void cadastrarCliente(Cliente cliente){
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
    
    public void atualizarCliente(){
        
    }
    
    public void excluirCliente(){
        
    }
    
}
