<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单 - 淘淘</title>

<link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/myjd.common.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/myjd.order.css" media="all" />
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

        	<div class="mod-main mod-comm lefta-box" id="order02">
        		<div class="mt">
	<ul class="taborder">
		<li>
			<div class="tyies-t">
				<strong class="ftx-01">全部订单</strong><b></b>
			</div>
			<div class="tyies-c">
				<div class="close"></div>
				    				    					<div class="filter-item">
    						<span class="label">不限：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=&amp;d=1&amp;s=4096" target="_self">全部类型</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">普通：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=0-6-8-9-10-11-13-15-16-17-18-19-21-22-23-24-25-32-33-41-42-49-54-56&amp;d=1&amp;s=4096" target="_self">实物商品</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">旅游：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=35-83&amp;d=1&amp;s=4096" target="_self">机票</a>
    								    									<a href="list.action?t=39&amp;d=1&amp;s=4096" target="_self">酒店</a>
    								    									<a href="list.action?t=45&amp;d=1&amp;s=4096" target="_self">租车</a>
    								    									<a href="list.action?t=47&amp;d=1&amp;s=4096" target="_self">度假</a>
    								    									<a href="list.action?t=44&amp;d=1&amp;s=4096" target="_self">景点</a>
    								    									<a href="list.action?t=46&amp;d=1&amp;s=4096" target="_self">火车</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">充值：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=34-62&amp;d=1&amp;s=4096" target="_self">游戏</a>
    								    									<a href="list.action?t=37&amp;d=1&amp;s=4096" target="_self">手机充值</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">票务：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=43&amp;d=1&amp;s=4096" target="_self">电影票</a>
    								    									<a href="list.action?t=53&amp;d=1&amp;s=4096" target="_self">演出票</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">数字：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=38&amp;d=1&amp;s=4096" target="_self">电子书</a>
    								    									<a href="list.action?t=58&amp;d=1&amp;s=4096" target="_self">数字音乐</a>
    								    									<a href="list.action?t=57&amp;d=1&amp;s=4096" target="_self">应用商店</a>
    								    							    						</div>
    					</div>
    				    					<div class="filter-item">
    						<span class="label">其他：</span>
    						<div class="item-con">
    							    								    									<a href="list.action?t=36&amp;d=1&amp;s=4096" target="_self">彩票</a>
    								    									<a href="list.action?t=28-29-201&amp;d=1&amp;s=4096" target="_self">团购</a>
    								    									<a href="list.action?t=48-64-65&amp;d=1&amp;s=4096" target="_self">保险</a>
    								    									<a href="list.action?t=2&amp;d=1&amp;s=4096" target="_self">夺宝岛</a>
    								    							    						</div>
    					</div>
    										</div>
		</li>
	</ul>
	<div class="extra-r">
				<div class="search-01">
			<input id="ip_keyword" name="" type="text" class="s-itxt" value="商品名称、商品编号、订单编号" onfocus="if (this.value==this.defaultValue) this.value=''" onblur="if (this.value=='') this.value=this.defaultValue" onkeydown="javascript:if(event.keyCode==13) OrderSearch('ip_keyword');">
	        <!--input name="" type="button" value="查 询" class="btn-13" onclick="OrderSearch('ip_keyword')" clstag="click|keycount|orderinfo|search"/-->
	        <a href="javascript:;" class="btn-13" onclick="OrderSearch('ip_keyword')" clstag="click|keycount|orderinfo|search">查 询</a>
		</div>
	</div>
</div>        		<div class="mc">
        			<table class="tb-void">
        				<colgroup>
	<col width="290">
	<col width="90">
	<col width="110">
	<col width="100">
	<col width="100">
	<col width="130">
</colgroup>
<thead>
	<tr>
		<th>订单信息</th>
		<th>收货人</th>
		<th>订单金额</th>
		<th>
			<select id="submitDate" name="" class="sele">
				<option value="1" selected="">最近三个月</option>
								  <option value="2">今年内</option>
								  <option value="2013">2013年</option>
								  <option value="2012">2012年</option>
								  <option value="2011">2011年</option>
								  <option value="3">2011年以前</option>
							</select>
		</th>
		<th>
			<select id="orderState" name="" class="sele">
				<option value="4096" selected="">全部状态</option>
				<option value="1">等待付款</option>
				<option value="32">等待自提</option>
				<option value="128">等待收货</option>
				<!-- <option value="0">处理中</option> -->
				<!--<option value="2048">有效</option> -->
				<option value="1024">已完成</option>
				<option value="-1">已取消</option>
			</select>
		</th>
		<th>操作</th>
	</tr>
</thead>

<script type="text/javascript" language="javascript">
    $("#submitDate").change(function () {
        var sDate = $("#submitDate option[@selected]").val();
        window.location = 'list.action?d='+sDate+'&s=4096&t=';
    });
	$("#orderState").change(function () {
        var oState = $("#orderState option[@selected]").val();
        window.location = 'list.action?d=1&s='+oState+'&t=';
    });
	$("#submitDate").val(1);
	$("#orderState").val(4096);
