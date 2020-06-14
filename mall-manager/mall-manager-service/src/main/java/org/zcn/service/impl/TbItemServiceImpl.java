package org.zcn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zcn.mapper.TbItemMapper;
import org.zcn.pojo.TbItem;
import org.zcn.pojo.TbItemExample;
import org.zcn.service.TbItemService;
import org.zcn.utils.EasyUIDataGridResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbItemServiceImpl implements TbItemService {

	@Resource
	private TbItemMapper tbItemMapper;
	
	@Override
	public EasyUIDataGridResult getTbItemList(Integer page,Integer rows) {
		//分页插件
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}

}
