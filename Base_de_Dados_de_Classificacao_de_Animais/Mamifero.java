package sistema;

import java.io.Serializable;

public class Mamifero extends Animal implements Serializable{

    public Mamifero(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }
    
    
}
