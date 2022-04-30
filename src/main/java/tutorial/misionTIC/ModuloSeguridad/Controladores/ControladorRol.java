package tutorial.misionTIC.ModuloSeguridad.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tutorial.misionTIC.ModuloSeguridad.Modelos.Rol;
import tutorial.misionTIC.ModuloSeguridad.Repositorios.RepositorioRol;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class ControladorRol {
    @Autowired
    private RepositorioRol miRepositorioRol;


    @GetMapping("")
    public List<Rol> index(){
        return this.miRepositorioRol.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Rol create(@RequestBody  Rol infoRol){

        return this.miRepositorioRol.save(infoRol);
    }
    @GetMapping("{id}")
    public Rol show(@PathVariable String id){
        Rol rolActual=this.miRepositorioRol
                        .findById(id)
                        .orElseThrow(RuntimeException::new);
        return rolActual;
    }
    @PutMapping("{id}")
    public Rol update(@PathVariable String id,@RequestBody  Rol infoRol){
        Rol rolActual=this.miRepositorioRol
                .findById(id)
                .orElseThrow(RuntimeException::new);
        rolActual.setNombre(infoRol.getNombre());

        return this.miRepositorioRol.save(rolActual);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Rol rolActual=this.miRepositorioRol
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioRol.delete(rolActual);
    }
}
