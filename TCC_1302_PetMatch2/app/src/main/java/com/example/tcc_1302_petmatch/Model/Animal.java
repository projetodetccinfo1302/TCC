package com.example.tcc_1302_petmatch.Model;

// IMPORTS RELACIONADOS AO ROOM
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// DECLARAÇÃO DA ENTIDADE ANIMAL
@Entity

// CLASSE ANIMAL
public class Animal {

    // A VARIÁVEL CÓDIGO É A PRIMARY KEY PARA FACILITAR BUSCAS NO BANCO DE DADOS
    @PrimaryKey (autoGenerate = true)
    private int codigo;

    // A VARIÁVEL MICROCHIP É O IDENTIFICADOR DELE NA PRÁTICA, FUNCIONANDO COMO UM CPF
    private int microchip;

    // VARIÁVEIS/ATRIBUTOS DA ENTIDADE ANIMAL
    private String nome;
    private String especie;
    private String raca;
    private String cor;
    private String sexo;
    private String porte;
    private String complicacao;
    private String estadoatual;
    private String castracao;
    private String vacinacao;
    private int idade;
    private String peso;

    // CONSTRUTOR DA CLASSE ANIMAL

    public Animal(String nome, String especie, String raca, String cor, String sexo, String porte, String complicacao, String s, int idade, String peso) {
        // ATRIBUIÇÃO DE VALORES
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.porte = porte;
        this.complicacao = complicacao;
        this.estadoatual = estadoatual;
        this.castracao = castracao;
        this.vacinacao = vacinacao;
        this.idade = idade;
        this.peso = peso;
    }

    // MÉTODOS GETTERS AND SETTERS PARA ACESSAR OS DADOS DA CLASSE USUÁRIO CLASSE ANIMAL
    // FORMA INLINE

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getMicrochip() {return microchip;}
    public void setMicrochip(int microchip) {this.microchip = microchip;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEspecie() {return especie;}
    public void setEspecie(String especie) {this.especie = especie;}
    public String getRaca() {return raca;}
    public void setRaca(String raca) {this.raca = raca;}
    public String getCor() {return cor;}
    public void setCor(String cor) {this.cor = cor;}
    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public String getPorte() {return porte;}
    public void setPorte(String porte) {this.porte = porte;}
    public String getComplicacao() {return complicacao;}
    public void setComplicacao(String complicacao) {this.complicacao = complicacao;}
    public String getEstadoatual() {return estadoatual;}
    public void setEstadoatual(String estadoatual) {this.estadoatual = estadoatual;}
    public String getCastracao() {return castracao;}
    public void setCastracao(String castracao) {this.castracao = castracao;}
    public String getVacinacao() {return vacinacao;}
    public void setVacinacao(String vacinacao) {this.vacinacao = vacinacao;}
    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}
    public String getPeso() {return peso;}
    public void setPeso(String peso) {this.peso = peso;}
}
