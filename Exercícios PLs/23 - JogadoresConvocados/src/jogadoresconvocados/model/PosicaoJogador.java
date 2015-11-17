package jogadoresconvocados.model;

public enum PosicaoJogador {
    Guarda_Redes { public  String  toString()  { return "Guarda-Redes"; }  }, 
    Defesa, 
    Medio { public  String  toString()  { return "Médio"; }  }, 
    Avancado { public  String  toString()  { return "Avançado"; }};
}
