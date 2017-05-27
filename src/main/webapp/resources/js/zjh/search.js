$(document).ready(function ()
{
	if($("#hiddenGoodsName")[0])
	{
		$("#search-form input[type='text']").val($("#hiddenGoodsName").val());
	}
	
	if($("#hiddenCategoryId")[0])
	{
		var categoryId=$("#hiddenCategoryId").val();
		var categoryTarget=$("input[name='typeradio'][value='"+categoryId+"']");
		var categoryName=categoryTarget.next().html();
		$("#typeButton").html(categoryName);
		$("#typeButton").css({"color":"red"})
	}
	
	if($("#hiddenBrandId")[0])
	{
		var brandId=$("#hiddenBrandId").val();
		var brandTarget=$("input[name='brandradio'][value='"+brandId+"']");
		var brandName=brandTarget.next().html();
		$("#brandButton").html(brandName);
		$("#brandButton").css({"color":"red"})
	}
	
	if($("#hiddenPreSaleNumber")[0])
	{
		$("#orderByPreSaleNumber").css({"border":"1px solid red","color":"red","border-radius":"10px","width":"23%"});
	}
	else if($("#hiddenRealPrice")[0])
	{
		var realPrice=$("#hiddenRealPrice").val();
		if(realPrice=="0.0")
		{
			$("#orderByRealPriceDesc").css({"border":"1px solid red","color":"red","border-radius":"10px","width":"23%"});
		}
		else if(realPrice=="1.0")
		{
			$("#orderByRealPriceAsc").css({"border":"1px solid red","color":"red","border-radius":"10px","width":"23%"});
		}
	}
});

$(document).ready(function ()
{
    $("#comprehensive-ul-li").click(function (e) 
    {  
        var target=$(e.target);
        if($("#comprehensive-ul-li-ul").css("display")=="none") 
        {
            $("#comprehensive-ul-li-ul").show();
        }
        else if($("#comprehensive-ul-li-ul").css("display")=="block")
        {
            if(target.closest("#comprehensive-ul-li-ul").length==0)
            {
                $("#comprehensive-ul-li-ul").hide();
            }  
        }
        return false;   
    });
})

$(document).ready(function ()
{
    $("#brandButton").click(function(e)
    {
         if($("#type-modal").css("display")=="block")
         {
            $("#type-modal").hide();
         }
         else
         {
           if($("#brand-modal").css("display")=="none") 
           {
        	   	 if($("#hiddenBrandId")[0])
	          	 {
	          		 $("input[name='brandradio'][value='"+$("#hiddenBrandId").val()+"']").attr("checked",true);
	          	 }
	          	 else
	          	 {
	          		 $("input[name='brandradio'][value='all']").attr("checked",true);
	          	 }
        	   	 $("#brand-modal").show();
           }
           else if($("#brand-modal").css("display")=="block")
           {
              $("#brand-modal").hide();
           }
         }
         return false;
     });
})


$(document).ready(function ()
{
    $("#typeButton").click(function(e)
    {
         if($("#brand-modal").css("display")=="block")
         {
             $("#brand-modal").hide();
         }
         else
         {
             if($("#type-modal").css("display")=="none") 
             {
            	 if($("#hiddenCategoryId")[0])
            	 {
            		 $("input[name='typeradio'][value='"+$("#hiddenCategoryId").val()+"']").attr("checked",true);
            	 }
            	 else
            	 {
            		 $("input[name='typeradio'][value='all']").attr("checked",true);
            	 }
            	 $("#type-modal").show();
             }
             else if($("#type-modal").css("display")=="block")
             {
                $("#type-modal").hide();
             }
         }
         return false;
    });
})

$(document).ready(function ()
{
    $("#filterButton").click(function(e)
    {
         if($("#filter-modal").css("display")=="none") 
         {
    	   	 if($("#hiddenBrandId")[0])
          	 {
          		 $("input[name='filterbrandradio'][value='"+$("#hiddenBrandId").val()+"']").attr("checked",true);
          	 }
          	 else
          	 {
          		 $("input[name='filterbrandradio'][value='all']").attr("checked",true);
          	 }
    	   	 
    	   	 if($("#hiddenCategoryId")[0])
        	 {
        		 $("input[name='filtertyperadio'][value='"+$("#hiddenCategoryId").val()+"']").attr("checked",true);
        	 }
        	 else
        	 {
        		 $("input[name='filtertyperadio'][value='all']").attr("checked",true);
        	 }
             $("#filter-modal").show();
         }
         else if($("#filter-modal").css("display")=="block")
         {
            $("#filter-modal").hide();
         }
         return false;
    });
})  ;


