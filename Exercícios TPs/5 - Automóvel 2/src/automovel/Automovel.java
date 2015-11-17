package automovel;

import biblioteca.Pessoa;

public class Automovel {

    private String marca;
    private Pessoa proprietario;
    private Matricula matricula;
    
    private static final String MARCA_POR_OMISSAO = "semmarca";
    private static final Pessoa PROPRIETARIO_POR_OMISSAO = new Pessoa();
    private static final Matricula MATRICULA_POR_OMISSAO = new Matricula();

    public Automovel(String marca, Pessoa proprietario, Matricula matricula) {
        this.marca = marca;
        this.proprietario = proprietario;
        this.matricula = new Matricula(matricula);
    }

    public Automovel() {
        this(Automovel.MARCA_POR_OMISSAO, Automovel.PROPRIETARIO_POR_OMISSAO, Automovel.MATRICULA_POR_OMISSAO);
    }
    
    public Automovel(Automovel outroAutomovel) {
        this.marca = outroAutomovel.getMarca();
        this.proprietario = outroAutomovel.getProprietario();
        this.matricula = new Matricula(outroAutomovel.getMatricula());
    }

    public String getMarca() {
        return this.marca;
    }
    
    public Pessoa getProprietario() {
        return this.proprietario;
    }

    public Matricula getMatricula() {
        return new Matricula(this.matricula);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula.setMatricula(matricula.getMatricula());
        this.matricula.setDataRegisto(matricula.getDataRegisto());
    }

    @Override
    public String toString() {
        return String.format("Automóvel: Marca = %s, Proprietário = %s, Matricula = %s",
                this.marca, this.proprietario, this.matricula);
    }
}
