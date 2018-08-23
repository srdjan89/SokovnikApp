/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokovnikapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Срђан
 */
public class Sokovnik {

    private static Sokovnik instanca = null;

    private List<Voce> posudaZaVoce;

    private Sokovnik() {

        posudaZaVoce = new ArrayList<>();
    }

    public static Sokovnik getSokovnik() {

        if (instanca == null) {
            instanca = new Sokovnik();
        }

        return instanca;
    }

    public void kapacitetPosude() {

        System.out.println("U posudi za voce ima " + this.posudaZaVoce.size() + " komada voca. Ima mesta za jos " + (15 - this.posudaZaVoce.size()) + ".");

    }

    public void kapacitetSokovnika() {
        double kapacitet = 0;
        for (int i = 0; i < this.posudaZaVoce.size(); i++) {
            kapacitet += this.posudaZaVoce.get(i).getTezina();
        }
        try {
            if (kapacitet > 30) {
                throw new PremasenKapacitetException("Sokovnik je pun! Premasili ste kapacitet!");
            }
        } catch (PremasenKapacitetException premasenKapacitet) {

            premasenKapacitet.printStackTrace();
        }

    }

    public void dodajVoce(Voce vocka) {

        if (this.posudaZaVoce.size() < 15 && vocka.isNijeTrula()) {
            this.posudaZaVoce.add(vocka);
            System.out.println("Dodali ste " + vocka.toString() + " u sokovnik.");
            kapacitetSokovnika();
        }
    }

    public double cediSok() {

        double iscedjeniSok = 0;

        for (Voce voce : this.posudaZaVoce) {

            iscedjeniSok += voce.getTezina() * 0.4;

        }
        System.out.println("Ukupno je iscedjeno " + iscedjeniSok);
        return iscedjeniSok;
    }

}
