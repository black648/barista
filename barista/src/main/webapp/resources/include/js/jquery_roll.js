$(document).ready(function(){

});

var sample_bn_speed = 300; //움직임 속도
var sample_bn_click = 0; //광클릭 방지
var sample_bn_time; //setInterval 지정변수(Interval 속성을 clear해주기 위해 변수처리)
var sample_bn_timeSpeed = 3500; //setInterval 함수 반복실행 시간(해당시간마다 sample_bn_after펑션을 호출한다.)/*0918 수정*/
var sample_bn_auto = "Y";//자동재생을 설정한다.(Y = 자동재생, N = 효과없음)
function bnr_ac(){
	var obj = $(".news_bnr"); //해당 object 변수
	var before_bt = obj.find(".bnr_prev"); //이전버튼 변수
	var after_bt = obj.find(".bnr_next"); //다음버튼 변수

	
	after_bt.click(sample_bn_after);//다음 버튼 클릭시 sample_bn_after펑션 호출
	before_bt.click(sample_bn_before);//이전 버튼 클릭시 sample_bn_before펑션 호출
	
	
	if(sample_bn_auto == "Y"){//자동재생의 경우 펑션을 호출한다.
		sample_bn_play();//이벤트 완료후 재생효과를 주기위한 펑션
	}
}
//다음 버튼 호출
function sample_bn_after(){
	if(sample_bn_click == 0){
		sample_bn_stop();//setInternterval속성을 clear시킨다.
		sample_bn_click = 1;//배너의 움직임이 지속되는동안은 클릭시 중첩되지 않게 된다.
		var move_obj = $(".news_bnr > div > ul"); //움직일 객체 변수
		var move_obj_width = (move_obj.find(">li").width() * -1); //움직일 컨텐츠의 넓이값 저장 (다음버튼클릭시 화면은 왼쪽으로 움직이기 위해 음수값을 만든다)
		
		move_obj.find(">li").eq(0).clone().appendTo(move_obj);//움직일 객체변수의 자식중 li의 0번째 녀석을 clone(복사)하여 appendTo(위치) 위치에 해당하는 곳의 배열중 마지막배열로 삽입한다.
		move_obj.animate(
			{left:move_obj_width}
			,sample_bn_speed
			,function(){
				//해당 펑션은 animate가 작동이 끝난뒤 처리된다.
				//이곳에 오기전까지의 데이터는 1번째을 복사하여 마지막 배열에 추가하였다.
				move_obj.find(">li").eq(0).remove();//remove함수를 사용하여 1번째 배열을 삭제한다.
				move_obj.css("left","0");//left값을 0으로 초기화시킨다. (1번째 배열을 삭제하였기때문에 그공간을 빼준 값이다.)
				//이곳까지 오게 되면 소스상의 데이터는 초기 : 1,2,3 에서 2,3,1로 변경 되어있다.
				//클릭시 마다 적용되며 클릭시마다 배열이 새롭게 변경된다.(무한반복)
				sample_bn_click = 0;//움직임이 끝났고 다음 클릭을 대비하여 값을 초기화한다.
				
				if(sample_bn_auto == "Y"){//자동재생의 경우 펑션을 호출한다.
					sample_bn_play();//이벤트 완료후 재생효과를 주기위한 펑션
				}
			}
		);//move_obj의 left를 저장해놓았던 넓이값만큼 미리정해놓은 속도로 이동시킨다.
	}
}
//이전 버튼 호출
function sample_bn_before(){
	if(sample_bn_click == 0){
		sample_bn_stop();//setInternterval속성을 clear시킨다.
		sample_bn_click = 1;//배너의 움직임이 지속되는동안은 클릭시 중첩되지 않게 된다.
		var move_obj = $(".news_bnr > div > ul"); //움직일 객체 변수
		var move_obj_width = (move_obj.find(">li").width() * -1); //움직일 컨텐츠의 넓이값 저장 (다음버튼클릭시 화면은 왼쪽으로 움직이기 위해 음수값을 만든다)
		
		move_obj.find(">li:last").clone().prependTo(move_obj);//움직일 객체변수의 자식중 li의 마지막 녀석을 clone(복사)하여 prependTo(위치) 위치에 해당하는 곳의 배열중 첫번째배열로 삽입한다.
		move_obj.css("left",move_obj_width+"px");//left값을 객체 하나만큼의 값만큼 -시킨다. (마지막 배열을 가져와 첫번째에 넣었기때문에 그만큼의 값을 -시킨것이다.)
		
		move_obj.animate(
			{left:0}
			,sample_bn_speed
			,function(){
				//해당 펑션은 animate가 작동이 끝난뒤 처리된다.
				//이곳에 오기전까지의 데이터는 마지막을 복사하여 첫번째 배열에 추가하였다.
				move_obj.find(">li:last").remove();//remove함수를 사용하여 마지막 배열을 삭제한다.			
				//이곳까지 오게 되면 소스상의 데이터는 초기 : 1,2,3 에서 3,1,2로 변경 되어있다.
				//클릭시 마다 적용되며 클릭시마다 배열이 새롭게 변경된다.(무한반복)
				sample_bn_click = 0;//움직임이 끝났고 다음 클릭을 대비하여 값을 초기화한다.
				
				if(sample_bn_auto == "Y"){//자동재생의 경우 펑션을 호출한다.
					sample_bn_play();//이벤트 완료후 재생효과를 주기위한 펑션
				}
				
			}
		);//move_obj의 left를 저장해놓았던 넓이값만큼 미리정해놓은 속도로 이동시킨다.
	}
}

$(document).ready(function(){
	$(".news_bnr > div > ul").bind('mouseenter focusin',function(){
		$(".news_bnr .bnr_play").css({'display': 'inline'});
		$(".news_bnr .bnr_stop").css({'display': 'none'});
		clearInterval(sample_bn_time);
		return false;
	});
	$(".news_bnr > div > ul").bind('mouseleave focusout',function(){
		$(".news_bnr .bnr_play").css({'display': 'none'});
		$(".news_bnr .bnr_stop").css({'display': 'inline'});
		sample_bn_stop();
		sample_bn_time = setInterval(sample_bn_after,sample_bn_timeSpeed);
		return false;
	});
});


//재생 버튼 호출
function sample_bn_play(){
	sample_bn_stop();//이곳에서 stop펑션을 호출한 이유는 혹시나 실행되고있는 Interval과 중첩되는 현상을 막기 위함이다.
	sample_bn_time = setInterval(sample_bn_after,sample_bn_timeSpeed); //해당시간마다 sample_bn_after펑션을 호출한다.
	return false;
}
//정지 버튼 호출
function sample_bn_stop(){
	clearInterval(sample_bn_time);//setInterval속성을 clear시킨다.
	return false;
	
}
