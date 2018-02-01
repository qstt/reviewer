package ustc.sce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ustc.sce.domain.Paper;
import ustc.sce.domain.PaperReview;
import ustc.sce.domain.User;
import ustc.sce.utils.MD5Utils;

public class PaperReviewDaoImp extends HibernateDaoSupport implements PaperReviewDao {

	public PaperReview notReview(int paperStatus, String paperTitle) {

		PaperReview paperReview = new PaperReview();
		Paper paper = new Paper();

		paperReview.setPaperStatus(paperStatus);
		paper.setPaperTitle(paperTitle);
		paperReview.setPaper(paper);

		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(paperReview);

		return paperReview;
	}

	public PaperReview changeReview(int paperStatus, String paperTitle) {

		String hql = "from Paper where paperTitle='" + paperTitle + "'";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		List<Paper> list = query.list();

		int paperId = list.get(0).getId();
		System.out.println(paperId);

		String hql1 = "from PaperReview where paperId='" + paperId + "'";
		Session session1 = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query1 = session1.createQuery(hql1);
		List<PaperReview> list1 = query1.list();

		PaperReview paperReview = list1.get(0);
		paperReview.setPaperStatus(paperStatus);

		this.getHibernateTemplate().getSessionFactory().getCurrentSession().update(paperReview);

		return paperReview;
	}

}
