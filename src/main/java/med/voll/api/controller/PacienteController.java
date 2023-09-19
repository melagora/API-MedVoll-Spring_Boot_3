package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.paciente.DatosRegistroPaciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @PostMapping
    public void registrar (@RequestBody DatosRegistroPaciente datosRegistroPaciente){
        System.out.println("La informacion del paciente se maneja con EXITO");
        System.out.println(datosRegistroPaciente);

    }
}
