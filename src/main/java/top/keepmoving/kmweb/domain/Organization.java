package top.keepmoving.kmweb.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 组织结构
 * <p>@Author:Vince
 * <p>@Date:2019-03-05
 * <p>@Description:
 */
@Entity()
@Table(name = "sys_organization")
public class Organization implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //编号
	private String name; //组织机构名称
	private Long parentId; //父编号
	private String parentIds; //父编号列表，如1/2/
	private Boolean available = Boolean.FALSE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
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

		Organization that = (Organization) o;

		return id != null ? id.equals(that.id) : that.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Organization{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				", parentIds='" + parentIds + '\'' +
				", available=" + available +
				'}';
	}
}
