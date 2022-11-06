package com.mueblesStgo.mueblesStgo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Justificativo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JustificativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private LocalDate fechaInasistencia;
    private String rutEmpleado;

    public JustificativoEntity(LocalDate fechaInasistencia, String rutEmpleado) {
        this.fechaInasistencia = fechaInasistencia;
        this.rutEmpleado = rutEmpleado;
    }
}
