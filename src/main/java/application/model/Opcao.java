package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private boolean correta;
    
    @ManyToOne
    private Questao questao;

    // Construtores, getters e setters
    public Opcao() {}
    
    public Opcao(Long id, String texto, boolean correta, Questao questao) {
        this.id = id;
        this.texto = texto;
        this.correta = correta;
        this.questao = questao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public boolean isCorreta() { return correta; }
    public void setCorreta(boolean correta) { this.correta = correta; }
    public Questao getQuestao() { return questao; }
    public void setQuestao(Questao questao) { this.questao = questao; }
}