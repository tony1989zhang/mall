package org.zcn.service;

import org.zcn.utils.EasyUIDataGridResult;
import org.zcn.utils.FjnyResult;

public interface TbItemParamService {
	public EasyUIDataGridResult getTbItemParamList(Integer page,Integer rows);
	public FjnyResult checkParam(Long itemCatId);

}
