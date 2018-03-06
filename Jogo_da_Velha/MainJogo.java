package JogoDaVelha;

import JogoDaVelha.Jogo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainJogo {
    public static void checarArquivo(ArrayList<Jogador> jogadores) {
        String file = "dados.txt";
        
        String linha = null;
        
        try {
            FileReader fileReader = new FileReader(file);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String nome = "";
            int participacoes = 0, vitorias = 0, derrotas = 0, empates = 0;
            while ((linha = bufferedReader.readLine()) != null) {
                if(linha.contains("Nome: ")) {
                    nome = linha.substring(6, linha.length());
                }
                if (linha.contains("Participações: ")){
                    participacoes = Integer.parseInt(linha.substring(15, linha.length()));
                }
                if (linha.contains("Vitórias: ")) {
                    vitorias = Integer.parseInt(linha.substring(10, linha.length()));
                }
                if (linha.contains("Derrotas: ")) {
                    derrotas = Integer.parseInt(linha.substring(10, linha.length()));
                }
                if (linha.contains("Empates: ")) {
                    empates = Integer.parseInt(linha.substring(9, linha.length()));
                    Jogador jogador = new Jogador(nome, participacoes, vitorias, derrotas, empates);
                    jogadores.add(jogador);
                }

            }                

            bufferedReader.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Não foi possível abrir o arquivo '" + file + "'");
        }
        catch (IOException ex) {
            System.out.println(
                "Erro ao ler o arquivo '" + file + "'");                  
        }
    }
    
    public static void salvarDados(ArrayList<Jogador> jogadores) {
        String file = "dados.txt";
        
        try {
            FileWriter fileWriter = new FileWriter(file);
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (int i = 0; i < jogadores.size(); i++) {
                bufferedWriter.write("Nome: " + jogadores.get(i).getNome());
                bufferedWriter.newLine();
                bufferedWriter.write("Participações: " + jogadores.get(i).getParticipacoes());
                bufferedWriter.newLine();
                bufferedWriter.write("Vitórias: " + jogadores.get(i).getVitorias());
                bufferedWriter.newLine();
                bufferedWriter.write("Derrotas: " + jogadores.get(i).getDerrotas());
                bufferedWriter.newLine();
                bufferedWriter.write("Empates: " + jogadores.get(i).getEmpates());
                bufferedWriter.newLine();
                bufferedWriter.write("-----------------------------");
                bufferedWriter.newLine();
            }
            
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro ao escrever no arquivo '"+ file + "'");
        }
    }
    
    public static void limparMatriz(String [][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }
    
    public static void imprimeMatriz(String [][] tabuleiro) {     
        System.out.println("      [ 1 ] [ 2 ] [ 3 ]\n"
                        +  "[ A ] [ " + tabuleiro[0][0] + " ] [ " + tabuleiro[0][1] + " ] [ " + tabuleiro[0][2] + " ]\n"
                        +  "[ B ] [ " + tabuleiro[1][0] + " ] [ " + tabuleiro[1][1] + " ] [ " + tabuleiro[1][2] + " ]\n"
                        +  "[ C ] [ " + tabuleiro[2][0] + " ] [ " + tabuleiro[2][1] + " ] [ " + tabuleiro[2][2] + " ]\n");
    }
    
    public static boolean checarInicio(String [][] tabuleiro, int i, int j) {
        if (tabuleiro[i][j].equals(" ")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean checarFim(String [][] tabuleiro) {
        int contO = 0;
        int contX = 0;
        // Linhas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].equals("O")) {
                    contO += 1;
                }
                else if (tabuleiro[i][j].equals("X")) {
                    contX += 1;
                }
            }
            
            if (contO == 3 || contX == 3) {
                return true;
            }
            else {
                contO = 0;
                contX = 0;
            }
        }
        
        // Colunas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[j][i].equals("O")) {
                    contO += 1;
                }
                else if (tabuleiro[j][i].equals("X")) {
                    contX += 1;
                }
            }
            
            if (contO == 3 || contX == 3) {
                return true;
            }
            else {
                contO = 0;
                contX = 0;
            }
        }
        
        // Diagonal Primária
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][i].equals("O")) {
                contO += 1;
            }
            else if (tabuleiro[i][i].equals("X")) {
                contX += 1;
            }
        }    
            
        if (contO == 3 || contX == 3) {
            return true;
        }
        else {
            contO = 0;
            contX = 0;
        }
        
        // Diagonal Secundária
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][2 - i].equals("O")) {
                contO += 1;
            }
            else if (tabuleiro[i][2 - i].equals("X")) {
                contX += 1;
            }
        }    
            
        if (contO == 3 || contX == 3) {
            return true;
        }
        else {
            contO = 0;
            contX = 0;
        }
        
        return false;
    }
    
    public static boolean checarVelha(String [][] tabuleiro) {
        int checked = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                if (tabuleiro[i][j].equals("X") || tabuleiro[i][j].equals("O")) {
                    checked += 1;
                }
            }
        }
        if (checked == 9) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static String decodificador(String jogada) {
        String decodificado = "";
        if (jogada.substring(0, 1).equals("A")) {
            decodificado += "0";
        }
        else if (jogada.substring(0, 1).equals("B")) {
            decodificado += "1";
        }
        else if (jogada.substring(0, 1).equals("C")) {
            decodificado += "2";
        }
        
        if (jogada.substring(1, 2).equals("1")) {
            decodificado += "0";
        }
        else if (jogada.substring(1, 2).equals("2")) {
            decodificado += "1";
        }
        else if (jogada.substring(1, 2).equals("3")) {
            decodificado += "2";
        }
        
        return decodificado;
    }
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        
        Jogo jogo = new Jogo();
        
        limparMatriz(jogo.getTabuleiro()); // Limpa/Inicia o tabuleiro
        
        checarArquivo(jogo.getJogadores()); // Checa o arquivo para encontrar jogadores e coloca os dados no arrayList
        
        if (jogo.getJogadores().size() == 0){
            System.out.println("Não existe nenhum jogador.");
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    System.out.print("Jogador O: ");
                }
                else if (i == 1) {
                    System.out.print("Jogador X: ");
                }
                
                System.out.print("\n");
                
                String nome = sn.next();
                Jogador jogador = new Jogador(nome);
                jogo.getJogadoresPartida()[i] = jogador;
                jogo.getJogadores().add(jogador);
                
                salvarDados(jogo.getJogadores());
            }
        } 
        else {
            System.out.println("Jogadores disponíveis: ");
            String jogadores = "";
            Jogador jogador1 = null, jogador2 = null;
            for (int i = 0; i < jogo.getJogadores().size(); i++) {
                System.out.println("-" + jogo.getJogadores().get(i).getNome());
                jogadores += jogo.getJogadores().get(i).getNome();
            }
            
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    System.out.print("Jogador 1: ");
                }
                else if (i == 1) {
                    System.out.print("Jogador 2: ");
                }
                
                System.out.print("\n");
                
                String nome = sn.next();
                if (jogadores.contains(nome)) {
                    for (int j = 0; j < jogo.getJogadores().size(); j++) {
                        if (jogo.getJogadores().get(j).getNome().equals(nome)) {
                            if (i == 0) {
                                jogador1 = jogo.getJogadores().get(j);
                                break;
                            }
                            else if (i == 1) {
                                jogador2 = jogo.getJogadores().get(j);
                                break;
                            }
                        }
                    }
                }
                else {
                    if (i == 0) {
                        jogador1 = new Jogador(nome);
                        jogo.getJogadores().add(jogador1);
                    }
                    else if (i == 1) {
                        jogador2 = new Jogador(nome);
                        jogo.getJogadores().add(jogador2);
                    }
                    salvarDados(jogo.getJogadores());
                }
            }
            if (jogador1.getDerrotas() > jogador2.getDerrotas()) {
                jogo.getJogadoresPartida()[1] = jogador2;
                jogo.getJogadoresPartida()[0] = jogador1;
            }
            else if (jogador1.getDerrotas() == jogador2.getDerrotas()) {
                if (jogador1.getEmpates() > jogador2.getEmpates()) {
                    jogo.getJogadoresPartida()[1] = jogador2;
                    jogo.getJogadoresPartida()[0] = jogador1;
                }
                else if (jogador1.getEmpates() == jogador2.getEmpates()) {
                    if (jogador1.getVitorias() < jogador2.getVitorias()) {
                        jogo.getJogadoresPartida()[1] = jogador2;
                        jogo.getJogadoresPartida()[0] = jogador1;
                    }
                    else if (jogador1.getVitorias() > jogador2.getVitorias()) {
                        jogo.getJogadoresPartida()[0] = jogador2;
                        jogo.getJogadoresPartida()[1] = jogador1;
                    }
                    else {
                        jogo.getJogadoresPartida()[0] = jogador2;
                        jogo.getJogadoresPartida()[1] = jogador1;
                    }
                    
                }
                else {
                    jogo.getJogadoresPartida()[0] = jogador2;
                    jogo.getJogadoresPartida()[1] = jogador1;
                }
            }
            else {
                jogo.getJogadoresPartida()[0] = jogador2;
                jogo.getJogadoresPartida()[1] = jogador1;
            }
            salvarDados(jogo.getJogadores());
        }
        
        System.out.println("\n" + jogo.getJogadoresPartida()[0].getNome() + "(O): " + jogo.getJogadoresPartida()[0].getParticipacoes() + " Participações: " + jogo.getJogadoresPartida()[0].getVitorias() + " Vitórias, " + jogo.getJogadoresPartida()[0].getDerrotas() + " Derrotas, " + jogo.getJogadoresPartida()[0].getEmpates() + " Empates.");
        System.out.println(jogo.getJogadoresPartida()[1].getNome() + "(X): " + jogo.getJogadoresPartida()[1].getParticipacoes() + " Participações: " + jogo.getJogadoresPartida()[1].getVitorias() + " Vitórias, " + jogo.getJogadoresPartida()[1].getDerrotas() + " Derrotas, " + jogo.getJogadoresPartida()[1].getEmpates() + " Empates.\n");
        
        imprimeMatriz(jogo.getTabuleiro());
        
        while(true) {
            if (jogo.getVez() == 0) {
                System.out.println(jogo.getJogadoresPartida()[0].getNome() + "(O) Sua Vez");
                String jogada = sn.next();
                if (jogada.length() != 2) {
                    System.out.println("Jogada Inválida!");
                }
                else {
                    jogada = decodificador(jogada);
                    if (jogada.length() != 2) {
                        System.out.println("Jogada Inválida!");
                    }
                    else {
                        if (checarInicio(jogo.getTabuleiro(), Integer.parseInt(jogada.substring(0, 1)), Integer.parseInt(jogada.substring(1, 2))) == true) {
                            jogo.getTabuleiro()[Integer.parseInt(jogada.substring(0, 1))][Integer.parseInt(jogada.substring(1, 2))] = "O";
                            imprimeMatriz(jogo.getTabuleiro());
                            if (checarFim(jogo.getTabuleiro()) == true) {
                                System.out.println("Parabéns " + jogo.getJogadoresPartida()[0].getNome() + "(O) você venceu!");
                                //Seta vitórias e participação para o jogador 1
                                jogo.getJogadoresPartida()[0].setVitorias(jogo.getJogadoresPartida()[0].getVitorias() + 1);
                                jogo.getJogadoresPartida()[0].setParticipacoes(jogo.getJogadoresPartida()[0].getParticipacoes() + 1);
                                //Seta Derrotas e participação para o jogador 2
                                jogo.getJogadoresPartida()[1].setDerrotas(jogo.getJogadoresPartida()[1].getDerrotas()+ 1);
                                jogo.getJogadoresPartida()[1].setParticipacoes(jogo.getJogadoresPartida()[1].getParticipacoes() + 1);
                                salvarDados(jogo.getJogadores());
                                break;
                            }
                            if (checarVelha(jogo.getTabuleiro()) == true) {
                                System.out.println("Opa, parece que deu velha.");
                                //Seta Empate e participação para o jogador 1
                                jogo.getJogadoresPartida()[0].setEmpates(jogo.getJogadoresPartida()[0].getEmpates() + 1);
                                jogo.getJogadoresPartida()[0].setParticipacoes(jogo.getJogadoresPartida()[0].getParticipacoes() + 1);
                                //Seta Empate e participação para o jogador 2
                                jogo.getJogadoresPartida()[1].setEmpates(jogo.getJogadoresPartida()[1].getEmpates() + 1);
                                jogo.getJogadoresPartida()[1].setParticipacoes(jogo.getJogadoresPartida()[1].getParticipacoes() + 1);
                                salvarDados(jogo.getJogadores());
                                break;
                            }
                            jogo.setVez(1); // Muda a vez para o jogador 2
                            
                        }
                        else {
                            System.out.println("Jogada Inválida!");
                        }
                    }
                }
            }
            else if (jogo.getVez() == 1) {
                System.out.println(jogo.getJogadoresPartida()[1].getNome() + "(X) Sua Vez");
                String jogada = sn.next();
                if (jogada.length() != 2) {
                    System.out.println("Jogada Inválida!");
                }
                else {
                    jogada = decodificador(jogada);
                    if (jogada.length() != 2) {
                        System.out.println("Jogada Inválida!");
                    }
                    else {
                        if (checarInicio(jogo.getTabuleiro(), Integer.parseInt(jogada.substring(0, 1)), Integer.parseInt(jogada.substring(1, 2))) == true) {
                            jogo.getTabuleiro()[Integer.parseInt(jogada.substring(0, 1))][Integer.parseInt(jogada.substring(1, 2))] = "X";
                            imprimeMatriz(jogo.getTabuleiro());
                            if (checarFim(jogo.getTabuleiro()) == true) {
                                System.out.println("Parabéns " + jogo.getJogadoresPartida()[1].getNome() + "(X) você venceu!");
                                //Seta vitórias e participação para o jogador 2
                                jogo.getJogadoresPartida()[1].setVitorias(jogo.getJogadoresPartida()[1].getVitorias() + 1);
                                jogo.getJogadoresPartida()[1].setParticipacoes(jogo.getJogadoresPartida()[1].getParticipacoes() + 1);
                                //Seta Derrotas e participação para o jogador 1
                                jogo.getJogadoresPartida()[0].setDerrotas(jogo.getJogadoresPartida()[0].getDerrotas()+ 1);
                                jogo.getJogadoresPartida()[0].setParticipacoes(jogo.getJogadoresPartida()[0].getParticipacoes() + 1);
                                break;
                            }
                            if (checarVelha(jogo.getTabuleiro()) == true) {
                                System.out.println("Opa, parece que deu velha.");
                                //Seta Empate e participação para o jogador 1
                                jogo.getJogadoresPartida()[0].setEmpates(jogo.getJogadoresPartida()[0].getEmpates() + 1);
                                jogo.getJogadoresPartida()[0].setParticipacoes(jogo.getJogadoresPartida()[0].getParticipacoes() + 1);
                                //Seta Empate e participação para o jogador 2
                                jogo.getJogadoresPartida()[1].setEmpates(jogo.getJogadoresPartida()[1].getEmpates() + 1);
                                jogo.getJogadoresPartida()[1].setParticipacoes(jogo.getJogadoresPartida()[1].getParticipacoes() + 1);
                                break;
                            }
                            jogo.setVez(0); // Muda a vez para o jogador 2
                            
                        }
                        else {
                            System.out.println("Jogada Inválida!");
                        }
                    }
                }
            }
        }
        
    }
    
    
}