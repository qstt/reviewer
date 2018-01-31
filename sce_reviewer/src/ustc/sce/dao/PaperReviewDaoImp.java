package ustc.sce.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ustc.sce.domain.Paper;
import ustc.sce.domain.PaperReview;

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

}
