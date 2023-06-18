/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ServicoDisponivelDAO;
import java.util.List;
import model.ServicoDisponivel;
import view.CadServicoDisponivel;

/**
 *
 * @author kaior
 */
public class ServicoDisponivelController {
    
    public void cadastrar(CadServicoDisponivel csd){
        ServicoDisponivel sd = new ServicoDisponivel();
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        sd.setNome(csd.inputNome.getText());
        sd.setPreco(Double.parseDouble(csd.inputPreco.getValue().toString()));
        sdDao.cadastrarServico(sd);
    }
    
    public List<ServicoDisponivel> listar() {
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        List<ServicoDisponivel> lista = sdDao.listarServico();
        return lista;
    }
}
