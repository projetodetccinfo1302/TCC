package com.example.tcc_1302_petmatch.Model;

// IMPORTS RELACIONADOS AO ROOM
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// DECLARAÇÃO DA ENTIDADE USUÁRIO
@Entity

public class Usuario {

    // PRIMARY KEY GERADA AUTOMATICAMENTE
    @PrimaryKey(autoGenerate = true) // A anotação @PrimaryKey indica que o campo 'codigo' é a chave primária da tabela.
    public int codigo; // Este campo será automaticamente gerado e incrementado pelo banco de dados.

    // VARIÁVEIS/ATRIBUTOS DA ENTIDADE USUÁRIO
    private String nome; // Nome do usuário
    private String sobrenome; // Sobrenome do usuário
    private String email; // E-mail do usuário
    private String senha; // Senha do usuário
    private String telefone; // Telefone do usuário
    private String cep; // CEP do usuário
    private String cpf; // CPF do usuário
    private int idade; // Idade do usuário
    private String tipo; // Tipo de usuário (por exemplo, "Adotante", "Doador", ou "Adotante e Doador")

    // CONSTRUTOR DA CLASSE USUÁRIO
    // O construtor é utilizado para criar um objeto Usuario com os dados informados.
    public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cep, String cpf, int idade, String tipo) {
        // ATRIBUIÇÃO DE VALORES aos atributos da classe
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

    // MÉTODOS GETTERS AND SETTERS PARA ACESSAR OS DADOS DA CLASSE USUÁRIO
    // FORMA INLINE

    // Metodo get para Nome
    public String getNome() { return nome; }

    //Metodo set para Nome
    public void setNome(String nome) { this.nome = nome; }

    //Metodo get para Sobrenome
    public String getSobrenome() { return sobrenome; }

    //Metodo set para Sobrenome
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    //Metodo get para Email
    public String getEmail() { return email; }

    //Metodo set para Email
    public void setEmail(String email) { this.email = email; }

    //Metodo get para senha
    public String getSenha() { return senha; }

    //Metodo set para Senha
    public void setSenha(String senha) { this.senha = senha; }

    //Metodo get para telefone
    public String getTelefone() { return telefone; }

    //Metodo set para telefone
    public void setTelefone(String telefone) { this.telefone = telefone; }

    //Metodo get para CEP
    public String getCep() { return cep; }

    //Metodo set para CEP
    public void setCep(String cep) { this.cep = cep; }

    //Metodo get para CPF
    public String getCpf() { return cpf; }

    //Metodo set para CPF
    public void setCpf(String cpf) { this.cpf = cpf; }

    //Metodo get para idade
    public int getIdade() { return idade; }

    //Metodo set para idade
    public void setIdade(int idade) { this.idade = idade; }

    //Metodo get para Tipo
    public String getTipo() { return tipo; }

    //Metodo set para tipo
    public void setTipo(String tipo) { this.tipo = tipo; }
}
