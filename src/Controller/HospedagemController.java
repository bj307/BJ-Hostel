/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HospedagemDAO;
import DAO.QuartoDAO;
import java.util.Date;
import model.Hospedagem;
import model.Quarto;
import view.CadHospedagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas às hospedagens.
 *
 * @author kaior
 */
public class HospedagemController {

    /**
     * Cadastra uma nova hospedagem.
     *
     * @param cHospedagem : é o formulário de cadastro de hospedagem
     */
    public void cadastrarHospedagem(CadHospedagem cHospedagem) {
        Hospedagem h = new Hospedagem();
        HospedagemDAO hDao = new HospedagemDAO();

        Quarto q = new Quarto();
        QuartoDAO qDao = new QuartoDAO();
        q = qDao.buscarQuartoNome(cHospedagem.boxQuartos.getSelectedItem().toString());

        QuartoController qc = new QuartoController();
        q.setStatus("ocupado");
        qc.atualizarQuarto(q);

        String d = cHospedagem.inputCheckin.getText();
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        try {
            Date date = formataData.parse(d);
            data = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        h.setQuarto(q);
        h.setCheckin(data);
        h.setCheckout(null);
        h.setnHospedes(Integer.parseInt(cHospedagem.inputHospedes.getText()));
        h.setPlaca(cHospedagem.inputPlaca.getText());
        h.setTotal(Double.parseDouble(cHospedagem.inputValor.getText()));
        h.setCliente(cHospedagem.getCliente());

        hDao.cadastrarHospedagem(h);
    }

    /**
     * Retorna a lista de todas as hospedagens.
     *
     * @return a lista de hospedagens
     */
    public List<Hospedagem> listarHospedagem() {
        HospedagemDAO hDao = new HospedagemDAO();
        List<Hospedagem> lista = hDao.listarHospedagem();
        return lista;
    }

    /**
     * Busca uma hospedagem pelo seu ID.
     *
     * @param i : o ID da hospedagem a ser buscada
     * @return a hospedagem encontrada, ou null se não encontrada
     */
    public Hospedagem buscaHospedagemId(int i) {
        int id = i;
        HospedagemDAO hDao = new HospedagemDAO();
        Hospedagem h;
        h = hDao.buscaHospedagemId(id);
        return h;
    }

    /**
     * Atualiza os dados de uma hospedagem.
     *
     * @param hp : a hospedagem a ser atualizada
     */
    public void atualizarHospedagem(Hospedagem hp) {
        Hospedagem h = hp;
        HospedagemDAO hDao = new HospedagemDAO();
        hDao.atualizarHospedagem(h);
    }
}
