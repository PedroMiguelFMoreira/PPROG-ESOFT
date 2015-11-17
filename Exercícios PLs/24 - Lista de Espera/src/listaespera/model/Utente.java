package listaespera.model;

public class Utente {
    
    private String nome;
    
    public Utente(String nome) {
        setNome(nome);
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do utente não pode estar vazio");
        }
        
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return String.format("Utente: %s", getNome());
    }
    
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        
        if (outroObjeto == null || this.getClass() == outroObjeto.getClass()) {
            return false;
        }
        
        Utente outroUtente = (Utente) outroObjeto;
        
        return this.getNome().equals(outroUtente.getNome());
    }
    
}
