package com.findyourhair.hairanalysis;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findyourhair.hairanalysis.service.BibiService;
import com.findyourhair.hairanalysis.service.ShopService;
import com.findyourhair.hairanalysis.vo.FaceFindVo;
import com.findyourhair.hairanalysis.vo.FaceVo;
import com.findyourhair.hairanalysis.vo.SelectVo;
import com.findyourhair.hairanalysis.vo.ShopVo;
import com.findyourhair.hairanalysis.vo.StyleFindVo;
import com.findyourhair.hairanalysis.vo.StyleVo;

import jep.Jep;
import jep.JepException;
import jep.MainInterpreter;
import jep.SharedInterpreter;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "Home";
	}
	@RequestMapping(value="/facetype", method=RequestMethod.GET)
	public String facetype() {
		return "facetypeGenderSelection";
	}
	
	@RequestMapping(value="/hairtype", method=RequestMethod.GET)
	public String hairtype() {
		return "hairGenderSelection";
	}
	
	@RequestMapping(value="/facetypeMale", method=RequestMethod.GET)
	public String facetypeMale(HttpSession session) {
		session.setAttribute("gender","male");
		return "imgUpload";
	}
	
	@RequestMapping(value="/facetypeFemale", method =RequestMethod.GET)
	public String facetypeFemale(HttpSession session){
		session.setAttribute("gender", "female");
		return "imgUpload";
	}
	
	@RequestMapping(value="/hairMale", method = RequestMethod.GET)
	public String hairMale(HttpSession session) {
		session.setAttribute("gender", "male");
		return "hairimgUpload";
	}
	
	@RequestMapping(value="/hairFemale", method = RequestMethod.GET)
	public String hairFemale(HttpSession session) {
		session.setAttribute("gender", "female");
		return "hairimgUpload";
	}

	
	@RequestMapping(value = "/imgUpload/post") //ajax에서 호출하는 부분
    public String faceupload(MultipartHttpServletRequest multipartRequest) throws UnsupportedEncodingException { //Multipart로 받는다.
         
        Iterator<String> itr =  multipartRequest.getFileNames();
        
        String filePath = "E:\\big12\\Spring_dev\\eclipse\\img"; //설정파일로 뺀다.
        
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
            
            /* 기존 주석처리
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            String originFileName = mpf.getOriginalFilename();
            System.out.println("FILE_INFO: "+originFileName); //받은 파일 리스트 출력'
            */
            
            MultipartFile mpf = multipartRequest.getFile(itr.next());
     
            String originalFilename = new String(mpf.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8"); //파일명
     
            String fileFullPath = filePath+"/"+"test.jpg"; //파일 전체 경로
     
            try {
                //파일 저장
                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
                
                System.out.println("originalFilename => "+originalFilename);
                System.out.println("fileFullPath => "+fileFullPath);
     
            } catch (Exception e) {
                System.out.println("postTempFile_ERROR======>"+fileFullPath);
                e.printStackTrace();
            }
                         
       }
         
        return "result";
    }
	
	@RequestMapping(value = "/hairimgUpload/post")
    public String hairupload(MultipartHttpServletRequest multipartRequest) throws UnsupportedEncodingException {
		Iterator<String> itr =  multipartRequest.getFileNames();
        
        String filePath = "E:\\big12\\Spring_dev\\eclipse\\img"; //설정파일로 뺀다.
        
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
            
            /* 기존 주석처리
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            String originFileName = mpf.getOriginalFilename();
            System.out.println("FILE_INFO: "+originFileName); //받은 파일 리스트 출력'
            */
            
            MultipartFile mpf = multipartRequest.getFile(itr.next());
     
            String originalFilename = new String(mpf.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8"); //파일명
     
            String fileFullPath = filePath+"/"+"test.jpg"; //파일 전체 경로
     
            try {
                //파일 저장
                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
                
                System.out.println("originalFilename => "+originalFilename);
                System.out.println("fileFullPath => "+fileFullPath);
     
            } catch (Exception e) {
                System.out.println("postTempFile_ERROR======>"+fileFullPath);
                e.printStackTrace();
            }
                         
       }
         
        return "result";
    }
	
	@RequestMapping(value="/facetypeLoading", method=RequestMethod.POST)
		public String facetypeLoading() {
			
			return "facetypeAnalysisLoading";
	}
	
	@RequestMapping(value="/hairLoading", method = RequestMethod.POST)
		public String hairLoading() {
		
			return "hairAnalysisLoading";
	}
	
	@RequestMapping(value="/facetypeResult", method=RequestMethod.GET)
	public String facetypeResult(HttpSession session, Model model) throws JepException {
		String gender = (String) session.getAttribute("gender");
		if(gender == "male") {
			gender = "M";
			SharedInterpreter jep = new SharedInterpreter();
			try {
			jep.eval("import tensorflow.keras");
			jep.eval("from PIL import Image, ImageOps");
			jep.eval("import numpy as np");
			jep.eval("import os");
			jep.eval("np.set_printoptions(suppress=True)");
			jep.eval("model = tensorflow.keras.models.load_model('./M_FacetypeAnalysis.h5')");
			jep.eval("data = np.ndarray(shape=(1, 224, 224, 3), dtype=np.float32)");
			jep.eval("image = Image.open('./img/test.jpg')");
			jep.eval("size = (224, 224)");
			jep.eval("image = ImageOps.fit(image, size, Image.ANTIALIAS)");
			jep.eval("image_array = np.asarray(image)");
			jep.eval("normalized_image_array = (image_array.astype(np.float32) / 127.0) - 1");
			jep.eval("data[0] = normalized_image_array");
			jep.eval("class_names = ['계란형','둥근형','각진형','역삼각형','긴형']");
			jep.eval("prediction = model.predict(data)");
			jep.eval("score = np.array(prediction[0])");
			jep.eval("score_second = np.delete(score, np.argmax(score))");
			jep.eval("result = \"{}\".format(class_names[np.argmax(score)])");
			jep.eval("os.remove('./img/test.jpg')");
			String result = jep.getValue("result").toString();
			session.setAttribute("result", result);
			System.out.println(result);
			session.setAttribute("track", "visited");
			jep.close();
			int resultnum;
			String imgsrc;
			if(result.equals("계란형")) {
				resultnum = 2;
				imgsrc = "M_계란형.jpg";
			}
			else if(result.equals("각진형")) {
				resultnum = 1;
				imgsrc = "M_각진형.jpeg";
			}
			else if(result.equals("긴형")) {
				resultnum = 3;
				imgsrc = "M_긴형.jpg";
			}
			else if(result.equals("둥근형")) {
				resultnum = 4;
				imgsrc = "M_둥근형.jpeg";
			}
			else if(result.equals("역삼각형")){
				resultnum = 5;
				imgsrc = "M_역삼각형.jpg";
			}
			else {
				resultnum = 0;
				imgsrc = "";
			}
			FaceFindVo ffv = new FaceFindVo();
			ffv.setFace_code(resultnum);
			ffv.setGender(gender);
			ArrayList<FaceVo> face_style =bibiService.face_style(ffv);
			session.setAttribute("imgsrc", imgsrc);
			model.addAttribute("face_style", face_style);
			System.out.println(face_style.get(0).getF_exp());
			}
			catch (JepException e) {
				jep.close();
				return "error";
			}
		}
		else if(gender == "female") {
			SharedInterpreter jep = new SharedInterpreter();
			try {
			jep.eval("import tensorflow.keras");
			jep.eval("from PIL import Image, ImageOps");
			jep.eval("import numpy as np");
			jep.eval("import os");
			jep.eval("np.set_printoptions(suppress=True)");
			jep.eval("model = tensorflow.keras.models.load_model('./F_FacetypeAnalysis.h5')");
			jep.eval("data = np.ndarray(shape=(1, 224, 224, 3), dtype=np.float32)");
			jep.eval("image = Image.open('./img/test.jpg')");
			jep.eval("size = (224, 224)");
			jep.eval("image = ImageOps.fit(image, size, Image.ANTIALIAS)");
			jep.eval("image_array = np.asarray(image)");
			jep.eval("normalized_image_array = (image_array.astype(np.float32) / 127.0) - 1");
			jep.eval("data[0] = normalized_image_array");
			jep.eval("class_names = ['계란형','둥근형','각진형','역삼각형','긴형']");
			jep.eval("prediction = model.predict(data)");
			jep.eval("score = np.array(prediction[0])");
			jep.eval("score_second = np.delete(score, np.argmax(score))");
			jep.eval("result = \\\"{}\\\".format(class_names[np.argmax(score)])");
			jep.eval("os.remove('./img/test.jpg')");
			String result = jep.getValue("result").toString();
			session.setAttribute("result", result);
			System.out.println(result);
			jep.close();
			}
			catch(JepException e) {
				jep.close();
				return "error";
			}
		}
		return "facetypeResult";
	}
	@RequestMapping(value="/hairResult", method=RequestMethod.GET)
	public String hairResult(HttpSession session, Model model) throws JepException {
		String gender = (String) session.getAttribute("gender");
		if(gender == "male") {
			SharedInterpreter jep = new SharedInterpreter();
			jep.eval("import tensorflow.keras");
			jep.eval("import numpy as np");
			jep.eval("import os");
			jep.eval("from glob import glob");
			jep.eval("model = tensorflow.keras.models.load_model('./M_HairPrediction.h5')");
			jep.eval("img_height = 180");
			jep.eval("img_width = 180");
			jep.eval("class_names = ['베이비펌', '크롭컷', '포마드펌', '가일컷', '가르마펌', '모히칸컷', '셰도우펌']");
			jep.eval("image_path = './img/test.jpg'");
			jep.eval("img = tensorflow.keras.preprocessing.image.load_img(image_path, target_size=(img_height, img_width))");
			jep.eval("img_array = tensorflow.keras.preprocessing.image.img_to_array(img)");
			jep.eval("img_array = tensorflow.expand_dims(img_array, 0)");
			jep.eval("predictions = model.predict(img_array)");
			jep.eval("score = tensorflow.nn.softmax(predictions[0])");
			jep.eval("score_second = np.array(score)");
			jep.eval("score_second = np.where(score_second==np.max(score_second), -1, score_second)");
			jep.eval("result = \"{}일 확률이 {:.2f}%, {}일 확률이 {:2f}% 입니다\".format(class_names[np.argmax(score)], 100 * np.max(score), class_names[np.argmax(score_second)], 100 * np.max(score_second))");
			jep.eval("os.remove('./img/test.jpg')");
			String result = jep.getValue("result").toString();
			session.setAttribute("result", result);
			jep.close();
			
		}
		else if(gender == "female") {
			SharedInterpreter jep = new SharedInterpreter();
			jep.eval("import tensorflow.keras");
			jep.eval("import numpy as np");
			jep.eval("import os");
			jep.eval("from glob import glob");
			jep.eval("model = tensorflow.keras.models.load_model('./F_HairPrediction.h5')");
			jep.eval("img_height = 180");
			jep.eval("img_width = 180");
			jep.eval("class_names = ['보브컷', '빌드펌', 'C컬펌', '히메컷', '허그컷', '젤리펌', '레이어드펌', '리프컷', '테슬컷', '볼륨매직']");
			jep.eval("image_path = './img/test.jpg'");
			jep.eval("img = tensorflow.keras.preprocessing.image.load_img(image_path, target_size=(img_height, img_width))");
			jep.eval("img_array = tensorflow.keras.preprocessing.image.img_to_array(img)");
			jep.eval("img_array = tensorflow.expand_dims(img_array, 0)");
			jep.eval("predictions = model.predict(img_array)");
			jep.eval("score = tensorflow.nn.softmax(predictions[0])");
			jep.eval("score_second = np.array(score)");
			jep.eval("score_second = np.where(score_second==np.max(score_second), -1, score_second)");
			jep.eval("result = \"{}일 확률이 {:.2f}%, {}일 확률이 {:2f}% 입니다\".format(class_names[np.argmax(score)], 100 * np.max(score), class_names[np.argmax(score_second)], 100 * np.max(score_second))");
			jep.eval("os.remove('./img/test.jpg')");
			String result = jep.getValue("result").toString();
			session.setAttribute("result", result);
			jep.close();
		}
		return "hairResult";
	}
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error(HttpSession session) {
		
		return "error";
	}
	
	@RequestMapping("/error/get")
	public String reupload() {
		return "imgUpload";
		}
	
	@RequestMapping(value="/selectLocation", method = RequestMethod.POST)
	public String selectLocation() {
		
		return "selectLocation";
	}
