/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokovnikapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Срђан
 */
public class SokovnikApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sokovnik sokovnik = Sokovnik.getSokovnik();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sokovnikLog.txt"))) {

            // 100 ciklusa cedjenja soka
            for (int i = 0; i < 100; i++) {

                // Dodavanje 25 jabuka u sokovnik
                for (int j = 0; j < 25; i++) {
                    //Verovatnoca dodavanja jabuke 70%
                    if (Math.random() <= 0.7) {
                        Voce jabuka = new Jabuka();
                        sokovnik.dodajVoce(jabuka);
                        bw.write("\nU sokovnik je dodata " + jabuka.toString() + "\n");
                    }
                }
                //Verovatnoca cedjenja soka 30%
                if (Math.random() <= 0.3) {
                    bw.write("\nIscedjeno je " + sokovnik.cediSok() + " soka\n");

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
