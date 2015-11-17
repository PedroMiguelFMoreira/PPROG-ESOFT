package utilitarios;

import java.util.Calendar;

/**
 * Representa um tempo através da hora, minuto e segundo.
 *
 * @author ISEP-DEI-PPROG
 */
public class Tempo implements Comparable<Tempo> {

    /**
     * A hora do tempo.
     */
    private int hora;

    /**
     * Os minutos do tempo.
     */
    private int minuto;

    /**
     * Os segundos do tempo.
     */
    private int segundo;

    /**
     * A hora por omissão.
     */
    private static final int HORA_POR_OMISSAO = 0;

    /**
     * Os minutos por omissão.
     */
    private static final int MINUTOS_POR_OMISSAO = 0;

    /**
     * Os segundos por omissão.
     */
    private static final int SEGUNDOS_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Tempo recebendo a hora, minutos e segundos.
     *
     * @param hora    a hora do tempo.
     * @param minuto  os minutos do tempo.
     * @param segundo os segundos do tempo.
     */
    public Tempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     * Constrói uma instância de Tempo recebendo a hora e os minutos e assumindo
     * os segundos por omissão.
     *
     * @param hora   a hora do tempo.
     * @param minuto os minutos do tempo.
     */
    public Tempo(int hora, int minuto) {
        this(hora, minuto, Tempo.SEGUNDOS_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Tempo recebendo a hora e assumindo os minutos e
     * os segundos, por omissão.
     *
     * @param hora a hora do tempo.
     */
    public Tempo(int hora) {
        this(hora, Tempo.MINUTOS_POR_OMISSAO, Tempo.SEGUNDOS_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Tempo com a hora, minutos e segundos, por
     * omissão.
     */
    public Tempo() {
        this(Tempo.HORA_POR_OMISSAO,
                Tempo.MINUTOS_POR_OMISSAO,
                Tempo.SEGUNDOS_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Tempo com as mesmas caraterísticas do tempo
     * recebido por parâmetro.
     *
     * @param outroTempo o tempo com as características a copiar.
     */
    public Tempo(Tempo outroTempo) {
        this(outroTempo.getHora(),
                outroTempo.getMinuto(),
                outroTempo.getSegundo());
    }

    /**
     * Devolve a hora do tempo.
     *
     * @return hora do tempo.
     */
    public int getHora() {
        return this.hora;
    }

    /**
     * Devolve os minutos do tempo.
     *
     * @return minutos do tempo.
     */
    public int getMinuto() {
        return this.minuto;
    }

    /**
     * Devolve os segundos do tempo.
     *
     * @return segundos do tempo.
     */
    public int getSegundo() {
        return this.segundo;
    }

    /**
     * Modifica a hora do tempo.
     *
     * @param hora a nova hora do tempo.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Modifica os minutos do tempo.
     *
     * @param minuto os novos minutos do tempo.
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Modifica os segundos do tempo.
     *
     * @param segundo os novos segundos do tempo.
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * Modifica a hora, os minutos e os segundos do tempo.
     *
     * @param hora    a nova hora do tempo.
     * @param minuto  os novos minutos do tempo.
     * @param segundo os novos segundos do tempo.
     */
    public void setTempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     * Devolve a descrição textual do tempo no formato: %02d:%02d:%02d AM/PM.
     *
     * @return caraterísticas do tempo.
     */
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (this.hora == 12 || this.hora == 0) ? 12 : this.hora % 12,
                this.minuto, this.segundo, this.hora < 12 ? "AM" : "PM");
    }

    /**
     * Devolve o tempo no formato: %02d%02d%02d.
     *
     * @return caraterísticas do tempo.
     */
    public String toStringHHMMSS() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto,
                this.segundo);
    }

    /**
     * Compara o tempo com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com o tempo.
     * @return true se o objeto recebido representar outro tempo equivalente ao
     *         tempo. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tempo outroTempo = (Tempo) outroObjeto;
        return this.hora == outroTempo.hora && this.minuto == outroTempo.minuto
                && this.segundo == outroTempo.segundo;
    }
    
    /**
     * Compara o tempo com o outro tempo recebido por parâmetro.
     * 
     * @param outroTempo o tempo a ser comparado.
     * @return o valor 0 se o outroTempo recebido é igual ao tempo; o valor -1
     *         se o outroTempo for posterior ao tempo; o valor 1 se o outroTempo 
     *         for anterior ao tempo.
     */    
    @Override
    public int compareTo(Tempo outroTempo) {
        return (outroTempo.isMaior(this)) ? -1 : (this.isMaior(outroTempo)) ? 1 : 0;
    }     

    /**
     * Aumenta o tempo em um segundo.
     */
    public void tick() {
        this.segundo = ++this.segundo % 60;
        if (this.segundo == 0) {
            this.minuto = ++this.minuto % 60;
            if (this.minuto == 0) {
                this.hora = ++this.hora % 24;
            }
        }
    }

    /**
     * Devolve o número de segundos correspondente ao tempo.
     *
     * @return número de segundos correspondente ao tempo.
     */
    private int segundos() {
        return this.hora * 3600 + this.minuto * 60 + this.segundo;
    }

    /**
     * Devolve true se o tempo for maior do que o tempo recebido por parâmetro.
     * Se o tempo for menor ou igual ao tempo recebido por parâmetro, devolve
     * false.
     *
     * @param outroTempo o outro tempo com o qual se compara o tempo.
     * @return true se o tempo for maior do que o tempo recebido por parâmetro,
     *         caso contrário devolve false.
     */
    public boolean isMaior(Tempo outroTempo) {
        return this.segundos() > outroTempo.segundos();
    }

    /*
     * Solução alternativa 
     * public boolean isMaior(Tempo outroTempo){ 
     *      if ( this.hora > outroTempo.hora || 
     *          (this.hora==outroTempo.hora && this.minuto>outroTempo.minuto) || 
     *          (this.hora==outroTempo.hora && this.minuto==outroTempo.minuto &&
     *           this.segundo > outroTempo.segundo) ) 
     *         return true;
     *      return false;
     * }
     */
    /**
     * Devolve true se o tempo for maior do que o tempo (hora, minutos e
     * segundos) recebido por parâmetro. Se o tempo for menor ou igual ao tempo
     * (hora, minutos e segundos) recebido por parâmetro, devolve false.
     *
     * @param hora    a outra hora do tempo com o qual se compara o tempo.
     * @param minuto  os outros minutos do tempo com o qual se compara o tempo.
     * @param segundo os outros segundos do tempo com o qual se compara o tempo.
     * @return true se o tempo for maior do que o tempo (hora, minutos e
     *         segundos) recebido por parâmetro, caso contrário devolve false.
     */
    public boolean isMaior(int hora, int minuto, int segundo) {
        Tempo outroTempo = new Tempo(hora, minuto, segundo);
        return this.segundos() > outroTempo.segundos();
    }

    /**
     * Devolve a diferença em segundos entre o tempo e o tempo recebido por
     * parâmetro.
     *
     * @param outroTempo o outro tempo com o qual se compara o tempo para
     *                   calcular a diferença em segundos.
     * @return diferença em segundos entre o tempo e o tempo recebido por
     *         parâmetro.
     */
    public int diferencaEmSegundos(Tempo outroTempo) {
        return Math.abs(this.segundos() - outroTempo.segundos());
    }

    /**
     * Devolve uma instância Tempo representativa da diferença entre o tempo e
     * o tempo recebido por parâmetro.
     *
     * @param outroTempo o outro tempo com o qual se compara o tempo para obter
     *                   uma instãncia Tempo representativa da diferença entre 
     *                   o tempo e o tempo recebido por parâmetro.
     * @return instância Tempo representativa da diferença entre o tempo e o
     *         tempo recebido por parâmetro.
     */
    public Tempo diferencaEmTempo(Tempo outroTempo) {
        int dif = this.diferencaEmSegundos(outroTempo);
        int s = dif % 60;
        dif = dif / 60;
        int m = dif % 60;
        int h = dif / 60;
        return new Tempo(h, m, s);
    }
    
    /**
     * Devolve o tempo atual do sistema.
     * 
     * @return o tempo atual do sistema.
     */
    public static Tempo tempoAtual() {
        Calendar agora = Calendar.getInstance();
        int hora = agora.get(Calendar.HOUR_OF_DAY);
        int minuto = agora.get(Calendar.MINUTE);
        int segundo = agora.get(Calendar.SECOND);
        return new Tempo(hora,minuto,segundo);
    }    

}