package com.internousdev.anemone.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.anemone.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String address;
	private String phoneNumber;
	private String email;

	private Map<String,Object> session;

	private List<String> familyNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> addressErrorMessageList = new ArrayList<String>();
	private List<String> phoneNumberErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();


	public String execute(){

		/*セッションタイムアウト時の処理*/
		if(!session.containsKey("mCategoryList")) {
			return "sessionError";
		}

		String result=ERROR;


		/*最遷移の入力保持とDBへの登録のためにsessionへput*/
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("address", address);
		session.put("phoneNumber", phoneNumber);
		session.put("email", email);

		/*inputCheckerで入力内容を確認、エラーがあればListにメッセージを入力*/
		InputChecker inputChecker = new InputChecker();

		familyNameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false, false, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false, false, false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		addressErrorMessageList = inputChecker.doCheck("住所", address, 10, 50, true, true, true, true, true, true, false, false, false);
		phoneNumberErrorMessageList = inputChecker.doCheck("電話番号", phoneNumber, 10, 13, false, false, false, true, false, false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 10, 32, true, false, false, true, true, false, false, false, false);

		/*リストにエラーメッセージを入力した場合はERRORを返す*/
		if(familyNameErrorMessageList.size()>0
		|| firstNameErrorMessageList.size()>0
		||	familyNameKanaErrorMessageList.size()>0
		||	firstNameKanaErrorMessageList.size()>0
		||	addressErrorMessageList.size()>0
		||	phoneNumberErrorMessageList.size()>0
		||	emailErrorMessageList.size()>0) {
			return result;
		}

		result=SUCCESS;
		return result;
	}

	/*sessionへputする為に入力項目のsetter*/
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/*エラーメッセージを表示するためのgetter*/
	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public List<String> getAddressErrorMessageList() {
		return addressErrorMessageList;
	}

	public List<String> getPhoneNumberErrorMessageList() {
		return phoneNumberErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

}
