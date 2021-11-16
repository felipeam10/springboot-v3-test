package br.com.forum.springbootv3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.forum.springbootv3.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nome);

}
