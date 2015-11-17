package figuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 3. Crie uma classe principal para testar as classes desenvolvidas, chamada
 * TesteFigura.
 *
 * @author Pedro
 */
public class TesteFigura {

    public static void main(String[] args) {
        // Instâncias existentes...
        Retangulo ret1 = new Retangulo();
        Retangulo ret2 = new Retangulo(2, 3, "Azul");
        Retangulo ret3 = new Retangulo(7, 19, "Branco");
        Circulo cir1 = new Circulo();
        Circulo cir2 = new Circulo(3, "Vermelho");
        Circulo cir3 = new Circulo(10, "Castanho");

        // 1.
        ArrayList<Figura> figuras2 = new ArrayList<>();

        // 2.
        figuras2.add(ret1);
        figuras2.add(ret2);
        figuras2.add(ret3);
        figuras2.add(cir1);
        figuras2.add(cir2);
        figuras2.add(cir3);

        System.out.println("For:");
        // 3. a)
        for (int i = 0; i < figuras2.size(); i++) {
            if (figuras2.get(i) != null) {
                System.out.print(figuras2.get(i));
            }
        }

        System.out.println("\nForeach:");
        // 3. b)
        for (Figura f : figuras2) {
            if (f != null) {
                System.out.print(f);
            }
        }

        System.out.println("\nOrdem crescente:");
        // 4. a)
        Collections.sort(figuras2);
        listar(figuras2);

        System.out.println("\nOrdem descrescente:");
        // 4. b)
        Collections.reverse(figuras2);
        listar(figuras2);

        System.out.println("\nOrdem crescente:");
        // 5. a) 
        // Classe no fim do ficheiro...
        //Comparator<Figura> criterio1 = new ComparadorArea();
        // Classe anónima
        Comparator<Figura> criterio1 = new Comparator<Figura>() {

            @Override
            public int compare(Figura f1, Figura f2) {
                if (f1.calcularArea() > f2.calcularArea()) {
                    return 1;
                } else if (f1.calcularArea() < f2.calcularArea()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(figuras2, criterio1);
        listar(figuras2);

        System.out.println("\nOrdem descrescente:");
        // 5. b)
        // Classe anónima
        /*Comparator<Figura> criterio2 = new Comparator<Figura>() {

         @Override
         public int compare(Figura f1, Figura f2) {
         if (f1.calcularArea() > f2.calcularArea()) {
         return 1;
         } else if (f1.calcularArea() < f2.calcularArea()) {
         return -1;
         } else {
         return 0;
         }
         }
         };
         Collections.sort(figuras2, criterio2);*/
        // OU!!!!
        Collections.sort(figuras2, Collections.reverseOrder(criterio1));
        listar(figuras2);

        System.out.println("\nRemover Objecto");
        // 6. 7. 8.
        System.out.println(figuras2.remove(new Circulo()));
        
        System.out.println("\nTeste de igualdades");
        // 9.
        System.out.println(cir1.equals(new Circulo()));
        System.out.println(cir2.equals(cir3));
        System.out.println(ret1.equals(cir1));
        System.out.println(ret2.equals(ret2));
    }

    private static void listar(ArrayList<Figura> figuras) {
        for (Figura figura : figuras) {
            if (figura != null) {
                System.out.printf("Área=%.1f %s", figura.calcularArea(), figura);
            }
        }
    }
}

class ComparadorArea implements Comparator<Figura> {

    @Override
    public int compare(Figura f1, Figura f2) {
        if (f1.calcularArea() > f2.calcularArea()) {
            return 1;
        } else if (f1.calcularArea() < f2.calcularArea()) {
            return -1;
        } else {
            return 0;
        }
    }

}
