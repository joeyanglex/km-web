package top.keepmoving.kmweb.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-06
 * <p>@Description:
 */
public interface ResourceRepository extends CrudRepository<Resource, Long> {

	@Query(value = "select r.permission from sys_resource r where r.id in ?1", nativeQuery = true)
	Set<String> findPermissions(Set<Long> ids);

	@Query(value = "select r.* from sys_resource r where sys_resource where r.permission in ?1 ", nativeQuery = true)
	Set<Resource> findByPermissionIn(Set<String> permissions);
}
