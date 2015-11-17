package torreshanoi.ui;

import java.util.Scanner;
import torreshanoi.model.Base;
import torreshanoi.model.Disco;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Base base = new Base();
        
        int discos;
        do {
            System.out.print("Digite o número de discos (3+): ");
            discos = ler.nextInt();
        } while (discos < 3);
        
        for (int i = discos; i > 0; i--) {
            base.getHaste(0).getPilha().push(new Disco(i));
        }
        
        int jogadas = 0;
        do {
            System.out.println(base);
            System.out.print("Mover um disco:\n");
            System.out.print("Indique a haste da qual pertende mover: ");
            int i = ler.nextInt() - 1;
            System.out.print("Indique a haste para qual pertende mover: ");
            int j = ler.nextInt() - 1;
            try {
                base.moverDisco(i, j);
                jogadas++;
            } catch(IllegalArgumentException ex) {
                System.out.println("\n" + ex.getMessage() + "\n");
            }
        } while(base.getHaste(2).size() != discos);
        
        System.out.println("Parabéns, ganhou ao fim de " + jogadas + " jogadas!");
        
    }
    
}
