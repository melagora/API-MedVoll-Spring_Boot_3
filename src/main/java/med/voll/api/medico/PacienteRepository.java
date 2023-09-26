package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.paciente.DatosListaPaciente;
import med.voll.api.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<DatosListaPaciente> findAllByAtivoTrue(Pageable pageable);
}