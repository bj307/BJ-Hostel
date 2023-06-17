/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author kaior
 */
public class Hospedagem {
    
    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private Date checkin;
    private Date checkout;
    private int nHospedes;
    private String placa;
    private double total;

    public Hospedagem() {
    }

    public Hospedagem(int id, Cliente cliente, Quarto quarto, Date checkin, Date checkout, int nHospedes, String placa, double total) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.nHospedes = nHospedes;
        this.placa = placa;
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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getnHospedes() {
        return nHospedes;
    }

    public void setnHospedes(int nHospedes) {
        this.nHospedes = nHospedes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
