package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.service.AlimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esta clase recibe peticiones HTTP y devuelve datos (JSON)”
@RestController

//perimite peticiones desde cualquier origen, es decir,
//  desde cualquier dominio, lo que es útil para el desarrollo frontend.
@CrossOrigin(origins = "*")
//crea la ruta para el controlador de alimentos, con los métodos para listar y guardar alimentos.
@RequestMapping("/alimentos")
public class AlimentoController {

//Oye Spring, dame el service para usarlo
    @Autowired
    private AlimentoService alimentoService;


    //metodo de mostrar alimentos, con la ruta /alimentos y el verbo GET
    @GetMapping
    public List<Alimento> listarAlimentos() {
        return alimentoService.listarAlimentos();
    }


    // metodo de agregar
    @PostMapping
    public Alimento guardarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.guardarAlimento(alimento);
}

//metodo de eliminar
@DeleteMapping("/{id}")
public void eliminarAlimento(@PathVariable Long id) {
    alimentoService.eliminarAlimento(id);
}

@PutMapping("/{id}")
public Alimento actualizarAlimento(@PathVariable Long id, @RequestBody Alimento alimento) {
    return alimentoService.actualizarAlimento(id, alimento);
}

    }

