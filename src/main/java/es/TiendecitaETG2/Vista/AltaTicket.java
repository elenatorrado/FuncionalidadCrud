package es.TiendecitaETG2.Vista;

import javax.swing.*;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AltaTicket extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdTicket;
    private JTextField txtFecha;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public AltaTicket(ControladorPrincipal controlador) {
    	getContentPane().setBackground(new Color(175, 238, 238));
        setTitle("Alta de Tickets");
        setSize(411, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("ID Ticket:");
        label.setBounds(27, 11, 144, 57);
        getContentPane().add(label);
        txtIdTicket = new JTextField();
        txtIdTicket.setBounds(197, 11, 187, 57);
        getContentPane().add(txtIdTicket);

        JLabel label_1 = new JLabel("Fecha (YYYY-MM-DD):");
        label_1.setBounds(20, 84, 134, 57);
        getContentPane().add(label_1);
        txtFecha = new JTextField();
        txtFecha.setBounds(197, 84, 187, 57);
        getContentPane().add(txtFecha);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(221, 160, 221));
        btnGuardar.setBounds(22, 173, 149, 57);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(221, 160, 221));
        btnCancelar.setBounds(197, 173, 149, 57);
        getContentPane().add(btnCancelar);

        btnGuardar.addActionListener(this::guardarTicket);
        btnCancelar.addActionListener(e -> dispose());
    }

    
	public AltaTicket(int int1, String string) {
		// TODO Auto-generated constructor stub
	}


	private void guardarTicket(ActionEvent e) {
        try {
            int idTicket = Integer.parseInt(txtIdTicket.getText());
            String fecha = txtFecha.getText();

            // Llamada al controlador
            ControladorPrincipal.getInstance().guardarTicket(idTicket, fecha);

            JOptionPane.showMessageDialog(this, "Ticket guardado correctamente.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}