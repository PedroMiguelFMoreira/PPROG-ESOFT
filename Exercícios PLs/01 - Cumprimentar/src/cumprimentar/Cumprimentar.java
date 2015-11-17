/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cumprimentar;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Cumprimentar {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        
        System.out.println("Qual é o seu nome?");
        Pessoa umaPessoa = new Pessoa(ler.nextLine());
        System.out.println("Olá, " + umaPessoa.getNome());
        System.out.println(umaPessoa.toString());
        
        Pessoa outraPessoa = new Pessoa();
        System.out.println("Olá, " + outraPessoa.getNome());
        System.out.println(outraPessoa.toString());
    }
    
}
