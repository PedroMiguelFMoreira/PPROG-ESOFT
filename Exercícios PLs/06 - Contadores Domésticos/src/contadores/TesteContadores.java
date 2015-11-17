package contadores;

public class TesteContadores {

    public static void main(String[] args) {

        // a)
        ContadorGas g1 = new ContadorGas("Pedro Moreira", 12);
        ContadorGas g2 = new ContadorGas("Tiago Ferreira", 17);
        ContadorGas g3 = new ContadorGas("Alexandra Silva", 10);
        ContadorEletricoSimples e1 = new ContadorEletricoSimples("Pedro Moreira", 1200, 5.7);
        ContadorEletricoBipartido e2 = new ContadorEletricoBipartido("Tiago Ferreira", 500, 10, 1000);
        ContadorEletricoSimples e3 = new ContadorEletricoSimples("Alexandra Silva", 1700, 7.8);

        Object[] contador = new Object[10];

        contador[0] = g1;
        contador[1] = g2;
        contador[2] = g3;
        contador[3] = e1;
        contador[4] = e2;
        contador[5] = e3;

        // b)
        System.out.println("\nContadores:");
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] != null) {
                System.out.println(((Contador) contador[i]));
            }
        }

        // c)
        System.out.println("\nTotal de contadores de eletricidade: " + ContadorEletrico.getNumContador());

        // d)
        System.out.println("\nContadores Bi-partidos:");
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] instanceof ContadorEletricoBipartido) {
                System.out.println(((Contador) contador[i]).getId());
            }
        }

        // e)
        System.out.println("\nCusto de consumo por contador:");
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] != null) {
                System.out.println("ID: " + ((Contador) contador[i]).getId() + " Custo: " + ((Contador) contador[i]).calcularCusto() + "€.");
            }
        }

        // f)
        int maiorConsumoGas = 0;

        for (int i = 0; i < contador.length; i++) {
            if (contador[i] instanceof ContadorGas && ((Contador) contador[i]).getConsumo() > maiorConsumoGas) {
                maiorConsumoGas = ((Contador) contador[i]).getConsumo();
            }
        }

        if (maiorConsumoGas != 0) {
            System.out.println("Maior consumo de gás: " + maiorConsumoGas);
        }

        // g) Ou eram instâncias de Pessoas??
        String[] clientes = new String[10];
        boolean guardar;
        int k = 0;
        
        for (int i = 0; i < contador.length; i++) {
            if(contador[i] != null) {
                guardar = true;
                
                for (int j = 0; j < k; j++) {
                    if (clientes[j].equalsIgnoreCase(((Contador)contador[i]).getCliente())) {
                        guardar = false;
                    }
                }
                
                if (guardar) {
                    clientes[k] = ((Contador)contador[i]).getCliente();
                    k++;
                }
            }
        }
        
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i] != null) {
                System.out.println(clientes[i]);
            }
        }
    }

}
