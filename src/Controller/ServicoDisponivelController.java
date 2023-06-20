/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ServicoDisponivelDAO;
import java.util.List;
import model.ServicoDisponivel;
import view.CadServicoDisponivel;

/**
 * Classe responsável por controlar as operações relacionadas aos serviços
 * disponíveis.
 *
 * @author kaior
 */
public class ServicoDisponivelController {

    /**
     * Cadastra um novo serviço disponível.
     *
     * @param csd : o formulário de cadastro de serviço disponível
     */
    public void cadastrar(CadServicoDisponivel csd) {
        ServicoDisponivel sd = new ServicoDisponivel();
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        sd.setNome(csd.inputNome.getText());
        sd.setPreco(Double.parseDouble(csd.inputPreco.getValue().toString()));
        sdDao.cadastrarServico(sd);
    }

    /**
     * Retorna a lista de todos os serviços disponíveis.
     *
     * @return a lista de serviços disponíveis
     */
    public List<ServicoDisponivel> listarServico() {
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        List<ServicoDisponivel> lista = sdDao.listarServico();
        return lista;
    }

    /**
     * Busca um serviço disponível pelo seu nome.
     *
     * @param n : o nome do serviço a ser buscado
     * @return o serviço disponível encontrado, ou null se não encontrado
     */
    public ServicoDisponivel buscarServicoNome(String n) {
        String nome = n;
        ServicoDisponivel sd = new ServicoDisponivel();
        sd = new ServicoDisponivelDAO().buscarServicoNome(nome);
        return sd;
    }

    /**
     * Busca um serviço disponível pelo seu ID.
     *
     * @param i : o ID do serviço a ser buscado
     * @return o serviço disponível encontrado, ou null se não encontrado
     */
    public ServicoDisponivel buscarServicoId(int i) {
        int id = i;
        ServicoDisponivel sd = new ServicoDisponivel();
        sd = new ServicoDisponivelDAO().buscarServicoId(id);
        return sd;
    }
}
