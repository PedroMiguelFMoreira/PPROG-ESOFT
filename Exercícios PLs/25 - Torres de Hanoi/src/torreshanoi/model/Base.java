/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torreshanoi.model;

import java.util.Arrays;

/**
 *
 * @author Pedro
 */
public class Base {
    
    private Haste[] listaHastes;
    private static final int numeroHastes = 3;
    
    public Base() {
        this.listaHastes = new Haste[Base.numeroHastes];

        for (int i = 0; i < Base.numeroHastes; i++) {
            this.listaHastes[i] = new Haste();
        }
    }
    
    public Haste[] getListaHastes() {
        return this.listaHastes;
    }
    
    public Haste getHaste(int indice) {
        return this.listaHastes[indice];
    }
    
    public void moverDisco(int i, int j) {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            throw new IllegalArgumentException("Não introduziu uma haste válida!");
        } else if(i == j) {
            throw new IllegalArgumentException("Não pode realizar jogadas sobre a mesma haste!");
        }
        Disco disco = this.listaHastes[i].pop();
        
        this.listaHastes[j].push(disco);
    }
    
    @Override
    public String toString() {
        String output = "";
        
        int i = 0;
        for (Haste haste : this.listaHastes) {
            output += String.format("Haste %d: %s%n", ++i, haste);
            
        }
        
        return output;
    }
    
}
