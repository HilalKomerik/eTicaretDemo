package eTicaretDemo.dateAccess.consretes;

import java.util.List;

import eTicaretDemo.dateAccess.abstracts.UserDao;
import eTicaretDemo.entities.consretes.User;
import eTicaretDemo.entities.consretes.UserList;

public class HibernateUseDao implements UserDao{

	private UserList userList ;
	public HibernateUseDao(UserList userList) {
		super();
		this.userList = userList;
	}

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile " + user.getFirstName()+" "+user.getLastName()+" eklendi");
		userList.userList.add(user);
		}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile " + user.getFirstName()+" "+user.getLastName()+" silindi.");
		userList.userList.remove(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile " + user.getFirstName()+" "+user.getLastName()+"  güncellendi.");
		
	}

	@Override
	public List<User> getAll() {
		return userList.userList;
	}

}
