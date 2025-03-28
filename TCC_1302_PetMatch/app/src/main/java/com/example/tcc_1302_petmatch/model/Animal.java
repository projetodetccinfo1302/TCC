package com.example.tcc_1302_petmatch.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    // PRIMARY KEY
    @PrimaryKey (autoGenerate = true)
    public int MICROCHIP;
    public String NOMEANIMAL;
    public String ESPECIE;
    public String RACA;
    public String SEXO;
    public String VACINACAO;
    public String CASTRACAO;
    public String COR;
    public String IDADEANIMAL;
    public String PESO;
    public String COMPLICACAO;

    public Animal(String NOMEANIMAL, String ESPECIE, String RACA, String SEXO, String VACINACAO, String CASTRACAO, String COR, String IDADEANIMAL, String PESO, String COMPLICACAO) {
        this.NOMEANIMAL = NOMEANIMAL;
        this.ESPECIE = ESPECIE;
        this.RACA = RACA;
        this.SEXO = SEXO;
        this.VACINACAO = VACINACAO;
        this.CASTRACAO = CASTRACAO;
        this.COR = COR;
        this.IDADEANIMAL = IDADEANIMAL;
        this.PESO = PESO;
        this.COMPLICACAO = COMPLICACAO;
    }
    public String getNOMEANIMAL() {return NOMEANIMAL;}
    public void setNOMEANIMAL(String NOMEANIMAL) {this.NOMEANIMAL = NOMEANIMAL;}

    public String getESPECIE() {return ESPECIE;}
    public void setESPECIE(String ESPECIE) {this.ESPECIE = ESPECIE;}

    public String getRACA() {return RACA;}
    public void setRACA(String RACA) {this.RACA = RACA;}

    public String getSEXO() {return SEXO;}

    public void setSEXO(String SEXO) {this.SEXO = SEXO;}

    public String getVACINACAO() {return VACINACAO;}
    public void setVACINACAO(String VACINACAO) {this.VACINACAO = VACINACAO;}

    public String getCASTRACAO() {return CASTRACAO;}
    public void setCASTRACAO(String CASTRACAO) {this.CASTRACAO = CASTRACAO;}

    public String getCOR() {return COR;}
    public void setCOR(String COR) {this.COR = COR;}

    public String getIDADEANIMAL() {return IDADEANIMAL;}
    public void setIDADEANIMAL(String IDADEANIMAL) {this.IDADEANIMAL = IDADEANIMAL;}

    public String getPESO() {return PESO;}

    public void setPESO(String PESO) {this.PESO = PESO;}

    public String getCOMPLICACAO() {return COMPLICACAO;}

    public void setCOMPLICACAO(String COMPLICACAO) {this.COMPLICACAO = COMPLICACAO;}

}
