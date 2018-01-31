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
		boolean fileDelect = fileDao.fileDelete(fileEntity);
		if (fileDelect) {
			return true;
		} else {
			return false;
		}
	}


	public boolean fileDelete(String fileName) {
		boolean fileDelect = fileDao.fileDelete(fileName);
		if (fileDelect) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public List<FileEntity> fileList() {
		
		return fileDao.fileList();
	}


	@Override
	public String fielShow(String fileName) {
		
		return fileDao.fileShow(fileName);
	}

}
