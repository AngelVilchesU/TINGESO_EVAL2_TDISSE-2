package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.JustificativoEntity;
import com.mueblesStgo.mueblesStgo.services.JustificativoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/justificativo")
@CrossOrigin
public class JustificativoController {
    @Autowired
    JustificativoService justificativoService;

    private final Logger log = LoggerFactory.getLogger(JustificativoController.class);
    /*
    @PostMapping("/ingresarJustificativo")
    public String guardarJustificativo(@RequestParam(name="rut") String r, @RequestParam(name="fecha") String f){
        JustificativoEntity justificativo = new JustificativoEntity();
        justificativo.setRutEmpleado(r);
        LocalDate fechaFormato = justificativoService.fechaFormato(f);
        justificativo.setFechaInasistencia(fechaFormato);
        justificativoService.guardarJustificativo(justificativo);
        return "Recibido";
    }

     */
    @PostMapping("/ingresarJustificativo")
     public @ResponseBody JustificativoEntity guardarJustificativo(
            @RequestBody JustificativoEntity jsonJustificativo){
        log.info("Request to create justification: {}", jsonJustificativo);
        System.out.println(jsonJustificativo.getRutEmpleado() + " " + jsonJustificativo.getFechaInasistencia());
        JustificativoEntity resultado = justificativoService.guardarJustificativo(jsonJustificativo);
        return jsonJustificativo;
    }
}
