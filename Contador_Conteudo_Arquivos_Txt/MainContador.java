package contador;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MainContador {
    public static String[] args2;
    
    public static void checarArquivo(String [] nomeArquivos) {
        String [] listaArquivos = nomeArquivos;
        Contador[] conta = new Contador[nomeArquivos.length];
        Map <Long, Contador> tempos = new TreeMap<>();
        int i = 0;
        
        try {
            for (i = 0; i < listaArquivos.length; i++) {
                FileReader fileReader = new FileReader(listaArquivos[i]);
                conta[i] = new Contador();
                conta[i].contaLinhas(listaArquivos[i]);
                tempos.put(conta[i].getTempo(), conta[i]);
            }
            for (Object key: tempos.keySet().toArray()) {
                tempos.get(key).imprimirParcial();
            }
            
            Contador.imprimirTotal();
        }
        catch (FileNotFoundException ex){
            System.out.println("Não foi possível abrir o arquivo '" + listaArquivos[i] + "'");
            criarArquivo(listaArquivos[i]);
        }
        catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo '" + listaArquivos[i] + "'");                  
        }
    }
    
    public static void criarArquivo(String arquivoNaoEncontrado) {
        String arquivo = arquivoNaoEncontrado;
        
        try {
            FileWriter fileWriter = new FileWriter(arquivo);
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");            
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro ao escrever no arquivo '"+ arquivo + "'");
        }
    }
    
    public static void main(String[] args){
        if(args.length == 0){  //Verifica se foram passados arquivos pela chamada
            args2 = new String[]{"quantitativo.txt", "Estacionamento.txt"};
            checarArquivo(args2);
        }
        else{
            checarArquivo(args);
        }
    }
}
    
