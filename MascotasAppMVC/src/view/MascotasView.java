package view;
import javax.swing.*;
import java.awt.*;

public class MascotasView extends JFrame {
    private JTextField idField, nombreField, colorField, edadField, tipoField;
    private JTextArea outputArea;
    private JButton agregarButton, buscarIdButton, buscarNombreButton, imprimirListaButton, salirButton;

    public MascotasView() {
        setTitle("Gestión de Mascotas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Datos de la Mascota"));


        idField = createFormField(inputPanel, "ID:");
        nombreField = createFormField(inputPanel, "Nombre:");
        colorField = createFormField(inputPanel, "Color:");
        edadField = createFormField(inputPanel, "Edad:");
        tipoField = createFormField(inputPanel, "Tipo:");


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Opciones"));


        agregarButton = createButton(buttonPanel, "Agregar Mascota");
        buscarIdButton = createButton(buttonPanel, "Buscar ID");
        buscarNombreButton = createButton(buttonPanel, "Buscar Nombre");
        imprimirListaButton = createButton(buttonPanel, "Imprimir Lista");


        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Salida de Datos"));


        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);


        add(mainPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);


        salirButton = new JButton("Salir");
        add(salirButton, BorderLayout.SOUTH);
    }


    private JTextField createFormField(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
        JTextField textField = new JTextField();
        panel.add(label);
        panel.add(textField);
        return textField;
    }


    private JButton createButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        panel.add(button);
        return button;
    }


    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getColorField() {
        return colorField;
    }

    public JTextField getEdadField() {
        return edadField;
    }

    public JTextField getTipoField() {
        return tipoField;
    }

    public JTextArea getOutputArea() {
        return outputArea;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getBuscarIdButton() {
        return buscarIdButton;
    }

    public JButton getBuscarNombreButton() {
        return buscarNombreButton;
    }

    public JButton getImprimirListaButton() {
        return imprimirListaButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }
}