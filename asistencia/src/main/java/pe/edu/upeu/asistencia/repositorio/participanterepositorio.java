package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.conexion.ConDB;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.participante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class participanterepositorio {
    public List<participante> listaestudiantes=null;

    Connection con= ConDB.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

public List<participante> findAll(){

    listaestudiantes=new ArrayList<>();
    try{
        pst=con.prepareStatement("select * from participante");
        rs=pst.executeQuery();
        while(rs.next()){
            participante p=new participante();
            p.setDni(new SimpleStringProperty(rs.getString("dni")));
            p.setNombre(new SimpleStringProperty(rs.getString("nombre")));
            p.setApellido(new SimpleStringProperty(rs.getString("apellido")));
            p.setCarrera(Carrera.valueOf(rs.getString("carrera")));
            p.setTipoparticipante(TipoParticipante.valueOf(rs.getString("tipo_participante")));
            p.setEstado(new SimpleBooleanProperty(rs.getBoolean("estado")));
            listaestudiantes.add(p);
        }
    }catch (SQLException e){
        throw new RuntimeException(e);

    }

    return listaestudiantes;

}
public void save(participante p){
    sql="INSERT INTO participante \n" +
            "(dni,nombre,apellido,carrera,tipo_participante,estado) \n"+
            "VALUES (?,?,?,?,?,?)";
    int i=0;
    try{
        pst= con.prepareStatement(sql);
        pst.setString(++i,p.getDni().getValue());
        pst.setString(++i,p.getNombre().getValue());
        pst.setString(++i,p.getApellido().getValue());
        pst.setString(++i,p.getCarrera().name());
        pst.setString(++i,p.getTipoparticipante().name());
        pst.setBoolean(++i,p.getEstado().getValue());
        pst.executeUpdate();
    }catch(SQLException e){
        throw new RuntimeException(e);
    }
}
public participante update(participante p){
    sql="UPDATE participante\n"+
            "SET nombre=?,apellido=?,carrera=?,tipo_participante=?,estado=?\n"+
            "WHERE dni=?";
    int i=0;
    try {
        pst= con.prepareStatement(sql);
        pst.setString(++i,p.getNombre().getValue());
        pst.setString(++i,p.getApellido().getValue());
        pst.setString(++i,p.getCarrera().name());
        pst.setString(++i,p.getTipoparticipante().name());
        pst.setBoolean(++i,p.getEstado().getValue());

        pst.setString(++i,p.getDni().getValue());
        pst.executeUpdate();

    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    return p;
}
public void delete(String dni){
    try{
        pst=con.prepareStatement("DELETE FROM participante WHERE dni=?");
        pst.setString(1, dni);
        pst.executeUpdate();

    }catch (SQLException e){
        throw new RuntimeException(e);
    }
}

}
