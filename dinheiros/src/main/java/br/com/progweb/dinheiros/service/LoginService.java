package br.com.progweb.dinheiros.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.progweb.dinheiros.controller.UsuarioController;
import br.com.progweb.dinheiros.dto.LoginDTO;
import br.com.progweb.dinheiros.model.Usuario;
import br.com.progweb.dinheiros.repository.UsuarioRepository;

@Service
public class LoginService  implements UserDetailsService{
//	@Autowired
//    private UsuarioRepository repository;

	private UsuarioController controller = new UsuarioController();
	
    @Transactional(readOnly = true)
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
    	Usuario usuario = new Usuario();
//		try {
//			usuario = controller.autenticar(username).get();
//		} catch (Exception e) {
//			throw new UsernameNotFoundException(e.getMessage());
//		}
		// usuario.setSenha(user.getPassword());
		usuario.setUser(username);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("idUsuario");
//		 if (repository.findOne(Example.of(usuario, matcher)).isPresent()) {
//			System.out.println(repository.findOne(Example.of(usuario, matcher)));
//			Usuario user = repository.findOne(Example.of(usuario, matcher)).get();
//		 };
		// Usuario user = repository.findAll().get(0);

    	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("user"));
//        }
        
        return new org.springframework.security.core.userdetails.User("string", "string1", grantedAuthorities);
    }

}
