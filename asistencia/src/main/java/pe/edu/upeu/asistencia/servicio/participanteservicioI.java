package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.participante;

import java.util.List;

public interface participanteservicioI {
    void save(participante participante);
    void delete(int index);
    void update(participante participante, int index);

     List<participante> findAll();
     participante findById(int index);
}
