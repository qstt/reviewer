package ustc.sce.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ustc.sce.domain.Token;

/**
 * 根据用户提供的token获得相应信息
 * @author 秋色天堂
 *
 */
public class TokenUtil extends HibernateDaoSupport{
	
	
	/**
	 * 将用户名和对应的token保存到数据库中
	 * @param token
	 * @param userName
	 */
	public void tokenSave(String token,String userName) {
		
		Token tk = new Token();
		
		tk.setToken(token);
		tk.setUserName(userName);
		System.out.println(tk.getToken()+"   " + tk.getUserName());
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(tk);
		
	}
	
	public int getId(String header) {
		
		String hql="from Token where token = '" + header + "'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<Token> list = query.list();
        if(list.isEmpty()){
            return -1;
        }
            return list.get(0).getId();
		
		
	}


}
