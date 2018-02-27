package ustc.sce.dao;


public interface AnnotationDao {

	boolean saveAnnotation(String annotationSelect, String annotationContent, int fileId);

}
