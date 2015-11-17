package listatelefonica.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicheiroListaTelefonica {
    
    public static final String NOME = "ListaTelefonica.bin";

    public FicheiroListaTelefonica() {
    }
    
    public ListaTelefonica ler(String nomeFicheiro) {
        ListaTelefonica listaTelefonica;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(nomeFicheiro));
            try {
                listaTelefonica = (ListaTelefonica) in.readObject();
            } finally {
                in.close();
            }
            return listaTelefonica;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean guardar(String nomeFicheiro, ListaTelefonica listaTelefonica) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(nomeFicheiro));
            try {
                out.writeObject(listaTelefonica);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
