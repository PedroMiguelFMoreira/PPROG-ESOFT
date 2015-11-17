package automovel;

import biblioteca.Data;

public class Matricula {

    private String matricula;
    private Data dataRegisto;  // Classe Data da Biblioteca 
    private static String MATRICULA_POR_OMISSAO = "sem matrícula";
    private static Data DATAREGISTO_POR_OMISSAO = new Data();

    public Matricula(String matricula, Data dataRegisto) {
        this.matricula = matricula;
        this.dataRegisto = dataRegisto;
    }

    public Matricula() {
        this(Matricula.MATRICULA_POR_OMISSAO, Matricula.DATAREGISTO_POR_OMISSAO);
    }

    public Matricula(Matricula outraMatricula) {
        this(outraMatricula.matricula, outraMatricula.dataRegisto);
    }

    public String getMatricula() {
        return this.matricula;
    }

    public Data getDataRegisto() {
        return this.dataRegisto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDataRegisto(Data dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    @Override
    public String toString() {
        return this.matricula + " registada em "
                + this.dataRegisto.toAnoMesDiaString();
    }
}
