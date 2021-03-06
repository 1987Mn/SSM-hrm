<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——添加用户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">

	$(function(){
		$(".quxiao").click(function () {
			parent.location = "${ctx}/main";
		});
    	/** 员工表单提交 */
		$("#deptForm").submit(function(){
			var name = $("#name");
			var remark = $("#remark");
			var msg = "";
			
			alret(name.val());
			if ($.trim(name.val()) == ""){
				msg = "部门名称不能为空！";
				name.focus();
				alert(msg);
				return false;
			}else if ($.trim(remark.val()) == ""){
				msg = "部门描述不能为空！";
				remark.focus();
				alert(msg);
				return false;
			}
		});
    });
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">

  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 添加用户</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<form action="${ctx}/deptsave" id="deptForm" method="post">
<input type="hidden" name="id" value="${requestScope.Dept.id}" />
<table width="100%"  border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr><td>${message}</td></tr>
  <tr valign="top">
    <td>
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">部门名：<input name="name" value="${requestScope.dept.name}" id="name" size="20" /></td>
		    			<td class="font3 fftd">部门描述：<input name="remark" value="${requestScope.dept.remark}" id="remark" size="20" /></td>
		    		</tr>
		    	</table>
		    </td></tr>
			<tr><td align="left" class="fftd"><input type="submit" value="保存">
				&nbsp;&nbsp;<input type="reset" id="quxiao" class="quxiao" value="取消 "></td></tr>
		  </table>
	</td>
  </tr>
</table>
</form>
</body>
</html>