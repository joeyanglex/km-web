package top.keepmoving.kmweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.keepmoving.kmweb.domain.User;
import top.keepmoving.kmweb.domain.UserRepository;
import top.keepmoving.kmweb.service.UserService;

import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-11
 * <p>@Description:
 */
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void changePassword(Long userId, String newPassword) {

//		userRepository.updatePasswordById(newPassword, userId);
	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		return null;
	}
}
