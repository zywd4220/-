<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的信息 - 美团</title>
<link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/myjd.common.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/myjd.info.css" media="all" />
<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>
<body>
<script type="text/javascript" src="/js/base-2011.js" charset="utf-8"></script>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<!-- header end -->

<div id="container">
<div class="w">
	
<div id="main">
    <div class="g-0">
        <div id="content" class="c-3-5">
            
			<div class="mod-main">
                        <div class="mt">
                            <ul class="extra-l">
                                <li class="fore-1"><a class="curr" href="http://i.jd.com/user/info">基本信息</a></li>

                                
                            </ul>
                        </div>
                        <form class="userForm"  action="/user/update.html" method="post">
                         <div class="mc">
                            <div class="user-set userset-lcol">
                                <div class="form">
                                    <div class="item">
                                        <span class="label"><em>*</em>昵称：</span>
                                        <div class="fl">
                                            <input type="text" class="itxt" maxlength="20" name="nickname" id="nickname">
                                            <div class="clr"></div><div class="prompt-06"><span id="nickName_msg"></span></div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label"><em>*</em>性别：</span>
                                        <div class="fl">
                                            <input type="radio" name="sex" id="sex" class="jdradio" value="0"><label class="mr10">男</label>
                                            <input type="radio" name="sex" id="sex" class="jdradio" value="1"><label class="mr10">女</label>
                                            <input type="radio" name="sex" id="sex" class="jdradio" value="2"><label class="mr10">保密</label>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">生日：</span>
                                        <div class="fl birthday-info">
                                            <select name="birthdayyear" class="selt selt1" id="birthdayyear"><option value="0" disabled="" selected="selected">请选择：</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="00后">00后</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option><option value="2000">2000</option><option value="90后">90后</option><option value="1999">1999</option><option value="1998">1998</option><option value="1997">1997</option><option value="1996">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option><option value="80后">80后</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option><option value="1980">1980</option><option value="70后">70后</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option><option value="1970">1970</option><option value="60后">60后</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="50后">50后</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="40后">40后</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="30后">30后</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option></select>
                                            <label class="ml5 mr5">年</label>
                                            <select name="birthdaymonth" class="selt selt1" id="birthdaymonth"><option value="0" disabled="" selected="selected">请选择：</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>
                                            <label class="ml5 mr5">月</label>
                                            <select name="birthdayday" class="selt selt1" id="birthday"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option></select>
                                            <label class="ml5 mr5">日</label>
                                            <span class="ftx03">填生日有惊喜哦~</span>
                                        </div>
                                    </div>


									<div class="item">
									<span class="label">邮箱：</span>
									<div class="fl">
									<input type="text" class="itxt" maxlength="20" name="email" id="email">
                                            <div class="clr"></div><div class="prompt-06"><span id="email_msg"></span></div>
										
																			</div>

									<div class="clr"></div>
								</div>
									
                                    <div class="item">
                                        <span class="label">真实姓名：</span>
                                        <div class="fl">
                                            <input type="text" class="itxt" maxlength="20" name="realname" >
                                            <div class="clr"></div><div class="prompt-06"><span id="realName_msg"></span></div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">所在地：</span>
                                        <div class="fl">
                                            <select name="receiverProvince" class="selt mr5" id="province" >
                                                                                                    <option value="广东">广东</option>
                                                                                                    <option value="上海">上海</option>
                                                                                                    <option value="天津">天津</option>
                                                                                                    <option value="重庆">重庆</option>
                                                                                                    <option value="河北">河北</option>
                                                                                                    <option value="山西">山西</option>
                                                                                                    <option value="河南">河南</option>

                                                                                            </select>
                                            <select name="receiverCity" class="selt mr5" id="City" value="广州市"><option value="广州市">广州市</option><option value="深圳市">深圳市</option><option value="佛山市">佛山市</option><option value="江门市">江门市</option><option value="长宁区">长宁区</option><option value="茂名市">茂名市</option><option value="惠州市">惠州市</option><option value="梅州市">梅州市</option></select>
                                            <select name="receiverArea" class="selt mr5" id="Area" value="海珠区"><option value="海珠区">海珠区</option><option value="越秀区">越秀区</option><option value="荔湾区">荔湾区</option><option value="天河区">天河区</option><option value="番禺区">番禺区</option><option value="花都区">花都区</option></select>
											<div class="clr"></div><div class="prompt-06"><span id="city_msg"></span></div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">&nbsp;</span>
                                        <div class="fl">
                                            <input type="text" class="itxt itxt1" name="receiverAddress" id="address" >
										    <div class="clr"></div><div class="prompt-06"><span id="address_msg"></span></div>
                                        </div>
                                    </div>
	                  		
                                    <div class="item">
                                        <span class="label">&nbsp;</span>
                                        <!--  <div class="fl">
                                            <input id="code" value="100294" style="display:none">
                                            <input id="rkey" value="736e6f5f315f67657455736572496e666f6468313839313030323934" style="display:none">
                                            <a href="http://localhost:8082/user/update.html" class="btn-5" onclick="updateUserInfo()">提交</a>                               
                                        </div>-->
                                        <button type="submit" class="checkout-submit btn-1" 
								          		  id="order-submit"	onclick="$('#userForm').submit()">
								          	提交
								          </button>
                                    </div>
                                </div>
                            </div>

                            <div id="user-info">
                                <div class="u-pic">
                                    <img alt="用户头像" src="/images/defaultImgs/1.jpg">
                                    <div class="mask"></div>
                                    <div class="face-link-box"></div>
                                    <a href="http://i.jd.com/user/userinfo/showImg.html" class="face-link">修改头像</a>
                                </div>
                                <div class="info-m">
									<div><b>用户名：${userInfo.nickname }</b></div>
                                    <div class="u-level">
										<span class="rank r4">
											<s></s><a href="http://usergrade.jd.com/user/grade" target="_blank">金牌会员</a>
										</span>
                                    </div>
                                    <div class="shop-level">购物行为评级：<span><a target="_blank" href="http://help.jd.com/help/question-57.html#help2173">
										<s id="userCredit" class="rank-sh rank-sh01 rank-sh02"></s></a></span></div>
                                    <div>会员类型：个人用户</div>
                                </div>
                            </div>

                            <div class="clr"></div>
							
                        </div>
                    </div>   
                    </form>       
                    
        </div>
    </div>
        <span class="clr"></span>
</div>
</div>
</div>

<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->
</body>
</html>