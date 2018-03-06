package pulpitoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PulpitoServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        String nome;
        System.out.println("Iniciando o Servidor.");
        try {
            server = new ServerSocket(9090); // Cria conexão do servidor na porta 9090
            System.out.println("Servidor Iniciado com Sucesso!");
            
            while (true) {
                Socket cliente = server.accept(); // Aceita/ aguarda a entrada de novos clientes.
                BufferedReader read = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Lê informação
                nome = read.readLine();
                if (nome.contains("::NOME: ")) {
                    nome = nome.substring(8, nome.length());
                    System.out.println(nome);
                    new ThreadCliente(cliente, nome); // Aciona um novo gerenciador de clientes a cada nova entrada de um.
                }
                else {
                    new ThreadCliente(cliente); // Aciona um novo gerenciador de clientes a cada nova entrada de um.
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(PulpitoServer.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException ex1) {
                Logger.getLogger(PulpitoServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
       
    }
    
}
