<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 3秒後に決済確認画面に移動 -->
<meta http-equiv="refresh"content="3; url=SettlementConfirmAction">
<link rel="stylesheet" href="./css/style.css">

<title>宛先情報入力完了画面</title>

</head>
<body>

<s:include value="header.jsp"/>

<div id ="contents">

<h1>宛先情報登録完了</h1>

<div class="message message_success">
宛先情報入力が完了しました。
</div>
</div>

<s:include value = "footer.jsp"/>
</body>
</html>