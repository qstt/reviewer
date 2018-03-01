package ustc.sce.service;

import java.util.List;

import ustc.sce.domain.FileEntity;

public interface FileService {

	void FileSave(FileEntity fileUpload);

	boolean fileDelete(int fileId);

	boolean fileDelete(String fileName);

	List<FileEntity> fileList();

	String fielShow(String fileName);

	boolean fileDelete(FileEntity fileEntity);
	
	

}
