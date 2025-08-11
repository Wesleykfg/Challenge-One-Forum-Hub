package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.autor.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {
    @Autowired
    private AutorRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder){
        var autor = new Autor(dados);
        repository.save(autor);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAutor(autor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAutor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemAutor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAutor dados){ //metodo para atualizaçãode dados
        var autor = repository.getReferenceById(dados.id());
        autor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAutor(autor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        autor.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAutor(autor));
    }
}
