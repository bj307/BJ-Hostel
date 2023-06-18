/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import java.util.List;
import model.Cliente;
import view.CadCliente;
import view.ClienteDetalhes;

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
    
    public void atualiza(ClienteDetalhes cCli, Cliente cliente) {
        ClienteDAO cDao = new ClienteDAO();
        Cliente c = new Cliente();
        c.setId(cliente.getId());
        c.setNome(cCli.nome.getText());
        c.setDataNasc(cliente.getDataNasc());
        c.setRg(cliente.getRg());
        c.setCpf(cliente.getCpf());
        c.setEmail(cCli.email.getText());
        c.setCelular(cCli.celular.getText());
        c.setCep(cCli.cep.getText());
        c.setEndereco(cCli.endereco.getText());
        c.setComplemento(cCli.complemento.getText());
        c.setCidade(cCli.cidade.getText());
        c.setEstado(cCli.boxUf.getSelectedItem().toString());
        cDao.atualizarCliente(c);
    }
    
    public List<Cliente> listar() {
        ClienteDAO cDao = new ClienteDAO();
        List<Cliente> lista = cDao.listarCliente();
        return lista;
    }
    
    public Cliente buscarId(int i) {
        int id = i;
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = cdao.buscarClienteId(id);
        return c;
    }
}
