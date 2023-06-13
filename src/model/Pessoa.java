/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kaior
 */
public abstract class Pessoa {
    
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String celular;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String cpf, String email, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", celular=" + celular + '}';
    }
    
}
