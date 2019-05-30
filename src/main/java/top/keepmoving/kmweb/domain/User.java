package top.keepmoving.kmweb.domain;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 用户
 * <p>@Author:Vince
 * <p>@Date:2019-03-05
 * <p>@Description:
 */
@Entity
@Table(name = "sys_user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id; //编号

	private Long organizationId; //所属公司

	private String username; //用户名

	private String password; //密码

	private String salt; //加密密码的盐

	private String roleIds; //拥有的角色列表

	private Boolean locked = Boolean.FALSE;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getRoleIds() {
		if(roleIds == null) {
			roleIds = "";
		}
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}


	public List<Long> getRoleIdsList() {

		if (StringUtils.isEmpty(roleIds)) {
			return Lists.newArrayList();
		}

		List<String> idList = Splitter.on(",").splitToList(roleIds);

		List<Long> ids = Lists.newArrayList();

		for (String id : idList) {
			ids.add(Long.valueOf(id));
		}

		return ids;
	}

	public void setRoleIdsList(List<Long> roleIdsList) {

		if (CollectionUtils.isEmpty(roleIdsList)) {
			return;
		}

		roleIds = Joiner.on(",").skipNulls().join(roleIdsList);
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", organizationId=" + organizationId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", roleIds=" + roleIds +
				", locked=" + locked +
				'}';
	}
}
