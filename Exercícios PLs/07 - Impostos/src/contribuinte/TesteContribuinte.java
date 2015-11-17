/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contribuinte;

/**
 *
 * @author Pedro
 */
public class TesteContribuinte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Desempregado d1 = new Desempregado("Abel Andrade", "Rua da tia dele", 5000, 12);
        TrabOutrem to1 = new TrabOutrem("Soraia Freitas", "Qualquer sitio", 12000, 5000, "Ginásio sóGrossos");
        TrabOutrem to2 = new TrabOutrem("Pedro Moreira", "Avenida Larga", 30001, 1000, "Contrabando");
        TrabCPropria tcp1 = new TrabCPropria("Rita Neves", "Rua dela", 2500, 50001, "Dançaria exótica");
        TrabCPropria tcp2 = new TrabCPropria("Diogo Azevedo", "Rua do paralelo alebantado", 30000, 20000, "Gigolo");
        Reformado r1 = new Reformado("Andreia Moreira", "Rua dos lacinhos", 10, 10000);

        Contribuinte[] contentores = new Contribuinte[10];

        contentores[0] = d1;
        contentores[1] = to1;
        contentores[2] = to2;
        contentores[3] = tcp1;
        contentores[4] = tcp2;
        contentores[5] = r1;

        System.out.println("\nContribuintes:");
        for (Contribuinte contentor : contentores) {
            if (contentor instanceof Contribuinte) {
                System.out.println(contentor);
                System.out.println("Imposto a pagar: " + contentor.calcularImposto() + "€.");
            }
        }

        System.out.println("\nDesempregados:");
        for (Contribuinte contentor : contentores) {
            if (contentor instanceof Desempregado) {
                System.out.println(contentor);
            }
        }

    }

}
