package ustc.sce.domain;

/**
 * 论文：论文包含文件
 * @author 秋色天堂
 *
 */
public class Paper {
	
	private int id;
	//论文题目
	private String paperTitle;
	//论文作者
	private String paperAuthor;
	//论文所有者（感觉和用户有些冲突）
	private String paperOwner;
	//论文是否公开     不公开只能论文上传者也就是用户自己看到
	private boolean ispublic;
	
	//文件和论文之间的关联   一个论文可以有多个文件（pdf)
	//文件和论文是一对多关系   只在多方（论文）中维护这个关联
	private FileEntity fileEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public String getPaperAuthor() {
		return paperAuthor;
	}

	public void setPaperAuthor(String paperAuthor) {
		this.paperAuthor = paperAuthor;
	}

	public String getPaperOwner() {
		return paperOwner;
	}

	public void setPaperOwner(String paperOwner) {
		this.paperOwner = paperOwner;
	}

	public boolean isIspublic() {
		return ispublic;
	}

	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}

	public FileEntity getFileEntity() {
		return fileEntity;
	}

	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}
	
	


}
