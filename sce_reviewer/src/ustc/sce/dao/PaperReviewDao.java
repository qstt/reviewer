package ustc.sce.dao;

import ustc.sce.domain.PaperReview;

public interface PaperReviewDao {

	PaperReview notReview(int paperStatus, String paperTitle);

}
