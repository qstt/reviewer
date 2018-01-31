package ustc.sce.authorization;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import ustc.sce.utils.StringUtil;
import ustc.sce.utils.TokenUtil;

/**        
 * Title: TokenManager的默认实现    
 * Description: 管理 Token
 * 
 */      
public class DefaultTokenManager implements TokenManager {
	
	/**
	 * 将token存储到JVM内存(ConcurrentHashMap)中
	 */
	private static Map<String,String> tokenMap = new ConcurrentHashMap<String,String>();
	
	TokenUtil tokenUtil = new TokenUtil();

	/**
	 * 利用UUID创建Token(用户登录时，创建Token)
	 */
	public String createToken(String userName) {
		String token = UUID.randomUUID().toString();
		
//		tokenUtil.tokenSave(token, userName);
		
//		tokenMap.put(token, userName);
		return token;
	}

	/**
	 * Token验证(用户登录验证)
	 */
	public boolean checkToken(String token) {
		return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
	}

	/**
	 * @description Token删除(用户登出时，删除Token)
	 */
	public void deleteToken(String token) {
		tokenMap.remove(token);
		
	}

}
