package com.lpdm.msorder;

import com.lpdm.msorder.entity.Order;
import com.lpdm.msorder.dao.OrderRepository;
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

	@Autowired
	OrderRepository orderRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void repositories(){

		Assert.assertNotNull(orderRepository);
		List<Order> orderList = orderRepository.findAll();
		Assert.assertTrue(orderList.size() > 0);
	}

}
