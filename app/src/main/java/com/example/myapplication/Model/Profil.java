package com.example.myapplication.Model;
import java.util.Date;

public class Profil {
    //constantes
    private static final Integer minFemme = 15; //maigre si en dessous
    private static final Integer maxFemme = 30; //gros si en dessus
    private static final Integer minHomme = 10; //maigre si en dessous
    private static final Integer maxHomme = 25; //gros si en dessus
    //propriétés
    private Integer poids;
    private Date dateMesure
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.dateMesure = dateMesure;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMC();
        this.resultIMC();
    }
    public Integer getPoids() {
        return poids;
    }
    public Integer getTaille() {
        return taille;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getSexe() {
        return sexe;
    }
    public float getImg() {
        return img;
    }
    public String getMessage() {
        return message;
    }
    public Date getDateMesure() {
        return dateMesure;
    }

    private void calculIMC(){
        float tailleM = ((float)taille)/100;
        this.img = (float)((1.2*poids/(tailleM*tailleM))+(0.23*age)-(10.83*sexe)- 5.4);
    }
    private void resultIMC(){
        Integer min;
        Integer max;
        if (sexe==0){ //Femme
            min = minFemme;
            max = maxFemme;
        }else { //Homme
            min = minHomme;
            max = maxHomme;
        }
//message correspondant
        message = "normal";
        if (img<min){
            message="trop faible";

        }else{
            if (img>max){
                message = "trop élevé";
            }
        }
    }
}


