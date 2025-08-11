package br.com.forumhub.challenge.forum.controller;


import java.time.LocalDateTime;


import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.forumhub.challenge.forum.model.cursos.CursosEntity;
import br.com.forumhub.challenge.forum.model.cursos.CursosRepository;
import br.com.forumhub.challenge.forum.model.topicos.TopicoEntity;
import br.com.forumhub.challenge.forum.model.topicos.ListagemTopicoDTO;
import br.com.forumhub.challenge.forum.model.topicos.TopicoRepository;
import br.com.forumhub.challenge.forum.model.topicos.TopicosAtualizacaoDTO;
import br.com.forumhub.challenge.forum.model.topicos.TopicosDTO;
import br.com.forumhub.challenge.forum.model.usuario.UsuarioEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class ResquestController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursosRepository cursosRepository;

    
    @PostMapping("/registrar")
    @Transactional
    public String registrarTopico(@RequestBody @Valid TopicosDTO json) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioEntity usuarioEntity = (UsuarioEntity) authentication.getPrincipal();

        CursosEntity cursosEntity = cursosRepository.findByNome(json.nomeCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        TopicoEntity topicoEntity = new TopicoEntity(
            null,
            json.titulo(),
            json.mensagem(),
            LocalDateTime.now(),
            true,
            usuarioEntity,
            cursosEntity
        );
        
        if(topicoRepository.existsById(topicoEntity.getId())) {
            throw new RuntimeException("Tópico já existe");
        }

        topicoRepository.save(topicoEntity);
        return "Tópico registrado com sucesso!";
    }

    @GetMapping("/listar")
    public Page<ListagemTopicoDTO> listarTopicos(@PageableDefault(size = 10, sort={"dataCriacao"}) Pageable pageable) {
        return topicoRepository.findAllByEstadoTopicoTrue(pageable).map(ListagemTopicoDTO::new);
    }

    @GetMapping("/listar/{id}")
    public ListagemTopicoDTO listarTopicoPorId(@PathVariable Long id) {
        if(id != null && id >= 0) {
            var topico = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return new ListagemTopicoDTO(topico);
        }

        throw new IllegalArgumentException("ID inválido");
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicosAtualizacaoDTO json) {
        var topicos = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topicos.atualizarTopico(json);

    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirTopico(@PathVariable Long id) {
        var topicos = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topicos.inativarTopico();
    }

}
