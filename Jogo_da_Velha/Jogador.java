package JogoDaVelha;

public class Jogador {
    private String nome;
    private int participacoes = 0, vitorias = 0, derrotas = 0, empates = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Jogador(String nome, int participacoes, int vitorias, int derrotas, int empates) {
        this.nome = nome;
        this.participacoes = participacoes;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public String getNome() {
        return nome;
    }

    public int getParticipacoes() {
        return participacoes;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParticipacoes(int participacoes) {
        this.participacoes = participacoes;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
}
