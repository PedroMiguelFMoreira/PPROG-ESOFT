package junho2013_2;

/**
 *
 * @author Pedro
 */
public class Data {

    private int ano;
    private int mes;
    private int dia;

    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAno() {
        return this.ano;
    }

    public int getMes() {
        return this.mes;
    }

    public int getDia() {
        return this.dia;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int diaDaSemana() {
        return 0;
    }

    public String nomeDoMes() {
        return "";
    }

    public int diasDoMes() {
        return 30;
    }

    public int semanasDoMes() {
        return 4;
    }

}
