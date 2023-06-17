/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kaior
 */
public class Servico {
    
    private int id;
    private ServicoDisponivel servicoDisponivel;
    private String data;
    private int quantidade;
    private double preco;
    private String status;

    public Servico() {
    }

    public Servico(int id, ServicoDisponivel servicoDisponivel, String data, int quantidade, double preco, String status) {
        this.id = id;
        this.servicoDisponivel = servicoDisponivel;
        this.data = data;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServicoDisponivel getServicoDisponivel() {
        return servicoDisponivel;
    }

    public void setServicoDisponivel(ServicoDisponivel servicoDisponivel) {
        this.servicoDisponivel = servicoDisponivel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
