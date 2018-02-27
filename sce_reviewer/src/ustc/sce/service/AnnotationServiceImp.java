package ustc.sce.service;

import org.springframework.transaction.annotation.Transactional;

import ustc.sce.dao.AnnotationDao;
import ustc.sce.domain.User;

@Transactional
public class AnnotationServiceImp implements AnnotationService {
	
	private AnnotationDao annotationDao;
	public void setAnnotationDao(AnnotationDao annotationDao) {
		this.annotationDao = annotationDao;
	}

	public boolean saveAnnotation(String annotationSelect, String annotationContent, int fileId, User user) {
		return annotationDao.saveAnnotation(annotationSelect,annotationContent,fileId,user);
	}

}
