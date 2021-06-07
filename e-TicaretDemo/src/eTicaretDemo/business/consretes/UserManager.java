package eTicaretDemo.business.consretes;

import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.core.adapters.ExternalValidationService;
import eTicaretDemo.core.mailCheck.MailCheckService;
import eTicaretDemo.dateAccess.abstracts.UserDao;
import eTicaretDemo.entities.consretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private MailCheckService mailCheckService;
	private ExternalValidationService externalValidationService;

	public UserManager(UserDao userDao ,MailCheckService mailCheckService, ExternalValidationService externalValidationService) {
		super();
		this.userDao = userDao;
		this.mailCheckService = mailCheckService;
		this.externalValidationService = externalValidationService;
	}
	
	@Override
	public void register(User user) {
		 
		if(user.getPassword().length()<6) {
			System.out.println("Þifre 6 haneden az olamaz...");
			return;
		}
		
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ad ve soyad en az 2 karakter içermelidir...");
			return;
		}
		
		if(!mailCheckService.regexMailCheck(user)) {
			System.out.println("Geçersiz e-posta adresi...");
			return;
		}
		
		if(!mailCheckService.sendVerificationEmail(user)) {
			System.out.println("E-posta doðrulanamadý...");
			return;
		}
		
		for (User customer: userDao.getAll()) {
			if(customer.getEmail()== user.getEmail()){
				System.out.println("Bu e-posta adresi daha önce kullanýlmýþ...");
				return;
			}
		}
		
		this.userDao.add(user);
		System.out.println("E-posta adresi doðrulandý ve kullanýcý kaydedildi...");
		
	}

	@Override
	public void signIn(String email, String password) {
		for (User customer: userDao.getAll()) {
			if(customer.getEmail()== email && customer.getPassword() == password){
				System.out.println("Sign in is successful:" + customer.getFirstName()+" "+ customer.getLastName());
				return;
			}
		}
		System.out.println("Oturum açma baþarýsýz.");
	}

	@Override
	public void registerWithAccount() {
		externalValidationService.signInWithExternal();
		
	}

}
