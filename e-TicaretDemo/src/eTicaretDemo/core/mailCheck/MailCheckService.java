package eTicaretDemo.core.mailCheck;

import eTicaretDemo.entities.consretes.User;

public interface MailCheckService {

	boolean regexMailCheck(User user);
	public boolean sendVerificationEmail(User user);
}
