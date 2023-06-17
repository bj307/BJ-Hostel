/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ServicoDAO;
import DAO.ServicoDisponivelDAO;
import java.util.List;
import model.Hospedagem;
import model.Servico;
import model.ServicoDisponivel;
import view.CadServico;

/**
 *
 * @author kaior
 */
public class ServicoController {
    
    public void cadastrar(CadServico cServico){
        Servico s = new Servico();
        Hospedagem h;
        h = cServico.getHosp();
        ServicoDAO sDao = new ServicoDAO();
        ServicoDisponivel sd;
        ServicoDisponivelDAO sdDao = new ServicoDisponivelDAO();
        sd = sdDao.buscarServicoNome(cServico.boxServicos.getSelectedItem().toString());
        int qtd = Integer.parseInt(cServico.inputQtd.getText());
        s.setServicoDisponivel(sd);
        s.setQuantidade(qtd);
        s.setData(cServico.inputData.getText());
        s.setStatus("Aberto");
        s.setPreco(sd.getPreco() * qtd);
        
        sDao.cadastrarServico(s, h);
    }
    
    public List<Servico> listar() {
        ServicoDAO sDao = new ServicoDAO();
        List<Servico> lista = sDao.listarServico();
        return lista;
    }
}
