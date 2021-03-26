package com.uniform.ea.common;

import java.util.List;

import com.uniform.ea.approval.vo.EaApprovalVO;
import com.uniform.ea.approval.vo.EaDocumentVO;
import com.uniform.ea.approval.vo.EaGianVO;
import com.uniform.ea.approval.vo.EaLineVO;
import com.uniform.ea.approval.vo.EaPoomVO;
import com.uniform.ea.approval.vo.EaUploadboardVO;
import com.uniform.ea.approval.vo.EaVacationVO;

public class Chaebun {

	//기안서 채번
	public static String gianChaebun(List<EaGianVO> chList){
		String gianCh = chList.get(0).getGi_docno();
		
		for(int i=gianCh.length(); i<4; i++){
			gianCh = "0" + gianCh;
		}
		gianCh = "GI" + gianCh;
		return gianCh;
	}
	
	//휴가계 채번
	public static String vacaChaebun(List<EaVacationVO> chList){
		String vacaCh = chList.get(0).getVa_docno();
		
		for(int i=vacaCh.length(); i<4; i++){
			vacaCh = "0" + vacaCh;
		}
		vacaCh = "VA" + vacaCh;
		return vacaCh;
	}	
	
	//결재선 채번
	public static String eaLineChaebun(List<EaLineVO> chList){
		String lineCh = chList.get(0).getEa_lineno();
		
		for(int i=lineCh.length();i<4;i++){
			lineCh = "0" + lineCh;
		}
		lineCh = "AL" + lineCh;
		return lineCh;
	}
	
	//결재 채번
	public static String eaChaebun(List<EaApprovalVO> chList){
		String eaCh = chList.get(0).getEa_no();
		
		for(int i=eaCh.length();i<4;i++){
			eaCh = "0" + eaCh;
		}
		eaCh = "EA" + eaCh;
		return eaCh;
	}
	
    public static String poomChaebun(List<EaPoomVO> chList){
	      String poomCh = chList.get(0).getPo_docno();
	      
	      for(int i=poomCh.length(); i<4; i++){
	         poomCh = "0" + poomCh;
	      }
	      poomCh = "PO" + poomCh;
	      return poomCh;
    }
   
    public static String lineChaebun(List<EaLineVO> chLine){
	      String lineCh = chLine.get(0).getEa_lineno();
	      
	      for(int i=lineCh.length(); i<4; i++){
	         lineCh = "0" + lineCh;
	      }
	      lineCh = "AL" + lineCh;
	      return lineCh;
    }
   
    public static String documentChaebun(List<EaDocumentVO> chDoc){
	      String docCh = chDoc.get(0).getDo_docno();
	      
	      for(int i=docCh.length(); i<4; i++){
	         docCh = "0" + docCh;
	      }
	      docCh = "DO" + docCh;
	      return docCh;
    }	
    
    public static String uploadChaebun(List<EaUploadboardVO> chUp){
	      String eaUp = chUp.get(0).getUp_no();
	      
	      for(int i=eaUp.length(); i<4; i++){
	    	  eaUp = "0" + eaUp;
		   }
	      	      
	      return eaUp;
	   }    
} //end of Chaebun class
