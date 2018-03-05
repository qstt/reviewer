package ustc.sce.service;

import org.springframework.transaction.annotation.Transactional;

import ustc.sce.dao.UserDao;
import ustc.sce.domain.Role;
import ustc.sce.domain.User;
import ustc.sce.utils.MD5Utils;

@Transactional
public class UserServiceImp implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean login(String userName, String userPassword) {
		boolean login = userDao.login(userName,userPassword);
		if (login) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean register(String userName, String userPassword, String roleName) {
		userPassword = MD5Utils.md5(userPassword);
		boolean register = userDao.register(userName,userPassword,roleName);
		if (register) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 检测用户是否已经注册
	 */
	public User checkUser(String userName) {
		return userDao.checkUser(userName);
	}


	@Override
	public User resetPassword(String userName, String userPassword) {
		
		userPassword = MD5Utils.md5(userPassword);
		return userDao.resetPassword(userName,userPassword);
	}


	@Override
	public boolean exit(String userName) {
		return userDao.exit(userName);
	}

}
