package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.JustificativoEntity;
import com.mueblesStgo.mueblesStgo.services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/justificativo")
@CrossOrigin
public class JustificativoController {
    @Autowired
    JustificativoService justificativoService;

    @GetMapping()
    public List<JustificativoEntity> obtenerJustificativos(){
        return justificativoService.obtenerJustificativos();
    }

    @PostMapping("/ingresarJustificativo")
     public String guardarJustificativo(
            @RequestBody JustificativoEntity jsonJustificativo) throws IOException {
        JustificativoEntity resultado = justificativoService.guardarJustificativo(jsonJustificativo);
        return "Recibido";
    }
}
