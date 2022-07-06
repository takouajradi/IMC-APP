package Outils;
package com.example.emds.myapplication.outils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    Private String creation =”create table profil(“
      +”dateMesure TEXT PRIMARY KEY,”+”poids INTEGER NOT NULL,”
      +”taille INTEGER NOT NULL,”
      +”age INTEGER NOT NULL,”
      +”sexe INTEGER NOT NULL);”;
      public MySQLiteOpenHelper

    @Override
    public void oncreate(SQLiteDatabase sqLiteDatabase){

    }
    public void onUpdate(SQLiteDatabase sqLiteDatabase, int i, int il){

    }
}

