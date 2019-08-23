package com.wiredbrain.friends;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wiredbrain.friends.controller.FriendController;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendsApplicationTests {
	
	@Autowired
	FriendController friendController;


	@Test
	public void contextLoads() {
		
		Assert.assertNotNull(friendController);
	}

}
