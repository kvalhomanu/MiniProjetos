package JogoDaVelha;

import java.util.ArrayList;

public class Jogo {
    private ArrayList<Jogador> jogadores = new ArrayList<>(); // Lista para os jogadores
    private String [][] tabuleiro = new String[3][3]; // Cria Matriz 3x3
    private Jogador [] jogadoresPartida = new Jogador[2]; // Coloca os dois jogadores da partida
    private int vez = 0; // Seleciona quem vai jogar.

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador[] getJogadoresPartida() {
        return jogadoresPartida;
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public int getVez() {
        return vez;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setJogadoresPartida(Jogador[] jogadoresPartida) {
        this.jogadoresPartida = jogadoresPartida;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }
    
}
