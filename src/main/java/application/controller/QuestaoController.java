package application.controller;

import application.service.QuestaoService;
import application.model.Questao;
import application.record.QuestaoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    private final QuestaoService service;

    public QuestaoController(QuestaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Questao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Questao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Questao salvar(@RequestBody QuestaoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public Questao atualizar(@PathVariable Long id, @RequestBody QuestaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}