package application.service;

import application.record.OpcaoDTO;
import application.record.QuestaoDTO;
import application.model.Questao;
import application.repository.QuestaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {
    private final QuestaoRepository repository;
    private final OpcaoService opcaoService;

    public QuestaoService(QuestaoRepository repository, OpcaoService opcaoService) {
        this.repository = repository;
        this.opcaoService = opcaoService;
    }

    public List<Questao> listarTodas() {
        return repository.findAll();
    }

    public Questao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Questao salvar(QuestaoDTO dto) {
        Questao questao = new Questao(null, dto.enunciado(), dto.dificuldade());
        Questao questaoSalva = repository.save(questao);
        
        if (dto.opcoes() != null) {
            dto.opcoes().forEach(opcaoDto -> {
                opcaoService.salvar(new OpcaoDTO(
                    null,
                    opcaoDto.texto(),
                    opcaoDto.correta(),
                    questaoSalva.getId()
                ));
            });
        }
        
        return questaoSalva;
    }

    public Questao atualizar(Long id, QuestaoDTO dto) {
        Questao questao = repository.findById(id).orElse(null);
        if (questao != null) {
            questao.setEnunciado(dto.enunciado());
            questao.setDificuldade(dto.dificuldade());
            return repository.save(questao);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}