$(document).ready(function ()
{
  //点击任意地方，隐藏显示的mydiv
    $(document).click(function (e) { 
        var target=$(e.target);
        if(target.closest("#comprehensive-ul-li-ul").length==0)
        {
            $("#comprehensive-ul-li-ul").hide();
        }
        if(target.closest("#brand-position").length==0)
        {
            $("#brand-modal").hide();
        }
        if(target.closest("#type-position").length==0)
        {
            $("#type-modal").hide();
        }
        if(target.closest("#filter-position").length==0)
        {
            $("#filter-modal").hide();
        }
    });
});

$(document).ready(function () {
	var pageCount=0;//页数
	var isStop=true;//触发开关,防止多次调用事件
	
	if(!$("#hiddenGoodsListLength")[0]||$("#hiddenGoodsListLength").val()<8)
	{
		isStop=false;
    	var goodsDiv=$("<div id='loadingDiv'>已没有更多数据!</div>");
    	$("#goods-list-content").append(goodsDiv);
	}
	
	$(window).scroll(function()
	{
	    //以下功能实现内容滚动到底部时加载新的内容,当距离最底部100个像素时开始加载
		var windowScrollTop=document.body.scrollTop;
		var windowHeight=window.screen.height;
		var documentHeight=$(document).height();
		var bottomHeight=5;
		if(document.body.scrollTop+windowHeight+bottomHeight>=documentHeight)
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
	});
})
function submitSearchForm()
{
	$("#search-form").submit();
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
        	name:getElementValueById("hiddenGoodsName"),
        	brand_id:getElementValueById("hiddenBrandId"),
        	category_id:getElementValueById("hiddenCategoryId"),
            pre_sale_number:getElementValueById("hiddenPreSaleNumber"),
            real_price:getElementValueById("hiddenRealPrice"),
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
	var hrefGoodsSerialCode=springUrl+"/index/goodsDetail/"+data.serial_code;
	var goodsPicPath=springUrl+data.image_path;
	
	var goodsItemContent=$("<div id='goods-item-content'></div>");
	
	//添加goods-img-content，添加图片和链接
	var goodsImgContent=$("<div id='goods-img-content'></div>");
	var aHrefFirst=$("<a></a>").attr("href",hrefGoodsSerialCode);
	var goodsPic=$("<img/>").attr("src",goodsPicPath);  
	aHrefFirst.append(goodsPic);
	goodsImgContent.append(aHrefFirst);
	
	//添加goods-message-content及相关元素
	var goodsMessageContent=$("<div id='goods-message-content'></div>");
	var aHrefSecond=$("<a></a>").attr("href",hrefGoodsSerialCode);
	var firstPElement=$("<p></p>").html(data.description);
	var secondPElement=$("<p></p>").html("￥"+data.real_price);
	aHrefSecond.append(firstPElement).append(secondPElement);
	
	
	var spanElement=$("<span></span>");
	var aHrefThird=$("<a></a>").attr("href",hrefGoodsSerialCode).html("销量:&nbsp;"+data.pre_sale_number);
	spanElement.append(aHrefThird);
	
	var secondSpanElement=$("<span></span>");
	
	var inputHidden1=$("<input type='hidden'/>").val(data.id);
	var inputHidden2=$("<input type='hidden'/>").val(data.real_price);
	var inputHidden3=$("<input type='hidden'/>").val(data.serial_code);
	var inputHidden4=$("<input type='hidden'/>").val(data.stock_count);
	var inputHidden5=$("<input type='hidden'/>").val(goodsPicPath);
	secondSpanElement.append(inputHidden1).append(inputHidden2).append(inputHidden3).append(inputHidden4).append(inputHidden5);
	secondSpanElement.append($("<img class='addShoppingCartImg' src='"+springUrl+"/resources/images/zjh/goods-ShoppingCart.png'/>"));
	
	
	goodsMessageContent.append(aHrefSecond).append(spanElement).append(secondSpanElement);
	
	goodsItemContent.append(goodsImgContent).append(goodsMessageContent);
	$("#goods-list-content").append(goodsItemContent);
}

