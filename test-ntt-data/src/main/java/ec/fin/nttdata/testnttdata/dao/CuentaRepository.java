package ec.fin.nttdata.testnttdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(value = "SELECT SALDO_INICIAL FROM core_transaccional.tcuentas where NUMERO_CUENTA = :numeroCuenta",
            nativeQuery = true)
    BigDecimal findSaldoInicial(@Param("numeroCuenta") int numeroCuenta);
}
