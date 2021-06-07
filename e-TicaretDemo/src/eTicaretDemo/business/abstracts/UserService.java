package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.consretes.User;

public interface UserService {
	
	void register(User user); // kayýt
	void signIn(String email, String password);// oturum aç 
	void registerWithAccount(); //Hesapla kayýt ol

}
