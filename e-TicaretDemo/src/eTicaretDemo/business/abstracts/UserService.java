package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.consretes.User;

public interface UserService {
	
	void register(User user); // kay�t
	void signIn(String email, String password);// oturum a� 
	void registerWithAccount(); //Hesapla kay�t ol

}
