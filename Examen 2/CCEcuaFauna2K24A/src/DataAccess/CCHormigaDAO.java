package DataAccess;
/* 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataAccess.DTO.CCHormigaDTO;

public class CCHormigaDAO implements GenericDAO<CCHormigaDTO> {

    @Override
    public boolean create(CCHormigaDTO entity) throws Exception {
        String query = "INSERT INTO Hormiga (TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = openConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getSexo());
            pstmt.setInt(3, entity.getProvincia());
            pstmt.setInt(4, entity.getGenoAlimento());
            pstmt.setInt(5, entity.getIngestaNativa());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = 'A' WHERE IdHormiga = ?";
        try (Connection conn = openConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = "SELECT COUNT(*) FROM Hormiga WHERE Estado = 'A'";
        try (Connection conn = openConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

    @Override
    public List<CCHormigaDTO> readAll() throws Exception {
        List<CCHormigaDTO> lst = new ArrayList<>();
        String query = "SELECT IdHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM Hormiga WHERE Estado = 'A'";
        try (Connection conn = openConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CCHormigaDTO hormigaDTO = new CCHormigaDTO(
                    rs.getInt("IdHormiga"),
                    rs.getInt("TipoHormiga"),
                    rs.getInt("Sexo"),
                    rs.getInt("Provincia"),
                    rs.getInt("GenoAlimento"),
                    rs.getInt("IngestaNativa"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea"),
                    rs.getString("FechaModifica")
                );
                lst.add(hormigaDTO);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public CCHormigaDTO readBy(Integer id) throws Exception {
        String query = "SELECT IdHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM Hormiga WHERE Estado = 'A' AND IdHormiga = ?";
        try (Connection conn = openConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CCHormigaDTO(
                    rs.getInt("IdHormiga"),
                    rs.getInt("TipoHormiga"),
                    rs.getInt("Sexo"),
                    rs.getInt("Provincia"),
                    rs.getInt("GenoAlimento"),
                    rs.getInt("IngestaNativa"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea"),
                    rs.getString("FechaModifica")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return null; // Retornar null si no se encuentra el registro
    }

    @Override
    public boolean update(CCHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Hormiga SET TipoHormiga = ?, Sexo = ?, Provincia = ?, GenoAlimento = ?, IngestaNativa = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try (Connection conn = openConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getSexo());
            pstmt.setInt(3, entity.getProvincia());
            pstmt.setInt(4, entity.getGenoAlimento());
            pstmt.setInt(5, entity.getIngestaNativa());
            pstmt.setString(6, dtf.format(now));
            pstmt.setInt(7, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    private Connection openConnection() throws SQLException {
        // Implementa la lógica para abrir una conexión a la base de datos
        // Por ejemplo: return DriverManager.getConnection("jdbc:sqlite:mi_base_de_datos.db");
        return null;
    }
}
*/
/* 
public class CCHormigaDAO {

    // Método para crear una hormiga
    public void crearHormiga(String tipo, String sexo, String provincia, String genoAlimento, String ingestaNativa) {
        String sql = "INSERT INTO Hormiga(TipoHormiga,Sexo,Provincia,GenoAlimento,IngestaNativa) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, getTipoHormigaId(tipo));
            pstmt.setInt(2, getCatalogoId(sexo));
            pstmt.setInt(3, getLocalidadId(provincia));
            pstmt.setInt(4, getGenoAlimentoId(genoAlimento));
            pstmt.setInt(5, getIngestaNativaId(ingestaNativa));
            pstmt.executeUpdate();
            System.out.println("Hormiga creada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para alimentar una hormiga
    public void alimentarHormiga(int idHormiga, String alimento) {
        String sql = "SELECT TipoHormiga, Sexo FROM Hormiga WHERE IdHormiga = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idHormiga);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int tipoHormiga = rs.getInt("TipoHormiga");
                int sexo = rs.getInt("Sexo");

                if ("Carne".equals(alimento)) {
                    matarHormiga(idHormiga);
                } else if ("Herbívoro".equals(alimento)) {
                    cambiarTipoOSexoHormiga(idHormiga);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para matar una hormiga
    private void matarHormiga(int idHormiga) {
        String sql = "UPDATE Hormiga SET Estado = 'X' WHERE IdHormiga = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idHormiga);
            pstmt.executeUpdate();
            System.out.println("Hormiga ha muerto.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para cambiar el tipo o sexo de la hormiga
    private void cambiarTipoOSexoHormiga(int idHormiga) {
        // Lógica para cambiar tipo o sexo de la hormiga.
    }

    // Métodos auxiliares para obtener IDs
    private int getTipoHormigaId(String tipo) {
        // Implementar consulta para obtener ID de TipoHormiga según el nombre
        return 0; // Reemplazar con valor real
    }

    private int getCatalogoId(String nombre) {
        // Implementar consulta para obtener ID de Catalogo según el nombre
        return 0; // Reemplazar con valor real
    }

    private int getLocalidadId(String nombre) {
        // Implementar consulta para obtener ID de Localidad según el nombre
        return 0; // Reemplazar con valor real
    }

    private int getGenoAlimentoId(String nombre) {
        // Implementar consulta para obtener ID de GenoAlimento según el nombre
        return 0; // Reemplazar con valor real
    }

    private int getIngestaNativaId(String nombre) {
        // Implementar consulta para obtener ID de IngestaNativa según el nombre
        return 0; // Reemplazar con valor real
    }
}
*/
/* 
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CCHormigaDAO {

    public CCHormigaDAO() {
        // Constructor can be empty or have initialization logic
    }

    public void crearHormiga(String tipo, String sexo, String provincia, String genoAlimento, String ingestaNativa) {
        String sql = "INSERT INTO Hormiga(TipoHormiga,Sexo,Provincia,GenoAlimento,IngestaNativa) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, getTipoHormigaId(tipo));
            pstmt.setInt(2, getCatalogoId(sexo));
            pstmt.setInt(3, getLocalidadId(provincia));
            pstmt.setInt(4, getGenoAlimentoId(genoAlimento));
            pstmt.setInt(5, getIngestaNativaId(ingestaNativa));
            pstmt.executeUpdate();
            System.out.println("Hormiga creada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Add your helper methods here (e.g., getTipoHormigaId, getCatalogoId, etc.)
}
*/
/* 
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCHormigaDAO {

    public CCHormigaDAO() {
        // Constructor logic if needed
    }

    public void crearHormiga(String tipo, String sexo, String provincia, String genoAlimento, String ingestaNativa) {
        String sql = "INSERT INTO Hormiga(TipoHormiga,Sexo,Provincia,GenoAlimento,IngestaNativa) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, getTipoHormigaId(tipo));
            pstmt.setInt(2, getCatalogoId(sexo));
            pstmt.setInt(3, getLocalidadId(provincia));
            pstmt.setInt(4, getGenoAlimentoId(genoAlimento));
            pstmt.setInt(5, getIngestaNativaId(ingestaNativa));
            pstmt.executeUpdate();
            System.out.println("Hormiga creada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Add your helper methods here (e.g., getTipoHormigaId, getCatalogoId, etc.)

    // Example of a helper method
    private int getTipoHormigaId(String tipo) {
        // Implement the logic to get the TipoHormiga ID from the database
        return 0; // Replace with actual implementation
    }

    // Other helper methods...
}

*/