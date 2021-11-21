package br.com.javamodas.service;

import br.com.javamodas.exception.BusinessRuleException;
import br.com.javamodas.model.Categoria;
import br.com.javamodas.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listAll(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    };

    public Categoria save(Categoria categoria){
        validateDuplicateCategoria(categoria);
        return  categoriaRepository.save(categoria);
    };

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Long id, Categoria categoria){
        Categoria categoriaSave = validateCateoriaExists(id);
        validateDuplicateCategoria(categoria);
        //update value on db
        BeanUtils.copyProperties(categoria, categoriaSave, "id");
        return categoriaRepository.save(categoriaSave);
    }


    public Categoria validateCateoriaExists(Long id) {
        Optional<Categoria> categoria = findById(id);
        if (categoria.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return categoria.get();

    }

    private void validateDuplicateCategoria(Categoria categoria){
        Categoria categoriaFound = categoriaRepository.findByNome(categoria.getNome());
        if (categoriaFound != null && categoriaFound.getId() != categoria.getId()){
            throw  new BusinessRuleException(String.format("A categoria %s já existe", categoria.getNome().toUpperCase()));
        }
    }

    ;
}
