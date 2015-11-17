package torreshanoi.model;

import java.util.Stack;

public class Haste {

    Stack<Disco> pilha;

    public Haste() {
        this.pilha = new Stack();
    }

    public Stack<Disco> getPilha() {
        return this.pilha;
    }

    @Override
    public String toString() {
        String output = "";
        
        for (Disco disco : this.pilha) {
            output += String.format("%s", disco);
        }
        
        return output;
    }

    public void push(Disco disco) {
        if (!this.pilha.isEmpty() && disco.compareTo(this.pilha.peek()) != 1) {
            throw new IllegalArgumentException(
                    "Não é possivel colocar este disco sobre um de tamanho menor.");
        }

        this.pilha.push(disco);
    }

    public Disco pop() {
        if (this.pilha.isEmpty()) {
            throw new IllegalArgumentException(
                    "A pilha não tem discos para remover.");
        }

        return this.pilha.pop();
    }
    
    public int size() {
        return this.pilha.size();
    }

}
