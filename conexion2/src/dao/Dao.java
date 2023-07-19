package dao;

import java.util.List;

public interface Dao <T, L> {
 void insertar(T dato) throws DaoExcepcion;
 void modificar(T dato) throws DaoExcepcion;
 void eliminar(T dato) throws DaoExcepcion;
 List <T> obtenerDatos() throws DaoExcepcion;
 T obtener(int id)throws DaoExcepcion;
    
}
