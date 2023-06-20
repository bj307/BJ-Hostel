/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FuncionarioDAO;
import model.Funcionario;
import view.CadFun;

/**
 * Classe responsável por controlar as operações relacionadas aos funcionários.
 *
 * @author kaior
 */
public class FuncionarioController {

    /**
     * Cadastra um novo funcionário.
     */
    public void cadastrarFuncionario(CadFun cFun) {
        Funcionario f = new Funcionario();
        f.setNome(cFun.inputNome.getText());
        f.setRg(Integer.parseInt(cFun.inputRg.getText()));
        f.setCpf(cFun.inputCpf.getText());
        f.setEmail(cFun.inputEmail.getText());
        f.setSenha(cFun.senha.getText());
        f.setTipo(cFun.boxCargo.getSelectedItem().toString());
        f.setCelular(cFun.inputCelular.getText());
        f.setCep(cFun.inputCep.getText());
        f.setEndereco(cFun.inputEndereco.getText());
        f.setComplemento(cFun.inputComplemento.getText());
        f.setCidade(cFun.inputCidade.getText());
        f.setEstado(cFun.boxUf.getSelectedItem().toString());
        FuncionarioDAO fDao = new FuncionarioDAO();
        fDao.cadastrarFuncionario(f);
    }

    /**
     * Realiza o login de um funcionário.
     *
     * @param i : o RG do funcionário
     * @param s : a senha do funcionário
     */
    public boolean login(int i, String s) {
        int rg = i;
        String senha = s;
        if (new FuncionarioDAO().login(rg, senha)) {
            return true;
        }
        return false;
    }
}
