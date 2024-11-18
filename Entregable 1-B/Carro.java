public  class Carro extends Vehiculo{


    public Carro(String marca, String modelo, double precio){
        super(marca, modelo, precio);
    }

    @Override
    public String getTipo(){
        return "Carro";

    }

}