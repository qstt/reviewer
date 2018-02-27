package ustc.sce.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ustc.sce.domain.FileEntity;
import ustc.sce.domain.Paper;

public class PaperDaoImp extends HibernateDaoSupport implements PaperDao {

	@Override
	public boolean createPaper(String paperTitle, String paperAuthor, String paperOwner, boolean ispublic,
			int fileId) {
		
		Paper paper = new Paper();
		
		paper.setPaperTitle(paperTitle);
		paper.setPaperAuthor(paperAuthor);
		paper.setPaperOwner(paperOwner);
		paper.setIspublic(ispublic);
		
		String hql="from FileEntity as file where file.id='"+fileId+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
        FileEntity fileEntity = list.get(0);
		
		paper.setFileEntity(fileEntity);
		
		Serializable save = this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(paper);
		
		if(save == null){
            return false;
        }
            return true;
	}

}
