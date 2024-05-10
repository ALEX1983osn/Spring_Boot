package com.alexey.springboot.SpringBootProject.reposetory;

import com.alexey.springboot.SpringBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
