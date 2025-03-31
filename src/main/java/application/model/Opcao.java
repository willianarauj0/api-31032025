package application.model;

import jakarta.persistence.*;

@Entity
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private boolean correto;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public Opcao() {}

    public Opcao(String descricao, boolean correto, Questao questao) {
        this.descricao = descricao;
        this.correto = correto;
        this.questao = questao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCorreto() {
        return correto;
    }

    public void setCorreto(boolean correto) {
        this.correto = correto;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
