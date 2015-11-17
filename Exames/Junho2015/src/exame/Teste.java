package exame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Teste {

    public static void main(String[] args) {
        List<Prato> listaPratos = new ArrayList<Prato>();
        
        adicionarPratos(listaPratos);
        
        float custoTotal = 0, descontoTotal = 0;
        for (Prato prato : listaPratos) {
            custoTotal += prato.calcularPreco();
            
            if (prato instanceof Desconto) {
                descontoTotal += ((Desconto) prato).calcularDesconto();
            }
        }
        
        System.out.println("Custo total: " + custoTotal + "€");
        System.out.println("Desconto total: " + descontoTotal + "€");

        try {
            FileOutputStream fos = new FileOutputStream(new File("data.bin"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaPratos);
            oos.close();
        } catch(IOException ex) {
            System.out.println("Não foi possível gravar o ficheiro.");
        }
    }
    
    private static void adicionarPratos(List<Prato> listaPratos) {
        // Método mágico que cria e adiciona instâncias e pratos...
        listaPratos.add(new PratoAPeso(new ListaAlimentos(), 0.2f));
    }
    
}
