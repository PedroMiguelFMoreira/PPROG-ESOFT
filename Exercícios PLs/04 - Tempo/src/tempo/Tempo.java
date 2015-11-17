package tempo;

public class Tempo {

    private int hora;
    private int minuto;
    private int segundo;

    public Tempo(int hora, int minuto, int segundo) {
        this.hora = hora == 24 ? 0 : hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Tempo() {
        this(0, 0, 0);
    }

    public int getHora() {
        return this.hora;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public int getSegundo() {
        return this.minuto;
    }

    public void setHora(int hora) {
        this.hora = hora == 24 ? 0 : hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    public String toAmPmString() {
        return String.format("%02d:%02d:%02d %s", this.hora < 12 ? this.hora : this.hora / 2, this.minuto, this.segundo, this.hora < 12 ? "AM" : "PM");
    }

    /**
     * Este método incremente mais um segundo no tempo.
     */
    public void incrementarSegundo() {
        this.segundo = ++this.segundo % 60;
        
        if (this.segundo == 0) {
            this.minuto = ++this.minuto % 60;
            
            if (this.minuto == 0) {
                this.hora = ++this.hora % 24;
            }
        }
        
        /**
         * Muito mais fácil usar o método de converter para segundos, somar um e
         * voltar a calcular o tempo!!! Thx PCT!!
         */        
    }

    public boolean isTempoMaior(Tempo tempo) {
        return toSegundos() > tempo.toSegundos();
    }

    public boolean isTempoMaior(int hora, int minuto, int segundo) {
        //Tempo outroTempo = new Tempo(hora, minuto, segundo);

        //return this.toSegundos() > outroTempo.toSegundos();
        return toSegundos() > toSegundos(hora, minuto, segundo);
    }

    public int verDiferencaSegundos(Tempo outroTempo) {
        return Math.abs(toSegundos() - outroTempo.toSegundos());
    }

    public String verDiferencaTempo(Tempo outroTempo) {
        int tempo = verDiferencaSegundos(outroTempo);
        
        return formatarTempo(tempo);
    }

    private int toSegundos() {
        return this.hora * 3600 + this.minuto * 60 + this.segundo;
    }
    
    private String formatarTempo(int tempo) {
        int horas = tempo / 3600;
        int minutos = tempo / 60 - horas * 60;
        int segundos = tempo - horas * 3600 - minutos * 60;
        
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    private static int toSegundos(int hora, int minutos, int segundo) {
        return hora * 3600 + minutos * 60 + segundo;
    }

}
