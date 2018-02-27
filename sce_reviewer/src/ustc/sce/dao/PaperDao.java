package ustc.sce.dao;

public interface PaperDao {

	boolean createPaper(String paperTitle, String paperAuthor, String paperOwner, boolean ispublic, int fileId);

}
