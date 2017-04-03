package com.binaryhunter.framework.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTFul控制器
 * @author Liyw
 */
@RestController
@RequestMapping("/api")
public class ApiController extends GenericController{
	//private static Logger logger = Logger.getLogger(CommonController.class);
	
	@RequestMapping("")
	public Object api(HttpServletRequest request){
		String basepath = getBasePath(request);
		
		Map<String, String> apiMap = new HashMap<String, String>();
		apiMap.put("ps_url", basepath + "api/ps");
		
		return toResponse(apiMap);
	}
	
	@RequestMapping("/404")
	public Object error404(){
		return toResponse("URL not found!", 404);
	}
	
	@RequestMapping("/500")
	public Object error500(){
		return toResponse("HTTP-Internal Server Error!", 500);
	}
}
