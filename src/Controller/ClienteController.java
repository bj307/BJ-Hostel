/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import model.Cliente;
import view.CadCliente;

/**
 *
 * @author 2020101202010138
 */
public class ClienteController {
    
    public void cadastrar(CadCliente cCli){
        Cliente c = new Cliente();
        ClienteDAO cDao = new ClienteDAO();
        c.setNome(cCli.inputNome.getText());
        c.setDataNasc(cCli.inputNascimento.getText());
        c.setRg(Integer.parseInt(cCli.inputRg.getText()));
        c.setCpf(cCli.inputCpf.getText());
        c.setEmail(cCli.inputEmail.getText());
        c.setCelular(cCli.inputCelular.getText());
        c.setCep(cCli.inputCep.getText());
        c.setEndereco(cCli.inputEndereco.getText());
        c.setComplemento(cCli.inputComplemento.getText());
        c.setCidade(cCli.inputCidade.getText());
        c.setEstado(cCli.boxUf.getSelectedItem().toString());
        cDao.cadastrarCliente(c);
    }
}
