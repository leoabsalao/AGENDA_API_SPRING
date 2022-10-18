package br.com.projeto.agendaapi.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.agendaapi.modelo.Contato;
import br.com.projeto.agendaapi.repositorio.ContatoRepositorio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
public class ContatoControle {

    @Autowired
    private final ContatoRepositorio repositorio;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato Salvar(@RequestBody Contato contato){
         return repositorio.save(contato);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Deletar(@PathVariable Integer id){
         repositorio.deleteById(id);
    }

    @GetMapping
    public List<Contato> list(){
        return repositorio.findAll();
    }

    @PatchMapping("{id}/favorito")
    public void favoritar(@PathVariable Integer id, @RequestBody Boolean favorito){
         Optional<Contato> contato = repositorio.findById(id);
         contato.ifPresent( c -> {
             c.setFavorito(favorito);
             repositorio.save(c);
         });
    }


}
