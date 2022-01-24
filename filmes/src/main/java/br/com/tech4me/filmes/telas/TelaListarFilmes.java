package br.com.tech4me.filmes.telas;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.repository.Repository;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmesRepositorio;

public class TelaListarFilmes implements Tela<Filme, Integer> {
    @Override
    public void executar(Scanner entrada, Repository<Filme, Integer> repositorio) {
        FilmesRepositorio repo = (FilmesRepositorio)repositorio;
        List<Filme> filmes = repo.encontrarTodosCompletos();

        if(filmes.isEmpty()) {
            System.out.println("\nNão há filmes cadrastados.");
            return;
        }

        System.out.println("\n***************************");
        System.out.println("Lista de filmes cadrastados.");
        System.out.println("*****************************");
        filmes.forEach(System.out::println);
}

}
