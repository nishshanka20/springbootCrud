package com.testProject.testProjec.repo;

import com.testProject.testProjec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer > {

    @Query(value="SELECT * FROM USER WHERE ID=?1",nativeQuery = true)
    User getUserById(int userId);

    @Query(value="SELECT * FROM USER WHERE ID=?1 AND ADDRESS=?2",nativeQuery = true)
    User getUserByData(int userId,String address);
}
