package top.keepmoving.kmweb.service;

import top.keepmoving.kmweb.domain.Resource;

import java.util.List;
import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-07
 * <p>@Description:
 */
public interface ResourceService {

	/**
	 * 获得资源对应的权限字符串
	 */
	Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 */
	Set<Resource> findMenus(Set<String> permissions);
}
