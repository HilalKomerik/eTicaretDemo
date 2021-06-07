package eTicaretDemo.dateAccess.abstracts;

import java.util.List;

import eTicaretDemo.entities.consretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	List<User> getAll();	
}
