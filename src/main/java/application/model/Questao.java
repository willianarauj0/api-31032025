package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private int dificuldade;
    
    @OneToMany(mappedBy = "questao")
    private List<Opcao> opcoes;

    // Construtores, getters e setters
    public Questao() {}
    
    public Questao(Long id, String enunciado, int dificuldade) {
        this.id = id;
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEnunciado() { return enunciado; }
    public void setEnunciado(String enunciado) { this.enunciado = enunciado; }
    public int getDificuldade() { return dificuldade; }
    public void setDificuldade(int dificuldade) { this.dificuldade = dificuldade; }
    public List<Opcao> getOpcoes() { return opcoes; }
    public void setOpcoes(List<Opcao> opcoes) { this.opcoes = opcoes; }
}