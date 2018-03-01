package ustc.sce.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ustc.sce.dao.FileDao;
import ustc.sce.domain.FileEntity;

@Transactional
public class FileServiceImp implements FileService {
	
	private FileDao fileDao;
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}


	public void FileSave(FileEntity fileUpload) {

		fileDao.FileSave(fileUpload);
	}


	public boolean fileDelete(FileEntity fileEntity) {
		return fileDao.fileDelete(fileEntity);
	}


	public boolean fileDelete(String fileName) {
		return fileDao.fileDelete(fileName);
	}

	@Override
	public boolean fileDelete(int fileId) {
		return fileDao.fileDelete(fileId);
	}

	@Override
	public List<FileEntity> fileList() {
		
		return fileDao.fileList();
	}


	@Override
	public String fielShow(String fileName) {
		
		return fileDao.fileShow(fileName);
	}


	@Override
	public FileEntity getFile(String fileName) {
		return fileDao.getFile(fileName);
	}


	

}
