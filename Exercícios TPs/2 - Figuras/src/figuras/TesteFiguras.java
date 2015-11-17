package figuras;

import java.util.ArrayList;

/**
 * 3. Crie uma classe principal para testar as classes desenvolvidas, chamada
 * TesteFiguras.
 *
 * @author Pedro
 */
public class TesteFiguras {

    public static void main(String[] args) {

        /**
         * 4. Crie e guarde várias instâncias, retângulo e círculo.
         */
        Retangulo ret1 = new Retangulo();
        Retangulo ret2 = new Retangulo(2, 3, "Azul");
        Retangulo ret3 = new Retangulo(7, 19, "Branco");
        Circulo cir1 = new Circulo();
        Circulo cir2 = new Circulo(3, "Vermelho");
        Circulo cir3 = new Circulo(10, "Castanho");

        /**
         * 5. Imprima no ecrã a descrição textual dos objetos criados.
         */
        System.out.println("" + ret1 + ret2 + ret3 + cir1 + cir2 + cir3);

        /**
         * 6. Crie uma variável do tipo Object, chamada obj.
         */
        Object obj = null;

        /**
         * 7. Verifique que esta variável obj permite guardar diferentes tipos
         * de instâncias, imprimindo estes objetos no ecrã. Repare que as
         * instruções de impressão são iguais mas que produzem um resultado
         * diferente.
         */
        obj = ret1;
        System.out.print(obj);
        obj = cir2;
        System.out.print(obj);

        /**
         * 8. Crie e guarde várias instâncias, retângulo e círculo, num
         * contentor do tipo Array, chamado figuras. Os elementos deste array
         * devem ser do tipo Object.
         */
        /*ArrayList<Object> figuras = new ArrayList<>();
        figuras.add(ret1);
        figuras.add(ret2);
        figuras.add(ret3);
        figuras.add(cir1);
        figuras.add(cir2);
        figuras.add(cir3);*/
        Object[] figuras = new Object[10];
        figuras[0] = ret1;
        figuras[1] = ret2;
        figuras[2] = ret3;
        figuras[3] = cir1;
        figuras[4] = cir2;
        figuras[5] = cir3;                        

        /**
         * 9. Programe um varrimento do contentor figuras para mostrar as
         * instâncias guardadas. 11. Teste o cálculo das áreas, mostrando as
         * áreas das várias instâncias retângulo e círculo guardadas no
         * contentor figuras.
         */
        System.out.println("");
        /*for (Object figura : figuras) {
            System.out.printf("%sArea: %s %n", figura, ((Figuras) figura).calcularArea());
        }*/
        for (int i = 0; i < figuras.length; i++) {
            if(figuras[i] != null) {
                System.out.print(figuras[i]);
            }
        }

        /**
         * 12. Verifique que é possível adicionar uma instância do tipo String
         * ao contentor figuras.
         */
        String umaString = "Qualquer Coisa!";
        // Vai crashar...
        //figuras.add(new String("Algo espetacular"));
        figuras[6] = umaString;
        
        /**
         * 13. Verifique que em runtime, o varrimento do contentor aquando do
         * cálculo das áreas gera um erro. 
         */
        System.out.println("");
        /*for (Object figura : figuras) {
            if (figura instanceof Figuras) {
                System.out.printf("%sArea: %s %n", figura, ((Figuras) figura).calcularArea());
            }
        }*/
        for (int i = 0; i < figuras.length; i++) {
            if(figuras[i] != null) {
                System.out.printf("%s | Área: %.1f", figuras[i], ((Figuras)figuras[i]).calcularArea());
            }
        }
               
        /**
         * 15. Programe as seguintes listagens separadas de:
         */
        // a) Instâncias retângulo
        System.out.println("");
        /*for (Object figura : figuras) {
            if (figura instanceof Retangulo) {
                System.out.printf("%sArea: %s %n", figura, ((Figuras) figura).calcularArea());
            }
        }*/
        for (int i = 0; i < figuras.length; i++) {
            if(figuras[i] instanceof Retangulo) {
                System.out.printf("%s | Área: %.1f", figuras[i], ((Figuras)figuras[i]).calcularArea());
            }
        }

        // b) Instâncias círculo
        System.out.println("");
        for (Object figura : figuras) {
            if (figura instanceof Circulo) {
                System.out.printf("%sArea: %s %n", figura, ((Figuras) figura).calcularArea());
            }
        }
        
        
        // 14. Altere o código de forma a resolver este problema.

        // Figuras[] figuras = new Figuras[10];
        // figuras[i].area() // já funciona :D
    }
}
