package ustc.sce.service;


public interface UserService {



	public boolean login(String userName, String userPassword);

	public boolean register(String userName, String userPassword, String roleName);

}
