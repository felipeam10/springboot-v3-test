package br.com.forum.springbootv3.config.security;

import br.com.forum.springbootv3.modelo.Usuario;
import br.com.forum.springbootv3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);
        if(usuario.isPresent()) {
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos!");
    }
}
