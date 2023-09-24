package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medico.DatoListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController{

    @Autowired // inyección de dependencias
    private MedicoRepository medicoRepository;
    
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        System.out.println("La informacion del medico se maneja con EXITO");
        System.out.println(datosRegistroMedico);
        medicoRepository.save(new Medico(datosRegistroMedico));
    }
    
    @GetMapping
    public List<DatoListadoMedico> listadoMedicos(){
        return medicoRepository.findAll().stream().map(DatoListadoMedico::new).toList();
    }
}