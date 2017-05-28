$(document).ready(function()
{
	$("#editShoppingCartFooter").hide();
	$(".numberButton").attr("disabled",true);
	$("#header-edit-span").click(function()
	{
		var value=$("#header-edit-span").html();
		if(value=="编辑")
		{
			$("#editShoppingCartFooter").show();
			$("#balanceFooter").hide();
			$("#header-edit-span").html("完成");
			$(".shoppingcart-item-number-label").hide();
			$(".numberDownwardButton").show();
			$(".numberUpwardButton").show();
			$(".numberButton").attr("disabled",false);
			$(".numberButton").css("border","1px solid gray");
		}
		else if(value="完成")
		{
			updateCurrentPageValue();
			$("#editShoppingCartFooter").hide();
			$("#balanceFooter").show();
			$("#header-edit-span").html("编辑");
			$(".shoppingcart-item-number-label").show();
			$(".numberDownwardButton").hide();
			$(".numberUpwardButton").hide();
			$(".numberButton").attr("disabled",true);
			$(".numberButton").css("border","none");
		}
	});
});

$(document).ready(function()
{
	var oldGoodsNumber=0;
	var currentShoppingCartId=0;
	$(".numberDownwardButton").click(function(e)
	{
		oldGoodsNumber=getCurrentGoodsNumber(e);
		currentShoppingCartId=getCurrentShoppingCartId(e);
		setStockCountAndButtonNumber(e);
		$("#number-modal").show();
	});
	
	$(".numberButton").click(function(e)
	{
		oldGoodsNumber=getCurrentGoodsNumber(e);
		currentShoppingCartId=getCurrentShoppingCartId(e);
		setStockCountAndButtonNumber(e);
		$("#number-modal").show();
	});
	$(".numberUpwardButton").click(function(e)
	{
		oldGoodsNumber=getCurrentGoodsNumber(e);
		currentShoppingCartId=getCurrentShoppingCartId(e);
		setStockCountAndButtonNumber(e);
		$("#number-modal").show();
	});
	
	$("#makeSureButton").click(function(){
		var currentGoodsNumber=$("#numbermodal-numberButton").html();
		if(oldGoodsNumber!=currentGoodsNumber)
		{
			var inputCheckBox=$("input[type='checkbox'][name='shoppingcart_checkbox'][value='"+currentShoppingCartId+"']");
			var parentItem=$(inputCheckBox).parent().parent();
			$(parentItem).find(".numberButton").html(currentGoodsNumber);
			var hiddenInputId=$("<input type='hidden' class='hiddenShoppingCartId' value='"+currentShoppingCartId+"'/>");
			var hiddenInputCurrentGoodsNumber=$("<input type='hidden' class='hiddenCurrentGoodsNumber' value='"+currentGoodsNumber+"'/>");
			$("#hiddenValueDiv").append(hiddenInputId).append(hiddenInputCurrentGoodsNumber);
		}
		$("#number-modal").hide();
	});
});


$(document).ready(function()
{
	$("#numbermodal-numberUpwardButton").click(function(e)
	{
		var numberButton=parseInt($("#numbermodal-numberButton").html());
		numberButton=numberButton+1;
		$("#numbermodal-numberButton").html(numberButton);
		if(numberButton>1)
		{
			$("#numbermodal-numberDownwardButton").attr("disabled",false);
		}

		if(numberButton>=parseInt($("#numbermodal-hiddenStockCount").val()))
		{
			$("#numbermodal-numberUpwardButton").attr("disabled",true);
		}
	});

	$("#numbermodal-numberDownwardButton").click(function(e)
	{
		var numberButton=parseInt($("#numbermodal-numberButton").html());
		numberButton=numberButton-1;
		$("#numbermodal-numberButton").html(numberButton);
		
		if(numberButton==1)
		{
			$("#numbermodal-numberDownwardButton").attr("disabled",true);
		}

		if(numberButton<parseInt($("#numbermodal-hiddenStockCount").val()))
		{
			$("#numbermodal-numberUpwardButton").attr("disabled",false);
		}
	});
});

$(document).ready(function(){
	$("#cancelButton").click(function(e){
		$("#number-modal").hide();
	});
	
	$("#number-modal").click(function (e) {
		 var target=$(e.target);
	     if(target.closest("#number-modal-content").length==0)
	     {
	         $("#number-modal").hide();
	    }
	}); 
});


function calculateAllPriceByCheckbox(obj)
{
	var allPrice=parseInt($("#all-price-element").html());
	var shoppingCartItem=$(obj).parent().parent();
	var price=shoppingCartItem.find("#shoppingcart-item-price").html();
	var number=shoppingCartItem.find(".numberButton").html();
	if(obj.checked)
		allPrice+=price*number;
	else
		allPrice-=price*number;
	$("#all-price-element").html(allPrice);
}

function select_all(obj)
{
    var isChecked = obj.checked;
    var input = $("input[name='shoppingcart_checkbox']");
    for (var i = 0; i < input.length; i++) 
    {
        if(input[i].checked != isChecked)
        {
        	input[i].click();
        	input[i].checked=isChecked;
        }
    }
}

