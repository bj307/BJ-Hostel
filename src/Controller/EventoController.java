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
 *
 * @author 2020101202010138
 */
public class EventoController {
    
    public void cadastrar(CadEvento cEvent) {
        Evento e = new Evento();
        EventoDAO eDao = new EventoDAO();
        
        e.setNomeEvento(cEvent.inputNome.getText());
        e.setLocalEvento(cEvent.inputLocal.getText());
        e.setData(cEvent.inputData.getText());
        e.setCapacidadeEvento(Integer.parseInt(cEvent.inputCapacidade.getText()));
        
        eDao.cadastrarEvento(e);
    }
    
    public List<Evento> listar() {
        EventoDAO eDao = new EventoDAO();
        List<Evento> lista = eDao.listarEvento();
        return lista;
    }
    
    public List<Evento> listarSH(int i) {
        int id = i;
        EventoDAO eDao = new EventoDAO();
        List<Evento> lista = eDao.listarEventoSH(id);
        return lista;
    }
    
    public int buscarParticipantes(int i) {
        int id = i;
        int numPessoas;
        EventoDAO eDao = new EventoDAO();
        numPessoas = eDao.buscarPessoasEvento(id);
        return numPessoas;
    }
    
    public Evento buscarPorNome(String n) {
        String nome = n;
        EventoDAO eDao = new EventoDAO();
        Evento e = eDao.buscarPorNome(nome);
        return e;
    }
    
    public void addEventoHosp(AddEvento add) {
        EventoDAO eDao = new EventoDAO();
        Evento e = add.getEvent();
        Hospedagem h = add.getHosp();
        int num = Integer.parseInt(add.inputQtd.getText());
        eDao.addEventoHosp(e, h, num);
    }
}
