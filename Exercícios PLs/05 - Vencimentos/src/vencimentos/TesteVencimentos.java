/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

/**
 *
 * @author Pedro
 */
public class TesteVencimentos {
    
    public static void main(String[] args) {
        TrabPeca tp = new TrabPeca("Jorge Silva", 20, 30);
        TrabCom tc = new TrabCom("Susana Ferreira", (float) 500.0, (float) 1500.0, (float) 6);
        TrabHora th = new TrabHora("Carlos Miguel", 160, (float) 3.5);
        
        Object[] trabalhador = new Object[10];
        
        trabalhador[0] = tp;
        trabalhador[1] = tc;
        trabalhador[2] = th;
        
        System.out.println("\nInstâncias de Trabalhadores:");
        for (int i = 0; i < trabalhador.length; i++) {
            // trabalhador[i] instanceof Trabalhador
            if (trabalhador[i] != null) {
                System.out.println(trabalhador[i]);
            }
        }
        
        System.out.println("\nIntâncias de Trabalhadores à hora:");
        for (int i = 0; i < trabalhador.length; i++) {
            // trabalhador[i] != null
            if (trabalhador[i] instanceof TrabHora) {
                System.out.println(trabalhador[i]);
            }
        }
        
        System.out.println("\nNomes e vencimentos:");
        for (int i = 0; i < trabalhador.length; i++) {
            if(trabalhador[i] != null) {
                System.out.println("Nome: " + ((Trabalhador)trabalhador[i]).getNome() + "Vencimento: " + ((Trabalhador)trabalhador[i]).vencimento() + "€");
            }
        }
        
        Trabalhador[] trab = new Trabalhador[10];
        trab[0] = tp;
        trab[1] = tc;
        trab[2] = th;
        
        System.out.println("Nomes e vencimentos:");
        for (int i = 0; i < trab.length; i++) {
            if(trab[i] != null) {
                System.out.println("Nome: " + trab[i].getNome() + "Vencimento: " + trab[i].vencimento() + "€");
            }
        }
    }
    
}
