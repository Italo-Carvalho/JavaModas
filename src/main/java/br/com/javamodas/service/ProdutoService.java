package br.com.javamodas.service;

import br.com.javamodas.exception.BusinessRuleException;
import br.com.javamodas.model.Produto;
import br.com.javamodas.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaService categoriaService;


    public List<Produto> findByCategoriaId(Long id){
        return produtoRepository.findByCategoriaId(id);
    }


    public Optional<Produto> findByIdAndCategoriaId(Long productId, Long categoryId){
        return produtoRepository.findByIdAndCategoriaId(productId, categoryId);
    }

    public Produto save(Produto produto, Long categoryId){
        categoriaService.validateCateoriaExists(categoryId);
        validateDuplicateProduct(produto);
        produto.setId(null); //prevent save to update
        return produtoRepository.save(produto);
    }


    public void delete(Long categoryId, Long productId){
        Produto product = validateProductExists(categoryId, productId);
        produtoRepository.delete(product);
    }

    public Produto update(Long id, Long idCategory, Produto product){
        Produto productSave = validateProductExists(id, idCategory);
        validateDuplicateProduct(product);
        BeanUtils.copyProperties(product, productSave, "id");
        return produtoRepository.save(productSave);

    }

    protected void updateQuantidadePosVenda(Produto produto){
        produtoRepository.save(produto);
    }

    protected Produto validateProductExists(Long idProduct, Long idCategory){
        Optional<Produto> productExists = findByIdAndCategoriaId(idProduct, idCategory);
        if (productExists.isEmpty()) throw new EmptyResultDataAccessException(1);
        return productExists.get();

    }

    protected Produto validateProductExists(Long idProduct){
        Optional<Produto> productExists = produtoRepository.findById(idProduct);
        if (productExists.isEmpty()) {
            throw new BusinessRuleException(String.format("Produto de ID %s não existe", idProduct));
        }
        return productExists.get();

    }

    public void validateDuplicateProduct(Produto produto){
        Optional<Produto> productFind = produtoRepository.findByCategoriaIdAndDescricao(produto.getCategoria().getId(), produto.getDescricao());
        if (productFind.isPresent() && productFind.get().getId() != produto.getId()){
            throw new BusinessRuleException(String.format("O produto %s já existe", produto.getDescricao()));
        }
    }
}