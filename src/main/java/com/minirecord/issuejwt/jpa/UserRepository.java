package com.minirecord.issuejwt.jpa;

import com.minirecord.issuejwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	Optional<User> findByEmail(String email);
}
