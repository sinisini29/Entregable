package Entregable_2B;

public class Circulo extends Forma {
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    } 
    
    @Override
    public double Area(){
        return Math.PI * (radio*radio);
    }

    @Override
    public String getDescripcion(){
        return "El circulo de radio: "+ radio;
    }

    
}
