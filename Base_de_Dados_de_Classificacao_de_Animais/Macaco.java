package sistema;

import java.io.Serializable;

public class Macaco extends Mamifero implements Serializable{
    private String corPelo;
    private String habitat;

    public Macaco(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

 
}
