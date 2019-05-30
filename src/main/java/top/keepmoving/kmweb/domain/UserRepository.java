package top.keepmoving.kmweb.domain;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-06
 * <p>@Description:
 */
public interface UserRepository extends CrudRepository<User, Long> {
//
//	@Modifying
//	@Query("update sys_user u set u.password = :password where u.id = :id")
//	int updatePasswordById(@Param("password") String password, @Param("id") Long id);

	User findByUsername(String username);
}
