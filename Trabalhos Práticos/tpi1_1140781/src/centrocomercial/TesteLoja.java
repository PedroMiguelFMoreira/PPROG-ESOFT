package centrocomercial;

/**
 * Testa as funcionalidades da class Loja, chamando os seus métodos no método main.
 * 
 * @author Pedro
 */
public class TesteLoja {

    public static void main(String[] args) {
        Loja loja1 = new Loja(1, "Loja de Roupa", 101, 10254.3);
        Loja loja2 = new Loja(2, "Loja de Livros", 15, 9875.6);
        Loja loja3 = new Loja(3, "Loja de Calçado", 30, 15765.2);

        System.out.println(loja1.toString());
        System.out.println(loja2.toString());
        System.out.println(loja3.toString());

        System.out.printf("%nLoja1: %s %d%n", loja1.determinarTamanho(), loja1.getArea());
        System.out.printf("Loja2: %s %d%n", loja2.determinarTamanho(), loja2.getArea());
        System.out.printf("Loja3: %s %d%n", loja3.determinarTamanho(), loja3.getArea());

        Loja.setLimiteA(50);
        
        System.out.printf("%nLoja1: %s %d%n", loja1.determinarTamanho(), loja1.getArea());
        System.out.printf("Loja2: %s %d%n", loja2.determinarTamanho(), loja2.getArea());
        System.out.printf("Loja3: %s %d%n", loja3.determinarTamanho(), loja3.getArea());
    }

}
