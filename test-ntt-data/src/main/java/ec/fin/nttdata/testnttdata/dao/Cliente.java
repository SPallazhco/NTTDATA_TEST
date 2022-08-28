package ec.fin.nttdata.testnttdata.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tclientes")
public class Cliente implements Serializable {
    private static final long serialVersionUUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteid;
    @Column(name = "CONTRASEÑA")
    private String contraseña;
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "IDENTIFICACION")
    private String identificacion;

    public Cliente(String contraseña, boolean estado, String identificacion) {
        this.clienteid = clienteid;
        this.contraseña = contraseña;
        this.estado = estado;
        this.identificacion = identificacion;
    }

    public Cliente() {}

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
