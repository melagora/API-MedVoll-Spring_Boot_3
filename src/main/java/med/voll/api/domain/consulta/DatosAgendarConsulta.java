package med.voll.api.domain.consulta;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DatosAgendarConsulta (Long id,@NotNull Long idPaciente, Long idMedico, @NotNull @Future LocalDate fecha) {

}
