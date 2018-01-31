package ustc.sce.service;

import ustc.sce.domain.PaperReview;

public interface PaperReviewService {

	PaperReview notReview(int paperStatus, String paperTitle);

}
