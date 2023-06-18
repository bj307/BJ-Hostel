/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kaior
 */
public class Fatura {
    
    private int id;
    private Cliente cliente;
    private Hospedagem hospedagem;
    private double total;

    public Fatura() {
    }

    public Fatura(int id, Cliente cliente, Hospedagem hospedagem, double total) {
        this.id = id;
        this.cliente = cliente;
        this.hospedagem = hospedagem;
        this.total = total;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Fatura{" + "id=" + id + ", cliente=" + cliente.getNome() + ", hospedagem=" + hospedagem.getId() + ", total=" + total + '}';
    }

}
