/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EventoDAO;
import java.util.List;
import model.Evento;
import model.Hospedagem;
import view.AddEvento;
import view.CadEvento;

/**
 * Classe responsável por controlar as operações relacionadas aos eventos.
 *
 * @author 2020101202010138
 */
public class EventoController {

    /**
     * Cadastra um novo evento.
     *
     * @param cEvent : o objeto CadEvento é a tela de cadastro de eventos
     * contendo os dados do evento a ser cadastrado
     */
    public void cadastrarEvento(CadEvento cEvent) {
        Evento e = new Evento();
        EventoDAO eDao = new EventoDAO();

        e.setNomeEvento(cEvent.inputNome.getText());
        e.setLocalEvento(cEvent.inputLocal.getText());
        e.setData(cEvent.inputData.getText());
        e.setCapacidadeEvento(Integer.parseInt(cEvent.inputCapacidade.getText()));

        eDao.cadastrarEvento(e);
    }

    /**
     * Lista todos os eventos cadastrados.
     *
     * @return uma lista contendo todos os eventos cadastrados
     */
    public List<Evento> listarEvento() {
        EventoDAO eDao = new EventoDAO();
        List<Evento> lista = eDao.listarEvento();
        return lista;
    }

    /**
     * Lista os eventos associados a uma hospedagem específica.
     *
     * @param i : o ID da hospedagem
     * @return uma lista contendo os eventos associados à hospedagem
     * especificada
     */
    public List<Evento> listarEventoHosp(int i) {
        int id = i;
        EventoDAO eDao = new EventoDAO();
        List<Evento> lista = eDao.listarEventoHosp(id);
        return lista;
    }

    /**
     * Busca a quantidade de pessoas de uma hospedagem que participaram do
     * evento.
     *
     * @param i : o ID do evento
     * @return o número de participantes do evento especificado
     */
    public int buscarParticipantes(int i) {
        int id = i;
        int numPessoas;
        EventoDAO eDao = new EventoDAO();
        numPessoas = eDao.buscarParticipantes(id);
        return numPessoas;
    }

    /**
     * Busca um evento pelo nome.
     *
     * @param n : o nome do evento a ser buscado
     * @return o objeto Evento correspondente ao nome especificado, ou null se
     * não for encontrado
     */
    public Evento buscarPorNome(String n) {
        String nome = n;
        EventoDAO eDao = new EventoDAO();
        Evento e = eDao.buscarPorNome(nome);
        return e;
    }

    /**
     * Adiciona um evento a uma hospedagem.
     *
     * @param add : o objeto AddEvento é a tela que contem o evento e a
     * hospedagem a serem associados
     */
    public void addEventoHosp(AddEvento add) {
        EventoDAO eDao = new EventoDAO();
        Evento e = add.getEvent();
        Hospedagem h = add.getHosp();
        int num = Integer.parseInt(add.inputQtd.getText());
        eDao.addEventoHosp(e, h, num);
    }
}
