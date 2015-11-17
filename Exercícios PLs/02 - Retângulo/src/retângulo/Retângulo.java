/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retângulo;

/**
 *
 * @author Pedro
 */
public class Retângulo {

    private final double comprimento;
    private final double largura;

    public Retângulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double calcArea() {
        return this.comprimento * this.largura;
    }

    public double calcPerimetro() {        
        return (this.comprimento * 2) + (this.largura * 2);
    }
    
    @Override
    public String toString() {
        return String.format("Comprimento: %.1f%nLargura: %.1f", this.comprimento, this.largura);
    }

}
