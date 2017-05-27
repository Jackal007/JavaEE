$(document).ready(function () {
	  var mySwiper = new Swiper ('.swiper-container', {
		direction: 'horizontal',
		loop: true,
		autoplay:3000,
		// 如果需要分页器
		pagination: '.swiper-pagination',
		paginationClickable: true,
		
		// 如果需要滚动条
		scrollbar: '.swiper-scrollbar',
	  })     
	  
	  
		if(!$("#goods-type-child ul li #hoverA")[0])
		{
			$("#goods-type-child ul li:nth-child(1) a").css({"color":"red","border-bottom":"3px solid red"});
		}
})


$(document).ready(function () {
	var pageCount=0;//页数
	var isStop=true;//触发开关,防止多次调用事件
	
	if(!$("#hiddenGoodsListLength")[0]||$("#hiddenGoodsListLength").val()<8)
	{
		isStop=false;
    	var goodsDiv=$("<div id='loadingDiv'>已没有更多数据!</div>");
    	$("#goods-list-content").append(goodsDiv);
	}
	
	var objectTop=$("#goods-type").offset().top;
	$("#body-content").scroll(function()
	{
		//以下功能实现商品类型div块拉到页面上端时,固定商品类型div块
		var scrollTop=$(this).scrollTop();
		var headerHeight=$("#header").height();
		if(scrollTop+headerHeight>=objectTop)
		{
			$("#goods-type").css({"position":"fixed","top":headerHeight,"margin-top":0});
		}
		else
		{
			$("#goods-type").css({"position":"relative","top":0,"margin-top":"10px"});
		}
		
		var bodyContent=document.getElementById("body-content");
		//以下功能实现内容滚动到底部时加载新的内容,当距离最底部100个像素时开始加载
		var wholeHeight=bodyContent.scrollHeight;
		var divHeight=bodyContent.clientHeight;
		var bottomHeight=5;
		if(scrollTop+divHeight+bottomHeight>=wholeHeight)
		{
			if(isStop==true)
			{
				isStop=false;
				pageCount=pageCount+1;
        		var loadingDiv=$("<div id='loadingDiv'>加载中...</div>");
				$("#goods-list-content").append(loadingDiv);
				if(getMoreGoodsListByAjax(pageCount))
				{
					isStop=true;
				}
				else
				{
		        	var goodsDiv=$("<div id='loadingDiv'>已没有更多数据!</div>");
		        	$("#goods-list-content").append(goodsDiv);
				}
				loadingDiv.hide();
			}
		}
	})
})

function submitSearchForm()
{
	$("#search-form").submit();
}

function getCategoryId()
{
	if($("#hiddenCategoryId")[0])
	{
		return $("#hiddenCategoryId").val();
	}
	else
	{
		return undefined;
	}
}

function getMoreGoodsListByAjax(page)
{
	var springUrl=$("#hiddenSpringUrl").val();
	var exists=true;
	$.ajax({
        url: springUrl+"/index/getGoodsListByAjax",
        async: false,
        cache: false,
        type: 'post',
        dataType: "json",
        data: {
        	category_id:getCategoryId(),
            size:8,
            no:page
        },
        success: function (data)
        {
        	for(var i=0;i<data.length;++i)
        	{
        		addGoodItemDivToHtml(springUrl,data[i]);
        	}
        	
        	if(data.length<8)
        	{
        		exists=false;
        	}
        },
        error:function(data)
        {
        	exists=false;
        }
	 });
	return exists;
}

function addGoodItemDivToHtml(springUrl,data)
{
	var goodsItemDiv=$("<div id='goods-item-div'></div>");
	
	//商品链接绝对路径
	var hrefString=springUrl+"/index/goodsDetail/"+data.serial_code;
	//商品图片绝对路径
	var goodsPicPath=springUrl+data.image_path;
	
	//创建a标签
	var goodsItemAHrefFirst=$("<a></a>").attr("href",hrefString);
	
	//创建商品图片
	var goodsPic=$("<img class='goods-pic'/>").attr("src",goodsPicPath);	
	
	//创建商品描述
	var goodsDesc=$("<p></p>").html("【&nbsp;"+data.name+"&nbsp;】&nbsp;"+data.description);
	
	//添加元素到a标签里
	goodsItemAHrefFirst.append(goodsPic).append(goodsDesc);
	
	//创建商品底部div
	var goodsBottomDiv=$("<div id='goods-bottom-div'></div>");
	
	//创建一个新的a标签
	var goodsItemAHrefSecond=$("<a></a>").attr("href",hrefString).html("￥"+data.real_price);
	
	//四个input type=hidden
	var inputHidden1=$("<input type='hidden'/>").val(data.id);
	var inputHidden2=$("<input type='hidden'/>").val(data.real_price);
	var inputHidden3=$("<input type='hidden'/>").val(data.serial_code);
	var inputHidden4=$("<input type='hidden'/>").val(data.stock_count);
	var inputHidden5=$("<input type='hidden'/>").val(goodsPicPath);
	//购物车标签
	var shoppingCartImg=$("<img class='addShoppingCartImg' src='"+springUrl+"/resources/images/zjh/goods-ShoppingCart.png'/>");
	
	//添加元素到商品底部div
	goodsBottomDiv.append(goodsItemAHrefSecond).append(inputHidden1).append(inputHidden2).append(inputHidden3).append(inputHidden4).append(inputHidden5).append(shoppingCartImg);
	
	goodsItemDiv.append(goodsItemAHrefFirst).append(goodsBottomDiv);
	$("#goods-list-content").append(goodsItemDiv);
}
