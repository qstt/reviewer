package ustc.sce.dao;

import java.util.List;

import ustc.sce.domain.FileEntity;

public interface FileDao {

	void FileSave(FileEntity fileUpload);

	boolean fileDelete(FileEntity fileEntity);

	boolean fileDelete(String fileName);

	List<FileEntity> fileList();

	String fileShow(String fileName);

}
