package com.jobJunior.cursomc.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobJunior.cursomc.model.enuns.Perfil;

public class UserSpringSecurity implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSpringSecurity() {
		super();
	}

	public UserSpringSecurity(Integer id, String email, String senha, Set<Perfil> perfils) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfils.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasHole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
