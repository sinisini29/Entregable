public class Moto extends Carro {
    public Moto(String marca, String modelo, double precio){
        super(marca, modelo, precio);
    }

    @Override
    public String getTipo(){
        return "Moto";
    }

}