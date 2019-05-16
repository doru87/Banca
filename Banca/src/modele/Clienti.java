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
public class Clienti {
    Integer numar_cont;
    String nume;
    String adresa;
    String tip_cont;
    String sex;
    Date data_nasterii;
    String parola;

    public Integer getNumar_cont() {
        return numar_cont;
    }

    public void setNumar_cont(Integer numar_cont) {
        this.numar_cont = numar_cont;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTip_cont() {
        return tip_cont;
    }

    public void setTip_cont(String tip_cont) {
        this.tip_cont = tip_cont;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    
    
}
