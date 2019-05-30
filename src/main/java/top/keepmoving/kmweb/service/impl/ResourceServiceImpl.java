package top.keepmoving.kmweb.service.impl;

import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.keepmoving.kmweb.domain.Resource;
import top.keepmoving.kmweb.domain.ResourceRepository;
import top.keepmoving.kmweb.service.ResourceService;

import java.util.List;
import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-07
 * <p>@Description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	ResourceRepository resourceRep;

	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {

		return resourceRep.findPermissions(resourceIds);
	}

	@Override
	public Set<Resource> findMenus(Set<String> permissions) {

		return resourceRep.findByPermissionIn(permissions);
	}
}
