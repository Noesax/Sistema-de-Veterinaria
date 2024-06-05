package pe.edu.unmsm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="dni_data")
public class DniModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numero;
    private String nombre_completo;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String codigo_verificacion;
}
