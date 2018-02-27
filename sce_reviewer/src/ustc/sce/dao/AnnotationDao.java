package ustc.sce.dao;

import ustc.sce.domain.User;

public interface AnnotationDao {

	boolean saveAnnotation(String annotationSelect, String annotationContent, int fileId, User user);

}
