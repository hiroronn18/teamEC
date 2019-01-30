package com.internousdev.anemone.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private String confirmFlg;

	public String execute(){

		/*セッションタイムアウト時の処理*/
		if(!session.containsKey("mCategoryList")) {
			return "sessionError";
		}

		if(confirmFlg==null){
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("address");
		session.remove("phoneNumber");
		session.remove("email");
		}

		return SUCCESS;
	}


 	public void setSession(Map<String,Object> session){
 		this.session=session;
 	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setConfirmFlg(String confirmFlg) {
		this.confirmFlg = confirmFlg;
	}


}
