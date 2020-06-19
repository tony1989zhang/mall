package org.zcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zcn.mapper.TbItemCatMapper;
import org.zcn.mapper.TbItemParamMapper;
import org.zcn.pojo.TbItemCat;
import org.zcn.pojo.TbItemParam;
import org.zcn.pojo.TbItemParamExample;
import org.zcn.pojo.TbItemParamExample.Criteria;
import org.zcn.pojo.TbItemParamExt;
import org.zcn.service.TbItemParamService;
import org.zcn.utils.EasyUIDataGridResult;
import org.zcn.utils.ExceptionUtil;
import org.zcn.utils.FjnyResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public EasyUIDataGridResult getTbItemParamList(Integer page, Integer rows) {
		TbItemParamExample example = new TbItemParamExample();
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		//添加商品类目名称
		for (int i = 0; i < list.size(); i++) {
			TbItemParam tbItemParam = list.get(i);
			if (null != tbItemParam.getItemCatId()) {
				String itemCatName = getItemCatName(tbItemParam.getItemCatId());
				tbItemParam.setItemCatName(itemCatName);
			}
		
		}
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult gridResult = new EasyUIDataGridResult(total, list);
		return gridResult;
	}
	public String getItemCatName(Long id) {
		TbItemCat key = tbItemCatMapper.selectByPrimaryKey(id);
		System.out.println(key);
		return key.getName();
	}
	@Override
	public FjnyResult checkParam(Long itemCatId) {
		try {
			TbItemParamExample example = new TbItemParamExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andItemCatIdEqualTo(itemCatId);
			List<TbItemParam> withBLOBs = tbItemParamMapper.selectByExampleWithBLOBs(example);
			if(null == withBLOBs || withBLOBs.isEmpty()) {
				return FjnyResult.ok();
			}
			return FjnyResult.ok(withBLOBs.get(0));
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}
}
