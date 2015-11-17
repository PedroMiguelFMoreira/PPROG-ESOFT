/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaespera.model;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Pedro
 */
public class ListaEspera {
    
    Queue<Utente> listaUtentes;
    
    public ListaEspera() {
        listaUtentes = new LinkedList();
    }
    
    public Utente novoUtente(String nome) {
        return new Utente(nome);
    }
    
    public void adicionarUtente(Utente utente) {
        if(this.listaUtentes.contains(utente)) {
            throw new IllegalArgumentException(
                    "O Utente já se encontra em lista de espera!");
        }
        
        this.listaUtentes.add(utente);
    }
    
    public void removerUtente(Utente utente) {
        if(!this.listaUtentes.contains(utente)) {
            throw new IllegalArgumentException(
                    "O utente não se encontra em lista de espera!");
        }
        
        this.listaUtentes.remove(utente);
    }
    
    public String listarUtentes() {
        String listaUtentesString = "Lista de Espera:\n";
        
        if (this.isVazia()) {
            return "Não existem utentes em fila de espera.";
        } else {
            for (Utente utente : this.listaUtentes) {
                listaUtentesString += utente.toString();
            }
        }
        
        return listaUtentesString;
    }
    
    public boolean isVazia() {
        return this.listaUtentes.isEmpty();
    }

}
