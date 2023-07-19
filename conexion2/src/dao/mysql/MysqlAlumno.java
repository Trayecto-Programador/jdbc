package dao.mysql;

import dao.AlumnoDao;
import dao.DaoExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;

public class MysqlAlumno implements AlumnoDao {

    final String insertar = "INSERT INTO alumno(nombre, edad) VALUES(?,?)";
    final String modificar = "UPDATE alumno SET nombre = ?, edad = ? WHERE idAlumno = ?";
    final String eliminar = "DELETE FROM alumno WHERE idAalumno = ?";
    final String listarAlumnos = "SELECT idAlumno, nombre, edad FROM alumno";
    final String buscarAlumno = "SELECT idAlumno, nombre, edad FROM alumno WHERE idAlumno = ?";

    private Connection conexion;

    public MysqlAlumno(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Alumno dato) throws DaoExcepcion {
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(insertar);
            ps.setString(1, dato.getNombre());
            ps.setInt(2, dato.getEdad());
            if (ps.executeUpdate() == 0) {
                throw new DaoExcepcion("No se guardo la info en la base de datos");

            }
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error mysql, ", ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DaoExcepcion("Error mysql, ", ex);
                }

            }
        }
    }

    public Alumno convertir(ResultSet rs) throws SQLException {
        //estraigo datos del resultSet y los almaceno en variables
        String nombre = rs.getString("nombre");
        int edad = rs.getInt("edad");
        int codigo = rs.getInt("idAlumno");

        //Crear un objeto Alumno y setearlos con los datos del resultset
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(codigo);
        alumno.setNombre(nombre);
        alumno.setEdad(edad);
        return alumno;
    }

    @Override
    public void modificar(Alumno dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Alumno dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> obtenerDatos() throws DaoExcepcion {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            ps = conexion.prepareStatement(listarAlumnos);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumnos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error en SQL ", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DaoExcepcion("Error en SQL ", ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DaoExcepcion("Error en SQL ", ex);
                }
            }
        }
        return alumnos;
    }

    @Override
    public Alumno obtener(int id) throws DaoExcepcion {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Alumno alumno = null;

        try {
            ps = conexion.prepareStatement(buscarAlumno);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno = convertir(rs);
            } else {
                throw new DaoExcepcion("Error en SQL ");
            }
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error en SQL ", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DaoExcepcion("Error en SQL ", ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DaoExcepcion("Error en SQL ", ex);
                }
            }
        }
        return alumno;
    }

}
