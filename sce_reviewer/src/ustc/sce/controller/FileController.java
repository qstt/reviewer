package ustc.sce.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import ustc.sce.domain.FileEntity;
import ustc.sce.response.Response;
import ustc.sce.service.FileService;
import ustc.sce.utils.TokenUtil;

@RestController
@RequestMapping("/file")
public class FileController {

	@Resource(name = "fileService")
	private FileService fileService;
	
	private static Map<String,String> tokenMap = new ConcurrentHashMap<String,String>();

	/**
	 * 文件上传
	 * @param file 上传的文件
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUplod(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws Exception, Exception {

		FileEntity fileUpload = new FileEntity();
		TokenUtil tokenUtil = new TokenUtil();

		if (!file.isEmpty()) {
			// 文件保存路径 获得项目的路径 ServletContext sc = request.getSession().getServletContext();
			// String filePath = request.getSession().getServletContext().getRealPath("\\")
			// + "upload\\"
			// + file.getOriginalFilename();
			// // 转存文件
			// file.transferTo(new File(filePath));
			// 绝对路径
			String filePath = "J:\\eclipse\\apache-tomacat-7.0.47\\webapps\\upload\\reviewer\\" + file.getOriginalFilename();
			file.transferTo(new File(filePath));

			// 上传的文件名
			String fileName = file.getOriginalFilename();
			// 文件的扩展名
			String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// 去掉文件后缀名，保存到数据库中
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			

			String header = request.getHeader("X-Token");
			int userId = tokenUtil.getId(header);
			System.out.println(userId);
			
			fileUpload.setFileName(fileName);
			fileUpload.setFileType(extensionName);
			fileUpload.setFilePath(filePath);

			fileService.FileSave(fileUpload);

			return JSON.toJSONString(new Response().success("FileUpload Success..."));

		}
		return JSON.toJSONString(new Response().failure("FileUpload Failure..."));

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String fileDelete(@RequestBody FileEntity fileEntity) {
		String path = fileEntity.getFilePath();
		boolean flag = fileService.fileDelete(fileEntity);
		if (flag) {
			//通过绝对路径删除文件
			File file = new File(path);
			file.delete();
			return JSON.toJSONString(new Response().success("FileDelect Success..."));
		}
		return JSON.toJSONString(new Response().failure("FileDelect Failure..."));
		
	}
	
	/**
	 * 删除文件和数据库中的记录
	 * @param fileName 删除文件的名字
	 * @return
	 */
	@RequestMapping(value = "/delete1", method = RequestMethod.POST)
	public String fileDelete(@RequestParam("fileName") String fileName) {
		
		boolean flag = fileService.fileDelete(fileName);
		if (flag) {
			return JSON.toJSONString(new Response().success("FileDelect Success..."));
		}
		return JSON.toJSONString(new Response().failure("FileDelect Failure..."));
	}
	
	/**
	 * 显示文件列表（后面应该实现显示论文列表）
	 * @return
	 */
	@RequestMapping(value = "/fileList", method = RequestMethod.POST,produces="text/html;charset=utf-8")
	public String fileList() {
		List<FileEntity> fileEntity = fileService.fileList();
		if(!fileEntity.isEmpty()) {
//			return (List<FileEntity>) JSON.toJSON(fileEntity);
			return JSON.toJSONString(new Response().success(fileEntity));
		}
		return JSON.toJSONString(new Response().failure("FileList Failure..."));
//		return (List<FileEntity>) JSON.toJSON(fileEntity);
		
	}
	
	/**
	 * 文件详情  显示成网页版进行批注
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/fileShow", method = RequestMethod.POST,produces="text/html;charset=utf-8")
	public String fileShow(@RequestParam("fileName") String fileName) {
		
		String filePath = fileService.fielShow(fileName);
		
		if(filePath != null) {
			return JSON.toJSONString(new Response().success(filePath));
		}
		return JSON.toJSONString(new Response().failure("fileShow Failure..."));
		
	}

}
