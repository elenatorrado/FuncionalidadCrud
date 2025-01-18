package es.TiendecitaETG2.Vista;

import javax.swing.*;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AltaArticulo extends JFrame {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public AltaArticulo(ControladorPrincipal controlador) {
    	getContentPane().setBackground(Color.PINK);
        setTitle("Alta de Artículos");
        setSize(446, 305);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Descripción:");
        label.setBounds(62, 38, 110, 37);
        getContentPane().add(label);
        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(197, 38, 187, 37);
        getContentPane().add(txtDescripcion);

        JLabel label_1 = new JLabel("Precio:");
        label_1.setBounds(79, 86, 93, 37);
        getContentPane().add(label_1);
        txtPrecio = new JTextField();
        txtPrecio.setBounds(197, 86, 187, 37);
        getContentPane().add(txtPrecio);

        JLabel label_2 = new JLabel("Stock:");
        label_2.setBounds(79, 134, 93, 37);
        getContentPane().add(label_2);
        txtStock = new JTextField();
        txtStock.setBounds(197, 134, 187, 37);
        getContentPane().add(txtStock);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(64, 224, 208));
        btnGuardar.setBounds(57, 190, 140, 37);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(64, 224, 208));
        btnCancelar.setBounds(244, 190, 140, 37);
        getContentPane().add(btnCancelar);

        btnGuardar.addActionListener(this::guardarArticulo);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarArticulo(ActionEvent e) {
        String descripcion = txtDescripcion.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());

        // Llamada al controlador
        ControladorPrincipal.getInstance().guardarArticulo(descripcion, precio, stock);

        JOptionPane.showMessageDialog(this, "Artículo guardado correctamente.");
        dispose();
    }
}
