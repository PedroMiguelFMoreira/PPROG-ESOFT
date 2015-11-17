package tributaveis;

public class TesteTributaveis {

    public static void main(String[] args) {
        Veiculo v1 = new Veiculo("22-33-CC", 1000, "encarnado");
        System.out.println(v1);
        Veiculo v2 = new Veiculo("44-55-DD", 2500, Cores.AZUL);
        System.out.println(v2);
        Veiculo v3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        System.out.println(v3);

        Moradia m1 = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        System.out.println(m1);

        Cores algo = v1;
        algo = m1;
        System.out.println(algo);

        Object[] tributaveis = new Object[10];

        tributaveis[0] = v1;
        tributaveis[1] = v2;
        tributaveis[2] = v3;
        tributaveis[3] = m1;

        double total = 0;
        for (int i = 0; i < tributaveis.length; i++) {
            if (tributaveis[i] != null) {
                total += ((Tributavel) tributaveis[i]).calcularImposto();
            }
        }
        System.out.printf("Total de imposto: %.1f", total);

        System.out.println("");
        imprimirImposto2(m1);
    }

    private static void imprimirImposto(Tributavel t) {
        System.out.println(t.toString() + " e paga " + t.calcularImposto()
                + "€ de imposto.");

    }
    
    private static void imprimirImposto2(Object t) {
        System.out.println(((Tributavel)t).toString() + " e paga " + ((Tributavel)t).calcularImposto()
                + "€ de imposto.");

    }

}
