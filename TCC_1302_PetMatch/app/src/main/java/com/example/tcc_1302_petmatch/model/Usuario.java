// PACOTE DO PROJETO
package com.example.tcc_1302_petmatch.model;

// BIBLIOTECAS USADAS
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// DECLARAÇÃO DA ENTIDADE USUÁRIO
@Entity (tableName = "Usuario")
public class Usuario {

    // UTILIZANDO O MODIFICADOR DE ACESSO "PBULIC" POR QUESTÕES DE ACESSIBILIDADE

    // PRIMARY KEY
    @PrimaryKey(autoGenerate = true)
    public long CODIGO;

    public String NOME;
    public String SOBRENOME;
    public String CPF;
    public String CEP;
    public int IDADEUSUARIO;
    public String EMAIL;
    public String TELEFONE;

    // CONSTRUTOR DA CLASSE USUÁRIO
    public Usuario(String NOME, String SOBRENOME, String CPF, String CEP, int IDADEUSUARIO, String EMAIL, String TELEFONE) {
        this.NOME = NOME;
        this.SOBRENOME = SOBRENOME;
        this.CPF = CPF;
        this.CEP = CEP;
        this.IDADEUSUARIO = IDADEUSUARIO;
        this.EMAIL = EMAIL;
        this.TELEFONE = TELEFONE;
    }
    // MÉTODOS GETTERS AND SETTERS DA CLASSE USUÁRIO (NA FORMA INLINE)

    public long getCODIGO() {return CODIGO;}
    public void setCODIGO(int CODIGO) {this.CODIGO = CODIGO;}

    public String getNOME() {return NOME;}
    public void setNOME(String NOME) {this.NOME = NOME;}

    public String getSOBRENOME() {return SOBRENOME;}
    public void setSOBRENOME(String SOBRENOME) {this.SOBRENOME = SOBRENOME;}

    public String getCPF() {return CPF;}
    public void setCPF(String CPF) {this.CPF = CPF;}

    public String getCEP() {return CEP;}
    public void setCEP(String CEP) {this.CEP = CEP;}

    public int getIDADE() {return IDADEUSUARIO;}
    public void setIDADE(int IDADE) {this.IDADEUSUARIO = IDADE;}

    public String getEMAIL() {return EMAIL;}
    public void setEMAIL(String EMAIL) {this.EMAIL = EMAIL;}

    public String getTELEFONE() {return TELEFONE;}
    public void setTELEFONE(String TELEFONE) {this.TELEFONE = TELEFONE;}



}