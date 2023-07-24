package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class MainController {
    @Autowired
    private CursoRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping(path="/")
    public @ResponseBody String home(){
        return "Feanaya-Laura Olortegui";
    }
    @GetMapping(path="/codigo")
    public @ResponseBody String codigo(){
        return "Feanaya";
    }
    @GetMapping(path="/nombre-completo")
    public @ResponseBody String nombre(){
        return "Laura Olortegui";
    }
   @GetMapping(path="/api/curso/listar")
    public @ResponseBody Iterable<Curso> listar(){
        return repository.findAll();
    }
    @PostMapping(path = "/api/curso/nuevo")
    public @ResponseBody String addNewCurso(
        @RequestParam String nombre, @RequestParam Integer creditos)
    {
        Curso n =new Curso();
        n.setNombre(nombre);
        n.setCreditos(creditos);
        repository.save(n);
        return "Curso Guardado";
    }
    @DeleteMapping(path="/api/curso/eliminar")
    public @ResponseBody String eliminar(@RequestParam Integer id){
        Curso n=new Curso();
        n.setId(id);
        repository.delete(n);
        return "Curso eliminado";
    }
 
}
