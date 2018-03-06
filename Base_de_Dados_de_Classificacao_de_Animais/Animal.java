package sistema;

import java.io.Serializable;

public abstract  class Animal implements Serializable{
   String nome;
   float peso;
   int idade;
   int tipoOrgao;

   

    public Animal(String nome, float peso, int idade, int membros) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.tipoOrgao = tipoOrgao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTipoOrgao() {
        return tipoOrgao;
    }

    public void setTipoOrgao(int tipoOrgao) {
        this.tipoOrgao = tipoOrgao;
    }

    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + ", peso=" + peso + ", idade=" + idade + ", tipoOrgao=" + tipoOrgao + '}';
    }
   
}
 
    
    

    
  
