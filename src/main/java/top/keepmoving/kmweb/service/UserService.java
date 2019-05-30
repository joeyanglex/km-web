package top.keepmoving.kmweb.service;

import top.keepmoving.kmweb.domain.User;

import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-08
 * <p>@Description:
 */
public interface UserService {

	void changePassword(Long userId, String newPassword);

	User findByUsername(String username);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);

}
