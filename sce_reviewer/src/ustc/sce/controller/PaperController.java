package ustc.sce.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ustc.sce.response.Response;
import ustc.sce.service.PaperService;

/**
 * 创建论文 关联文件（文件单独上传，在创建论文时提供文件的id进行关联）
 * 
 * @author 秋色天堂
 *
 */

@RestController
@RequestMapping("/paper")
public class PaperController {

	@Resource(name = "paperService")
	private PaperService paperService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPaper(@RequestParam("paperTitle") String paperTitle,
			@RequestParam("paperAuthor") String paperAuthor, 
			@RequestParam(value = "paperOwner",required = false) String paperOwner,
			@RequestParam("ispublic") boolean ispublic, 
			@RequestParam(value = "fileId",required = false) Integer fileId,
			HttpServletResponse response, HttpServletRequest request) {

		boolean flag = paperService.create(paperTitle, paperAuthor, paperOwner, ispublic, fileId);
		if (flag) {
			return JSON.toJSONString(new Response().success("createPaper Success..."));
		}
		return JSON.toJSONString(new Response().failure("createPaper Failure..."));
	}

}
