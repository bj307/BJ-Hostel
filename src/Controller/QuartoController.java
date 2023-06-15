/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.QuartoDAO;
import model.Quarto;

/**
 *
 * @author kaior
 */
public class QuartoController {
    
    public void cadastrar() {
        Quarto q = new Quarto();
        QuartoDAO qDao = new QuartoDAO();
        
        q.setTipo(tipo);
        q.setCamas(0);
        q.setDescricao(descricao);
        q.setPreco(0);
        q.setTamanho(0);
        
        qDao.cadastrarQuarto(q);
    }
}
