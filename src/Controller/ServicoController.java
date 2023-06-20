/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ServicoDAO;
import DAO.ServicoDisponivelDAO;
import java.util.List;
import model.Cliente;
import model.Hospedagem;
import model.Servico;
import model.ServicoDisponivel;
import view.CadServico;

/**
 * Classe responsável por controlar as operações relacionadas aos serviços.
 *
 * @author kaior
 */
public class ServicoController {

    /**
     * Cadastra um novo serviço.
     *
     * @param cServico : é o formulário de cadastro de serviço
     */
    public void cadastrarServico(CadServico cServico) {
        Servico s = new Servico();
        Hospedagem h;
        h = cServico.getHosp();
        ServicoDAO sDao = new ServicoDAO();
        ServicoDisponivel sd;
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        sd = sdDao.buscarServicoNome(cServico.boxServicos.getSelectedItem().toString());
        int qtd = Integer.parseInt(cServico.inputQtd.getText());
        s.setServicoDisponivel(sd);
        s.setQuantidade(qtd);
        s.setData(cServico.inputData.getText());
        s.setStatus("Aberto");
        s.setPreco(sd.getPreco() * qtd);
        h.setTotal(h.getTotal() + s.getPreco());
        sDao.cadastrarServico(s, h);
    }

    /**
     * Retorna a lista de todos os serviços.
     *
     * @return a lista de serviços
     */
    public List<Servico> listarTodosServicos() {
        ServicoDAO sDao = new ServicoDAO();
        List<Servico> lista = sDao.listarTodosServicos();
        return lista;
    }

    /**
     * Retorna a lista de serviços de uma hospedagem específica.
     *
     * @param i : o ID da hospedagem
     * @return a lista de serviços da hospedagem
     */
    public List<Servico> listarServicosHospedagem(int i) {
        int id = i;
        ServicoDAO sDao = new ServicoDAO();
        List<Servico> lista = sDao.listarServicosHospedagem(id);
        return lista;
    }

    /**
     * Busca um serviço pelo seu ID.
     *
     * @param i : o ID do serviço a ser buscado
     * @return o serviço encontrado, ou null se não encontrado
     */
    public Servico buscarServicoId(int i) {
        int id = i;
        Servico s;
        ServicoDAO sDao = new ServicoDAO();
        s = sDao.buscarServicoId(id);
        return s;
    }

    /**
     * Busca o cliente associado a um serviço de hospedagem pelo ID do serviço.
     *
     * @param i : o ID do serviço
     * @return o cliente associado ao serviço, ou null se não encontrado
     */
    public Cliente buscarServHospId(int i) {
        int id = i;
        Cliente c;
        ServicoDAO sDao = new ServicoDAO();
        c = sDao.buscarServHospId(id);
        return c;
    }

    /**
     * Atualiza os dados de um serviço.
     *
     * @param serv : o serviço a ser atualizado
     */
    public void atualizaServico(Servico serv) {
        Servico s = serv;
        ServicoDAO sDao = new ServicoDAO();
        sDao.atualizaServico(s);
    }
}
