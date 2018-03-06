
package sistema;

import java.io.Serializable;

public class BeijaFlor extends Animal implements Serializable {
    protected String corPena;

    public BeijaFlor(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }


  
    
}
