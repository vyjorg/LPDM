package com.lpdm.msorder;

import com.lpdm.msorder.entity.Order;
import com.lpdm.msorder.dao.OrderRepository;
import com.lpdm.msorder.proxy.MsProductProxy;
import com.lpdm.msorder.proxy.MsUserProxy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsOrderApplicationTests {

	@Autowired OrderRepository orderRepository;
	@Autowired MsProductProxy msProductProxy;
	@Autowired MsUserProxy msUserProxy;

	@Test
	public void contextLoads() {
	}

	@Test
	public void repositories(){

		Assert.assertNotNull(orderRepository);
		List<Order> orderList = orderRepository.findAll();
		Assert.assertTrue(orderList.size() > 0);
	}

	@Test
	public void feignProductMS(){

		Assert.assertNotNull(msProductProxy.findAll());
		Assert.assertNotNull(msProductProxy.findById(1));
	}

	@Test
	public void feignUserMS(){

		Assert.assertNotNull(msUserProxy.findById(1));
	}

}
