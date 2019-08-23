package com.wiredbrain.friends;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.wiredbrain.friends.model.Friend;

public class SystemTests {

	@Test
	public void testCreateReadDelete() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8181/friend";

		Friend friend = new Friend("Gordon", "Moore");
		ResponseEntity<Friend> entity = restTemplate.postForEntity(url, friend, Friend.class);
		Friend[] friends = restTemplate.getForObject(url, Friend[].class);
		Assertions.assertThat(friends).extracting(Friend::getFriendName).containsOnly("Gordon");

		restTemplate.delete(url + "/" + entity.getBody().getId());
		Assertions.assertThat(restTemplate.getForObject(url, Friend[].class)).isEmpty();

	}

	@Test
	public void testErrorHandlingReturnsBadRequest() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8181/wrong";

		try {

			restTemplate.getForEntity(url, String.class);
		} catch (HttpClientErrorException e) {
			Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
		}

	}

}
