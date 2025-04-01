package application.service;

import application.record.OpcaoDTO;
import application.model.Opcao;
import application.model.Questao;
import application.repository.OpcaoRepository;
import application.repository.QuestaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcaoService {
    private final OpcaoRepository repository;
    private final QuestaoRepository questaoRepository;

    public OpcaoService(OpcaoRepository repository, QuestaoRepository questaoRepository) {
        this.repository = repository;
        this.questaoRepository = questaoRepository;
    }

    public List<Opcao> listarPorQuestao(Long questaoId) {
        return repository.findByQuestaoId(questaoId);
    }

    public Opcao salvar(OpcaoDTO dto) {
        Questao questao = questaoRepository.findById(dto.questaoId())
            .orElseThrow(() -> new RuntimeException("Questão não encontrada"));
        
        Opcao opcao = new Opcao(null, dto.texto(), dto.correta(), questao);
        return repository.save(opcao);
    }

    public Opcao atualizar(Long id, OpcaoDTO dto) {
        Optional<Opcao> opcaoExistente = repository.findById(id);
        if (opcaoExistente.isPresent()) {
            Opcao opcao = opcaoExistente.get();
            opcao.setTexto(dto.texto());
            opcao.setCorreta(dto.correta());
            return repository.save(opcao);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}