

package com.example.myapplication.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Controleur.Controle;
import com.example.myapplication.R;

public class CalculActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.controle = Controle.getInstance();
        init();}
    //proprietés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private ImageView imgsmiley;
    private TextView lblIMG;
    private Controle controle;

    private void init(){
        txtPoids = (EditText)findViewById(R.id.txtPoids);
        txtTaille = (EditText)findViewById(R.id.txtTaille);
        txtAge = (EditText)findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView)findViewById(R.id.lblIMG);
        imgsmiley = (ImageView)findViewById(R.id.imgsmiley);
        ecouteCalcul();
    }
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                try{
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch(Exception e) {};
                if(rdHomme.isChecked()){
                    sexe = 1;
                }
                if(poids ==0|| taille==0|| age==0){
                    Toast.makeText(CalculActivity.this,"saisie incorrecte",Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(poids,taille,age,sexe);
                }
            }
        });
    }
    private void afficheResult(Integer poids, Integer taille , Integer age, Integer sexe){
        this.controle.creerProfil(poids, taille, age, sexe);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();
        if(message=="normal"){
            imgsmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }else{
            lblIMG.setTextColor(Color.RED);
            if(message=="trop faible"){
                imgsmiley.setImageResource(R.drawable.maigre);
            }else{
                imgsmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMG.setText(String.format("%.01f",img)+" : IMC "+message);




    }
}

