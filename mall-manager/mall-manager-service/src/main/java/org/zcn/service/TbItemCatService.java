package org.zcn.service;

import java.util.List;

import org.zcn.utils.EasyUITRreeNodeBean;

public interface TbItemCatService {
	List<EasyUITRreeNodeBean> getTbItemCatList(Long parentId);
}