function deleteGoodsInShoppingCart()
{
	var isCheck=$("input[name='shoppingcart_checkbox']:checked");
	if(isCheck.length>0)
	{
		if(confirm("您确定要删除这"+isCheck.length+"件商品吗?"))
		{
			var springUrl=$("#hiddenSpringUrl").val();
			var deleteShoppingCartList=new Array();
			for(var i=0;i<isCheck.length;++i)
			{
				deleteShoppingCartList.push({"id":isCheck[i].value});
			}
			$.ajax({
		        url: springUrl+"/cart/delete",
		        async: false,
		        cache: false,
		        type: 'post',
		        dataType: "json",
		        contentType:"application/json",
		        data:JSON.stringify(deleteShoppingCartList),
		        success: function (data)
		        {
		        	if(data.code=="200")
		        	{
			        	for(var i=0;i<isCheck.length;++i)
						{
			        		var shoppingCartItem=$(isCheck[i]).parent().parent();
			        		shoppingCartItem.remove();
						}
		        	}
		        	else
		        	{
		        		alert(data.message);
		        	}
		        },
			 });
		}
	}
}

function buyGoods()
{
	var isCheck=$("input[name='shoppingcart_checkbox']:checked");
	if(isCheck.length>0)
	{
		var isSuccessSumbit=true;
		var goodsName="";
		
		for(var i=0;i<isCheck.length;++i)
		{
			var shoppingCartItem=$(isCheck[i]).parent().parent();
			var number=parseInt(shoppingCartItem.find(".numberButton").html());
			var stockCount=parseInt(shoppingCartItem.find("#shoppingcart-item-stock-count").html());
			if(number>stockCount)
			{
				isSuccessSumbit=false;
				goodsName=$("#shoppingcart-item-name-label").html();
				break;
			}
		}
		
		if(isSuccessSumbit)
		{	
			var springUrl=$("#hiddenSpringUrl").val();
			var form=$("<form action='"+springUrl+"/cart/order' method='post'></form>")
			
			for(var i=0;i<isCheck.length;++i)
			{
				var shoppingCartItem=$(isCheck[i]).parent().parent();
				var id=shoppingCartItem.find("#hiddenGoodsId").val();
				var number=shoppingCartItem.find(".numberButton").html();
				
				var inputGoodsId=$("<input type='hidden' name='goodsId' value='"+id+"'/>");
				var inputGoodsNumber=$("<input type='hidden' name='goodsNumber' value='"+number+"'/>");
				form.append(inputGoodsId).append(inputGoodsNumber);
			}
			form.appendTo("body");
	        form.css('display','none');
	        form.submit();
		}
		else
		{
			alert("商品\""+goodsName+"\"不符合要求,原因:商品数量大于库存量.请修改!");
		}
	}
}

function getCurrentGoodsNumber(e)
{
	var parentItem=$(e.target).parent();
	var stockCount=$(parentItem).find(".numberButton").html();
	return stockCount;
}

function getCurrentShoppingCartId(e)
{
	var parentItem=$(e.target).parent().parent().parent();
	var shoppingCartId=$(parentItem).find("input[type='checkbox'][name='shoppingcart_checkbox']").val();
	return shoppingCartId;
}

function setStockCountAndButtonNumber(e)
{
	var parentItem=$(e.target).parent().parent();
	var stockCount=parseInt($(parentItem).find("#shoppingcart-item-stock-count").html());
	var number=parseInt($(parentItem).find(".numberButton").html());
	$("#numbermodal-numberButton").html(number);
	$("#numbermodal-hiddenStockCount").val(stockCount);
	
	if(number<=1)
	{
		$("#numbermodal-numberDownwardButton").attr("disabled",true);
	}
	
	if(number>=stockCount)
	{
		$("#numbermodal-numberUpwardButton").attr("disabled",true);
	}
}

function updateCurrentPageValue()
{
	var isCheck=$("input[name='shoppingcart_checkbox']:checked");
	var currentAllPrice=0;
	for(var i=0;i<isCheck.length;++i)
	{
		var parentItem=$(isCheck[i]).parent().parent();
		var currentGoodsNumber=parseInt($(parentItem).find(".numberButton").html());
		var price=parseInt($(parentItem).find("#shoppingcart-item-price").html());
		currentAllPrice+=currentGoodsNumber*price;
	}
	$("#all-price-element").html(currentAllPrice);
	
	
	var updateShoppingCart=new Array();
	var parentHiddenValueDiv=$("#hiddenValueDiv");
	var hiddenShoppingCartId=$(parentHiddenValueDiv).find(".hiddenShoppingCartId");
	var hiddenCurrentGoodsNumber=$(parentHiddenValueDiv).find(".hiddenCurrentGoodsNumber");
	for(var i=0;i<hiddenShoppingCartId.length;++i)
	{
		updateShoppingCart.push({"id":$(hiddenShoppingCartId[i]).val(),"goodsNumber":$(hiddenCurrentGoodsNumber[i]).val()});
	}	
	var springUrl=$("#hiddenSpringUrl").val();
	$.ajax({
        url: springUrl+"/cart/update",
        async: false,
        cache: false,
        type: 'post',
        dataType: "json",
        contentType:"application/json",
        data:JSON.stringify(updateShoppingCart),
        success: function (data)
        {
        	if(data.code=="200")
        	{
	        	;
        	}
        	else
        	{
        		alert(data.message);
        	}
        },
	 });
	
	$("#hiddenValueDiv").empty();
}