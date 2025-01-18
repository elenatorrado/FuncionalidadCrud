package es.TiendecitaETG2.Vista;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;
import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControladorPrincipal controlador;

    public PantallaInicio() {
    	setBackground(new Color(255, 182, 193));
        controlador = new ControladorPrincipal();

        setTitle("Gestión de Artículos y Tickets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArticulos = new JMenu("Artículos");
        menuBar.add(mnArticulos);

        JMenuItem itemAltaArticulo = new JMenuItem("Alta");
        mnArticulos.add(itemAltaArticulo);
        itemAltaArticulo.addActionListener(e -> abrirAltaArticulo());

        JMenuItem itemConsultaArticulo = new JMenuItem("Consulta");
        mnArticulos.add(itemConsultaArticulo);
        itemConsultaArticulo.addActionListener(e -> abrirConsultaArticulo());

        JMenuItem itemModificacionArticulo = new JMenuItem("Modificación");
        mnArticulos.add(itemModificacionArticulo);
        itemModificacionArticulo.addActionListener(e -> abrirModificacionArticulo());

        JMenuItem itemBajaArticulo = new JMenuItem("Baja");
        mnArticulos.add(itemBajaArticulo);
        itemBajaArticulo.addActionListener(e -> abrirBajaArticulo());

        JMenu mnTickets = new JMenu("Tickets");
        menuBar.add(mnTickets);

        JMenuItem itemAltaTicket = new JMenuItem("Alta");
        mnTickets.add(itemAltaTicket);
        itemAltaTicket.addActionListener(e -> abrirAltaTicket());

        JMenuItem itemConsultaTicket = new JMenuItem("Consulta");
        mnTickets.add(itemConsultaTicket);
        itemConsultaTicket.addActionListener(e -> abrirConsultaTicket());

        contentPaneSetup();
    }

    private void contentPaneSetup() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 206, 209));
        panel.setLayout(null);
        JLabel label = new JLabel("Bienvenido al sistema de gestión de Tiendecita", JLabel.CENTER);
        label.setBounds(10, 69, 434, 79);
        label.setForeground(new Color(255, 250, 240));
        panel.add(label);
        setContentPane(panel);
    }

    private void abrirAltaArticulo() {
        AltaArticulo vista = new AltaArticulo(controlador);
        vista.setVisible(true);
    }

    private void abrirConsultaArticulo() {
        ConsultaArticulo vista = new ConsultaArticulo(controlador);
        vista.setVisible(true);
    }

    private void abrirModificacionArticulo() {
        ModificarArticulo vista = new ModificarArticulo(controlador);
        vista.setVisible(true);
    }

    private void abrirBajaArticulo() {
        BajaArticulo vista = new BajaArticulo(controlador);
        vista.setVisible(true);
    }

    private void abrirAltaTicket() {
        AltaTicket vista = new AltaTicket(controlador);
        vista.setVisible(true);
    }

    private void abrirConsultaTicket() {
        ConsultaTicket vista = new ConsultaTicket(controlador);
        vista.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PantallaInicio inicio = new PantallaInicio();
            inicio.setVisible(true);
        });
    }
}
