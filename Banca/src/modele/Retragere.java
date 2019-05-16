/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Retragere {
    public Integer numar_cont;
    public double suma;
    public Date data;
    
    public Retragere(Integer numar_cont, double suma, Date data) {
        this.numar_cont = numar_cont;
        this.suma = suma;
        this.data = data;
    }

    public Integer getNumar_cont() {
        return numar_cont;
    }

    public void setNumar_cont(Integer numar_cont) {
        this.numar_cont = numar_cont;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}


