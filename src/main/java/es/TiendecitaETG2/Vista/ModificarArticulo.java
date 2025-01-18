package es.TiendecitaETG2.Vista;

import javax.swing.*;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;
import es.TiendecitaETG2.Modelo.ArticuloTicket;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ModificarArticulo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdArticulo;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public ModificarArticulo(ControladorPrincipal controlador) {
    	getContentPane().setBackground(new Color(176, 224, 230));
    	setBackground(new Color(176, 224, 230));
        setTitle("Modificación de Artículos");
        setSize(490, 374);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("ID Artículo:");
        label.setBounds(43, 5, 136, 54);
        getContentPane().add(label);
        txtIdArticulo = new JTextField();
        txtIdArticulo.setBounds(176, 11, 230, 43);
        getContentPane().add(txtIdArticulo);

        JLabel label_1 = new JLabel("Nueva Descripción:");
        label_1.setBounds(27, 65, 180, 54);
        getContentPane().add(label_1);
        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(176, 70, 230, 43);
        getContentPane().add(txtDescripcion);

        JLabel label_2 = new JLabel("Nuevo Precio:");
        label_2.setBounds(37, 128, 170, 54);
        getContentPane().add(label_2);
        txtPrecio = new JTextField();
        txtPrecio.setBounds(176, 134, 230, 43);
        getContentPane().add(txtPrecio);

        JLabel label_3 = new JLabel("Nuevo Stock:");
        label_3.setBounds(37, 193, 142, 54);
        getContentPane().add(label_3);
        txtStock = new JTextField();
        txtStock.setBounds(176, 193, 230, 43);
        getContentPane().add(txtStock);

        btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setBackground(new Color(221, 160, 221));
        btnGuardar.setForeground(new Color(240, 248, 255));
        btnGuardar.setBounds(10, 256, 208, 54);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(221, 160, 221));
        btnCancelar.setForeground(new Color(240, 248, 255));
        btnCancelar.setBounds(250, 256, 187, 54);
        getContentPane().add(btnCancelar);

        btnGuardar.addActionListener(this::modificarArticulo);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void modificarArticulo(ActionEvent e) {
        try {
            int idArticulo = Integer.parseInt(txtIdArticulo.getText());
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());

            // Llamada al controlador
            ControladorPrincipal.getInstance().modificarArticulo(
            	    new ArticuloTicket(idArticulo, descripcion, precio, stock, null)
            	);
            JOptionPane.showMessageDialog(this, "Artículo modificado correctamente.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}