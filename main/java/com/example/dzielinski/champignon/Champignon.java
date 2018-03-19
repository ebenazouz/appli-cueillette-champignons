package com.example.dzielinski.champignon;

import java.util.ArrayList;

/**
 * Created by dzielinski on 19/03/18.
 */

public class Champignon {

    public String nom;
    public String nomScientifique;
    public ArrayList<String> chapeau;
    public ArrayList<String> marge;
    public ArrayList<String> pied;
    public String lame;
    public ArrayList<String> couleurChapeau;
    public ArrayList<String> couleurHymenium;
    public ArrayList<String> couleurDuPied;
    public String comestibilite;


    public Champignon() {
        chapeau = new ArrayList<>();
        marge = new ArrayList<>();
        pied = new ArrayList<>();
        couleurChapeau = new ArrayList<>();
        couleurHymenium = new ArrayList<>();
        couleurDuPied = new ArrayList<>();
    }
}
