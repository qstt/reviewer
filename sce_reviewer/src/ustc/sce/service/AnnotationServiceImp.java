package ustc.sce.service;

import org.springframework.transaction.annotation.Transactional;

import ustc.sce.dao.AnnotationDao;

@Transactional
public class AnnotationServiceImp implements AnnotationService {
	
	private AnnotationDao annotationDao;
	public void setAnnotationDao(AnnotationDao annotationDao) {
		this.annotationDao = annotationDao;
	}

	public boolean saveAnnotation(String annotationSelect, String annotationContent, int fileId) {
		return annotationDao.saveAnnotation(annotationSelect,annotationContent,fileId);
	}

}
