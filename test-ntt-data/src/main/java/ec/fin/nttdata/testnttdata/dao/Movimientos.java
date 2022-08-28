package ec.fin.nttdata.testnttdata.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tmovimientos")
public class Movimientos implements Serializable {

    @Id
    private Date fecha;
    @Column(name = "TIPO_MOVIMIENTOS")
    private String tipoMovimiento;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @Column(name = "IDENTIFICACION")
    private  String identificacion;
    @Column(name = "NUMERO_CUENTA")
    private int numeroCuenta;

    public Movimientos(Date fecha,
                       String tipoMovimiento,
                       BigDecimal valor,
                       BigDecimal saldo,
                       String identificacion,
                       int numeroCuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.identificacion = identificacion;
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Movimientos() {

    }


    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
