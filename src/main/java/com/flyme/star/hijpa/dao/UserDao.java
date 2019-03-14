package com.flyme.star.hijpa.dao;

import com.flyme.star.hijpa.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query("select u from User u where u.userName=:userName")
    public User findUserByName(@Param("userName") String userName);
}
