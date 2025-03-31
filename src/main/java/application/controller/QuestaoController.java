package application.controller;

import application.model.Questao;
import application.repository.QuestaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    private final QuestaoRepository repository;

    public QuestaoController(QuestaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Questao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Questao criar(@RequestBody Questao questao) {
        return repository.save(questao);
    }
}
