package com.example.testG38.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testG38.entities.Estudiante;
import com.example.testG38.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    
        @Autowired
        private EstudianteRepository estudianteRepository;

        public EstudianteService(EstudianteRepository estudianteRepository) {
            this.estudianteRepository = estudianteRepository;
        }

        // METODOS CRUD
        public List<Estudiante> getListEstudiantes(){

            return this.estudianteRepository.findAll();
        }

        public Estudiante getEstudiante(int id){
            if(!this.estudianteRepository.findById(id).isEmpty()){
                return this.estudianteRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Estudiante crearEstudiante(Estudiante estudiante){
            return this.estudianteRepository.save(estudiante);
        }

        public void eliminarEstudiante(int id){
            if(!this.estudianteRepository.findById(id).isEmpty()){
                this.estudianteRepository.deleteById(id);
            }
        }

        public void actualizarEstudiante(int id, Estudiante estudiante){
            if(!this.estudianteRepository.findById(id).isEmpty()){
                Estudiante estudianteDB = this.estudianteRepository.findById(id).get();

                if(estudiante.getNombre() != null){
                    estudianteDB.setNombre(estudiante.getNombre());
                }
                if(estudiante.getApellido() != null){
                    estudianteDB.setApellido(estudiante.getApellido());
                }
                if(estudiante.getEdad() != null){
                    estudianteDB.setEdad(estudiante.getEdad());
                }
                estudianteDB.setUptatedAt(new Date());
                this.estudianteRepository.save(estudianteDB);
            }
        }
        
        
}
