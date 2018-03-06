package sistema;

import java.io.Serializable;

public class Cavalo extends Mamifero implements Serializable{
    private String corPelo;
    private String raçaCavalo;

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

    public String getRaçaCavalo() {
        return raçaCavalo;
    }

    public void setRaçaCavalo(String raçaCavalo) {
        this.raçaCavalo = raçaCavalo;
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

    public Cavalo(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

    
        
}
