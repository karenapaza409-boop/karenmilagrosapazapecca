package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.participante;
import pe.edu.upeu.asistencia.repositorio.participanterepositorio;

import java.util.List;

@Service
public class estudianteservicioImp extends participanterepositorio implements participanteservicioI {




    @Override
    public void save(participante participante) {
        super.save(participante);
    }

    @Override
   public void delete(int index) {
      listaestudiantes.remove(index);
    }

    @Override
    public  participante update(participante participante) {

      return super.update(participante);
    }

    @Override
    public List<participante> findAll() {

        return super.findAll();
    }

    @Override
    public participante findById(int index) {
        return listaestudiantes.get(index);
    }
}
