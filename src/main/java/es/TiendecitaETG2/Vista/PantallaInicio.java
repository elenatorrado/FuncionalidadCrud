package es.TiendecitaETG2.Vista;

import es.TiendecitaETG2.Controlador.ControladorPrincipal;
import es.studium.Jaspersoft.InformeArticulos;
import es.studium.Jaspersoft.InformeTickets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ControladorPrincipal controlador;
    Button btnGenerarInformeAr = new Button("Generar Informe Articulos");
    Button btnGenerarInformeTi = new Button("Generar Informe Tickets");

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
        // Creamos el panel de fondo
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 206, 209)); // Color de fondo
        panel.setLayout(new BorderLayout()); // Usamos BorderLayout para que ocupe todo el espacio disponible

        // Creamos la etiqueta
        JLabel label = new JLabel("Bienvenido al sistema de gestión de Tiendecita", JLabel.CENTER);
        label.setBounds(10, 69, 434, 79);
        label.setForeground(new Color(255, 250, 240));

        // Añadir la etiqueta al panel (centrado)
        panel.add(label, BorderLayout.NORTH);

        // Creamos el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 206, 209));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centra los botones
        buttonPanel.add(btnGenerarInformeAr);
        buttonPanel.add(btnGenerarInformeTi);

        // Añadir el panel de botones al panel principal
        panel.add(buttonPanel, BorderLayout.CENTER); // Esto hará que los botones estén centrados

        // Configuramos el contentPane para que use el panel de fondo
        setContentPane(panel);

        // Añadimos los listeners a los botones
        btnGenerarInformeAr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarInformeArticulos();
            }
        });

        btnGenerarInformeTi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarInformeTickets();
            }
        });
    }

    // Métodos para generar los informes
    private void generarInformeArticulos() {
        // Aquí se podría invocar algún método en el controlador que genere el informe de artículos
        System.out.println("Generando informe de Artículos...");
        // Por ejemplo:
       new InformeArticulos();
    }

    private void generarInformeTickets() {
        // Aquí se podría invocar algún método en el controlador que genere el informe de tickets
        System.out.println("Generando informe de Tickets...");
        new InformeTickets();
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
