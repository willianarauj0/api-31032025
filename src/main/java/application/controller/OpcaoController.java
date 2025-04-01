package application.controller;

import application.service.OpcaoService;
import application.model.Opcao;
import application.record.OpcaoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes/{questaoId}/opcoes")
public class OpcaoController {
    private final OpcaoService service;

    public OpcaoController(OpcaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Opcao> listarPorQuestao(@PathVariable Long questaoId) {
        return service.listarPorQuestao(questaoId);
    }

    @PostMapping
    public Opcao salvar(@PathVariable Long questaoId, @RequestBody OpcaoDTO dto) {
        OpcaoDTO dtoComQuestao = new OpcaoDTO(dto.id(), dto.texto(), dto.correta(), questaoId);
        return service.salvar(dtoComQuestao);
    }

    @PutMapping("/{id}")
    public Opcao atualizar(@PathVariable Long questaoId, @PathVariable Long id, @RequestBody OpcaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}