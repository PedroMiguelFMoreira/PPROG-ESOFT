package listatelefonica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Arrays;
//import java.util.Set;
//import java.util.TreeSet;

public class ListaTelefonica implements Serializable {
    
    private Map<Integer, Telefone> listaTelefonica;
    
    public ListaTelefonica() {
        this.listaTelefonica = new HashMap<>();
    }
    
    public ListaTelefonica(Map<Integer, Telefone> listaTelefonica){
        this.listaTelefonica = new HashMap<>(listaTelefonica);
    }

    public Map<Integer, Telefone> getListaTelefonica() {
        return new HashMap(this.listaTelefonica);
    }

    public void setListaTelefonica(Map<Integer, Telefone> listaTelefonica) {
        this.listaTelefonica.clear();
        this.listaTelefonica.putAll(listaTelefonica);
    }
    
    public Telefone getTelefone(int numero){
        return this.listaTelefonica.get(numero);
    }
    
    public Telefone setTelefone(Telefone telefone){
        return this.listaTelefonica.put(telefone.getNumero(), telefone);
    }
    
    public boolean adicionarTelefone(Telefone telefone) {
        if (this.listaTelefonica.containsKey(telefone.getNumero())) {
            return false;
        }
        this.listaTelefonica.put(telefone.getNumero(), telefone);
        return true;
    }
    
    public int adicionarListaTelefonica(ListaTelefonica listaTelefonica) {
        int totalTelefonesAdicionados = 0;
        for (Telefone telefone : listaTelefonica.getListaTelefonica().values()) {
            boolean telefoneAdicionado = this.adicionarTelefone(telefone);
            if (telefoneAdicionado) {
                totalTelefonesAdicionados++;
            }
        }
        return totalTelefonesAdicionados;
    }
    
    public boolean removerTelefone(Telefone telefone) {
        return this.listaTelefonica.remove(telefone.getNumero()) != null;
    }
      
    public boolean removerTodos(ListaTelefonica listaTelefonica) {
        boolean telefoneRemovido = false;
        for (Telefone telefone : listaTelefonica.getListaTelefonica().values()) {
            if (this.removerTelefone(telefone)) {
                telefoneRemovido = true;
            }
        }
        return telefoneRemovido;
    }
    
    public void limpar(){
        this.listaTelefonica.clear();
    }
    
    public int tamanho(){
        return this.listaTelefonica.size();
    }
    
    public boolean isVazio(){
        return this.listaTelefonica.isEmpty();
    }
    
    public Telefone[] getArray() {
        return this.listaTelefonica.values().toArray(
                new Telefone[this.listaTelefonica.size()]);
    }

    @Override
    public String toString() {
        List<Telefone> telefones = new ArrayList(this.listaTelefonica.values());        
        Collections.sort(telefones);
        StringBuilder s = new StringBuilder();
        for (Telefone telefone : telefones) {
            s.append(telefone);
            s.append("\n");
        }
        return String.format("Lista Telefónica%n%s", s.toString());
    
//        // Alternativa
//        Set<Integer> setNumeros = this.listaTelefonica.keySet(); 
//        Integer[] arrayNumeros = setNumeros.toArray(new Integer[setNumeros.size()]);
//        Arrays.sort(arrayNumeros);            
//        StringBuilder s = new StringBuilder();
//        for (Integer numero : arrayNumeros) {
//            s.append(this.listaTelefonica.get(numero));
//            s.append("\n");
//        }
//        return String.format("Lista Telefónica%n%s", s.toString());    
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        ListaTelefonica outraListaTelefonica = (ListaTelefonica) outroObjeto;
        return this.listaTelefonica.equals(outraListaTelefonica.getListaTelefonica());
    }
}
