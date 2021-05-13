package com.findyourhair.hairanalysis.dao;

import java.util.ArrayList;

import com.findyourhair.hairanalysis.vo.FaceFindVo;
import com.findyourhair.hairanalysis.vo.FaceVo;
import com.findyourhair.hairanalysis.vo.SelectVo;
import com.findyourhair.hairanalysis.vo.ShopVo;
import com.findyourhair.hairanalysis.vo.StyleFindVo;
import com.findyourhair.hairanalysis.vo.StyleVo;

public interface BibiDao {
	
	public ArrayList<ShopVo> shoplist(SelectVo selectvo);
	public ArrayList<FaceVo> face_style(FaceFindVo ffv);
	public ArrayList<StyleVo> style_tag(StyleFindVo sfv);



}
