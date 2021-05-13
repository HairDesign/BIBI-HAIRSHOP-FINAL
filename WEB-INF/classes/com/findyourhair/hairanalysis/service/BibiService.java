package com.findyourhair.hairanalysis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findyourhair.hairanalysis.dao.BibiDao;
import com.findyourhair.hairanalysis.vo.FaceFindVo;
import com.findyourhair.hairanalysis.vo.FaceVo;
import com.findyourhair.hairanalysis.vo.SelectVo;
import com.findyourhair.hairanalysis.vo.ShopVo;
import com.findyourhair.hairanalysis.vo.StyleFindVo;
import com.findyourhair.hairanalysis.vo.StyleVo;

@Service
public class BibiService {
	

	@Autowired 
	private BibiDao bibidao;
		
	public ArrayList<ShopVo> shoplist(SelectVo selectvo){
		ArrayList<ShopVo> shoplist = bibidao.shoplist(selectvo);
		return shoplist;
	}
	
	
	public ArrayList<FaceVo> face_style(FaceFindVo ffv){
			ArrayList<FaceVo> facelist = bibidao.face_style(ffv);
			return facelist;
		}
		
	public ArrayList<StyleVo> style_tag(StyleFindVo sfv){
			ArrayList<StyleVo> stylelist = bibidao.style_tag(sfv);
			return stylelist;
		}


}
