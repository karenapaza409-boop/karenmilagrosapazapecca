package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.estudiante;

import java.util.List;

public interface estudianteservioI {
    void saveentidad(estudiante estudiante);
    List<estudiante> deleteentidad(int index);
    void updateentidad(estudiante estudiante, int index);

    estudiante finentidad(int index);
    List<estudiante> findallentidades();
}
