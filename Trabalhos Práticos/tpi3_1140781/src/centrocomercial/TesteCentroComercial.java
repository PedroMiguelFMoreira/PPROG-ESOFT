package centrocomercial;

/**
 * Classe de testes, esta classe tem como funcionalidade testar o comportamento
 * da classe Centro Comercial quando devidamente instânciada.
 *
 * @author Pedro
 */
public class TesteCentroComercial {

    public static void main(String[] args) {
        /**
         * Instâncias de lojas
         */
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
        LojaComumQuiosque lcq2 = new LojaComumQuiosque(11, "Loja de Gomas", 11, 26000, 3);
        LojaComumQuiosque lcq3 = new LojaComumQuiosque(12, "Quiosque", 9, 22000, 3);

        /**
         * Instância de um centro comercial sem nada e alteração do nome
         */
        CentroComercial cc1 = new CentroComercial();
        cc1.setNome("Parque Nascente");

        /**
         * Adição das lojas ao centro comercial
         */
        cc1.addLoja(lap1);
        cc1.addLoja(lap2);
        cc1.addLoja(lap3);
        cc1.addLoja(lae1);
        cc1.addLoja(lae2);
        cc1.addLoja(lcr1);
        cc1.addLoja(lcr2);
        cc1.addLoja(lcr3);
        cc1.addLoja(lcr4);
        cc1.addLoja(lcq1);
        cc1.addLoja(lcq2);
        cc1.addLoja(lcq3);
        
        lap1.setDescr("fnac");

        double totalAncoraSeguranca = 0, totalComumRenda = 0, custoSeguranca, valorRenda;
        System.out.println(cc1.getNome());
        for (Loja loja : cc1.getListaLojas()) {
            System.out.printf("%s:%n", loja.getDescr());

            if (loja instanceof Seguranca) {
                custoSeguranca = ((Seguranca) loja).calcularSeguranca();
                System.out.printf("- Valor do custo de segurança: %.2f€%n", custoSeguranca);
                if (loja instanceof LojaAncora) {
                    totalAncoraSeguranca += custoSeguranca;
                }
            }

            if (loja instanceof Renda) {
                valorRenda = ((Renda) loja).calcularRenda();
                System.out.printf("- Valor da renda: %.2f€%n", valorRenda);
                if (loja instanceof LojaComum) {
                    totalComumRenda += valorRenda;
                }
            }
        }

        System.out.printf("%n### Receitas ###%n"
                + "Total dos custos de segurança das Lojas Âncora: %.2f€%n"
                + "Total das rendas das Lojas Comuns: %.2f€%n"
                + "Valor das receitas mensais do centro comercial: %.2f€%n", totalAncoraSeguranca, totalComumRenda, cc1.calcularReceitas());

    }

}
