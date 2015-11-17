/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retângulo;

/**
 *
 * @author Pedro
 */
public class TesteRetângulo {
    
    public static void main(String[] args) {
        Retângulo retangulo1 = new Retângulo(4, 3);
        
        System.out.println(retangulo1.toString());
        System.out.println("Área: " + retangulo1.calcArea());
        System.out.println("Perímetro: " + retangulo1.calcPerimetro());
    }
}
