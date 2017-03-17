package com.study.shopcar;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.shopcar.core.MD5Util;
import com.study.shopcar.core.Role;
import com.study.shopcar.dao.GoodsDao;
import com.study.shopcar.dao.UserDao;
import com.study.shopcar.dmo.Goods;
import com.study.shopcar.dmo.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopcarApplication.class)
@Rollback(value=false)
public class TestDao {
	@Autowired
	UserDao userDao;
	@Autowired
	GoodsDao goodsDao;

	@Test
	public void saveGoods() {
		Goods goods = new Goods();
		goods.setInfo("info");
		goods.setName("name");
		this.goodsDao.save(goods);
	}

	@Test
	public void saveUser() {
		User user = new User();
		user.setUsername("test");
		user.setPassword(MD5Util.getSecurityCode("123456"));
		user.setRole(Role.管理员.name());
		userDao.save(user);
	}

	@Test
	public void findUser() {
		List<User> user = this.userDao.findAll();
		for (User user2 : user) {
			System.out.println(user2.getUsername());
		}
	}
}
