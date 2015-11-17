package tempo;

public class TesteTempo {

    public static void main(String[] args) {
        Tempo t1 = new Tempo(18, 5, 10);
        System.out.println(t1.toAmPmString());
        t1.incrementarSegundo();
        System.out.println(t1.toAmPmString());
        
        Tempo t2 = new Tempo(18, 5, 20);
        System.out.println(t2.toAmPmString());
        
        if(t1.isTempoMaior(t2)) {
            System.out.println(t1 + " é maior que " + t2);
        } else if (t2.isTempoMaior(t1)) {
            System.out.println(t1 + " é menor que " + t2);
        } else {
            System.out.println(t1 + " é igual a " + t2);
        }
        
        if (t1.isTempoMaior(23, 7, 4)) {
            System.out.println(t1 + " é maior que 23:07:04");
        } else {
            System.out.println(t1 + " é menor que 23:07:04");
        }
        
        System.out.println(t1.verDiferencaSegundos(t2) + " segundos");
        System.out.println(t1.verDiferencaTempo(t2));
    }
    
}
