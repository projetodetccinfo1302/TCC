package com.example.tcc_1302_petmatch.Model;

// IMPORTS RELACIONADOS AO ROOM
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// DECLARAÇÃO DA ENTIDADE USUÁRIO
@Entity

// CLASSE USUÁRIO
public class Usuario {

    // PRIMARY KEY GERADA AUTOMATICAMENTE
    @PrimaryKey (autoGenerate = true)
    public int codigo;

    // VARIÁVEIS/ATRIBUTOS DA ENTIDADE USUÁRIO
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String telefone;
    private String cep;
    private String cpf;
    private int idade;
    private String tipo;

    // CONSTRUTOR DA CLASSE USUÁRIO
    public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cep, String cpf, int idade, String tipo) {
        // ATRIBUIÇÃO DE VALORES
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cep = cep;
        this.cpf = cpf;
        this.idade = idade;
        this.tipo = tipo;
    }

    // MÉTODOS GETTERS AND SETTERS PARA ACESSAR OS DADOS DA CLASSE USUÁRIO CLASSE USUÁRIO
    // FORMA INLINE

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getSobrenome() {return sobrenome;}
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
}
