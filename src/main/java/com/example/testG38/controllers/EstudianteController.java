package com.example.testG38.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testG38.entities.Estudiante;
import com.example.testG38.services.EstudianteService;

@Service
@RestController
@RequestMapping("/estudiante")

public class EstudianteController {    

    @Autowired
    EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return new ResponseEntity<List<Estudiante>>(this.estudianteService.getListEstudiantes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable("id") int id){
        return new ResponseEntity<Estudiante>(this.estudianteService.getEstudiante(id), HttpStatus.OK);
    }

    @GetMapping("/dios/{tabla}")
    public String getDios(@PathVariable("tabla") String tabla){
        if(tabla.equals("ESTUDIANTES")){
            return "esta es la tabla estudiantes";
        }
        if(tabla.equals("PROFESORES")){
            return "esta es la tabla profesores";
        }
        if(tabla.equals("EMPRESAS")){
            return "esta es la tabla empresas";
        }
        if(tabla.equals("CARRRITOS")){
            return "esta es la tabla carritos";
        }
        return "";
    }


    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){
        return new ResponseEntity<Estudiante>(this.estudianteService.crearEstudiante(estudiante), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable("id") int id){
        this.estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<String>("Estudiante Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEstudiante(@PathVariable("id") int id, @RequestBody Estudiante estudiante){
        this.estudianteService.actualizarEstudiante(id, estudiante);
        return new ResponseEntity<String>("Estudiante Actualizado", HttpStatus.CREATED);
    }

}
