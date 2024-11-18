public abstract class Vehiculo{

    protected String marca;
    protected String modelo;
    protected double precio;

    public Vehiculo(String marca, String modelo, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca(){return marca;}
    public String getModelo(){return modelo;}
    public double getPrecio(){return precio;}

    public abstract String getTipo();

}