package com.example.onlineshopagain.persistance;

import com.example.onlineshopagain.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
