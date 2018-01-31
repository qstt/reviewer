package ustc.sce.dao;


public interface UserDao {


	public boolean login(String userName, String userPassword);

	public boolean register(String userName, String userPassword, String roleName);

}
