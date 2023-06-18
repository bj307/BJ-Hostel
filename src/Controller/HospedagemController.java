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
 *
 * @author kaior
 */
public class HospedagemController {

    public void cadastrar(CadHospedagem cHospedagem) {
        Hospedagem h = new Hospedagem();
        HospedagemDAO hDao = new HospedagemDAO();

        Quarto q = new Quarto();
        QuartoDAO qDao = new QuartoDAO();
        q = qDao.buscarQuartoNome(cHospedagem.boxQuartos.getSelectedItem().toString());

        QuartoController qc = new QuartoController();
        q.setStatus("ocupado");
        qc.atualizar(q);

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

    public List<Hospedagem> listarHospedagem() {
        HospedagemDAO hDao = new HospedagemDAO();
        List<Hospedagem> lista = hDao.listarHospedagem();
        return lista;
    }

    public Hospedagem buscarId(int i) {
        int id = i;
        HospedagemDAO hDao = new HospedagemDAO();
        Hospedagem h;
        h = hDao.buscaHospedagemId(id);
        return h;
    }

    public void atualizar(Hospedagem hp) {
        Hospedagem h = hp;
        HospedagemDAO hDao = new HospedagemDAO();
        hDao.atualizarHospedagem(h);
    }
}
