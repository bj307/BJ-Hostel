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
 *
 * @author kaior
 */
public class QuartoController {

    public void cadastrar(CadQuarto cQuarto) {
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

    public List<Quarto> listaDesocupado() {
        QuartoDAO qDao = new QuartoDAO();
        List<Quarto> lista = qDao.listarQuartoDisponivel();
        return lista;
    }
    
    public Quarto buscaQuartoNome(String n) {
        String nome = n;
        QuartoDAO qdao = new QuartoDAO();
        Quarto q;
        q = qdao.buscarQuartoNome(nome);
        return q;
    }
    
    public void atualizar(Quarto qt){
        Quarto q = qt;
        QuartoDAO qDao = new QuartoDAO();
        qDao.atualizarQuarto(q);
    }
}
