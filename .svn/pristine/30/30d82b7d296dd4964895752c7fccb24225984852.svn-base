$('.herd .herd_dao .herd_two p').css('border-bottom','none')


//导航
	$('.herd .herd_dao .herd_two li').mouseover(function(){
		$(this).find('p').css('color','#4af787')
		$(this).find('p').css('border-bottom','')
	
	})
	
	$('.herd .herd_dao .herd_two li').mouseout(function(){
		$(this).find('p').css('color','white')
		$(this).find('p').css('border-bottom','none')
		
	})

//登录注册
	$('.herd .herd_dao .herd_three li').mouseover(function(){
		$(this).css('color','#4af787')
		
	})
	
	$('.herd .herd_dao .herd_three li').mouseout(function(){
		$(this).css('color','white')
	
	})
	
	
//新闻通知


$('.box2 .mag_dao .ad1').css('color', '#55c740')
$('.box2 .mag_dao li').click(function() {

	$(this).addClass('ap').siblings().removeClass("ap")

	if($(this).hasClass("ap")) {
		$(this).css('color', '#55c740').siblings().css('color', 'black')

		if($('.box2 .mag_dao .ad1').hasClass("ap")) {
			$('.box2 .a1').removeClass("table").siblings().addClass('table')
		}

		if($('.box2 .mag_dao .ad2').hasClass("ap")) {
			$('.box2 .a2').removeClass("table").siblings().addClass('table')
		}
		
		if($('.box2 .mag_dao .ad3').hasClass("ap")) {
			$('.box2 .a3').removeClass("table").siblings().addClass('table')
		}
		
		if($('.box2 .mag_dao .ad4').hasClass("ap")) {
			$('.box2 .a4').removeClass("table").siblings().addClass('table')
		}


	}

})

//便民服务

$('.box7 .dome .dome_top .pople .mond').mouseover(function(){
		$(this).css("background-image","url(../static/img/bluex.png)");
		$(this).css('color','#35b4ff')
	
	})

$('.box7 .dome .dome_top .pople .mond').mouseout(function(){
		$(this).css("background-image","url(../static/img/blue.png)");
		$(this).css('color','black')
	
	})


//教学资源
$('.box3 .mag_dao .ad1').css('color','#55c740')
$('.box3 .mag_dao li').click(function() {

	$(this).addClass('ap').siblings().removeClass("ap")

	if($(this).hasClass("ap")) {
		$(this).css('color', '#55c740').siblings().css('color', 'black')

		if($('.box3 .mag_dao .ad1').hasClass("ap")) {
			$('.box3 .box3_mag .a1').removeClass("text1").siblings().addClass('text1')
		
		}

		if($('.box3 .mag_dao .ad2').hasClass("ap")) {
			$('.box3 .box3_mag .a2').removeClass("text1").siblings().addClass('text1')
		}
		
		


	}

})

//教学资源
$('.box3 .box3_mag .mag_text .lef').click(function(){
	
	var le=$('.left-nav .bo').offset().left;
	
	var vm=le-300-357.5
	
	if(le<20){
		
	}else{
		$('.left-nav').animate({left: vm}, 100);
	}
	
})


$('.box3 .box3_mag .rig').click(function(){
	$('.left-nav').animate({left: '0'}, 100);
		
})

//子站展示
$('.box1 .box1_mag .mapx').mouseover(function(){
	
	$(this).find('p').css('color','#55c740')
	 $(this).css({"border":"1px solid #55c740"});
	/*$(this).find('p').css('border-bottom','none')*/
})

$('.box1 .box1_mag .mapx').mouseout(function(){
	$(this).css({"border":"1px solid #c5c5c5"});
	$(this).find('p').css('color','white')
})

$('.box1 .box1_mag .mapx').click(function(){
	var inp= $(this).find("input").val()
	
	$('.box1 .box1_mag .new_right img').attr('src','../static/img/'+inp+'.png')
})

//子站
$('.herd_dao .herd_three .dom .layui-icon').click(function(){
	
	$(".herd_dao .herd_three .dom .user_bo").toggle();
})

//新闻资讯
$('.news .newinfor .ap').css('color','#03A9F4')
$('.news .newinfor p').click(function(){
			$(this).addClass('ap').siblings().removeClass('ap')
			$(this).css('color','#03A9F4').siblings().css('color','black')
			
	
	if($('.news .newinfor .news_text .te1').hasClass('ap')){
		$('.news .show .box1').removeClass('bo').siblings().addClass('bo')
	}
	
	if($('.news .newinfor .news_text .te2').hasClass('ap')){
		$('.news .show .box2').removeClass('bo').siblings().addClass('bo')
	}
	
	if($('.news .newinfor .news_text .te3').hasClass('ap')){
		$('.news .show .box3').removeClass('bo').siblings().addClass('bo')
	}
})