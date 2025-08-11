package br.com.alura.forumhub.domain.topico.agendamento;


import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.topico.DadosCadastroTopico;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraTopicoNoDia implements ValidadorAgendamentoDeTopico {
    @Autowired
    private TopicoRepository repository;

    public void validar(DadosCadastroTopico dados) {

    }
}
