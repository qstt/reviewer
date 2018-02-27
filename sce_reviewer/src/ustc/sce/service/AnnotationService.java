package ustc.sce.service;

import ustc.sce.domain.User;

public interface AnnotationService {

	boolean saveAnnotation(String annotationSelect, String annotationContent, int fileId, User user);

}
