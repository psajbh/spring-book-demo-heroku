package com.jhart.repo.user;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jhart.domain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByLdapId(String ldapId);
	
	@Query(value = "SELECT name FROM user order by name", nativeQuery = true) 
	List<String> findDistinctUserNames();		
	
}
