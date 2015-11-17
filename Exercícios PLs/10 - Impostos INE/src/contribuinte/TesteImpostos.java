/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contribuinte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Pedro
 */
public class TesteImpostos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Contribuinte> contribuintes = new ArrayList<>();

        contribuintes.add(new Desempregado("Lito Vidal", "Lisboa", 230.00f, 1));
        contribuintes.add(new Reformado("Valter Cubilhas", "Olival", 600.00f, 400.00f));
        contribuintes.add(new Desempregado("Paulo Santos", "Braga", 150.00f, 4));
        contribuintes.add(new TrabOutrem("Ana Sousa", "Matosinhos", 1800.00f, 300.00f, "CMM"));
        contribuintes.add(new Reformado("Jaime Magalhães", "Porto", 1500.00f, 100.00f));
        contribuintes.add(new TrabOutrem("Salvio Salvador", "Seixal", 8000.00f, 1000.00f, "SSB"));
        contribuintes.add(new TrabCPropria("Mario Luz", "Guarda", 1500.00f, 300.00f, "Eletricista"));
        contribuintes.add(new Reformado("Aníbal Silva", "Coimbra", 1000.00f, 500.00f));
        contribuintes.add(new TrabOutrem("João Pereira", "Lisboa", 800.00f, 100.00f, "CML"));
        contribuintes.add(new TrabCPropria("Carla Santos", "Porto", 15000.00f, 1000.00f, "Advogado"));
        contribuintes.add(new Desempregado("Maria Sá", "Afife", 230.00f, 8));

        System.out.println("\n### Lista de Contribuintes ###");
        listar(contribuintes);

        System.out.println("\n### Remover Objeto: ###");
        System.out.println(contribuintes.remove(new Desempregado("Lito Vidal", "Lisboa", 230.00f, 1)));

        System.out.println("\n### Comparações: ###");
        System.out.println(contribuintes.get(0).equals(contribuintes.get(0)));
        System.out.println(contribuintes.get(1).equals(contribuintes.get(4)));
        System.out.println(contribuintes.get(3).equals(contribuintes.get(6)));

        System.out.println("\n### Ordem alfabética inversa: ###");
        Comparator<Contribuinte> alfabeticamente = new Comparator<Contribuinte>() {

            @Override
            public int compare(Contribuinte c1, Contribuinte c2) {
                return c1.getNome().compareToIgnoreCase(c2.getNome());
            }

        };

        Collections.sort(contribuintes, Collections.reverseOrder(alfabeticamente));
        listar(contribuintes);

        System.out.println("\n### Ordem por tipo de contribuinte e alfabéticamente: ###");
        Comparator<Contribuinte> classe_nome = new Comparator<Contribuinte>() {

            @Override
            public int compare(Contribuinte c1, Contribuinte c2) {
                return ((c1.getClass().getName() + " " + c1.getNome()).compareTo(c2.getClass().getName() + " " + c2.getNome()));
            }

        };

        Collections.sort(contribuintes, classe_nome);
        listar(contribuintes);
    }

    private static void listar(ArrayList<Contribuinte> contribuintes) {
        for (Contribuinte contribuinte : contribuintes) {
            if (contribuinte != null) {
                System.out.printf("%s%n", contribuinte);
            }
        }
    }

}
