<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">

<title>宛先情報入力確認画面</title>
</head>
<body>
<s:include value="header.jsp" />
<div id ="contents">

<h1>宛先情報入力確認画面</h1>

	<s:form action="CreateDestinationCompleteAction">
	<table class="vertical-list-table">

	<tr>
		<th>姓</th>
		<td><s:property value="%{#session.familyName}"/></td>
	</tr>

	<tr>
		<th>名</th>
		<td><s:property value="%{#session.firstName}" /></td>
	</tr>

	<tr>
		<th>姓ふりがな</th>
		<td><s:property value="%{#session.familyNameKana}"/></td>
	</tr>

	<tr>
		<th>名ふりがな</th>
		<td><s:property value="%{#session.firstNameKana}"/></td>
	</tr>

	<tr>
		<th>住所</th>
		<td><s:property value="%{#session.address}"/></td>
	</tr>

	<tr>
		<th>電話番号</th>
		<td><s:property value="%{#session.phoneNumber}" /></td>
	</tr>

	<tr>
		<th>メールアドレス</th>
		<td><s:property value="%{#session.email}"/></td>
	</tr>
	</table>

	<div class="submit_btn_box">
	<div id=".contents-btn-set">
	<s:submit value="登録" class="submit_btn" />
	</div>
	</div>
	</s:form>
	<s:form action="CreateDestinationAction">
	<div class="submit_btn_box">
	<div id=".contents-btn-set">
	<s:submit value="戻る" class="submit_btn" />
	<s:hidden name="confirmFlg" value="1" />
	</div>
	</div>
	</s:form>

	</div>

<s:include value = "footer.jsp"/>
</body>
</html>