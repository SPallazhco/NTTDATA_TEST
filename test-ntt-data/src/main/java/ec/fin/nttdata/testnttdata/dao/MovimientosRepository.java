package ec.fin.nttdata.testnttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface MovimientosRepository extends JpaRepository<Movimientos, Date> {
    @Query(value = "SELECT SALDO FROM core_transaccional.tmovimientos WHERE NUMERO_CUENTA = :numeroCuenta ORDER BY FECHA DESC LIMIT 1;",
            nativeQuery = true)
    BigDecimal findSaldoActual(@Param("numeroCuenta") int numeroCuenta);

    @Query(value = "SELECT * FROM core_transaccional.tmovimientos tm WHERE tm.FECHA BETWEEN :fdesde AND :fhasta AND NUMERO_CUENTA = :cuenta", nativeQuery = true)
    List<Movimientos> findAllByFecha(@Param("fdesde") Date fdesde,
                                     @Param("fhasta") Date fhasta,
                                     @Param("cuenta") int cuenta);
}
