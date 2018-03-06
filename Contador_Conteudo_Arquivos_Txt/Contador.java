package contador;

import java.io.*;

public class Contador{
    private String arquivo;
    private long inicio = 0;
    private long fim = 0, tempo = 0, especiais = 0, linhas = 0, palavras = 0, vogais = 0, consoantes = 0, digitos = 0, brancos = 0;
    public static long totalTempo = 0;
    private static long totalEspeciais = 0, totalLinhas = 0, totalPalavras = 0;
    private static long totalVogais = 0, totalConsoantes = 0, totalDigitos = 0, totalBrancos = 0;

   public void contaLinhas(String arquivo, BufferedReader in) throws IOException{
      inicio = System.currentTimeMillis();
      String linha;
      
      this.arquivo = arquivo;
      
      do{
         linha = in.readLine();
         if(linha != null){
             
            //numeroCaracteres += linha.length();
            especiais = contaEspeciais(linha);
            palavras = contaPalavras(linha);
            vogais = contaVogais(linha);
            consoantes = contaConsoantes(linha);
            digitos = contaDigitos(linha);
            brancos = contaBrancos(linha);
            linhas++;
            
            totalEspeciais += especiais;
            totalPalavras += palavras;
            totalVogais += vogais;
            totalConsoantes += consoantes;
            totalDigitos += digitos;
            totalBrancos += brancos;
            totalLinhas++;
            
            }
         }while(linha != null);{    
         }
   fim = System.currentTimeMillis();
   tempo = fim - inicio;
   totalTempo += tempo;
   //System.out.println("Arquivo processado em:" + tempo + "seg \n");
        
    }

   public void contaLinhas(String arquivo){
      BufferedReader in = null;
      try{
         FileReader file = new FileReader(arquivo);
         in = new BufferedReader(file);
         contaLinhas(arquivo,in);
      }catch(IOException e){
         System.out.println("Arquivo não encontrado no directorio");//e.printStackTrace();
      }
   }
   
   public void imprimirParcial(){
         System.out.println("Arquivo:" +arquivo);
         System.out.println("Número de linhas: " + linhas); 
         System.out.println("Número de palavras: " + palavras);
         System.out.println("Número de brancos: " + brancos);
         System.out.println("Número de vogais: " + vogais);
         System.out.println("Número de Consoantes: " + consoantes);
         System.out.println("Número de digitos: " + digitos);
         System.out.println("Número de caracteres Especiais: " + especiais);
         System.out.println("Arquivo processado em:" + tempo + " milisegundos \n");
   }
   
   public static void imprimirTotal(){
         System.out.println("Número de linhas: " +totalLinhas); 
         System.out.println("Número de palavras: " +totalPalavras);
         System.out.println("Número de brancos: " +totalBrancos);
         System.out.println("Número de vogais: " +totalVogais);
         System.out.println("Número de Consoantes: " +totalConsoantes);
         System.out.println("Número de digitos: " +totalDigitos);
         System.out.println("Número de caracteres Especiais: " +totalEspeciais);
         System.out.println("Arquivo processado em:" + totalTempo + " milisegundos \n"); 
   }
   
   public long getTempo() {
       return this.tempo;
    }
   
   private static long contaPalavras(String linha){
      long numeroPalavras = 0;
      int indice = 0;
      boolean espacoEmBranco = true;
      while(indice < linha.length()){
         char c = linha.charAt(indice++);
         boolean espacoEmBrancoAtual = Character.isWhitespace(c);
         if(espacoEmBranco && !espacoEmBrancoAtual){
            numeroPalavras++;
         }
         espacoEmBranco = espacoEmBrancoAtual;
      }
           return numeroPalavras;
      
   }
   
   private static long contaVogais(String linha){
        String vogais = "aeiouAEIOU";
        int total_vogais = 0;
        char[] v = linha.toCharArray();

        int NumeroLetras = linha.length();
        for(int i = 0; i < NumeroLetras; i++){
            if(vogais.indexOf(v[i]) >= 0){
                 total_vogais++;
                }
        }
        return total_vogais;
    }

   private static long contaConsoantes(String linha){
        String consoantes = "bcdfghjklmnpqrstvxwyzBCDFGHJKLMNPQRSTVXYZ";
        int total_consoantes = 0;
        char[] c = linha.toCharArray();   
        
        int NumeroLetras = linha.length();
        for(int i = 0; i < NumeroLetras; i++){
            if(consoantes.indexOf(c[i]) >= 0)
                 total_consoantes++;
            }
        return total_consoantes++;
 }
   
   private static long contaDigitos(String linha){
        String digitos = "0123456789";
        int total_digitos = 0;
        char[] d = linha.toCharArray();   
        
        int NumeroLetras = linha.length();
        for(int i = 0; i < NumeroLetras; i++){
            if(digitos.indexOf(d[i]) >= 0)
                 total_digitos++;
            }
        return total_digitos++;
 }
   
   private static long contaBrancos(String linha){
        String digitos = " ";
        int total_brancos = 0;
        char[] d = linha.toCharArray();   
        
        int NumeroLetras = linha.length();
        for(int i = 0; i < NumeroLetras; i++){
            if(digitos.indexOf(d[i]) >= 0)
                 total_brancos++;
            }
        return total_brancos++;
 }
   
   private static long contaEspeciais(String linha){
        String digitos = "�!?=+-_,.:;/*'@#$%&()[]{}";
        int total_digitos = 0;
        char[] d = linha.toCharArray();   
        
        int NumeroLetras = linha.length();
        for(int i = 0; i < NumeroLetras; i++){
            if(digitos.indexOf(d[i]) >= 0)
                 total_digitos++;
            }
        return total_digitos++;
 }
   
}
