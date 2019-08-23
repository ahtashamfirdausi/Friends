package com.wiredbrain.friends.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.wiredbrain.friends.model.Friend;
import com.wiredbrain.friends.service.FriendService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {

	@Autowired
	FriendService friendService;

	@Test
	public void testCreateReadDelete() {
		
		Friend friend = new Friend("Gordon","Moore");
		
		friendService.save(friend);
		
		Iterable<Friend> friends =friendService.findAll();
		Assertions.assertThat(friends).extracting(Friend::getFriendName).containsOnly("Gordon","Moore");
		
		friendService.deleteAll();
		Assertions.assertThat(friendService.findAll()).isEmpty();
		

	}

}
