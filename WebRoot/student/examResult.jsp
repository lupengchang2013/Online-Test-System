<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Exam Result</title>
<link href="images/css2.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
.STYLE3 {font-size: 18px; }
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}
-->
</style>

<body>
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	<table width="60%" align="center" cellpadding="10" cellspacing="0" border="1">
      <tr>
        <td height="35" colspan="2"></td>
      </tr>
      <tr>
        <td height="49" colspan="2"><div align="center"><span class="STYLE4"><strong>eggpeijun</strong>Exam Info</span></div></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">Name: ${request.studentName}</div></td>
        <td><div align="center">Grade: ${request.GeneralPoint}</div></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center"><a href="showSubjectAnswer.action">Show Answer</a></div></td>
      </tr>
    </table></td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
