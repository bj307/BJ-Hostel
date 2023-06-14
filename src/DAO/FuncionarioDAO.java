/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import jdbc.ConnectBD;
import model.Funcionario;
import view.Dashboard;

/**
 *
 * @author kaior
 */
public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectBD().getConnection();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        try {
            String sql = "insert into tb_funcionarios (nome, rg, cpf, email, senha, cargo, celular, cep, endereco, complemento, cidade, estado) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, funcionario.getNome());
            state.setInt(2, funcionario.getRg());
            state.setString(3, funcionario.getCpf());
            state.setString(4, funcionario.getEmail());
            state.setString(5, funcionario.getSenha());
            state.setString(6, funcionario.getCargo());
            state.setString(7, funcionario.getCelular());
            state.setString(8, funcionario.getCep());
            state.setString(9, funcionario.getEndereco());
            state.setString(10, funcionario.getComplemento());
            state.setString(11, funcionario.getCidade());
            state.setString(12, funcionario.getEstado());
            state.execute();
            state.close();

            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionario");
            System.out.println(e);
        }
    }

    public void login(int rg, String senha) {
        try {
            String sql = "select * from tb_funcionarios where rg = ? and senha = ?";
            PreparedStatement state = con.prepareStatement(sql);
            state.setInt(1, rg);
            state.setString(2, senha);
            ResultSet rs = state.executeQuery();
            if (rs.next()) {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sai fora hacker");
            }
        } catch (SQLException e) {
            System.out.println(e + "logou nao");
        }
    }

}
