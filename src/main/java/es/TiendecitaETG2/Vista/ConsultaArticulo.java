package es.TiendecitaETG2.Vista;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;
import es.TiendecitaETG2.Modelo.ArticuloTicket;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConsultaArticulo extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControladorPrincipal controlador;

    public ConsultaArticulo(ControladorPrincipal controlador) {
        this.controlador = controlador;

        setTitle("Consulta de Artículos");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        List<ArticuloTicket> articulos = controlador.obtenerArticulos();
        for (ArticuloTicket articulo : articulos) {
            textArea.append(articulo + "\n");
        }

        add(scrollPane, BorderLayout.CENTER);
    }
}