function getElementValueById(elementId)
{
	if($("#"+elementId)[0])
	{
		return $("#"+elementId).val();
	}
	else
	{
		return undefined;
	}
}

function orderByPreSaleNumber()
{
	if($("#hiddenRealPrice")[0])
	{
		$("#hiddenRealPrice").remove();
	}

	if($("#hiddenPreSaleNumber")[0])
	{
		$("#hiddenPreSaleNumber").val("0");
	}
	else
	{
		var hiddenPreSaleNumber=$("<input id='hiddenPreSaleNumber' name='pre_sale_number' type='hidden' value='0'/>")
		$("#changeConstrainForm").append(hiddenPreSaleNumber);
	}
	$("#changeConstrainForm").submit();
}

function orderByRealPrice(orderSequence)
{
	if($("#hiddenPreSaleNumber")[0])
	{
		$("#hiddenPreSaleNumber").remove();
	}
	
	if($("#hiddenRealPrice")[0])
	{
		$("#hiddenRealPrice").val(orderSequence);
	}
	else
	{
		var hiddenRealPrice=$("<input id='hiddenRealPrice' name='real_price' type='hidden' value='"+orderSequence+"'/>")
		$("#changeConstrainForm").append(hiddenRealPrice);
	}
	$("#changeConstrainForm").submit();
}

function sortByCategoryId()
{
	var categoryId=$('input:radio[name="typeradio"]:checked').val();
	if(categoryId)
	{
		if(categoryId=="all")
		{
			if($("#hiddenCategoryId")[0])
			{
				$("#hiddenCategoryId").remove();
			}
		}
		else
		{
			if($("#hiddenCategoryId")[0])
			{
				$("#hiddenCategoryId").val(categoryId);
			}
			else
			{
				var hiddenCategoryId=$("<input id='hiddenCategoryId' name='category_id' type='hidden' value='"+categoryId+"'/>")
				$("#changeConstrainForm").append(hiddenCategoryId);
			}
		}
		$("#changeConstrainForm").submit();
	}
}

function sortByBrandId()
{
	var brandId=$('input:radio[name="brandradio"]:checked').val();
	if(brandId)
	{
		if(brandId=="all")
		{
			if($("#hiddenBrandId")[0])
			{
				$("#hiddenBrandId").remove();
			}
		}
		else
		{
			if($("#hiddenBrandId")[0])
			{
				$("#hiddenBrandId").val(brandId);
			}
			else
			{
				var hiddenBrandId=$("<input id='hiddenBrandId' name='brand_id' type='hidden' value='"+brandId+"'/>")
				$("#changeConstrainForm").append(hiddenBrandId);
			}	
		}
		$("#changeConstrainForm").submit();
	}
}

function sortByCategoryIdAndBrandId()
{
	var categoryId=$('input:radio[name="filtertyperadio"]:checked').val();
	var brandId=$('input:radio[name="filterbrandradio"]:checked').val();
	
	if(categoryId)
	{
		if(categoryId=="all")
		{
			if($("#hiddenCategoryId")[0])
			{
				$("#hiddenCategoryId").remove();
			}
		}
		else
		{
			if($("#hiddenCategoryId")[0])
			{
				$("#hiddenCategoryId").val(categoryId);
			}
			else
			{
				var hiddenCategoryId=$("<input id='hiddenCategoryId' name='category_id' type='hidden' value='"+categoryId+"'/>")
				$("#changeConstrainForm").append(hiddenCategoryId);
			}
		}
	}
	if(brandId)
	{
		if(brandId=="all")
		{
			if($("#hiddenBrandId")[0])
			{
				$("#hiddenBrandId").remove();
			}
		}
		else
		{
			if($("#hiddenBrandId")[0])
			{
				$("#hiddenBrandId").val(brandId);
			}
			else
			{
				var hiddenBrandId=$("<input id='hiddenBrandId' name='brand_id' type='hidden' value='"+brandId+"'/>")
				$("#changeConstrainForm").append(hiddenBrandId);
			}
		}
	}
	if(categoryId||brandId)
	{
		$("#changeConstrainForm").submit();	
	}
}

function resetRadioBrand()
{
	$("input[name='brandradio']").attr("checked",false);
}

function resetRadioType()
{
	$("input[name='typeradio']").attr("checked",false);
}

function resetRadioBrandType()
{
	$("input[name='filterbrandradio']").attr("checked",false);
	$("input[name='filtertyperadio']").attr("checked",false);
}