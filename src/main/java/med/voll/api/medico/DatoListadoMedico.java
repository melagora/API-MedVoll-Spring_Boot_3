package med.voll.api.medico;

public record DatoListadoMedico (String nombre, String especialidad, String documento, String email) {

    public DatoListadoMedico (Medico medico){
        this(medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
