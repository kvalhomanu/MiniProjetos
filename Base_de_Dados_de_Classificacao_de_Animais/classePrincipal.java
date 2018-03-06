package sistema;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;



public class classePrincipal {
    
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Sistema sistema = new Sistema();
       
       Map<String, Animal> valores = null;
       sistema.adicionaAnimal(new Homem("joao soares",528,19,2));
       sistema.adicionaAnimal(new Homem("joao mari",726,20,4));
       sistema.adicionaAnimal(new Cavalo("Pangaré", 366, 15, 4));
    
 

       
       ArmazenarSistemaArquivo.salvarTxt(sistema.getListaAnimais());
       ArmazenarSistemaArquivo.lerDadosArquivo();
       sistema.listaAnimaisArmazenados();
       
       
       
     
}

}

    