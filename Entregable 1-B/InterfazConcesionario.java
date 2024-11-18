import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazConcesionario extends JFrame {
    private Concesionario concesionario;
    private JTextArea areaListado;

    public InterfazConcesionario() {
        concesionario = new Concesionario();
        setTitle("Concesionario de Vehículos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para añadir vehículos
        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(new GridLayout(5, 2));
        
        JTextField campoMarca = new JTextField();
        JTextField campoModelo = new JTextField();
        JTextField campoPrecio = new JTextField();
        
        String[] tipos = {"Motocicleta", "Automóvil", "Camión"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JButton botonAgregar = new JButton("Agregar Vehículo");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = campoMarca.getText();
                String modelo = campoModelo.getText();
                double precio = Double.parseDouble(campoPrecio.getText());
                String tipo = (String) comboTipo.getSelectedItem();

                Vehiculo vehiculo;
                if (tipo.equals("Motocicleta")) {
                    vehiculo = new Moto(marca, modelo, precio);
                } else if (tipo.equals("Automóvil")) {
                    vehiculo = new Carro(marca, modelo, precio);
                } else {
                    vehiculo = new Camion(marca, modelo, precio);
                }
                concesionario.agregarVehiculo(vehiculo);
                actualizarListado();
                limpiarCampos();
            }

            private void limpiarCampos() {
                campoMarca.setText("");
                campoModelo.setText("");
                campoPrecio.setText("");
            }
        });

        panelAgregar.add(new JLabel("Marca:"));
        panelAgregar.add(campoMarca);
        panelAgregar.add(new JLabel("Modelo:"));
        panelAgregar.add(campoModelo);
        panelAgregar.add(new JLabel("Precio:"));
        panelAgregar.add(campoPrecio);
        panelAgregar.add(new JLabel("Tipo:"));
        panelAgregar.add(comboTipo);
        panelAgregar.add(botonAgregar);

        // Area de listado
        areaListado = new JTextArea();
        areaListado.setEditable(false);
        JScrollPane scrollListado = new JScrollPane(areaListado);

        add(panelAgregar, BorderLayout.NORTH);
        add(scrollListado, BorderLayout.CENTER);
    }

    private void actualizarListado() {
        StringBuilder listado = new StringBuilder();
        for (Vehiculo v : concesionario.getVehiculos()) {
            listado.append(v.getTipo())
                    .append(" - Marca: ").append(v.getMarca())
                    .append(", Modelo: ").append(v.getModelo())
                    .append(", Precio: $").append(v.getPrecio())
                    .append("\n");
        }
        areaListado.setText(listado.toString());
    }

    public static void main(String[] args) {
        InterfazConcesionario frame = new InterfazConcesionario();
        frame.setVisible(true);
    }
}

