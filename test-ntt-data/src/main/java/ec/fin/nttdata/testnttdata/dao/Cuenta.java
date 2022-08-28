package ec.fin.nttdata.testnttdata.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tcuentas")
public class Cuenta implements Serializable {
    public static final long serialVersionUUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCuenta;

    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "SALDO_INICIAL")
    private BigDecimal saldoInicial;
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Column(name = "NOMBRE")
    private String nombre;

    public Cuenta(String tipoCuenta, BigDecimal saldoInicial, boolean estado, String identificacion, String nombre) {
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public Cuenta() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean getEstado() {
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
