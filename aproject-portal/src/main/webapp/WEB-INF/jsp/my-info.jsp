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
                        <div class="mc">
                            <div class="user-set userset-lcol">
                                <div class="form">
                                    <div class="item">
                                        <span class="label"><em>*</em>昵称：</span>
                                        <div class="fl">
                                           	${userInfo.nickname }
                                            <div class="clr"></div><div class="prompt-06"><span id="nickName_msg"></span></div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label"><em>*</em>性别：</span>
                                        <div class="fl">
                                            <c:choose>
							        			<c:when test="${ userInfo.sex == 0}">男</c:when>
							        			<c:when test="${ userInfo.sex == 1}">女</c:when>
							        			<c:when test="${ userInfo.sex == 2}">保密</c:when>
							        			<c:otherwise>未知</c:otherwise>
							        		</c:choose>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">生日：</span>
                                        <div class="fl birthday-info">
                                           ${ userInfo.birthdayyear}-${userInfo.birthdaymonth }-${userInfo.birthdayday }
                                        </div>
                                    </div>

                                    
									<div class="item">
									<span class="label">邮箱：</span>
									<div class="fl">
																				<div>
											<strong>    ${userInfo.email }</strong>
											<a target="_blank" class="ml5 ftx05" href="http://safe.jd.com/validate/updateMail">修改</a>
											<span class="ftx-03">&nbsp;&nbsp;&nbsp;已验证</span>
										</div>
																			</div>

									<div class="clr"></div>
								</div>
									
                                    <div class="item">
                                        <span class="label">真实姓名：</span>
                                        <div class="fl">
                                             ${userInfo.realname}
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">所在地：</span>
                                        <div class="fl">
                                             ${userShipping.receiverProvince}&nbsp&nbsp&nbsp ${userShipping.receiverCity } &nbsp&nbsp&nbsp ${userShipping.receiverArea }
                                            
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">&nbsp;</span>
                                        <div class="fl">
                                           ${userShipping.receiverAddress }
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="label">&nbsp;</span>
                                        <div class="fl">
                                            <input id="code" value="100294" style="display:none">
                                            <input id="rkey" value="736e6f5f315f67657455736572496e666f6468313839313030323934" style="display:none">
                                            <a href="http://localhost:8082/my-info-edit.html" class="btn-5" onclick="updateUserInfo()">修改</a>
                                        </div>
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