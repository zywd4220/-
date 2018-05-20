<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>美团订单系统</title>

<link href="/css/taotao.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/psearch20131008.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/psearch.onebox.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/pop_compare.css" media="all" />
<script type="text/javascript">
	window.pageConfig={
	compatible:true,
	navId:"home",
	enableArea: true
	};
</script>
<style type="text/css">
#categorys-2013 .mc {
	display: block;
}
#categorys-2013 .mt {
	background: 0
}
</style>
</head>
<body>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<!-- header end -->
<div class="w">
<div id="o-slide">
<div class="slide" id="slide">
<script type="text/javascript">
;(function(cfg, doc) {
    if ( !cfg.DATA_MSlide ) {
        cfg.DATA_MSlide=[];
    }
    //var data = [{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304360302109345.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304360302109345.jpg","widthB":550,"href":"http://sale.jd.com/act/e0FMkuDhJz35CNt.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304353109508500.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304353109508500.jpg","widthB":550,"href":"http://sale.jd.com/act/UMJaAPD2VIXkZn.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304345761102862.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304345761102862.jpg","widthB":550,"href":"http://sale.jd.com/act/UMJaAPD2VIXkZn.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/201503030434200950530.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/201503030434200950530.jpg","widthB":550,"href":"http://sale.jd.com/act/kj2pmwMuYCrGsK3g.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304333327002286.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304333327002286.jpg","widthB":550,"href":"http://sale.jd.com/act/xcDvNbzAqK0CoG7I.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304324649807137.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304324649807137.jpg","widthB":550,"href":"http://sale.jd.com/act/eDpBF1s8KcTOYM.html?cpdad=1DLSUE","heightB":240}];
	var data = ${ad1};

    cfg.DATA_MSlide = data;
    // 初始化一个广告信息
    if ( cfg.DATA_MSlide.length > 1 ) {
    	var first = pageConfig.FN_GetCompatibleData( cfg.DATA_MSlide[0] );
        var TPL = ''
            +'<ul class="slide-items">'
            +'<li clstag="homepage|keycount|home2013|09a1">'
            +'<a href="'+ first.href +'" target="_blank" title="'+ first.alt +'">'
            +'<img src="'+ first.src +'" width="'+ first.width +'" height="'+ first.height +'" >'
            +'</a>'
            +'</li>'
            +'</ul><div class="slide-controls"><span class="curr">1</span></div>';
        doc.write(TPL);
    }
})(pageConfig, document);;</script>
</div><!--slide end-->


</div>

<!--新闻结束-->
 


<!--virtuals end-->

</div>
<!-- 幻灯片, 公信力, 美团快报, 虚拟产品 end -->
 <!-- 家电通讯楼层 end-->
</div>
 

<div class="w main">
	
<div class="clr"></div>
<div class="m clearfix" id="bottom_pager">

</div>
<div class="m psearch " id="plist">
<ul class="list-h clearfix" tpl="2">
<c:forEach items="${itemList}" var="item">
<li class="item-book" bookid="11078102">
	<div class="p-img">
		<a target="_blank" href="/item/${item.id }.html">
			<img width="160" height="160" data-img="1" data-lazyload="${item.image}" />
		</a>
	</div>
	<div >
		<a target="_blank" href="/item/${item.id }.html">
			${item.title}
		</a>
	</div>
		<div >
		<a target="_blank" href="/">
			商家名：${item.sellerName}
		</a>
	</div>
	<div class="p-price">
		<i>美团价：</i>
		<strong>￥<fmt:formatNumber groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" value="${item.price / 100 }"/></strong>
	</div>
	<div class="service">由 美团 配送</div>
	<div class="extra">
		<span class="star"><span class="star-white"><span class="star-yellow h5">&nbsp;</span></span></span>
					<div id="choose-btn-append"  class="btn">
							<a class="btn-append " id="InitCartUrl" href="/cart/add/${item.id}.html?num=1" clstag="shangpin|keycount|product|initcarturl">加入购物车<b></b></a>
					</div>
	</div>
</li>
</c:forEach>
</ul></div>
</div>
<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->
 
<script type="text/javascript" src="/js/home.js" charset="utf-8"></script>

</body>
</html>