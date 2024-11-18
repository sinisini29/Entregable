package Entregable_2B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Clase base para formas geométricas
abstract class Forma {
    public abstract double Area();
    public abstract String getDescripcion();
}

// Clase para Círculo
class Circulo extends Forma {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double Area() {
        return Math.PI * radio * radio;
    }

    @Override
    public String getDescripcion() {
        return "Círculo con radio: " + radio;
    }
}

// Clase para Rectángulo
class Rectangulo extends Forma {
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
        return "Rectángulo con ancho: " + ancho + ", alto: " + alto;
    }
}

// Tienda que almacena formas
class Tienda_Forma {
    private ArrayList<Forma> formas;

    public Tienda_Forma() {
        formas = new ArrayList<>();
    }

    public void Agregar_Forma(Forma forma) {
        formas.add(forma);
    }

    public ArrayList<Forma> getFormas() {
        return formas;
    }
}

// Interfaz gráfica
public class Interfaz_Grafica extends JFrame {
    private Tienda_Forma tienda;
    private JTextArea areaListado;

    public Interfaz_Grafica() {
        tienda = new Tienda_Forma();
        setTitle("Tienda de Formas Geométricas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para agregar formas
        JPanel panelAgregar = new JPanel(new GridLayout(5, 2));

        JTextField campoRadio = new JTextField();
        JTextField campoAncho = new JTextField();
        JTextField campoAlto = new JTextField();

        String[] tipos = {"Círculo", "Rectángulo"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        // Cambiar visibilidad de campos dependiendo de la forma seleccionada
        comboTipo.addActionListener(e -> {
            String tipoSeleccionado = (String) comboTipo.getSelectedItem();
            campoRadio.setVisible(tipoSeleccionado.equals("Círculo"));
            campoAncho.setVisible(tipoSeleccionado.equals("Rectángulo"));
            campoAlto.setVisible(tipoSeleccionado.equals("Rectángulo"));
            revalidate();
            repaint();
        });

        JButton botonAgregar = new JButton("Agregar Forma");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) comboTipo.getSelectedItem();
                String mensaje = "";

                try {
                    if (tipo.equals("Círculo")) {
                        double radio = Double.parseDouble(campoRadio.getText());
                        Forma circulo = new Circulo(radio);
                        tienda.Agregar_Forma(circulo);
                        mensaje = "Se agregó un Círculo con área: " + String.format("%.2f", circulo.Area());
                    } else if (tipo.equals("Rectángulo")) {
                        double ancho = Double.parseDouble(campoAncho.getText());
                        double alto = Double.parseDouble(campoAlto.getText());
                        Forma rectangulo = new Rectangulo(ancho, alto);
                        tienda.Agregar_Forma(rectangulo);
                        mensaje = "Se agregó un Rectángulo con área: " + String.format("%.2f", rectangulo.Area());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(null, mensaje, "Información de la Forma", JOptionPane.INFORMATION_MESSAGE);
                actualizarListado();
                limpiarCampos();
            }

            private void limpiarCampos() {
                campoRadio.setText("");
                campoAncho.setText("");
                campoAlto.setText("");
            }
        });

        panelAgregar.add(new JLabel("Tipo de Forma:"));
        panelAgregar.add(comboTipo);
        panelAgregar.add(new JLabel("Radio (solo Círculo):"));
        panelAgregar.add(campoRadio);
        panelAgregar.add(new JLabel("Ancho (solo Rectángulo):"));
        panelAgregar.add(campoAncho);
        panelAgregar.add(new JLabel("Alto (solo Rectángulo):"));
        panelAgregar.add(campoAlto);
        panelAgregar.add(botonAgregar);

        // Área de listado
        areaListado = new JTextArea();
        areaListado.setEditable(false);
        JScrollPane scrollListado = new JScrollPane(areaListado);

        add(panelAgregar, BorderLayout.NORTH);
        add(scrollListado, BorderLayout.CENTER);
    }

    private void actualizarListado() {
        StringBuilder listado = new StringBuilder();
        for (Forma forma : tienda.getFormas()) {
            listado.append(forma.getDescripcion())
                   .append(" - Área: ").append(String.format("%.2f", forma.Area()))
                   .append("\n");
        }
        areaListado.setText(listado.toString());
    }

    public static void main(String[] args) {
        Interfaz_Grafica frame = new Interfaz_Grafica();
        frame.setVisible(true);
    }
}
