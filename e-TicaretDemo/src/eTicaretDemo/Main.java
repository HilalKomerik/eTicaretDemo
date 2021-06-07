package eTicaretDemo;

import java.util.Scanner;

import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.business.consretes.UserManager;
import eTicaretDemo.core.adapters.JGoogleManagerAdapter;
import eTicaretDemo.core.mailCheck.MailCheckManager;
import eTicaretDemo.dateAccess.consretes.HibernateUseDao;
import eTicaretDemo.entities.consretes.User;
import eTicaretDemo.entities.consretes.UserList;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			UserList userList = new UserList();
			UserService userService = new UserManager(new HibernateUseDao(userList), new MailCheckManager() , new JGoogleManagerAdapter());
			
			User user = new User();
				
			System.out.print("Ýsminizi Giriniz: ");
			user.setFirstName(scan.next());

			System.out.print("Soyadýnýzý Giriniz: ");
			user.setLastName(scan.next());
					
			System.out.print("E-posta giriniz: ");
			user.setEmail(scan.next());
				
			System.out.print("Þifrenizi giriniz:");
			user.setPassword(scan.next());
					
			userService.register(user);
			
		}
	}	
}
