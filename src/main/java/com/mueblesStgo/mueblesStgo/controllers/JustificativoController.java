package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.JustificativoEntity;
import com.mueblesStgo.mueblesStgo.repositories.JustificativoRepository;
import com.mueblesStgo.mueblesStgo.services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/justificativo")
@CrossOrigin
public class JustificativoController {
    @Autowired
    JustificativoService justificativoService;

    @PostMapping("/ingresarJustificativo")
    public String guardarJustificativo(@RequestParam(name="rut") String r, @RequestParam(name="fecha") String f){
        JustificativoEntity justificativo = new JustificativoEntity();
        justificativo.setRutEmpleado(r);
        LocalDate fechaFormato = justificativoService.fechaFormato(f);
        justificativo.setFechaInasistencia(fechaFormato);
        justificativoService.guardarJustificativo(justificativo);
        return "Recibido";
    }
}
