<%@page import="com.qf.bmi.pojo.Record" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%List<Record> records=(List<Record>)request.getSession().getAttribute("records");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<title>BMI计算</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
		
	</head>
	<body>
		
		<div class="w">
			<div class="box">
				<div class="Left">
			<div class="form">
				<form action="#" method="post" id="form">
				<h3>BMI计算</h3>
				<div class="hei">
					<span>身高：</span>
					<input type="text" class="height" name="height"/>
					<div class="cm">厘米</div>
				</div>
				<div class="wei">
					<span>体重：</span>
					<input type="text" class="weight" name="weight"/>
					<div class="kg">kg</div>
				</div>
				<div class="sex">
					<span>性别：</span>
					<input type="radio" name="sex" id="sex" value="0" checked="checked"/><span>男</span>
					<input type="radio" name="sex" id="sex" value="1" class="nv"/><span>女</span>
				</div>
				<div class="calculate">
					<input type="button" name="count" id="submit" class="submit" value="计算BMI值" />
				</div>
				</form>
			</div>
			<div class="cankao">
				<table class="table_norm">
					<form action="#" method="post" id="form2">
					<tr>
						<td>分类</td>
						<td>BMI范围</td>
					</tr>
					<tr id="line1">
						<td>偏瘦</td>
						<td><=18.4</td>
					</tr>
					<tr id="line2">
						<td>正常</td>
						<td>18.5~23.9</td>
					</tr>
					<tr id="line3">
						<td>过重</td>
						<td>24.0~27.9</td>
					</tr>
					<tr id="line4">
						<td>肥胖</td>
						<td>>=28.0</td>
					</tr>
					</form>
				</table>
			</div>
		</div>
		<div class="Right">
		<div class="RightTop">	
			<div class="touxiang">
				<img src="${pageContext.request.contextPath}/img/3_01.jpg" class="photo" id="photo"/>
			</div>
			<div class="result">
				<h3 class="results" id="results">14.53 偏瘦</h3>
				<h3 class="dream" id="dream">68.4kg</h3>
			</div>
		</div>
		<div class="RightBottm">
			<table class="bmi_result">
				<tr class="result_title">
					<td>ID</td>
					<td>日期</td>
					<td>身高</td>
					<td>体重</td>
					<td>性别</td>
					<td>BMI</td>
					<td>理想体重</td>
					<td>删除 </td>
				</tr>
				<%
				if(records!=null){
				for(Record record :records) {%>
				<tr class="num1">
					<td><%=record.getId()%></td>
					<td><%=record.getTime()%></td>
					<td><%=record.getHeight()%></td>
					<td><%=record.getHeight()%></td>
					<td><%=record.getSex()%></td>
					<td><%=record.getBmi()%></td>
					<td><%=record.getDream_value()%></td>
					<td><input type="button" id="button" class="button" value="删除"/></td>
				</tr>
				<%
				} 
				}
				%>
			</table>
		</div>
		</div>
		</div>
		</div>
		<script type="text/javascript" >
		//实现动态切换
		var photo =document.getElementById("photo");
		var results=document.getElementById("results");
		var dream=document.getElementById("dream");
		function fun(sex,bmi,dream_value,photo,results,dream){
			if(sex=="0"){
				if(bmi<=18.4){
					alert("hey man，太苗条咯，注意身体健康！");
					results.innerHTML=bmi+"偏瘦";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_01.jpg";
				}
				if(18.5<=bmi&&bmi<=23.9){
					alert("hey man，体重正常，保持！");
					results.innerHTML=bmi+"正常";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_02.jpg";
				}
				if(24.0<=bmi&&bmi<=27.9){
					alert("hey man，体重过重，注意锻炼！");
					results.innerHTML=bmi+"过重";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_03.jpg";
				}
				if(28.0<=bmi){
					alert("偶买噶，您已是生命不能承受之重！");
					results.innerHTML=bmi+"肥胖";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_04.jpg";
				}
			}
			else{
				if(bmi<=18.4){
					alert("hey girl，太苗条咯，注意身体健康！");
					results.innerHTML=bmi+"偏瘦";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_01_01.jpg";
				}
				if(18.5<=bmi&&bmi<=23.9){
					alert("hey girl，体重正常，保持！");
					results.innerHTML=bmi+"正常";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_01_03.jpg";
				}
				if(24.0<=bmi&&bmi<=27.9){
					alert("hey girl，体重过重，注意锻炼！");
					results.innerHTML=bmi+"过重";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_01_04.jpg";
				}
				if(28.0<=bmi){
					alert("偶买噶，您已是生命不能承受之重！");
					results.innerHTML=bmi+"肥胖";
					dream.innerHTML="理想体重"+dream_value;
					photo.src="${pageContext.request.contextPath}/img/3_01_05.jpg";
				}
			}
		}
		//实现删除操作
		window.onload=function(){
			if("${index}"==""){
				window.location.href="${pageContext.request.contextPath}/servlet/FindAllServlet";
			}
		}
		$(".button").click(function(){
			var rId=$(this).parents("tr").find("td").eq(0).html();
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/servlet/DeleteByIdServlet?rId="+rId,
				dataType:'json',
				async:true,
				success:function(data){
					alert(data.msg);
					window.location.reload();
				}
			});
		})
		//实现添加操作
			$("#submit").click(function(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/servlet/CalcServlet",
				data:$("#form").serialize(),
				dataType:'json',
				async:true,
				success:function(data){
				alert(data.sex);
				alert(data.bmi);
				alert(data.dream_value);
				var sex=data.sex;
				var bmi=data.bmi;
				var dream_value=data.dream_value;
				fun(sex,bmi,dream_value,photo,results,dream);
				
		}
	});
})

		</script>
	</body>
</html>