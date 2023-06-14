/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kaior
 */
public class Funcionario extends Pessoa {
    
    private int rg;
    private String senha;
    private String cargo;
    private String acesso;
    private String cep;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;

    public Funcionario(String kaio, int par, String string, String kaiofuncionariocom, String senha1, String adm, String _92752317, String string1, String rua_São_Paulo, String if_Goiano, String urutaí, String go) {
    }

    public Funcionario(int rg, String senha, String cargo, String acesso, String cep, String endereco, String complemento, String cidade, String estado, String nome, String cpf, String email, String celular) {
        super(nome, cpf, email, celular);
        this.rg = rg;
        this.senha = senha;
        this.cargo = cargo;
        this.acesso = acesso;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Funcionario() {
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
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
    
    
    
}
