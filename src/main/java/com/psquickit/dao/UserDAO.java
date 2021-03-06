package com.psquickit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psquickit.dto.DoctorUserDTO;
import com.psquickit.dto.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, Long> {
	
	@Query("Select u from UserDTO u where u.uid = :uid")
	public UserDTO checkUIDExist(@Param("uid") String uid);
}
