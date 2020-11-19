package com.dchab.springModel5.repo;

import com.dchab.springModel5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
