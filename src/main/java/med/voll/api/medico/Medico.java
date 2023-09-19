package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

//acá esta la persistencia de datos con nuestro modelo de base de datos
@Table(name = "medicos") //Nombre de la tabla en nuestra DB
@Entity(name = "Medico") //Nombre de la tabla en el proyecto a relacionar con la anterior
@Getter //Al compilar se generarán nuestro metodos get
@NoArgsConstructor //Constroctor sin parametro
@AllArgsConstructor //Contructor con todos los parametros
@EqualsAndHashCode (of = "id") //usar el parametro id para las comparaciones entre medicos
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }
}
