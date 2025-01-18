package es.TiendecitaETG2.Vista;

import javax.swing.*;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;

import java.awt.*;
import java.util.List;

public class ConsultaTicket extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaTickets;
    private JScrollPane scrollPane;

    public ConsultaTicket(ControladorPrincipal controlador) {
        setTitle("Consulta de Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID Ticket", "Fecha"};

        // Llamada al controlador
        List<Object[]> datos = ControladorPrincipal.getInstance().consultarTickets();

        Object[][] datosTabla = new Object[datos.size()][columnas.length];
        for (int i = 0; i < datos.size(); i++) {
            datosTabla[i] = datos.get(i);
        }

        tablaTickets = new JTable(datosTabla, columnas);
        scrollPane = new JScrollPane(tablaTickets);
        add(scrollPane, BorderLayout.CENTER);
    }
}
