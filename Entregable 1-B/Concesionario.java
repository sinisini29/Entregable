import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Vehiculo> vehiculos;

    public Concesionario() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}