package ustc.sce.dao;

import ustc.sce.domain.PaperReview;
import ustc.sce.domain.User;

public interface PaperReviewDao {

	PaperReview notReview(int paperStatus, String paperTitle, User user);

	PaperReview changeReview(int paperStatus, String paperTitle);

}
