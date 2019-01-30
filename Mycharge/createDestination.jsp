<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">


<title>宛先情報入力画面</title>
</head>
<body>
<s:include value="header.jsp" />
<div id ="contents">

<h1>宛先情報入力画面</h1>


 	<!-- エラーメッセージの表示 -->

	<s:if test="!familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!addressErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="addressErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!phoneNumberErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="phoneNumberErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<s:if test="!emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="message message_error">
	<s:iterator value ="emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</s:if>

	<!-- 入力フォーム -->
	<s:form action="CreateDestinationConfirmAction">
	<table class="vertical-list-table">

	<tr>
		<th>姓</th>
		<td><s:textfield name="familyName" value="%{#session.familyName}" class="txt" /></td>
	</tr>

	<tr>
		<th>名</th>
		<td><s:textfield name="firstName" value="%{#session.firstName}" class="txt"/></td>
	</tr>

	<tr>
		<th>姓ふりがな</th>
		<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" class="txt"/></td>
	</tr>

	<tr>
		<th>名ふりがな</th>
		<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" class="txt"/></td>
	</tr>

	<tr>
		<th>住所</th>
		<td><s:textfield name="address" value="%{#session.address}" class="txt"/></td>
	</tr>

	<tr>
		<th>電話番号</th>
		<td><s:textfield name="phoneNumber" value="%{#session.phoneNumber}" class="txt"/></td>
	</tr>

	<tr>
		<th>メールアドレス</th>
		<td><s:textfield name="email" value="%{#session.email}" class="txt"/></td>
	</tr>

	</table>

	<div class="submit_btn_box">
	<div id=".contents-btn-set">
	<s:submit value ="確認" class="submit_btn"/>
	</div>
	</div>


	</s:form>

</div>
<br><br><br><br><br><br>
<s:include value = "footer.jsp"/>
</body>
</html>