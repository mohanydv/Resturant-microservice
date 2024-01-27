package com.mhn.userInfo.service.repoitory;

import org.mapstruct.control.MappingControl.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhn.userInfo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