</script>    					    						            					    								    												<tbody id="tb-3965995220">
    
    <tbody id="tb-2538292730">
    	<c:forEach items="${orderInfos }" var="orderInfo">
    	
        <tr class="tr-th">
            <td colspan="6">
                <span class="tcol1">
                    订单编号:
                    <a name="orderIdLinks" id="idUrl2538292730" target="_blank" href="http://order.jd.com/normal/item.action?orderid=2538292730&amp;PassKey=769448C6BA99F1ADA8244BAE7BC60580" clstag="click|keycount|orderinfo|order_num">${orderInfo.orderId }</a>
                                        
		    		                </span>

                                    <span class="tcol2">
      	     美团
                    </span>
                    <span class="tcol3">
                        <a class="btn-im" onclick="getPamsForChat()" href="#none" title="联系客服"></a>
                    </span>
                            </td>
        </tr>
        <tr id="track2538292730" oty="0,1,70" class="tr-td">
            <td>
            	<div class="img-list">
            	<c:forEach items="${orderInfo.orderItems }" var="orderItem">
            	
            		        		  		<a href="localhost:8082/item/${orderItem.itemId }.html" class="img-box" clstag="click|keycount|orderinfo|order_product" target="_blank">
        					<img title="${orderItem.title }" width="50" height="50" src="${orderItem.picPath }" class="err-product">
        		  		</a>

            	</c:forEach>
        		               	</div>
            </td>
            <td><div class="u-name">${orderInfo.buyerNick }</div></td>
	        	<td>
	        		${orderInfo.payment }
	        		<br>
	        		<c:choose>
	        			<c:when test="${ orderInfo.paymentType == 1}">支付宝支付</c:when>
	        			<c:when test="${ orderInfo.paymentType == 2}">微信支付</c:when>
	        			<c:otherwise>未知</c:otherwise>
	        		</c:choose>
	        		<br>
	        	 </td>

            <td>
                <span class="ftx-03"> <fmt:formatDate value="${orderInfo.createTime }"  pattern="yyyy-MM-dd"/><br> 
                <fmt:formatDate value="${orderInfo.createTime }"  pattern="HH:mm:ss"/> </span>
                <input type="hidden" id="datasubmit-2538292730" value="2014-10-20 22:30:49">
            </td>
            
            <td><span class="ftx-03">
            <c:choose>
            	<c:when test="${orderInfo.status == 1 }">已付款</c:when>
            	<c:when test="${orderInfo.status == 2 }">未付款</c:when>
            	<c:when test="${orderInfo.status == 3 }">未发货</c:when>
            	<c:when test="${orderInfo.status == 4 }">已发货</c:when>
            	<c:when test="${orderInfo.status == 5 }">交易成功</c:when>
            	<c:when test="${orderInfo.status == 6 }">交易关闭</c:when>
            	<c:otherwise>未知</c:otherwise>
            </c:choose>
            </span></td>
            
            <td id="operate2538292730" class="order-doi" width="100">
        	  
            <span id="pay-button-2538292730" state=""></span>
            <a target="_blank" href="http://order.jd.com/normal/item.action?orderid=2538292730&amp;PassKey=769448C6BA99F1ADA8244BAE7BC60580" clstag="click|keycount|orderinfo|order_check">查看</a><span id="order_comment"></span><span class="pop-recycle-a">|<a href="javascript:void(0)" clstag="click|keycount|orderinfo|order_del" onclick="ensureMoveOrderToRecycle(2538292730,'397FF574E089D5409E6CC8EF67129D65');">删除</a></span><span id="doi2538292730"><br><a href="http://club.jd.com/JdVote/TradeComment.aspx?ruleid=2538292730&amp;ot=0&amp;payid=1&amp;shipmentid=70" target="_blank" clstag="click|keycount|orderinfo|order_comment">评价晒单</a><br></span>
            <a class="btn-again" clstag="click|keycount|orderlist|buy" href="/" target="_blank"> </a>
            
            </td>
        </tr>
    	</c:forEach>
    </tbody>
								                                    						            					    								    												<tbody id="tb-3122336930">
    
       
    								                                    						    					    				</table>
        		</div>
                <div class="mt10">
            		<div class="pagin fr">
            	                                  <!--  <span class="text">共20条记录</span>    <span class="text">共1页</span> -->
                <span class="prev-disabled">上一页<b></b></span>
       
		<!-- <span class="prev-disabled">首页</span> -->
                                                                                          <a class="current">1</a>                                                                                       	<!-- <span class="next-disabled">末页</span>  -->
    <span class="next-disabled">下一页<b></b></span>
            
                        </div>
                    <div class="clr"></div>
                </div>
        	</div>
            
            
        </div>
    </div>
</div>
</div>

<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->
</body>
</html>