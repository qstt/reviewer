package ustc.sce.dao;

import java.util.List;

import ustc.sce.domain.Role;
import ustc.sce.domain.User;

public interface UserDao {

	public boolean login(String userName, String userPassword);

	public boolean register(String userName, String userPassword, String roleName);

	public User checkUser(String userName);

	public User resetPassword(String userName, String userPassword);

	public boolean exit(String userName);

	public List<Role> getRole();

}
