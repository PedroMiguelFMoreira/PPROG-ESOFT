package data;

import java.util.Calendar;

public class TesteData {

    public static void main(String[] args) {

        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;
        int dia = hoje.get(Calendar.DAY_OF_MONTH);

        Data data1 = new Data(ano, mes, dia);
        System.out.println(data1.toString());

        Data data2 = new Data(1974, 04, 25);
        System.out.println(data2.toAnoMesDiaString());

        if (data1.isMaior(data2)) {
            System.out.println(data1 + " é mais recente que " + data2 + ".");
        } else if (data2.isMaior(data1)) {
            System.out.println(data2 + " é mais recente que " + data1 + ".");
        } else {
            System.out.println("As datas são iguais.");
        }

        System.out.println("Diferença entre as datas: " + data1.diferenca(data2) + " dias.");
        
        System.out.println("Dias até ao natal: " + data1.diferenca((mes < 12) ? (dia < 25) ? ano : ano + 1 : ano, 12, 25));
        
        System.out.println(data2.diaDaSemana());
        
        // Supostamente não se faz isto...
        System.out.println(data2.isAnoBissexto(data2.getAno()) ? "Foi um ano bissexto!" : "Não foi um ano bissexto!");
        
        System.out.println(Data.isAnoBissexto(data2.getAno()) ? "Foi um ano bissexto!" : "Não foi um ano bissexto!");
        
    }

}
