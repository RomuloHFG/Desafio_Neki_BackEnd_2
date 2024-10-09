package com.example.login_auth_api.infra.security;

import com.example.login_auth_api.domain.user.User;
import com.example.login_auth_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}

//O CustomUserDetailsService é fundamental para garantir que o Spring Security tenha acesso às informações corretas do usuário durante o processo de autenticação.
//Ele permite que você personalize como os detalhes do usuário são carregados e validados,
//integrando-se perfeitamente com o sistema de autenticação e autorização do Spring Security para proteger sua aplicação web.
