package ustc.sce.domain;

/**
 * 上传的文件   默认为pdf文件
 * @author 秋色天堂
 *
 */
public class FileEntity {
	
	private int id;
	//上传的文件名称
	private String fileName;
	//上传的文件的类型   默认为pdf
	private String fileType = "pdf";
	//上传文件的位置
	private String filePath;
	
	//用户和文件之间的关联   一个用户可以上传多个文件
	//用户和文件是一对多关系   只在多方（文件）中维护这个关联
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}
