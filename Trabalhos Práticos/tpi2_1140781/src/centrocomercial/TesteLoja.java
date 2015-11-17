package centrocomercial;

/**
 * Testa as funcionalidades das classes LojaAncoraPropria, LojaAncoraExterna,
 * LojaComumRestauracao e LojaComumQuiosque.
 * main.
 *
 * @author Pedro
 */
public class TesteLoja {

    public static void main(String[] args) {

        LojaAncoraPropria lap1 = new LojaAncoraPropria(1, "FNAC", 150, 5000000, 500);
        LojaAncoraPropria lap2 = new LojaAncoraPropria(2, "Jumbo", 400, 10000000, 1400);
        LojaAncoraPropria lap3 = new LojaAncoraPropria(3, "Leroy Merlin", 270, 4700000, 2700);

        LojaAncoraExterna lae1 = new LojaAncoraExterna(4, "Springfield", 70, 500000, 150, 6, 15);
        LojaAncoraExterna lae2 = new LojaAncoraExterna(5, "Primark", 300, 2000000, 1000, 12, 64);

        LojaComumRestauracao lcr1 = new LojaComumRestauracao(6, "McDonald's", 40, 1000000, 32, 10, 10);
        LojaComumRestauracao lcr2 = new LojaComumRestauracao(7, "Pans", 32, 500000, 7, 250, 2);
        LojaComumRestauracao lcr3 = new LojaComumRestauracao(8, "Burger King", 27, 4000000, 12, 200, 7);
        LojaComumRestauracao lcr4 = new LojaComumRestauracao(9, "KFC", 23, 2000000, 12, 500, 7);

        LojaComumQuiosque lcq1 = new LojaComumQuiosque(10, "Livraria", 10, 30000, 4);
        LojaComumQuiosque lcq2 = new LojaComumQuiosque(11, "Papelaria", 11, 26000, 3);
        LojaComumQuiosque lcq3 = new LojaComumQuiosque(12, "Quiosque27", 9, 22000, 3);

        Loja[] centrocomercial = new Loja[15];

        centrocomercial[0] = lap1;
        centrocomercial[1] = lap2;
        centrocomercial[2] = lap3;
        centrocomercial[3] = lae1;
        centrocomercial[4] = lae2;
        centrocomercial[5] = lcr1;
        centrocomercial[6] = lcr2;
        centrocomercial[7] = lcr3;
        centrocomercial[8] = lcr4;
        centrocomercial[9] = lcq1;
        centrocomercial[10] = lcq2;
        centrocomercial[11] = lcq3;
        
            System.out.printf(""
                    + "### Instâncias de lojas ###%n"
                    + "Lojas Âncora: %d%n"
                    + "Lojas Âncora Próprias: %d%n"
                    + "Lojas Comuns: %d%n", LojaAncora.getNLojas(), LojaAncoraPropria.getNLojas(), LojaComum.getNLojas());

            double totalRendasAncora = 0, totalRendasComum = 0, totalRenda;
            System.out.println("\n### Renda das lojas ###");
            for (Loja loja : centrocomercial) {
                totalRenda = 0;
                if (loja != null) {
                    if (loja instanceof LojaAncoraExterna) {
                        totalRenda = ((LojaAncoraExterna)loja).calcularRenda();
                        totalRendasAncora += totalRenda;
                    } else if (loja instanceof LojaComum) {
                        totalRenda = ((LojaComum)loja).calcularRenda();
                        totalRendasComum += totalRenda;
                    }
                    System.out.printf("%s: %s.%n", loja.getDescr(), (totalRenda != 0) ? String.format("%.2f€ de renda anual", totalRenda) : "Não paga renda");
                }
            }

            totalRenda = totalRendasAncora + totalRendasComum;

            System.out.printf("%n"
                    + "### Total das rendas ###%n"
                    + "Renda total Lojas: %.2f€%n"
                    + "Renda total Lojas Âncora: %.2f€(%.0f%%)%n"
                    + "Renda total Lojas Âncora: %.2f€(%.0f%%)%n"
                    , totalRenda, totalRendasAncora, (totalRendasAncora / totalRenda) * 100, totalRendasComum, (totalRendasComum / totalRenda) * 100);

    }

}
