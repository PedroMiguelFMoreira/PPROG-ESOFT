package vencimentos;

import java.util.Collection;

public abstract class Servicos {

    public <E> void listarArrayUnidimensional(E[] array) {
        System.out.print("\nArray Unidimensional: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public <E> void listarCollection(Collection<? extends E> collection) {
        System.out.println("\nContentor de objetos do tipo " + collection.getClass() + ": ");
        for (E obj : collection) {
            System.out.print(obj + " ");
        }
    }

    /* Verificar se numa lista, representada por uma coleção do Java, os seus elementos
    estão ordenados de forma ascendente. Neste caso o método deve retornar true, caso
    contrário deve retornar false. Os elementos têm de ser do tipo Comparable. */
    public <E> boolean collectionContemObj(Collection<? extends E> collection, E element) {
        for (E obj : collection) {
            return element.equals(obj);
        }

        return false;
    }

    /* Verificar se numa lista, representada por um array unidimensional, os seus
    elementos estão ordenados de forma ascendente. Neste caso o método deve
    retornar true, caso contrário deve retornar false. Os elementos têm de ser do
    tipo Comparable. */
    public <E> boolean arrayUnidimensionalAscendente(E[] array, E element) {
        for(int i = 0; i < 0; i++) {
//            if (array[i])
        }
        
        return true;
    }

    /* Determinar a união de dois arrays unidimensionais do mesmo tipo. O método
    deve receber esses dois arrays por parâmetro e tem de retornar o array 
    resultante dessa união. */
    public <E> boolean unirArrayUnidimensional() {
        return true;
    }

    /*  
    

    Teste convenientemente estes métodos. No primeiro método referido, inclua o teste 
        de um vetor de tipo primitivo. Para testar os métodos que verificam se uma 
        lista está ordenada de forma ascendente, use as classes Trabalhador e TrabPeça 
        fornecidas como exemplos de classes que não são do tipo Comparable.
*/
}
