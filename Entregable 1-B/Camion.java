public class Camion extends Carro {
    public Camion(String marca, String modelo, double precio){
        super(marca, modelo, precio);
    }
    @Override
    public String getTipo(){
        return "Camion";
    }
}
