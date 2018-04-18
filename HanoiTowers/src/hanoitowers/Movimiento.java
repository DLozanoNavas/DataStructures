/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitowers;

/**
 *
 * @author dlozanonavas
 */
public class Movimiento {

    private int ficha;
    private int torreOrigen;
    private int torreDestino;

    public Movimiento(int ficha, int torreOrigen, int torreDestino) {
        this.ficha = ficha;
        this.torreOrigen = torreOrigen;
        this.torreDestino = torreDestino;
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public int getTorreDestino() {
        return torreDestino;
    }

    public void setTorreDestino(int torreDestino) {
        this.torreDestino = torreDestino;
    }

    public int getTorreOrigen() {
        return torreOrigen;
    }

    public void setTorreOrigen(int torreOrigen) {
        this.torreOrigen = torreOrigen;
    }
}

