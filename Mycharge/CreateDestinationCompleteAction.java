package com.internousdev.anemone.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.anemone.dao.DestinationInfoDAO;
import com.internousdev.anemone.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;

	public String execute(){

		List<String> familyNameErrorMessageList = new ArrayList<String>();
		List<String> firstNameErrorMessageList = new ArrayList<String>();
		List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
		List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
		List<String> addressErrorMessageList = new ArrayList<String>();
		List<String> phoneNumberErrorMessageList = new ArrayList<String>();
		List<String> emailErrorMessageList = new ArrayList<String>();

		String result=ERROR;

		/*セッションタイムアウト時の処理*/
		if(!session.containsKey("mCategoryList")) {
			return "sessionError";
		}

		/*sessionに項目が入っていない場合はERRORを返す*/
		if(!session.containsKey("familyName") || !session.containsKey("firstName") || !session.containsKey("familyNameKana")
				|| !session.containsKey("firstNameKana") || !session.containsKey("address") || !session.containsKey("phoneNumber") ||!session.containsKey("email") ){
		return result;
		}

		/*inputCheckerで入力内容を確認、エラーがあればListにメッセージを入力*/
		InputChecker inputChecker = new InputChecker();

		familyNameErrorMessageList = inputChecker.doCheck("姓", (session.get("familyName").toString()), 1, 16, true, true, true, false, false, false, false, false, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", (session.get("firstName").toString()), 1, 16, true, true, true, false, false, false, false, false, false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", (session.get("familyNameKana").toString()), 1, 16, false, false, true, false, false, false, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", (session.get("firstNameKana").toString()), 1, 16, false, false, true, false, false, false, false, false, false);
		addressErrorMessageList = inputChecker.doCheck("住所", (session.get("address").toString()), 10, 50, true, true, true, true, true, true, false, false, false);
		phoneNumberErrorMessageList = inputChecker.doCheck("電話番号", (session.get("phoneNumber").toString()), 10, 13, false, false, false, true, false, false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", (session.get("email").toString()), 10, 32, true, false, false, true, true, false, false, false, false);

		/*リストにエラーメッセージを入力した場合はERRORを返す*/
		if(familyNameErrorMessageList.size()>0
		|| firstNameErrorMessageList.size()>0
		|| familyNameKanaErrorMessageList.size()>0
		|| firstNameKanaErrorMessageList.size()>0
		|| addressErrorMessageList.size()>0
		|| phoneNumberErrorMessageList.size()>0
		|| emailErrorMessageList.size()>0) {
		return result;
		}


		/*DBと接続して登録ができた場合SUCCESを返す*/
		DestinationInfoDAO dao= new DestinationInfoDAO();
		int count = dao.insertDestinationInfo(String.valueOf(session.get("loginId")), (session.get("familyName")).toString(), (session.get("firstName")).toString(),
				(session.get("familyNameKana")).toString(), (session.get("firstNameKana")).toString(),
				(session.get("address")).toString(), (session.get("phoneNumber")).toString(), (session.get("email")).toString());
		if(count>0){
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("address");
			session.remove("phoneNumber");
			session.remove("email");
			result=SUCCESS;
		}
		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
