package med.voll.api.domain.consulta;

import java.time.LocalDate;

public record DatosDetalleConsulta (Long id, Long idPaciente, Long idMedico, LocalDate fecha){

}
