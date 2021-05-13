package com.findyourhair.hairanalysis.dao;

import java.util.ArrayList;

import com.findyourhair.hairanalysis.vo.SelectVo;
import com.findyourhair.hairanalysis.vo.ShopVo;

public interface ShopDao {
	
//	public  ArrayList<ShopVo> shoplist(String gender, int loc);

	public ArrayList<ShopVo> shoplist(SelectVo selectvo);
}
