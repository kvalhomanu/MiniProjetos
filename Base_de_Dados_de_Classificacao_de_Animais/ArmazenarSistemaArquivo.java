package sistema;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ArmazenarSistemaArquivo {
    public static void salvarTxt(Map<String, Animal> valorMap) throws IOException { 
        FileOutputStream arquivo = null;
        ObjectOutputStream obj = null;
        
        
        try {
            arquivo = new FileOutputStream(new File("save.txt"));
            obj = new ObjectOutputStream(arquivo);
     
        } catch(IOException ex){
            System.out.println("Não foi possível criar o arquivo!");
        } 
        
        try {
            for (Animal an : valorMap.values()) {
                obj.writeObject(an);
                //System.out.println("opa "+an);
            } 
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        try {
            obj.close();
            arquivo.close();
            
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    
    
    public static Map<String, Animal> lerDadosArquivo()  throws IOException, InterruptedException, ClassNotFoundException{
        Map<String, Animal> imprimirObjArquivo = new HashMap<String, Animal>();
        Animal a;
        ObjectInputStream lerObj = null;
        FileInputStream leituraArquivo = null;
        File verificaExistenciaArquivo = new File("save.txt");
        
        if(!verificaExistenciaArquivo.exists()){
            verificaExistenciaArquivo.createNewFile();
        }
        try {
            leituraArquivo = new FileInputStream("save.txt");
            lerObj = new ObjectInputStream(leituraArquivo);
            a = (Animal)lerObj.readObject();
            System.out.println(a);
            //imprimirObjArquivo = (HashMap <String, Animal>)lerObj.readObject();
            //System.out.println(imprimirObjArquivo);
            
            lerObj.close();
            leituraArquivo.close();
        }  catch(IOException ex){
            System.out.println("Error ao ler o arquivo!");
        }          
        return imprimirObjArquivo;

        
    
                
    }
            
           
        
        
    }
    
        
           
   