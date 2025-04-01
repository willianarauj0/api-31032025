package application.record;

import java.util.List;

public record QuestaoDTO(
    Long id,
    String enunciado,
    int dificuldade,
    List<OpcaoDTO> opcoes
) {
    public QuestaoDTO {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("Enunciado não pode ser vazio");
        }
        if (dificuldade < 1 || dificuldade > 5) {
            throw new IllegalArgumentException("Dificuldade deve ser entre 1 e 5");
        }
    }
}