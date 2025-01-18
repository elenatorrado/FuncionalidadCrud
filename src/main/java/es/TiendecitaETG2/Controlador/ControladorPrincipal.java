package es.TiendecitaETG2.Controlador;

import es.TiendecitaETG2.Conexion.DatabaseConnection;
import es.TiendecitaETG2.Modelo.ArticuloTicket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPrincipal {
	// --- Operaciones con Artículos ---

    public List<ArticuloTicket> obtenerArticulos() {
        List<ArticuloTicket> articulos = new ArrayList<>();
        String query = "SELECT * FROM Articulos";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ArticuloTicket articulo = new ArticuloTicket(
                        resultSet.getInt("idArticulos"),
                        resultSet.getString("descripcionArticulos"),
                        resultSet.getDouble("precioArticulos"),
                        resultSet.getInt("stockArticulo"),
                        "" // Proveedor no incluido en la base de datos actual
                );
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articulos;
    }

    public boolean altaArticulo(ArticuloTicket articulo) {
        String query = "INSERT INTO Articulos (idArticulos, descripcionArticulos, precioArticulos, stockArticulo) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, articulo.getId());
            statement.setString(2, articulo.getDescripcion());
            statement.setDouble(3, articulo.getPrecio());
            statement.setInt(4, articulo.getStock());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarArticulo(ArticuloTicket articulo) {
        String query = "UPDATE Articulos SET descripcionArticulos = ?, precioArticulos = ?, stockArticulo = ? WHERE idArticulos = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, articulo.getDescripcion());
            statement.setDouble(2, articulo.getPrecio());
            statement.setInt(3, articulo.getStock());
            statement.setInt(4, articulo.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarArticulo(int id) {
        String query = "DELETE FROM Articulos WHERE idArticulos = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Operaciones con Tickets ---

    public boolean agregarTicket(int idTicket, Date fecha) {
        String query = "INSERT INTO Tickets (idTickets, fechaTickets) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idTicket);
            statement.setDate(2, fecha);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean agregarDetalleTicket(int idTicket, int idArticulo, int cantidad) {
        String query = "INSERT INTO detalles_tickets (idTicketsFK, idArticulosFK, cantidadArticulos) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idTicket);
            statement.setInt(2, idArticulo);
            statement.setInt(3, cantidad);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ArticuloTicket> ConsultaTickets(int idTicket) {
        List<ArticuloTicket> detalles = new ArrayList<>();
        String query = "SELECT a.idArticulos, a.descripcionArticulos, a.precioArticulos, a.stockArticulo " +
                       "FROM detalles_tickets dt " +
                       "JOIN Articulos a ON dt.idArticulosFK = a.idArticulos " +
                       "WHERE dt.idTicketsFK = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idTicket);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ArticuloTicket articulo = new ArticuloTicket(
                        resultSet.getInt("idArticulos"),
                        resultSet.getString("descripcionArticulos"),
                        resultSet.getDouble("precioArticulos"),
                        resultSet.getInt("stockArticulo"),
                        "" // Proveedor no incluido
                );
                detalles.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalles;
    }

   private static ControladorPrincipal instance;

    public static ControladorPrincipal getInstance() {
        if (instance == null) {
            instance = new ControladorPrincipal();
        }
        return instance;

}

    public void guardarArticulo(String descripcion, double precio, int stock) {
        String query = "INSERT INTO Articulos (descripcionArticulos, precioArticulos, stockArticulo) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Asignar valores a los parámetros de la consulta
            statement.setString(1, descripcion);
            statement.setDouble(2, precio);
            statement.setInt(3, stock);

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Artículo guardado correctamente.");
            } else {
                System.out.println("No se pudo guardar el artículo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al guardar el artículo: " + e.getMessage());
        }
    }

    public void guardarTicket(int idTicket, String fecha) {
        String query = "INSERT INTO Tickets (idTickets, fechaTickets) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Asignar valores a los parámetros de la consulta
            statement.setInt(1, idTicket);
            statement.setString(2, fecha);

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Ticket guardado correctamente.");
            } else {
                System.out.println("No se pudo guardar el ticket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al guardar el ticket: " + e.getMessage());
        }
    }

    public List<Object[]> consultarTickets() {
        List<Object[]> listaTickets = new ArrayList<>();
        System.out.println("Los Tickets son: ");

        // Consulta SQL para obtener los detalles de los tickets, sus artículos y cantidades
        String query = "SELECT * FROM tickets";

        // Conexión a la base de datos y ejecución de la consulta
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Antes del while"); 

            // Iterar sobre los resultados
            while (resultSet.next()) {
                // Crear un arreglo de objetos que contiene los datos de un ticket
                Object[] ticketDetails = new Object[6];  // idTickets, fechaTickets, idArticulos, descripcionArticulos, precioArticulos, cantidadArticulos

                // Asignar los resultados a los elementos del arreglo
                ticketDetails[0] = resultSet.getInt("idTickets");  // idTickets
                ticketDetails[1] = resultSet.getDate("fechaTickets");  // fechaTickets
                               // Agregar el arreglo a la lista de resultados
                listaTickets.add(ticketDetails);
            }

            // Comprobación: imprimir los datos almacenados en la lista
            System.out.println("Comprobación de los registros guardados:");
            for (Object[] ticket : listaTickets) {
                System.out.println(String.format(
                    "ID Ticket: %d, Fecha: %s, ID Artículo: %d, Descripción: %s, Precio: %.2f, Cantidad: %d",
                    ticket[0], ticket[1], ticket[2], ticket[3], ticket[4], ticket[5]
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTickets;
    }


	
	}
	

	
