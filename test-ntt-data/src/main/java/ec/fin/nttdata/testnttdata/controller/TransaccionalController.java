package ec.fin.nttdata.testnttdata.controller;

import ec.fin.nttdata.testnttdata.dao.*;
import ec.fin.nttdata.testnttdata.model.InfoCliente;
import ec.fin.nttdata.testnttdata.model.RangoFechas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TransaccionalController {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    MovimientosRepository movimientosRepository;

    private Gson gson;

    /**
     * CREACION DE CLIENTE Y CREACION DE CUENTA
     * @param bodyReques
     * @return
     */

    @PostMapping("/CrearClientes")
    public InfoCliente createPersona(@RequestBody String bodyReques){
        log.info("LLEGO A CLASE");
        InfoCliente infoCliente;
        gson = new Gson();
        infoCliente = gson.fromJson(bodyReques, InfoCliente.class);
        // Creacion de registro en la tabla tpersona
        Persona persona = gson.fromJson(bodyReques, Persona.class);
        personaRepository.save(persona);
        // Creacion de registro en la tabla tcuenta
        Cliente cliente = gson.fromJson(bodyReques, Cliente.class);
        clienteRepository.save(cliente);
        return infoCliente;
    }

    @PostMapping("/CrearCuenta")
    public Cuenta crearCuenta(@Validated @RequestBody Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    @PostMapping("/CrearMovimiento")
    public Movimientos crearMovimiento(@Validated @RequestBody Movimientos movimientos){
        //Fecha de la transaccion
        Calendar calendar = Calendar.getInstance();
        movimientos.setFecha(calendar.getTime());
        BigDecimal saldoActual;
        // Obtener saldo de tmovimientos
        saldoActual = movimientosRepository.findSaldoActual(movimientos.getNumeroCuenta());
        // En caso de que sea null sacar el saldo inicial
        if(saldoActual == null){
            saldoActual = cuentaRepository.findSaldoInicial(movimientos.getNumeroCuenta());
        }
        if(saldoActual.signum() >= 0) {
            movimientos.setSaldo(saldoActual.add(movimientos.getValor()));
        } else {
            movimientos.setTipoMovimiento("SALDO NO DISPONIBLE");
            return movimientos;
        }
        return movimientosRepository.save(movimientos);
    }

    @GetMapping("/ReporteFechas")
    public List<Movimientos> getMovimientos(@RequestBody String bodyRequest) throws ParseException {
        RangoFechas rangoFechas;
        gson = new Gson();
        rangoFechas = gson.fromJson(bodyRequest, RangoFechas.class);
        log.info("TRAMA TRANSFORMADA" + rangoFechas);
        Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rangoFechas.fdesde);
        Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rangoFechas.fhasta);
        log.info(date1 + "   " + date2 + "  " + rangoFechas.cuenta);
        return movimientosRepository.findAllByFecha(date1, date2, 4);
    }

}
