/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author 2020101202010138
 */
public class Evento {
    
    private String nomeEvento;
    private String data;
    private String localEvento;
    private int capacidadeEvento;

    public Evento() {
    }

    public Evento(String nomeEvento, String data, String localEvento, int capacidadeEvento) {
        this.nomeEvento = nomeEvento;
        this.data = data;
        this.localEvento = localEvento;
        this.capacidadeEvento = capacidadeEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public int getCapacidadeEvento() {
        return capacidadeEvento;
    }

    public void setCapacidadeEvento(int capacidadeEvento) {
        this.capacidadeEvento = capacidadeEvento;
    }
    
}
