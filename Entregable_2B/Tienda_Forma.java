package Entregable_2B;

import java.util.ArrayList;

public class Tienda_Forma {
    private ArrayList<Forma> formas;

    // Constructor para inicializar la lista
    public Tienda_Forma() {
        formas = new ArrayList<>(); // Se inicializa la lista para evitar errores
    }

    // Método para agregar una forma a la lista
    public void Agregar_Forma(Forma forma) {
        formas.add(forma);
    }

    // Método para obtener la lista de formas
    public ArrayList<Forma> getFormas() {
        return formas;
    }
}
