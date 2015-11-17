/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Pedro
 */
public class TesteVencimentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrabPeca tp = new TrabPeca("Jorge Silva", 20, 30);
        TrabCom tc = new TrabCom("Susana Ferreira", (float) 500.0, (float) 1500.0, (float) 6);
        TrabHora th = new TrabHora("Carlos Miguel", 160, (float) 3.5);
        
        ArrayList<Trabalhador> trabalhadores = new ArrayList<>();
        
        trabalhadores.add(tp);
        trabalhadores.add(tc);
        trabalhadores.add(th);
        
        System.out.println("### Comparable ###");
        System.out.println("\nOrdem crescente:");
        Collections.sort(trabalhadores);
        listar(trabalhadores);
        System.out.println("\nOrdem descrescente:");
        Collections.reverse(trabalhadores);
        listar(trabalhadores);
        
        System.out.println("");
        System.out.println("### Comparator ###");
        Comparator<Trabalhador> crescente = new Comparator<Trabalhador>() {

            @Override
            public int compare(Trabalhador t1, Trabalhador t2) {
                if (t1.vencimento() > t2.vencimento()) {
                    return 1;
                } else if(t1.vencimento() < t2.vencimento()) {
                    return -1;
                }
                
                return 0;
            }
        };
        
        Comparator<Trabalhador> alfabeticamente = new Comparator<Trabalhador>() {

            @Override
            public int compare(Trabalhador t1, Trabalhador t2) {
                return t1.getNome().compareTo(t2.getNome());
            }
        };
        
        System.out.println("\nOrdem crescente:");
        Collections.sort(trabalhadores, crescente);
        listar(trabalhadores);
        System.out.println("\nOrdem descrescente:");
        Collections.sort(trabalhadores, Collections.reverseOrder(crescente));
        listar(trabalhadores);
        System.out.println("\nOrdem alfabetica:");
        Collections.sort(trabalhadores, alfabeticamente);
        listar(trabalhadores);
    }
    
    private static void listar(ArrayList<Trabalhador> trabalhadores) {
        for (Trabalhador trabalhador : trabalhadores) {
            if (trabalhador != null) {
                System.out.printf("%s, tem um vencimento de %.1f€%n", trabalhador.getNome(), trabalhador.vencimento());
            }
        }
    }
    
}
