package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

public record DatosActualizacionPaciente (@NotNull Long id, String nombre, String telefono, DatosDireccion direccion) {
}