package testes;

import automovel.Automovel;
import automovel.Matricula;
import biblioteca.Data;
import biblioteca.Pessoa;

public class TesteAutomovel {


    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Jorge", 1234567);
        Data d1 = new Data(2012, 2, 2);
        Matricula m1 = new Matricula("11-11-AA", d1);
        Automovel a1 = new Automovel("KIA", p1, m1);

        System.out.println("## Alterado nome ##");
        p1.setNome("Jorge Paixão");
        System.out.println(p1);

        System.out.println("## Tentativa de alterar a matricula ##");
        m1.setMatricula("22-22-BB");
        System.out.println(m1);
        System.out.println(a1);
        
        System.out.println("## Tentativa de alterar a data ##");
        d1.setData(2013, 3, 3);
        System.out.println(m1);
        System.out.println(a1);
        
        System.out.println("## Tentativa de altetar a matricula e a data ##");
        a1.setMatricula(m1);
        System.out.println(a1);
        
        System.out.println("## Tentativa de mudar a marca ##");
        a1.setMarca("BMW");
        System.out.println(a1);
        // A variável marca está guarda dentro da instância a1
        
        Automovel a2 = new Automovel(a1);
        
        System.out.println("Automóveis ");
        a1.setMatricula(new Matricula("33-33-CC", new Data(1989, 05, 22)));
        System.out.println(a1);
        System.out.println(a2);
        
        
    }
    
}
