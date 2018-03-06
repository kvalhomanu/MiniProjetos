package sistema;

import java.io.Serializable;

public class Anfibios extends Animal implements Serializable{  

    public String getCorPele() {
        return corPele;
    }

    public void setCorPele(String corPele) {
        this.corPele = corPele;
    }

    public String getRespiracao() {
        return respiracao;
    }

    public void setRespiracao(String respiracao) {
        this.respiracao = respiracao;
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
    protected String corPele;
    protected String respiracao;

    public Anfibios(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

    
}
