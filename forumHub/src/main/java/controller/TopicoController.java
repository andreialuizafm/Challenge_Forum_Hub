package controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("topicos")

public class TopicoController{
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopico dados){
        repository.save(new Topico(dados));
    }


    @GetMapping
    public ResponseEntity<Page<DadosTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){
        var page:Page<DadosTopico>= repository.findAllByAtivoTrue(paginacao).map(DadosTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosTopico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
        return ResponseEntity.ok(new DadosTopico(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }

}