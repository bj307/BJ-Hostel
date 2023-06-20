/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.QuartoDAO;
import java.util.List;
import model.Quarto;
import view.CadQuarto;

/**
 * Classe responsável por controlar as operações relacionadas aos quartos.
 *
 * @author kaior
 */
public class QuartoController {

    /**
     * Cadastra um novo quarto.
     *
     * @param cQuarto : é o formulário de cadastro de quarto
     */
    public void cadastrarQuarto(CadQuarto cQuarto) {
        Quarto q = new Quarto();
        QuartoDAO qDao = new QuartoDAO();

        q.setTipo(cQuarto.boxTipo.getSelectedItem().toString());
        q.setCamas(Integer.parseInt(cQuarto.inputCama.getText()));
        q.setDescricao(cQuarto.inputDetalhe.getText());
        q.setPreco(Double.parseDouble(cQuarto.inputPreco.getValue().toString()));
        q.setTamanho(Integer.parseInt(cQuarto.inputTam.getText()));
        q.setStatus("desocupado");

        qDao.cadastrarQuarto(q);
    }

    /**
     * Retorna a lista de todos os quartos.
     *
     * @return a lista de quartos
     */
    public List<Quarto> listarQuarto() {
        QuartoDAO qDao = new QuartoDAO();
        List<Quarto> lista = qDao.listarQuarto();
        return lista;
    }

    /**
     * Retorna a lista de quartos disponíveis.
     *
     * @return a lista de quartos disponíveis
     */
    public List<Quarto> listarQuartoDisponivel() {
        QuartoDAO qDao = new QuartoDAO();
        List<Quarto> lista = qDao.listarQuartoDisponivel();
        return lista;
    }

    /**
     * Busca um quarto pelo seu ID.
     *
     * @param i : o ID do quarto a ser buscado
     * @return o quarto encontrado, ou null se não encontrado
     */
    public Quarto buscarQuartoId(int i) {
        int id = i;
        QuartoDAO qdao = new QuartoDAO();
        Quarto q;
        q = qdao.buscarQuartoId(id);
        return q;
    }

    /**
     * Busca um quarto pelo seu nome.
     *
     * @param n : o nome do quarto a ser buscado
     * @return o quarto encontrado, ou null se não encontrado
     */
    public Quarto buscaQuartoNome(String n) {
        String nome = n;
        QuartoDAO qdao = new QuartoDAO();
        Quarto q;
        q = qdao.buscarQuartoNome(nome);
        return q;
    }

    /**
     * Atualiza os dados de um quarto.
     *
     * @param qt o quarto a ser atualizado
     */
    public void atualizarQuarto(Quarto qt) {
        Quarto q = qt;
        QuartoDAO qDao = new QuartoDAO();
        qDao.atualizarQuarto(q);
    }
}
