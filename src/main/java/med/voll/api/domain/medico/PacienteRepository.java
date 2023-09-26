package med.voll.api.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}