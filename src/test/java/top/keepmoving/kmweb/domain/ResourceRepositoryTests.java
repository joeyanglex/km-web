package top.keepmoving.kmweb.domain;

import com.google.common.collect.Sets;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-07
 * <p>@Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ResourceRepositoryTests {

	private static Logger logger = LoggerFactory.getLogger(ResourceRepositoryTests.class);

//	@Autowired
//	ResourceRepository repository;

	@Test
	public void testFindPermissions() {
/*
		Set<Long> ids = Sets.newHashSet(1L, 2L);

		Set<String> permissions = repository.findPermissions(ids);

		Assert.assertEquals(1, permissions.size());*/
	}

	@Test
	public void testFindMenus() {
		/*Set<String> permissions = Sets.newHashSet("organization:create", "organization:view");

		Set<Resource> menus = repository.findByPermissionIn(permissions);

		Assert.assertEquals(2, menus.size());

		for (Resource r :
				menus) {
			logger.info(menus.toString());
		}*/


	}


}
