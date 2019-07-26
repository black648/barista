var sel_file;

$(document).ready(function(){
	/* 메뉴 */
	$('.menu>li').mouseover(function(){
		$(this).find('>a').addClass('on');
		$(this).children('.lnb').stop().slideDown();
	});

	$('.menu>li').mouseleave(function(){
		$(this).find('>a').removeClass('on');
		$(this).children('.lnb').stop().slideUp();
	});

	$('#menu_all').click(function(){
		$(this).toggleClass('all_on');
		$('.menu_all').toggle();
	});

	/* footer 관련사이트 */
	$('.site_area').click(function(){
		$(this).toggleClass('open');
	});

	/* 공지사항 */
	$('.notice').mouseover(function(){
		$(this).find('.bg').css({
			'background':'url("/resources/include/images/main/plus2.png")',
			'transform':'rotate(180deg)',
			'transition':'2s all',
			'cursor':'pointer'
		});
	});

	$('.notice').mouseleave(function(){
		$(this).find('.bg').css({
			'background':'url("/resources/include/images/main/plus1.png")',
			'transform':'rotate(-90deg)'
		});
	});

	/* 캘린더 */
	$('.calendar').mouseover(function(){
		$(this).find('.bg').css({
			'background':'url("/resources/include/images/main/plus2.png")',
			'transform':'rotate(180deg)',
			'transition':'2s all',
			'cursor':'pointer'
		});
	});

	$('.calendar').mouseleave(function(){
		$(this).find('.bg').css({
			'background':'url("/resources/include/images/main/plus1.png")',
			'transform':'rotate(-90deg)'
		});
	});

	/* 메인배너 롤링 */
	$('#boxBanner ul').bxSlider({
		auto: true, 
		autoHover: true,
		autoControls: true,
				
		mode:'horizontal',
		pause: 3000,
		pager: true,
		pagerSelector: '#boxBanner > p',
		pagerActiveClass: 'on',
		controls: false,
		displaySlideQty: 1,
		moveSlideQty: 1,
		speed: 500,
				
		startImage :'/resources/include/images/ico/main_btn_play.png',
		stopImage:'/resources/include/images/ico/main_btn_stop.png',
		startText :'비주얼 이미지 플레이',
		stopText :'비주얼 이미지 멈춤'
	});	

	/* TOP 버튼 */
	$('.top').click(function(){
		return $('html,body').animate({scrollTop:0},300),!1
	});
	$('.top').hide();
	$(function(){
		$(window).scroll(function(){
			if($(this).scrollTop() > 1){
				$('.top').fadeIn();
			} else {
				$('.top').fadeOut();
			}
		});
	});

	/* 02-02 입사지원서 */
	$('#input_img').on('change',handleImgRileSelect);

	/* 03-03 교육신청 */
	$('.stu_list').click(function(){
		$(this).toggleClass('open');
		$(this).children('.cont').toggle('slow');
	});

	/* 05-02 FAQ */
	$('.faq_list').click(function(){
		$(this).toggleClass('open');
		$(this).children('.cont').toggle('slow');
	});

	/* 05-03 Q&A */
	$('textarea.autosize').on('keydown keyup',function(){
		$(this).height(1).height($(this).prop('scrollHeight')+12);
	});
})


/* 02-02 입사지원서 input type file img넣을 때 */
function handleImgRileSelect(e){
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	filesArr.forEach(function(f) {
		if(!f.type.match('image.*')) {
			alert('확장자를 확인하세요');
			return;
		}

		sel_file = f;

		var reader = new FileReader();
		reader.onload = function(e) {
			$('#img').attr('src',e.target.result);
		}
		reader.readAsDataURL(f);
	});
}

/* 메인 - 바로가기 */
var sample_bn_speed = 300;
var sample_bn_click = 0;
var sample_bn_time;
var sample_bn_auto = "Y";

function bnr_ac() {
	var obj = $('.')
}