package automovel;

public class TesteAutomovel {

    public static void main(String[] args) {
        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400);
        System.out.println(a1.toString());
        System.out.println("Matrícula: " + a1.getMatricula());
        System.out.println("Instâncias: " + Automovel.getTotalAutos());
        
        Automovel a2 = new Automovel("22-22-BB", "Audi");
        System.out.println(a2.toString());
        a2.setCilindrada(1800);
        System.out.println(a2.toString());
        System.out.println("Instâncias: " + Automovel.getTotalAutos());
        
        System.out.println("Diferença: " + a1.diferencaCilindrada(a2) + " cc.");
        
        if(a1.isSuperior(a2)) {
            System.out.println("Matrícula: " + a1.getMatricula());
        } else if (a2.isSuperior(a1)){
            System.out.println("Matrícula: " + a2.getMatricula());
        } else {
            System.out.println("As cilindradas são iguais.");
        }
    }
    
}
