package application.record;

public record OpcaoDTO(
    Long id, 
    String texto, 
    boolean correta,
    Long questaoId
) {
    public OpcaoDTO {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Texto não pode ser vazio");
        }
    }
}