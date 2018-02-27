package ustc.sce.service;

import org.springframework.transaction.annotation.Transactional;

import ustc.sce.dao.PaperDao;

@Transactional
public class PaperServiceImp implements PaperService {
	
	private PaperDao paperDao;
	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}

	public boolean create(String paperTitle, String paperAuthor, String paperOwner, boolean ispublic, int fileId) {
		return paperDao.createPaper(paperTitle,paperAuthor,paperOwner,ispublic,fileId);
	}

}
