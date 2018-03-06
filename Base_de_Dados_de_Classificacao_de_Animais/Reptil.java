package sistema;

import java.io.Serializable;


public class Reptil extends Animal implements Serializable{
    
    private String corEscama;
    private String tipoReptil;  

    public Reptil(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

    

    
    
}
