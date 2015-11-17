package empregado;

import utilitarios.Data;
import utilitarios.Tempo;

public class TesteEmpregado {

    public static void main(String[] args) {

        Data data = new Data(1989, 05, 22);
        System.out.printf(""
                + "### Data ###%n"
                + "%s%n", data);

        Tempo tempoEntrada = new Tempo(9);
        Tempo tempoSaida = new Tempo(18);
        System.out.printf("%n"
                + "### Tempos ###%n"
                + "%s%n"
                + "%s%n", tempoEntrada, tempoSaida);

        Empregado empregado1 = new Empregado("Pedro", "Moreira", data, tempoEntrada, tempoSaida);
        Empregado empregado2 = new Empregado("Tiago", "Ferreira", data, tempoEntrada, tempoSaida);

        empregado1.setDataContrato(new Data(1990, 02, 10));
        System.out.printf("%n"
                + "### Teste às referências de Data ###%n"
                + "%s%n"
                + "%s%n", empregado1.getDataContrato(), empregado2.getDataContrato());

        empregado1.setHoraEntrada(new Tempo(10));
        empregado2.setHoraSaida(new Tempo(17));
        System.out.printf("%n"
                + "### Teste às referências de Tempo ###%n"
                + "%s - %s%n"
                + "%s - %s%n", empregado1.getHoraEntrada(), empregado1.getHoraSaida(),
                empregado2.getHoraEntrada(), empregado2.getHoraSaida());

        System.out.printf("");

        data.setData(1991, 01, 01);
        tempoEntrada.setHora(11);
        tempoSaida.setHora(20);

        System.out.printf("%n"
                + "### Teste geral ###%n"
                + "Data: %s%n"
                + "Hora de Entrada: %s%n"
                + "Hora de Saída: %s%n"
                + "Empregados: %n"
                + "- %s%n"
                + "- %s%n", data, tempoEntrada, tempoSaida, empregado1, empregado2);

        empregado2.setDataContrato(new Data(1993, 07, 04));
        empregado2.setHoraEntrada(new Tempo(12));
        empregado2.setHoraSaida(new Tempo(22));

        Empregado[] empresa = new Empregado[5];
        empresa[0] = empregado1;
        empresa[1] = empregado2;

        System.out.println("\n### Lista de Empregados ###");
        for (Empregado empregado : empresa) {
            if (empregado != null) {
                System.out.println(empregado);
            }
        }

        System.out.println("\n### Info de Empregados ###");
        for (Empregado empregado : empresa) {
            if (empregado != null) {
                System.out.printf("%s %s, trabalha %d horas por semana e está na empresa à %d dias.%n",
                        empregado.getPrimeiroNome(), empregado.getUltimoNome(),
                        empregado.determinarHorasTrabalho(), empregado.determinarTempoEmpregado());
            }
        }
    }

}
