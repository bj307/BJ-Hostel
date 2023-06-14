/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EventoDAO;
import model.Evento;
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
}
