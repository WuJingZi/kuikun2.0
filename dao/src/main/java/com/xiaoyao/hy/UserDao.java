package com.xiaoyao.hy;

import java.util.List;

import com.xiaoyao.hy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
	User findBySusername(String susername);
}
