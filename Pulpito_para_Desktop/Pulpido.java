package pulpido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Pulpido {
    public static void main(String[] args) {
        try {
            final Socket cliente = new Socket("127.0.0.1", 9090);
            String nome;
            
            // Escrevendo
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Lê informação da entrada padrão.
            PrintWriter write = new PrintWriter(cliente.getOutputStream(), true); // Manda informação.
            
            if (args.length != 0) {
                nome = args[0];
                write.println("::NOME: " + nome);
            }
            else {
                write.println("::NONE: ");
            }
            // Lendo do Servidor
            new Thread() { 
                @Override
                public void run() {
                    try {
                        BufferedReader read = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Lê informação
                        String mensagem = null;
                        while((mensagem = read.readLine()) != null) {
                            System.out.println(mensagem); // Printa as mensagens que vieram do servidor.
                            if (mensagem.equalsIgnoreCase("/EXIT")) {
                                System.exit(0);
                            }
                        }
                    } catch (IOException ex) {
                        System.err.println("Não foi possível ler a mensagem. A conexão com o servidor pode ter sido perdida.");
                    }
                }
                
            }.start();
            
            //Escrevendo no Servidor
            while(true) {
                String mensagemEnviar = reader.readLine(); // Armazena a mensagem da entrada padrão, estilo o Scanner.
                write.println(mensagemEnviar); // Envia a mensagem para o servidor distribuir.
            }
            

        } catch (IOException ex) {
            System.err.println("Não foi possível conectar-se ao servidor.");
            
        }
    }
    
}
