function getCurrentAllPrice()
{
	var number=$("#numberButton").html();
	var price=$("#shoppingCart-goods-price").html();
	return number*price;
}

function showShoppingCartModal()
{
	var stockCount=$("#shoppingCart-content #shoppingCart-goods-stockCount").html();
	if(stockCount<=1)
	{
		$("#numberButton").html(stockCount);
		$("#numberUpwardButton").attr("disabled",true);
	}
	else
	{
		$("#numberButton").html(1);
	}
	$("#numberDownwardButton").attr("disabled",true);
	$("#numberButton").attr("disabled",true);
	$("#shoppingCart-middle-all-price-span").html(getCurrentAllPrice());

	$("#shoppingCart-modal").show();
}

$(document).ready(function(){
	$("#addToShoppingCartButton").click(function(e)
    { 
		showShoppingCartModal();
    });

	$("#shoppingCart-exit-span").click(function(e){
		$("#shoppingCart-modal").hide();
	});

     $("#shoppingCart-modal").click(function (e) { 
        var target=$(e.target);
        if(target.closest("#shoppingCart-content").length==0)
        {
        	$("#shoppingCart-modal").hide();
        }
    });
});

$(document).ready(function()
{
	$("#numberUpwardButton").click(function(e)
	{
		var numberButton=parseInt($("#numberButton").html());
		numberButton=numberButton+1;
		$("#numberButton").html(numberButton);
		$("#shoppingCart-middle-all-price-span").html(getCurrentAllPrice());
		if(numberButton>1)
		{
			$("#numberDownwardButton").attr("disabled",false);
		}

		if(numberButton>=$("#shoppingCart-goods-stockCount").html())
		{
			$("#numberUpwardButton").attr("disabled",true);
		}
	});

	$("#numberDownwardButton").click(function(e)
	{
		var numberButton=parseInt($("#numberButton").html());
		numberButton=numberButton-1;
		$("#numberButton").html(numberButton);
		$("#shoppingCart-middle-all-price-span").html(getCurrentAllPrice());
		
		if(numberButton==1)
		{
			$("#numberDownwardButton").attr("disabled",true);
		}

		if(numberButton<$("#shoppingCart-goods-stockCount").html())
		{
			$("#numberUpwardButton").attr("disabled",false);
		}
	});
});

$(document).ready(function()
{
	$("#goods-list-content").on("click",".addShoppingCartImg",function(e)
	{
		var target=$(e.target);
		$("#shoppingCart-content #hiddenGoodsId").val(target.prev().prev().prev().prev().prev().val());
		$("#shoppingCart-content #shoppingCart-goods-price").html(target.prev().prev().prev().prev().val());
		$("#shoppingCart-content #shoppingCart-goods-serial-code").html(target.prev().prev().prev().val());
		$("#shoppingCart-content #shoppingCart-goods-stockCount").html(target.prev().prev().val());
		$("#shoppingCart-content #shoppingCart-Goods-picture").attr("src",target.prev().val());
		
		showShoppingCartModal();
	});
});

function addGoodsToShoppingCart()
{
	if($("#numberButton").html()==0)
	{
		alert("购物车商品数量不能为0!");
	}
	else
	{
		var springUrl=$("#hiddenSpringUrl").val();
		$.ajax({
	        url: springUrl+"/cart/add",
	        async: false,
	        cache: false,
	        type: 'post',
	        dataType: "json",
	        data: {
	        	goodsId:$("#hiddenGoodsId").val(),
	        	goodsNumber:$("#numberButton").html()
	        },
	        success:function(data)
	        {
	        	alert(data.message);
	        	if(data.code=="200")
	        	{
	        		location.reload();
	        	}
	        }
		});
	}
}