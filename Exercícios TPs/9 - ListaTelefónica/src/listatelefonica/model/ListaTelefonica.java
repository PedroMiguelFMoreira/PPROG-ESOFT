package listatelefonica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTelefonica implements Serializable {
    
    private List<Telefone> listaTelefonica;

    public ListaTelefonica() {
        this.listaTelefonica = new ArrayList<>();
    }
    
    public ListaTelefonica(List<Telefone> listaTelefonica){
        this.listaTelefonica = new ArrayList<>(listaTelefonica);
    }

    public List<Telefone> getListaTelefonica() {
        return new ArrayList(listaTelefonica);
    }

    public void setListaTelefonica(List<Telefone> listaTelefonica) {
        this.listaTelefonica.clear();
        this.listaTelefonica.addAll(listaTelefonica);
    }
    
    public Telefone getTelefone(int indice){
        return this.listaTelefonica.get(indice);
    }
    
    public Telefone setTelefone(int indice, Telefone telefone){
        return this.listaTelefonica.set(indice, telefone);
    }
    
    public boolean adicionarTelefone(Telefone telefone) {
        return this.listaTelefonica.contains(telefone)
                ? false
                : this.listaTelefonica.add(telefone);
    }
    
    public int adicionarListaTelefonica(ListaTelefonica listaTelefonica){
        int totalTelefonesAdicionados = 0;
        for (Telefone telefone : listaTelefonica.getListaTelefonica()) {
            boolean telefoneAdicionado = this.adicionarTelefone(telefone);
            if(telefoneAdicionado){
                totalTelefonesAdicionados++;
            }
        }
        return totalTelefonesAdicionados;
    }
    
    public boolean removerTelefone(Telefone telefone){
        return this.listaTelefonica.remove(telefone);
    }
    
    public Telefone removerTelefone(int indice){
        return this.listaTelefonica.remove(indice);
    }
    
    public boolean removerTodos(ListaTelefonica listaTelefonica){
        return this.listaTelefonica.removeAll(listaTelefonica.getListaTelefonica());
    }
    
    public int obterIndiceDeTelefone(Telefone telefone){
        return this.listaTelefonica.indexOf(telefone);
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
        return this.listaTelefonica.toArray(
                new Telefone[this.listaTelefonica.size()]);
    }

    @Override
    public String toString() {
        Collections.sort(this.listaTelefonica);
        StringBuilder s = new StringBuilder();
        for (Telefone telefone : this.listaTelefonica) {
            s.append(telefone);
            s.append("\n");
        }
        return String.format("Lista Telefónica%n%s", s.toString());
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
