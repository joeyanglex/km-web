package top.keepmoving.kmweb.domain;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * <p>@Author:Vince
 * <p>@Date:2019-03-05
 * <p>@Description:
 */
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //编号
	private String role; //角色标识 程序中判断使用,如"admin"
	private String description; //角色描述,UI界面显示使用
	private String resourceIds; //拥有的资源
	private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

	public Role() {
	}

	public Role(String role, String description, Boolean available) {
		this.role = role;
		this.description = description;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceIds() {
		if(resourceIds == null) {
			resourceIds = "";
		}
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public List<Long> getResourceIdsList() {

		if (StringUtils.isEmpty(resourceIds)) {
			return Lists.newArrayList();
		}

		List<String> idsList = Splitter.on(",").splitToList(resourceIds);

		List<Long> ids = Lists.newArrayList();

		for (String id : idsList) {
			ids.add(Long.valueOf(id));
		}

		return ids;
	}

	public void setResourceIdsStr(List<Long> resourceIdsList) {
		if(CollectionUtils.isEmpty(resourceIdsList)) {
			return;
		}
		resourceIds = Joiner.on(",").skipNulls().join(resourceIdsList);
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Role role = (Role) o;

		if (id != null ? !id.equals(role.id) : role.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", role='" + role + '\'' +
				", description='" + description + '\'' +
				", resourceIds=" + resourceIds +
				", available=" + available +
				'}';
	}

}
