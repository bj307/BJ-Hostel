/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kaior
 */
public class Cliente extends Pessoa {

    private int rg;
    private String cep;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String dataNasc;

    public Cliente() {
    }

    public Cliente(int rg, String cep, String endereco, String complemento, String cidade, String estado, String nome, String dataNasc, String cpf, String email, String celular) {
        super(nome, cpf, email, celular);
        this.rg = rg;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.dataNasc = dataNasc;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
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
    
    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }


    @Override
    public String toString() {
        return "Cliente{" + "id=" + getId() + ", nome=" + getNome() + ", dataNasc=" + dataNasc + ", rg=" + rg + ", cpf=" + getCpf() + ", email=" + getEmail() + ", celular=" + getCelular() + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + '}';
    }

}
