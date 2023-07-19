package servicio;

import entidades.Persona;
import persistencia.PersonaDao;

public class PersonaServicio {

    private PersonaDao dao;

    public PersonaServicio() {
        this.dao = new PersonaDao();
    }

    public Persona crearPersona(){
        return new Persona();
    }
    public void insertarBase(Persona persona) throws Exception{
        try {
            dao.insertarPersona(persona);
        } catch (Exception ex) {
            throw ex;
        }
    }
}

