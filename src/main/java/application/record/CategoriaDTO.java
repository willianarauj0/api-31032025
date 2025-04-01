package application.record;

public record CategoriaDTO(Long id, String nome) {
    public CategoriaDTO {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }
}