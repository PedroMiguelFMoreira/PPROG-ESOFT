/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cumprimentar;

/**
 *
 * @author Pedro
 */
public class Pessoa {
    
    private String nome;
    private int idade;
    
    public Pessoa() {
        this.nome = "Sem nome";
        this.idade = 0;
    }
    
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
    }
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
    
    public int getIdade(int novaIdade) {
        return this.idade;
    }
    
    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }
    
    @Override
    public String toString() {
        return "O nome é " + this.nome + " e essa pessoa tem " + this.idade + " anos.";
    }
}
