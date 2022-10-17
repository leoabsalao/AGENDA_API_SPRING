package br.com.projeto.agendaapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.agendaapi.modelo.Contato;

public interface ContatoRepositorio extends JpaRepository<Contato, Integer>{    
}
