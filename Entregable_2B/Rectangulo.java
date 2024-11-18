package Entregable_2B;

public class Rectangulo extends Forma{
    private double ancho;
    private double alto;
    
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double Area() {
        return ancho * alto;
    }

    @Override
    public String getDescripcion() {
        return "Rectángulo de Ancho: " + ancho + "y  Alto: " + alto + ")";
    }
}
