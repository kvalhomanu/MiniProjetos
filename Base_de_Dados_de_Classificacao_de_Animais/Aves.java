package sistema;

import java.io.Serializable;

public class Aves extends Animal implements Serializable {
    protected String corPena;
    protected String tipoAve;

    public Aves(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

    
    
}
