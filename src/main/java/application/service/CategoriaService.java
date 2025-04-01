package application.service;

import application.record.CategoriaDTO;
import application.model.Categoria;
import application.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria salvar(CategoriaDTO dto) {
        Categoria categoria = new Categoria(dto.id(), dto.nome());
        return repository.save(categoria);
    }

    public Categoria atualizar(Long id, CategoriaDTO dto) {
        Optional<Categoria> categoriaExistente = repository.findById(id);

        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNome(dto.nome());
            return repository.save(categoria);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }
}