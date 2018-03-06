package sistema;

import java.io.Serializable;

public class Homem extends Mamifero implements Carnivoro, AnimalDomesticavel, Herbivoro, Serializable {
    private String estiloVida;
    private String profissao;


    Homem(String nome, float peso, int idade, int membros) {
        super(nome, peso, idade, membros);
    }

    @Override
    public void comerProteina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void correr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void comerVegetais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void caminhar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
}


