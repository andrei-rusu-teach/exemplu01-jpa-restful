package eu.andreirusu.daw.cardb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eu.andreirusu.daw.cardb.domain.Userr;
import eu.andreirusu.daw.cardb.domain.UserrRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserrRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Userr currentUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(
				username, currentUser.getPassword(), true, true, true, true,
				AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
}
