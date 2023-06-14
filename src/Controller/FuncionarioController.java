/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FuncionarioDAO;
import model.Funcionario;

/**
 *
 * @author kaior
 */
public class FuncionarioController {
    
    public void cadastra(){
        Funcionario f = new Funcionario();
        f.setNome("Kaio");
        f.setRg(1234567);
        f.setCpf("777.666.555-44");
        f.setEmail("kaio@funcionario.com");
        f.setSenha("senha");
        f.setCargo("ADM");
        f.setCelular("(64)9 9275-2317");
        f.setCep("75.790-000");
        f.setEndereco("Rua São Paulo");
        f.setComplemento("IF Goiano");
        f.setCidade("Urutaí");
        f.setEstado("GO");
        FuncionarioDAO fDao = new FuncionarioDAO();
        fDao.cadastrarFuncionario(f);
    }
}
