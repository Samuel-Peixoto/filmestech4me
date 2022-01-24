package br.com.tech4me.filmes.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import br.com.tech4me.filmes.model.Filme;

@Repository
public interface FilmesRepositorio extends JpaRepository<Filme, Integer> {
    List<Filme> findByOrderByTituloAsc();
    List<Filme> findByTituloContainsIgnoreCaseOrderByTituloAsc(String titulo);
    @Query("select f from Filme f left join fetch f.atuacoes order by f.titulo")
    List<Filme> encontrarTodosCompletos();
}
