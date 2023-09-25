package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DatoListadoMedico;
import med.voll.api.medico.DatosActualizarMedico;
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
    public Page<Object> listadoMedicos(Pageable pageable){
        //return medicoRepository.findAll().stream().map(DatoListadoMedico::new).toList();
        return medicoRepository.findByActivoTrue(pageable).map(DatoListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico (@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    // DELETE LOGICO
    @DeleteMapping ("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }

    // DELETE EN BASE DE DATOS
    //public void eliminarMedico(@PathVariable Long id){
    //    Medico medico = medicoRepository.getReferenceById(id);
    //    medicoRepository.delete(medico);
    //}

}