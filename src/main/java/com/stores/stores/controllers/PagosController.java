package com.stores.stores.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.CreditoModel;
import com.stores.stores.models.PagosModel;
import com.stores.stores.models.utils.SendMail;
import com.stores.stores.services.CreditoService;
import com.stores.stores.services.PagosService;

@RestController
@RequestMapping(path = "/api/pagos")
public class PagosController {

	@Autowired
	PagosService pagosService;

	@Autowired
	SendMail mail;

	@Autowired
	CreditoService creditoService;

	@PostMapping(path = "/registrar")
	public ResponseEntity<?> guardarPago(@RequestBody PagosModel pago) {
		PagosModel pagoCuota = pagosService.pagarCuota(pago);
		Optional<CreditoModel> credito = creditoService.huscraById(pagoCuota.getCredito().getId());
		String body = credito.get().getTienda().getNombre() + "te informa que tu pago por el valor de $"
				+ pagoCuota.getValor() + " el dia " + pagoCuota.getFecha()
				+ " ha sido recibido con exito, identificador del pago: " + pagoCuota.getId()
				+ " este correo es automatico ";
		try {
			mail.sendPago("haroldmaussa@gmail.com", credito.get().getVenta().getCliente().getEmail(), "Pago recibido",
					credito.get().getTienda().getNombre(), pagoCuota.getValor(), pagoCuota.getFecha(),
					pagoCuota.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(pagoCuota);
	}

	@GetMapping(path = "/{credito}")
	public ResponseEntity<?> buscarByCredito(@PathVariable("credito") Long id) {
		return ResponseEntity.ok(pagosService.buacarByCredito(id));
	}

}
