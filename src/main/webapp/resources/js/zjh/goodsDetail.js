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
});

$(document).ready(function () {
	$("#goods-detail-div").scroll(function()
	{
		var scrollTop=$("#goods-detail-div").scrollTop();
		var uptownTop= -0.133 * scrollTop + 7;
		$("#goods-detail-swiper-pic").css("top",uptownTop+"%");
	});
});

$(document).ready(function(){

	$("#display-all-description-button").click(function(){
		var scrollHeight=document.getElementById("goods-description-content").scrollHeight;
		var height=$("#goods-description-content").height();
		if(scrollHeight>=height)
		{
			$("#goods-description-content").css("height",scrollHeight+"px");
			$("#display-all-description-div").hide();
			$("#hidden-all-description-div").show();
		}
	});

	$("#hidden-all-description-button").click(function(){
		$("#goods-description-content").css("height","30px");
		$("#display-all-description-div").show();
		$("#hidden-all-description-div").hide();
	});
});