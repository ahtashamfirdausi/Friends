package com.wiredbrain.friends.service;

import org.springframework.data.repository.CrudRepository;

import com.wiredbrain.friends.model.Friend;

public interface FriendService  extends CrudRepository<Friend, Integer>{
	
	Iterable<Friend>findByFirstNameAndlastName(String firstName,String lastName);
	
	Iterable<Friend> findByFirstName(String firstName);
	Iterable<Friend> findByLastName(String lastName);

}
