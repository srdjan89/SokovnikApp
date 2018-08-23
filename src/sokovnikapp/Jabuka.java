/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokovnikapp;

import java.util.Random;

/**
 *
 * @author Срђан
 */
public final class Jabuka implements Voce {

    private final String sorta;
    private final double tezina;
    private final boolean nijeTrula;

    public Jabuka() {
        this.sorta = odrediSortu();
        this.tezina = odrediTezinu();
        this.nijeTrula = odrediSvezinu();
    }

    private String odrediSortu() {

        String[] sorte = {"Zlatni Delišes", "Ajdared", "Greni Smit", "Budimka", "Kolačara"};

        int random = new Random().nextInt(sorte.length);
        return sorte[random];
    }

    @Override
    public double odrediTezinu() {
        Random r = new Random();
        double random = 0.1 + (3.0 - 0.1) * r.nextDouble();
        return random;
    }

    @Override
    public boolean odrediSvezinu() {
        return Math.random() <= 0.8;
    }

    @Override
    public String toString() {
        return "Jabuka{" + "sorta=" + sorta + ", tezina=" + tezina + ", nijeTrula=" + nijeTrula + '}';
    }

    public String getSorta() {
        return sorta;
    }

    @Override
    public double getTezina() {
        return tezina;
    }

    @Override
    public boolean isNijeTrula() {
        return nijeTrula;
    }

}
