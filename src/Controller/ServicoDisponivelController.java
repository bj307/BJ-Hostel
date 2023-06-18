/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ServicoDisponivelDAO;
import java.util.List;
import model.ServicoDisponivel;

/**
 *
 * @author kaior
 */
public class ServicoDisponivelController {
    
    public void cadastrar(){
        
    }
    
    public List<ServicoDisponivel> listar() {
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        List<ServicoDisponivel> lista = sdDao.listarServico();
        return lista;
    }
}
