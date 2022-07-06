package com.example.myapplication.Controleur;
import com.example.myapplication.Model.Profil;

import java.util.Date;

public final classControle {
        private static Controle instance=null;
        private Profil profil;
        private Controle(){
            super();
        }
        public static final Controle getInstance(){
            if (Controle.instance == null){
                Controle.instance = new Controle();
            }
            return Controle.instance;
        }

        public void creerProfil(Integer poids, Integer taille, Integer
                age, Integer sexe){
            profil = new Profil(poids, taille, age, sexe);
        }
        public float getImg(){
            return profil.getImg();
        }
        public String getMessage(){
            return profil.getMessage();
        }
    }
