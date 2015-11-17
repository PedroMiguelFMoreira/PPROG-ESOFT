package junho2013_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profissional p1 = new Profissional("Alexandra Silva", "Xadrez", 123, Desempenho.ALTO);
        Amador a1 = new Amador("Pedro Moreira", "Programar", 1140781, "Estudante");
        Seccionista s1 = new Seccionista("Francisco Azevedo", "Xadrez");
        
        List<Pessoa> listaPessoas = new ArrayList();
        listaPessoas.add(p1);
        listaPessoas.add(a1);
        listaPessoas.add(s1);
        
        for (Pessoa pessoa : listaPessoas) {
            System.out.println(pessoa);
        }
        
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa instanceof Vencimento) {
                System.out.println(((Vencimento) pessoa).calcularVencimento());
            }
        }
        
        // Guardar em binário...
    }
    
}
