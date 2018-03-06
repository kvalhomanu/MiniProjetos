package sistema;
//IsEmpty vê se o array ta vazio
//contains analisa se tem o obj na lista
// size retorna o tamanho do arraylist
//indexOf retorna a posição do obj pedido

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sistema implements Serializable {
    
    private Map<String, Animal> vetorAnimais;

    public Sistema() {
        this.vetorAnimais = new HashMap<String, Animal>();
    }


    public void adicionaAnimal(Animal animal) {
        this.vetorAnimais.put(animal.toString(), animal);
    }


    public void removeAnimal(Animal animal) {
        this.vetorAnimais.remove(animal.getNome());    
    }


    public void atualizaAnimal(Animal animal) {
        this.vetorAnimais.replace(animal.getNome(), animal);   
    }


    public void listaAnimaisArmazenados() { 
        for(Animal animal : this.vetorAnimais.values()) {
            System.out.println(animal.toString());
        }    
    }


    public Map<String, Animal> getListaAnimais() {
        return this.vetorAnimais;    
    }
    
}


