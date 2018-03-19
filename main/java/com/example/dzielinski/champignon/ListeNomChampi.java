package com.example.dzielinski.champignon;

import org.jdom2.Document;
import org.jdom2.Element;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzielinski on 15/03/18.
 */

public class ListeNomChampi {


    private ArrayList<String> listeNom;

    public ListeNomChampi(ArrayList<Champignon> listeChampi) {
        listeNom = new ArrayList<>();
        for(Champignon c : listeChampi) {
            listeNom.add(c.nom);
        }
    }

    public void afficher() {
        for(String l : listeNom) {
            System.out.println(l);
        }
        System.out.println(listeNom.size());
    }

    public String getIndex(int i) {
        return listeNom.get(i);
    }

    public ArrayList<String> get() {
        return listeNom;
    }
}