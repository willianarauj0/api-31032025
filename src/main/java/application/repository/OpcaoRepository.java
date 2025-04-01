package application.repository;

import application.model.Opcao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
    List<Opcao> findByQuestaoId(Long questaoId);
}