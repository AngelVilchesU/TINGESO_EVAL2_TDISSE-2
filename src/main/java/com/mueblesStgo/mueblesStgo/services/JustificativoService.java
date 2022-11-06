package com.mueblesStgo.mueblesStgo.services;

import com.mueblesStgo.mueblesStgo.entities.JustificativoEntity;
import com.mueblesStgo.mueblesStgo.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JustificativoService {
    @Autowired
    JustificativoRepository justificativoRepository;

    public List<JustificativoEntity> obtenerJustificativos(){
        return (List<JustificativoEntity>) justificativoRepository.findAll();
    }

    public JustificativoEntity guardarJustificativo(JustificativoEntity justificativo){
        return justificativoRepository.save(justificativo);
    }

    public LocalDate fechaFormato(String fecha){
        String[] parte = fecha.split("-");
        int dia = Integer.parseInt(parte[2]);
        int mes = Integer.parseInt(parte[1]);
        int anio = Integer.parseInt(parte[0]);
        return LocalDate.of(anio, mes, dia);
    }

    public boolean estaJustificado(LocalDate fechaInasistencia, String rutEmpleado){
        List<JustificativoEntity> justificativoEntityList = obtenerJustificativos();
        for (int i = 0; i < justificativoEntityList.size(); i++){
            if (justificativoEntityList.get(i).getRutEmpleado().equals(rutEmpleado) &&
                    justificativoEntityList.get(i).getFechaInasistencia().equals(fechaInasistencia)){
                return true;
            }
        }
        return false;
    }
}