//	@RequestMapping(value="/hairshopList", method = RequestMethod.POST)
//	public String hairshopList(HttpSession session, @RequestParam("location") String loc) {
//		session.setAttribute("loc", loc);
//		return "hairshopList";
//		
//	}
	@RequestMapping(value="/facetypeHairrec", method = RequestMethod.GET)
	public String facetypeHairrec() {
		
		return "facetypeHairrec";
	}
//	@Autowired
//	private ShopService shopService;
//
//	@RequestMapping(value="/hairshopList", method=RequestMethod.POST)
//	public String ShopList(Model model, HttpSession session, @RequestParam("location") int loc) {
//				SelectVo selectvo = new SelectVo();
//				String gender = (String) session.getAttribute("gender");
//				if(gender == "male") {
//					gender = "M";
//				}
//				else {
//					gender = "F";
//				}
//				selectvo.setGender(gender);
//				selectvo.setLoc(loc);
//				ArrayList<ShopVo> shoplist =shopService.shoplist(selectvo);
//				model.addAttribute("shoplist", shoplist);
//				return "shop";
//			}	
	
	
	@Autowired
	private BibiService bibiService;
	
	
	@RequestMapping(value="/hairshopList", method=RequestMethod.GET)
		public String shoplist( HttpSession session, @RequestParam("location") int loc ,Model model) {
		SelectVo selectvo = new SelectVo();
		String gender = (String) session.getAttribute("gender");
		if(gender == "male") {
			gender = "M";
		}
		else {
			gender = "F";
		}
		selectvo.setGender(gender);
		selectvo.setLoc(loc);
		ArrayList<ShopVo> shoplist =bibiService.shoplist(selectvo);
		model.addAttribute("shoplist", shoplist);
			return "";
		}
	
	@RequestMapping(value="/dfr", method=RequestMethod.GET)
		public String face_style(   FaceFindVo ffv ,        Model model) {
		ArrayList<FaceVo> face_style =bibiService.face_style(ffv);
		model.addAttribute("face_style", face_style);
			return "";
		}
	
	@RequestMapping(value="", method=RequestMethod.GET)
		public String style_tag(    StyleFindVo sfv   ,     Model model) {
		ArrayList<StyleVo> style_tag =bibiService.style_tag( sfv );
		model.addAttribute("style_tag", style_tag);
			return "";
		}
	
		
		
	
	
	
	
	@RequestMapping(value="/dosim", method = RequestMethod.GET)
	public String dosim(HttpSession session) {
		session.setAttribute("loc", "dosim");
		return "hairshopList";
	}
	
	@RequestMapping(value="/dongnam", method = RequestMethod.GET)
	public String dongnam(HttpSession session) {
		session.setAttribute("loc", "dongnam");
		return "hairshopList";
	}
	@RequestMapping(value="/dongbuk", method = RequestMethod.GET)
	public String dongbuk(HttpSession session) {
		session.setAttribute("loc", "dongbuk");
		return "hairshopList";
	}
	@RequestMapping(value="/seonam", method = RequestMethod.GET)
	public String seonam(HttpSession session) {
		session.setAttribute("loc", "seonam");
		return "hairshopList";
	}
	@RequestMapping(value="/seobuk", method = RequestMethod.GET)
	public String seobuk(HttpSession session) {
		session.setAttribute("loc", "seobuk");
		return "hairshopList";
	}
	
	}
