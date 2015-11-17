package empregado;

import utilitarios.Data;
import utilitarios.Tempo;

/**
 *
 * @author Pedro
 */
public class Empregado {
    
    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato,
            Tempo horaEntrada, Tempo horaSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public Data getDataContrato() {
        return new Data(dataContrato);
    }

    public Tempo getHoraEntrada() {
        return new Tempo(horaEntrada);
    }

    public Tempo getHoraSaida() {
        return new Tempo(horaSaida);
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato.setData(dataContrato.getAno(), dataContrato.getMes(), dataContrato.getDia());
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada.setTempo(horaEntrada.getHora(), horaEntrada.getMinuto(), horaEntrada.getSegundo());
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida.setTempo(horaSaida.getHora(), horaSaida.getMinuto(), horaSaida.getSegundo());
    }

    @Override
    public String toString() {
        return String.format("%s %s, contratado a %s, entra às %s e sai às %s.", this.primeiroNome, this.ultimoNome, this.dataContrato, this.horaEntrada, this.horaSaida);
    }
    
    public int determinarHorasTrabalho() {
        return (this.horaEntrada.diferencaEmSegundos(this.horaSaida) * 5) / 3600;
    }
    
    public int determinarTempoEmpregado() {
        return this.dataContrato.diferenca(Data.dataAtual());
    }

}
