package exposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteExposicao {

    public static void main(String[] args) {

        Quadro q1 = new Quadro("A origem do mundo", "Samuel Soares", 1987);
        Quadro q2 = new Quadro("Bruxas negras", "Ruben Carvalho", 1944);
        Quadro q3 = new Quadro("A Monagrossa", "Adriano Ludgero", 1980);
        Quadro q4 = new Quadro("O poder do cavalo Lusitano", "Hugo Torres", 1990);
        Quadro q5 = new Quadro("Mafalda Tettoni", "Carlos Santos", 1992);
        Quadro q6 = new Quadro("Coisas do carago", "Pedro Moreira", 1989);

        List<Quadro> listaQuadros = new ArrayList<Quadro>();

        listaQuadros.add(q1);
        listaQuadros.add(q2);
        listaQuadros.add(q3);
        listaQuadros.add(q4);
        listaQuadros.add(q5);
        listaQuadros.add(q6);

        System.out.println("### Quadros ###");
        listar(listaQuadros);

        Exposicao expo1 = new Exposicao("Quadros 1", 1999);
        Exposicao expo2 = new Exposicao("Quadros 2", 2001);
        Exposicao expo3 = new Exposicao("Quadros 3", 2003);

        expo1.adicionarQuadro(q1);
        expo1.adicionarQuadro(q2);
        expo1.adicionarQuadro(q6);
        expo2.adicionarQuadro(q3);
        expo2.adicionarQuadro(q4);
        expo2.adicionarQuadro(q6);
        expo3.adicionarQuadro(q5);
        expo3.adicionarQuadro(q6);

        List<Exposicao> listaExposicoes = new ArrayList<Exposicao>();

        listaExposicoes.add(expo1);
        listaExposicoes.add(expo2);
        listaExposicoes.add(expo3);

        System.out.println("\n### Exposições ###");
        listar(listaExposicoes);

        System.out.println("\n### Exposições após alteração ###");
        q6.setAutor("João Pestana");
        q6.setDesignacao("Adormecendo");
        listar(listaExposicoes);

        System.out.println("\n### Exposições (decrescente) ###");
        Collections.reverse(listaExposicoes);
        listar(listaExposicoes);
        
        System.out.println("\n### Remoção de Quadro ###");
        expo1.removarQuadro(q6);
        System.out.println(expo1);

    }

    private static void listar(List lista) {
        for (Object elemento : lista) {
            if (elemento != null) {
                System.out.printf("%s%n", elemento);
            }
        }
    }

}
