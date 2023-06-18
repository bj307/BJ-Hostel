/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FaturaDAO;
import model.Fatura;
import model.Hospedagem;

/**
 *
 * @author kaior
 */
public class FaturaController {
    
    public void cadastrar(Hospedagem h) {
        Fatura f = new Fatura();
        FaturaDAO fDao = new FaturaDAO();
        f.setCliente(h.getCliente());
        f.setHospedagem(h);
        f.setTotal(h.getTotal());
        fDao.cadastrar(f);
    }
    
    public Fatura buscarId(int i) {
        int id = i;
        Fatura f = new FaturaDAO().buscarId(id);
        return f;
    }
}
