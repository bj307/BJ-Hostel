/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.Dashboard;

/**
 *
 * @author kaior
 */
public class Funcionario extends Pessoa {

    private String cep;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(int rg, String senha, String cargo, String cep, String endereco, String complemento, String cidade, String estado, String nome, String cpf, String email, String celular) {
        super(nome, cpf, email, celular, rg, senha);
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cargo = cargo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return cargo;
    }

    public void setTipo(String tipo) {
        this.cargo = tipo;
    }

    @Override
    public void login(String tipo) {
        super.login(tipo);
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        if (tipo.equals("ADM")) {
            dashboard.verificaAdm(true);
        } else {
            dashboard.verificaAdm(false);
        }
    }

}
