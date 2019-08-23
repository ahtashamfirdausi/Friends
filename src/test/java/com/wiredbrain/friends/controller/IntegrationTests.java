package com.wiredbrain.friends.controller;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wiredbrain.friends.model.Friend;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

	@Autowired
	FriendController friendController;

	@Test
	public void testCrateReadDelete() {
		Friend friend = new Friend("Gordon", "Moore");

		Friend friendResult = friendController.create(friend);
		Iterable<Friend> friends = friendController.read();

		Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName", "Gordon");

		friendController.delete(friendResult.getId());
		Assertions.assertThat(friendController.read()).isEmpty();

	}
	
	
	@Test(expected = ValidationException.class)
	public void errorHandlingValidationExceptionThrown() {
	   friendController.somethingIsWrong();
		
	}

}
