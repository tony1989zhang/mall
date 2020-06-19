package org.zcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zcn.service.TbItemParamService;
import org.zcn.utils.EasyUIDataGridResult;
import org.zcn.utils.FjnyResult;

@Controller
@RequestMapping("/item/param")
public class TbItemParamLController {
	
	@Autowired
	private TbItemParamService tbItemParamService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult TbItemParamList(@RequestParam(defaultValue = "1") 
	Integer page
	,@RequestParam(defaultValue = "30") Integer rows) {
		return tbItemParamService.getTbItemParamList(page, rows);
	}

	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public FjnyResult checkParam(@PathVariable Long itemCatId) {
		return tbItemParamService.checkParam(itemCatId);
	}
}
