package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.estudiante;
import pe.edu.upeu.asistencia.repositorio.estudianterepositorio;

import java.util.ArrayList;
import java.util.List;

@Service
public class estudianteservicioImp extends estudianterepositorio implements estudianteservioI {


    @Override
    public void saveentidad(estudiante estudiante) {
        listaestudiantes.add(estudiante);
    }

    @Override
    public List<estudiante> deleteentidad(int index) {
     return listaestudiantes;
    }

    @Override
    public void updateentidad(estudiante estudiante, int index) {
        listaestudiantes.set(index,estudiante);
    }

    @Override
    public estudiante finentidad(int index) {
        return listaestudiantes.remove(index);
    }

    @Override
    public List<estudiante> findallentidades() {
        return listaestudiantes;
    }
}
