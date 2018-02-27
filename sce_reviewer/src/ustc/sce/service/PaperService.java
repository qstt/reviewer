package ustc.sce.service;

public interface PaperService {

	boolean create(String paperTitle, String paperAuthor, String paperOwner, boolean ispublic, int fileId);

}
