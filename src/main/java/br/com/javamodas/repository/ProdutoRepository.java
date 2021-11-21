package br.com.javamodas.repository;

import br.com.javamodas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaId(Long id);
//    @Query("SELECT prod"
//            + " FROM Produto prod"
//            + " WHERE prod.id = :productId"
//            + " AND prod.categoria.id = :categoryId")
    Optional<Produto> findByIdAndCategoriaId(Long productId, Long categoryId);
    Optional<Produto> findByCategoriaIdAndDescricao(Long categoriaId ,String productDescricao);
}