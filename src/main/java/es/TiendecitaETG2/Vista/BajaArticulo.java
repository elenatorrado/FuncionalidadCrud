package es.TiendecitaETG2.Vista;

import javax.swing.*;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;

public class BajaArticulo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdArticulo;
    private JButton btnEliminar;
    private JButton btnCancelar;

    public BajaArticulo(ControladorPrincipal controlador) {
    	getContentPane().setBackground(new Color(143, 188, 143));
        setTitle("Baja de Artículos");
        setSize(374, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("ID Artículo:");
        label.setBackground(new Color(250, 250, 210));
        label.setBounds(43, 29, 78, 47);
        getContentPane().add(label);
        txtIdArticulo = new JTextField();
        txtIdArticulo.setBounds(166, 26, 174, 47);
        getContentPane().add(txtIdArticulo);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 182, 193));
        btnEliminar.setBounds(21, 94, 125, 47);
        getContentPane().add(btnEliminar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 182, 193));
        btnCancelar.setBounds(171, 92, 145, 47);
        getContentPane().add(btnCancelar);

        btnEliminar.addActionListener(this::eliminarArticulo);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void eliminarArticulo(ActionEvent e) {
        try {
            int idArticulo = Integer.parseInt(txtIdArticulo.getText());

            // Llamada al controlador
            ControladorPrincipal.getInstance().eliminarArticulo(idArticulo);

            JOptionPane.showMessageDialog(this, "Artículo eliminado correctamente.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

