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
 * Classe responsável por controlar as operações relacionadas aos clientes.
 *
 * @author 2020101202010138
 */
public class ClienteController {

    /**
     * Cadastra um novo cliente.
     *
     * @param cCli : o objeto CadCliente é a tela de cadastro de clientes que
     * contem os dados do cliente.
     */
    public void cadastrarCliente(CadCliente cCli) {
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

    /**
     * Atualiza os dados de um cliente existente.
     *
     * @param cCli : o objeto ClienteDetalhes é a tela de detalhes do cliente
     * específico a ser atualizado
     * @param cliente : o objeto Cliente a ser atualizado
     */
    public void atualizarCliente(ClienteDetalhes cCli, Cliente cliente) {
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

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return uma lista contendo todos os clientes cadastrados
     */
    public List<Cliente> listarCliente() {
        ClienteDAO cDao = new ClienteDAO();
        List<Cliente> lista = cDao.listarCliente();
        return lista;
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param i : o ID do cliente a ser buscado
     * @return o objeto Cliente correspondente ao ID especificado, ou null se
     * não for encontrado
     */
    public Cliente buscarClienteId(int i) {
        int id = i;
        Cliente c = new ClienteDAO().buscarClienteId(id);
        return c;
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cp : o CPF do cliente a ser buscado
     * @return o objeto Cliente correspondente ao CPF especificado, ou null se
     * não for encontrado
     */
    public Cliente buscarClienteCpf(String cp) {
        String cpf = cp;
        Cliente c = new ClienteDAO().buscarClienteCpf(cpf);
        return c;
    }
}
