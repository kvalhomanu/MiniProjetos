package pulpitoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ThreadCliente extends Thread {
    
    private Socket cliente;
    private String nome = null;
    private String mensagem;
    private BufferedReader read;
    private PrintWriter write;
    
    private static final Map <String, ThreadCliente> clientes = new HashMap <>(); // Mapeia os nomes dos clientes para suas ThreadsCliente correspondente

    public ThreadCliente(Socket cliente) {
        this.cliente = cliente;
        start(); // Inicia a Thread
    }
    
    public ThreadCliente(Socket cliente, String nome) {
        this.cliente = cliente;
        this.nome = nome;
        start(); // Inicia a Thread
    }

    public BufferedReader getRead() {
        return read;
    }

    public PrintWriter getWrite() {
        return write;
    }
    

    @Override
    public void run() {
        try {
            read = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Lê informação
            write = new PrintWriter(cliente.getOutputStream(), true); // Manda informação
            if (nome == null) {
                write.println("Informe seu nome: "); // Pede o nome ao Cliente
                String mensagem = read.readLine(); // Coloca o nome recebido na variável da mensagem recebida
                this.nome = mensagem; // Coloca o nome em sua variável.
            }
            write.println("Olá, " + this.nome); // Serve para dar um feedback sobre a inclusão do nome da pessoa
            clientes.put(this.nome, this); // Adiciona o novo cliente no mapa de clientes.
            
            while (true) {
                write.println("Informe a mensagem: ");
                mensagem = read.readLine(); // Lê a mensagem da entrada padrão
                if (mensagem.equalsIgnoreCase("/EXIT")) {
                    this.cliente.close(); // Fecha a conexão ao usar esse comando.
                }
                else {
                    System.out.println("[ " + this.nome + " ] " + mensagem); // Printa para o servidor a mensagem e de quem foi enviada.
                    for (Map.Entry<String, ThreadCliente> cli : clientes.entrySet()) { // Percorre o mapa para ser enviada a mensagem para todos.
                        cli.getValue().getWrite().println("[ " + this.nome + " ] " + mensagem); // Printa em todos os clientes a mensagem enviada
                        if (cli.getKey().equals(this.nome) == false) { // Se não foi a própria pessoa que enviou ele reprinta o "Informe a mensagem: "
                            cli.getValue().getWrite().println("Informe a mensagem: ");
                        }
                    }
                }
            }
            
        } catch (IOException ex) {
            System.err.println("Não foi possível uma conexão com o cliente.");
        }
    }
    
    

    
    
    
    
}
