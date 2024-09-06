package controller;
import model.Mascota;
import view.MascotasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MascotasController {
    private MascotasView view;
    private HashMap<String, Mascota> mascotas;

    public MascotasController(MascotasView view) {
        this.view = view;
        this.mascotas = new HashMap<>();
        initController();
    }

    private void initController() {
        view.getAgregarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMascota();
            }
        });

        view.getBuscarIdButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMascotaPorId();
            }
        });

        view.getBuscarNombreButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMascotaPorNombre();
            }
        });

        view.getImprimirListaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirListaMascotas();
            }
        });

        view.getSalirButton().addActionListener(e -> System.exit(0));
    }

    private void agregarMascota() {
        String id = view.getIdField().getText();
        String nombre = view.getNombreField().getText();
        String color = view.getColorField().getText();
        String edadText = view.getEdadField().getText();
        String tipo = view.getTipoField().getText();

        if (camposVacios(id, nombre, color, edadText, tipo)) {
            view.getOutputArea().setText("Por favor, complete todos los campos antes de agregar una mascota.\n");
            return;
        }

        if (mascotas.containsKey(id)) {
            view.getOutputArea().setText("La mascota con ID " + id + " ya está registrada.\n");
            return;
        }

        try {
            int edad = Integer.parseInt(edadText);
            Mascota mascota = new Mascota(id, nombre, color, edad, tipo);
            mascotas.put(id, mascota);
            view.getOutputArea().setText("Mascota agregada:\n" + mascota + "\n");
            limpiarCampos();
        } catch (NumberFormatException e) {
            view.getOutputArea().setText("Por favor, ingrese un número válido para la edad.\n");
        }
    }

    private boolean camposVacios(String... campos) {
        for (String campo : campos) {
            if (campo.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void buscarMascotaPorId() {
        String id = view.getIdField().getText();
        if (id.isEmpty()) {
            view.getOutputArea().setText("Por favor, ingrese un ID para buscar.\n");
            return;
        }

        Mascota mascota = mascotas.get(id);
        if (mascota != null) {
            view.getOutputArea().setText("Mascota encontrada:\n" + mascota + "\n");
        } else {
            view.getOutputArea().setText("No se encontró ninguna mascota con el ID: " + id + "\n");
        }
    }

    private void buscarMascotaPorNombre() {
        String nombre = view.getNombreField().getText();
        if (nombre.isEmpty()) {
            view.getOutputArea().setText("Por favor, ingrese un nombre para buscar.\n");
            return;
        }

        boolean found = false;
        for (Mascota mascota : mascotas.values()) {
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                view.getOutputArea().setText("Mascota encontrada:\n" + mascota + "\n");
                found = true;
                break;
            }
        }

        if (!found) {
            view.getOutputArea().setText("No se encontró ninguna mascota con el nombre: " + nombre + "\n");
        }
    }

    private void imprimirListaMascotas() {
        if (mascotas.isEmpty()) {
            view.getOutputArea().setText("No hay mascotas registradas.\n");
            return;
        }

        StringBuilder lista = new StringBuilder("Lista de mascotas:\n");
        for (Mascota mascota : mascotas.values()) {
            lista.append(mascota).append("\n");
        }
        view.getOutputArea().setText(lista.toString());
    }

    private void limpiarCampos() {
        view.getIdField().setText("");
        view.getNombreField().setText("");
        view.getColorField().setText("");
        view.getEdadField().setText("");
        view.getTipoField().setText("");
    }
}