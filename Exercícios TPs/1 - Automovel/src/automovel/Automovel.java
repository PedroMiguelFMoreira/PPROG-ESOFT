package automovel;

/**
 * Representa um automóvel através da matricula, marca e cilindrada.
 * @author Pedro
 */
public class Automovel {

    /**
     * 
     */
    private String matricula;

    /**
     * 
     */
    private String marca;

    /**
     * 
     */
    private int cilindrada;

    /**
     * 
     */
    private static int totalAutos = 0;

    /**
     * 
     * @param matricula A matricula do automóvel
     * @param marca A marca do automóvel
     * @param cilindrada A cilindrada do automóvel
     */
    public Automovel(String matricula, String marca, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.cilindrada = cilindrada;
        totalAutos++;
    }

    /**
     * 
     * @param matricula
     * @param marca 
     */
    public Automovel(String matricula, String marca) {
        this(matricula, marca, 0);
    }

    /**
     * 
     */
    public Automovel() {
        this("sem matricula", "sem marca", 0);
    }

    /**
     * 
     * @param outroAutomovel 
     */
    public Automovel(Automovel outroAutomovel) {
        this.matricula = outroAutomovel.getMatricula();
        this.marca = outroAutomovel.getMarca();
        this.cilindrada = outroAutomovel.getCilindrada();
        Automovel.totalAutos++;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public void setMatricula(String novaMatricula) {
        this.matricula = novaMatricula;
    }

    public void setMarca(String novaMarca) {
        this.marca = novaMarca;
    }

    public void setCilindrada(int novaCilindrada) {
        this.cilindrada = novaCilindrada;
    }

    @Override
    public String toString() {
        //return "O automóvel com a matrícula " + this.matricula + ", é um " + this.marca + " e tem cilindrada de " + this.cilindrada + " cc.";
        return String.format("O automóvel com a matriculo %s é um %s e tem cilindrada %d cc.", this.matricula, this.marca, this.cilindrada);
    }

    public int diferencaCilindrada(Automovel outroAuto) {
        return Math.abs(this.cilindrada - outroAuto.getCilindrada());
    }

    public boolean isSuperior(Automovel outroAuto) {
        return this.cilindrada > outroAuto.getCilindrada();
    }

    public boolean isSuperior(int valor) {
        return this.cilindrada > valor;
    }

    public static int getTotalAutos() {
        return Automovel.totalAutos;
    }

}
