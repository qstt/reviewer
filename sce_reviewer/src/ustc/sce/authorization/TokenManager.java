package ustc.sce.authorization;

public interface TokenManager {
	
	String createToken(String userName);
	
	boolean checkToken(String token);
	
	void deleteToken(String token);
	
}
