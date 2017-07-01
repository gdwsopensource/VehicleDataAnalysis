/*
 * File Name：test.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月30日 下午2:11:15
 */
package com.gdws.vehicle.controller.rest;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月30日 下午2:11:15
 */
@Controller
public class Test {
	@RequestMapping("test")
	JSONObject test() {
		String name = "广园快速369号路段";
		String time = "2017-02-26";
		String sendUrl = "http://192.168.1.138:8082/getCarOverviewCross?crossName=" + name + "&crossTime=" + time;
		HttpClient client = new HttpClient();
		HttpMethod getMethod = new GetMethod(sendUrl);
		JSONObject jo = new JSONObject();
		getMethod.setRequestHeader(new Header("Accept-Language", "zh-cn"));
		try {
			client.executeMethod(getMethod);
			if (getMethod.getStatusCode() == 200) {
				String jsonStr = getMethod.getResponseBodyAsString();
				jo = JSONObject.parseObject(jsonStr);
				// JSONArray documents = jo.getJSONArray("documents");
				//
				// //filterKbCategoryByPermission(documents);业务处理
				// String searchJson = jo.toString();
			}
			return jo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
