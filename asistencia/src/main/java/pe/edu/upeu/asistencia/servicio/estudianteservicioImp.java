package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.participante;
import pe.edu.upeu.asistencia.repositorio.participanterepositorio;

import java.util.List;

@Service
public class estudianteservicioImp extends participanterepositorio implements participanteservicioI {




    @Override
    public void save(participante participante) {
        listaestudiantes.add(participante);
    }

    @Override
    public List<participante> delete(int index) {
     return listaestudiantes;
    }

    @Override
    public void update(participante participante, int index) {
        listaestudiantes.set(index, participante);
    }

    @Override
    public List<participante> findAll() {
        if(listaestudiantes.isEmpty()){
            return super.findAll();
        }
        return listaestudiantes;
    }

    @Override
    public participante findById(int index) {
        return listaestudiantes.get(index);
    }
}
