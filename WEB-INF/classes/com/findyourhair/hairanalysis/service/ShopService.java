package com.findyourhair.hairanalysis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findyourhair.hairanalysis.dao.ShopDao;
import com.findyourhair.hairanalysis.vo.SelectVo;
import com.findyourhair.hairanalysis.vo.ShopVo;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;
	

	public ArrayList<ShopVo> shoplist(SelectVo selectvo) {
		ArrayList<ShopVo> shoplist = shopDao.shoplist(selectvo);
		return shoplist;
	}


}

