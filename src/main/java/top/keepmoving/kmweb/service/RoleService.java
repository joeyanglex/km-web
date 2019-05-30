package top.keepmoving.kmweb.service;

import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-08
 * <p>@Description:
 */
public interface RoleService {

	Set<String> findRoles(Long... roleIds);

	Set<String> findPermissions(Long[] roleIds);
}
