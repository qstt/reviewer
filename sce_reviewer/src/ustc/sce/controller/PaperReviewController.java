package ustc.sce.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ustc.sce.domain.PaperReview;
import ustc.sce.response.Response;
import ustc.sce.service.PaperReviewService;

@RestController
@RequestMapping("/paper-review")
public class PaperReviewController {
	
	@Resource(name="paperReviewService")
	private PaperReviewService paperReviewService;
	
	@RequestMapping(value = "/not-review",method = RequestMethod.POST)
	public String notReview(@RequestParam("paperStatus") int paperStatus,@RequestParam("paperTitle") String paperTitle) {
		
		PaperReview paperReview = paperReviewService.notReview(paperStatus,paperTitle);
		
		if (paperReview != null) {
			return JSON.toJSONString(new Response().success(paperReview));
		}
		return JSON.toJSONString(new Response().failure("notReview Failure..."));
		
	}

}
