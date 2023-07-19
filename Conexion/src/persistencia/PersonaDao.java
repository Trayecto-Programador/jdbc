package persistencia;

import entidades.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public final class PersonaDao extends Dao {

    public void insertarPersona(Persona person) throws Exception {
        try {
            if (person == null) {
                throw new Exception("Debe enviar una persona");
            }
            String consulta = "INSERT INTO persona(nombre, apellido, edad)"
                    + "VALUES  ('" + person.getNombre() + "','" + person.getApellido() + "','" + person.getEdad() + "');";

            insertarEliminarModificar(consulta);

        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizarPersona(Persona person) throws Exception {
        try {
            if (person == null) {
                throw new Exception("Debe enviar una persona");
            }
            String consulta = "UPDATE persona SET"
                    + " nombre = '" + person.getNombre() + "' WHERE idPersona = '" + person.getCodigoPersona();
            insertarEliminarModificar(consulta);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarPersona(String id) throws Exception {
        try {
            String consulta = "DELETE FROM persona WHERE idPersona = '" + id + "'";
            insertarEliminarModificar(consulta);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public Persona buscarPersonaId(String id) throws Exception {
        try {
            String consulta = "SELECT * FROM persona WHERE idPersona = '" + id + "'";
            consultarBase(consulta);
            Persona persona = null;
            
            while (resultado.next()) {
                persona = new Persona();
                persona.setCodigoPersona(resultado.getInt(1));
                persona.setNombre(resultado.getString(2));
                persona.setApellido(resultado.getString(3));
                persona.setEdad(resultado.getString(4));
                
                desconectarBase();
                return persona;

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return null;
    }
    public Collection<Persona> listarPersonas() throws Exception {
        try {
            String consulta = "SELECT idPersona, nombre, Apellido FROM persona '";
            consultarBase(consulta);
            Persona persona = null;
            Collection<Persona> personas = new ArrayList<>();
            
            while (resultado.next()) {
                persona = new Persona();
                persona.setCodigoPersona(resultado.getInt(1));
                persona.setNombre(resultado.getString(2));
                persona.setApellido(resultado.getString(3));
                personas.add(persona);
                
                desconectarBase();
                return personas;

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return null;
    }
}
