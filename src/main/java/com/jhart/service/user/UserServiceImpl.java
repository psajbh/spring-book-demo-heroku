package com.jhart.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jhart.domain.User;
import com.jhart.repo.user.PlayerRepository;
import com.jhart.repo.user.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private PlayerRepository playerRepository;
	
	public UserServiceImpl(UserRepository userRepository, 
			PlayerRepository playerRepository) {
		this.userRepository = userRepository;
		this.playerRepository = playerRepository;
	}
	
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> listAll() {
		return userRepository.findAll();
	}
	
	@Override
	public List<String> getPlayerNameList() {
		List<String> playerNameList = playerRepository.findDistinctUserNames();
		return playerNameList;
	}
	
	@Override
	public User findById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			//log.warn("findById- id not found: " + id);
			// throw new NotFoundException("User Not Found. For ID value: " + id );
			return null;
		}

		return userOptional.get();
	}
	
	@Override
	public User findByLdapId(String ldapId) {
		User user = userRepository.findByLdapId(ldapId);
		return user;
	}

}
