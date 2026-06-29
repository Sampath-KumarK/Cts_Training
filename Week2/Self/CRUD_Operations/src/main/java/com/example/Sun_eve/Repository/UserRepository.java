package com.example.Sun_eve.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Sun_eve.Entity.UserEntity;

// @Deprecated
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
