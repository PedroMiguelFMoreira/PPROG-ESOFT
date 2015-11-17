package animais;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        Cao c1 = new Cao("Bart");
        Cao c2 = new Cao("Fido");
        Gato g1 = new Gato("Bolinha");
        CaoRobot r1 = new CaoRobot("CaoRobot");
        Leao l1 = new Leao("Simba");
        
        ArrayList<Brincar> animais = new ArrayList<>();
        
        animais.add(c1);
        animais.add(c2);
        animais.add(g1);
        animais.add(r1);
        //animais.add(l1); 
        
        for (Brincar b : animais) {
            //if (c != null) {
                //caes[i].ladra();
            b.brinca();
            //}
        }
    }
    
}
