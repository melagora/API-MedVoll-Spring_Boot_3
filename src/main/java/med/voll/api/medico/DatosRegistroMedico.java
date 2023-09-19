package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico (
    
    @NotBlank //Realiza la validacion de que no se vaya el dato niNULO niBLANCO (vacio).
    String nombre,
    
    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String documento,
    
    @NotNull
    Especialidad especialidad, 

    @NotNull //Los objetos siempre llegan nulos
    @Valid
    DatosDireccion direccion) {
    
}
