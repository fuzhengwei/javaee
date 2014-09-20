<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>studentupdate</title>
	</head>

	<body>
		<form action="StudentServlet?type=studentupdate" method="post">
			<input type="hidden" value="${ model.stu_id }" name="stu_id"/>
			<table align="center" width="100%" border="1">
				<tr>
					<td width="180px">
						姓名：
					</td>
					<td>
						<input type="text" name="stu_name" value="${ model.stu_name }"/>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input type="password" value="${ model.stu_pwd }" name="stu_pwd"/>
					</td>
				</tr>
				<tr>
					<td>
						性别：
					</td>
					<td>
						<select name="stu_sex">
							<option value="男">
								男
							</option>
							<option value="女">
								女
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						生日
					</td>
					<td>
						<input type="text" name="stu_birthday" value="${ model.stu_birthday }"/>
					</td>
				</tr>
				<tr>
					<td>
						民族：
					</td>
					<td>
						<select name="stu_nation">
							<option value="汉族">
								汉族
							</option>
							<option value="阿昌族">
								阿昌族
							</option>
							<option value="白　族">
								白 族
							</option>
							<option value="保安族">
								保安族
							</option>
							<option value="布朗族">
								布朗族
							</option>
							<option value="布依族">
								布依族
							</option>
							<option value="朝鲜族">
								朝鲜族
							</option>
							<option value="达斡尔族">
								达斡尔族
							</option>
							<option value="傣族">
								傣族
							</option>
							<option value="德昂族">
								德昂族
							</option>
							<option value="侗族">
								侗族
							</option>
							<option value="东乡族">
								东乡族
							</option>
							<option value="独龙族">
								独龙族
							</option>
							<option value="鄂伦春族">
								鄂伦春族
							</option>
							<option value="俄罗斯族">
								俄罗斯族
							</option>
							<option value="鄂温克族">
								鄂温克族
							</option>
							<option value="高山族">
								高山族
							</option>
							<option value="仡佬族">
								仡佬族
							</option>
							<option value="哈尼族">
								哈尼族
							</option>
							<option value="哈萨克族">
								哈萨克族
							</option>
							<option value="赫哲族">
								赫哲族
							</option>
							<option value="回族">
								回族
							</option>
							<option value="基诺族">
								基诺族
							</option>
							<option value="京族">
								京族
							</option>
							<option value="景颇族">
								景颇族
							</option>
							<option value="柯尔克孜族">
								柯尔克孜族
							</option>
							<option value="拉祜族">
								拉祜族
							</option>
							<option value="黎族">
								黎族
							</option>
							<option value="傈僳族">
								傈僳族
							</option>
							<option value="珞巴族">
								珞巴族
							</option>
							<option value="满族">
								满族
							</option>
							<option value="毛南族">
								毛南族
							</option>
							<option value="门巴族">
								门巴族
							</option>
							<option value="蒙古族">
								蒙古族
							</option>
							<option value="苗族">
								苗族
							</option>
							<option value="仫佬族">
								仫佬族
							</option>
							<option value="纳西族">
								纳西族
							</option>
							<option value="怒族">
								怒族
							</option>
							<option value="普米族">
								普米族
							</option>
							<option value="羌族">
								羌族
							</option>
							<option value="撒拉族">
								撒拉族
							</option>
							<option value="畲族">
								畲族
							</option>
							<option value="水族">
								水族
							</option>
							<option value="塔吉克族">
								塔吉克族
							</option>
							<option value="塔塔尔族">
								塔塔尔族
							</option>
							<option value="土族">
								土族
							</option>
							<option value="土家族">
								土家族
							</option>
							<option value="佤族">
								佤族
							</option>
							<option value="维吾尔族">
								维吾尔族
							</option>
							<option value="乌兹别克族">
								乌兹别克族
							</option>
							<option value="锡伯族">
								锡伯族
							</option>
							<option value="瑶族">
								瑶族
							</option>
							<option value="彝族">
								彝族
							</option>
							<option value="裕固族">
								裕固族
							</option>
							<option value="藏族">
								藏族
							</option>
							<option value="壮族">
								壮族
							</option>
						</select>修改前：${ model.stu_nation }
					</td>
				</tr>

				<tr>
					<td>
						政治面貌：
					</td>
					<td>
						<select name="stu_pa">
							<option>
								团员
							</option>
							<option>
								党员
							</option>
							<option>
								无党人士
							</option>
						</select>修改前：${ model.stu_pa }
					</td>
				</tr>

				<tr>
					<td>
						学生专业编号：
					</td>
					<td>
						<input type="text" name="stu_pro_number" value="${ model.stu_pro_number }"/>
					</td>
				</tr>

				<tr>
					<td>
						学生班级编号：
					</td>
					<td>
						<input type="text" name="stu_class_number" value="${ model.stu_class_number }"/>
					</td>
				</tr>

				<tr>
					<td>
						学生寝室编号：
					</td>
					<td>
						<input type="text" name="stu_bedroom_number" value="${ model.stu_bedroom_number }"/>
					</td>
				</tr>
				
				<tr>
					<td>
						联系方式：
					</td>
					<td>
						<input type="text" name="stu_contact" value="${ model.stu_contact }"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="修改" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
