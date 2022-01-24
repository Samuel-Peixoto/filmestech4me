package br.com.tech4me.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "movie")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id")
    private Integer id;
    @Column(name = "mov_title")
    private String titulo;
    @Column(name = "mov_year")
    private Integer anoLancamento;
    @Column(name = "mov_time")
    private Integer duracao;
    @Column(name = "mov_lang")
    private String idioma;
    @Column(name = "mov_dt_rel")
    private LocalDate dataLancamento;
    @Column(name = "mov_rel_country")
    private String paisLancamento;

    @OneToMany(mappedBy = "id.filme")
    private List<Atuacao> atuacaos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "movie_direction",
        joinColumns = @JoinColumn(name = "mov_id", referencedColumnName = "mov_id"),
        inverseJoinColumns = @JoinColumn(name = "dir_id", referencedColumnName = "dir_id")
    )
    private List<Diretor> diretores = new ArrayList<>();

    public List<Diretor> getDiretores() {
       return diretores;
    }
     public Map<String, Ator> getElenco() {
         Map<String, Ator> saida = new HashMap<>();

         atuacaos.forEach(at -> saida.put(at.getPapel().trim(), at.getId().getAtor()));
         
         return saida;
     } 

     @Override
     public String toString(){
      List<Diretor> dirs = getDiretores();
      return String.format("Título: %s (%d)\n\tDiretores: %s\n\tElenco: %s\n",
      titulo.trim(), anoLancamento, dirs, getElenco());


     }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public String getPaisLancamento() {
        return paisLancamento;
    }
    public void setPaisLancamento(String paisLancamento) {
        this.paisLancamento = paisLancamento;
    }

    
}
