package ustc.sce.dao;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ustc.sce.domain.FileEntity;

public class FileDaoImp extends HibernateDaoSupport implements FileDao {

	public void FileSave(FileEntity fileUpload) {
//		this.getHibernateTemplate().save(fileUpload);  运行时会报错说找不到sessionFaction  不知道为什么会报错？？？
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(fileUpload);
	}

	@Override
	public boolean fileDelete(FileEntity fileEntity) {
		
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(fileEntity);
		
		String hql="from FileEntity as file where file.fileName='"+fileEntity.getFileName()+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
        if(list.isEmpty()){
            return false;
        }
            return true;
	}

	public boolean fileDelete(String fileName) {
		String hql="from FileEntity as file where file.fileName='"+fileName+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
        if(!list.isEmpty()){
        	FileEntity fileEntity = list.get(0);
        	String path = fileEntity.getFilePath();
        	//path只是文件存储路径的后半部分  加上前面的才是完整的路径
        	path = "J:\\eclipse\\apache-tomacat-7.0.47\\webapps\\upload\\" + path;
        	File file = new File(path);
        	this.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(fileEntity);
        	file.delete();
            return true;
        }
            return false;
	}
	
	
	public boolean fileDelete(int fileId) {
		String hql="from FileEntity as file where file.id='"+fileId+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
        if(!list.isEmpty()){
        	FileEntity fileEntity = list.get(0);
        	String path = fileEntity.getFilePath();
        	//path只是文件存储路径的后半部分  加上前面的才是完整的路径
        	path = "J:\\eclipse\\apache-tomacat-7.0.47\\webapps\\upload\\" + path;
        	File file = new File(path);
        	this.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(fileEntity);
        	file.delete();
            return true;
        }
            return false;
	}
	

	@Override
	public List<FileEntity> fileList() {
		String hql="from FileEntity";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
		return list;
	}

	@Override
	public String fileShow(String fileName) {
		//为什么这个hql语句会出错
		//[Request processing failed; nested exception is java.lang.ClassCastException: java.lang.String cannot be cast to ustc.sce.domain.FileEntity]
//		String hql="select file.filePath from FileEntity as file where file.fileName='"+fileName+"'";
		String hql="from FileEntity as file where file.fileName='"+fileName+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
		return list.get(0).getFilePath();
	}

	@Override
	public FileEntity getFile(String fileName) {
		String hql="from FileEntity as file where file.fileName='"+fileName+"'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =session.createQuery(hql);
        List<FileEntity> list = query.list();
        if(!list.isEmpty()){
        	return list.get(0);
        }
            return null;
	}

	

}
