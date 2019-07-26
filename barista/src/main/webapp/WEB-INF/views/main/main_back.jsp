<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>바리스타</title>




	
	
<div id="container_box"><!-- /contents -->
		<div class="m_visual"><!--m_vusual-->
			<div class="bg">
				<img src="../resources/include/twb_images/m_visual_text.png" alt="">
			</div>
			<div class="bg_bottom">
				<div class="popmenu"><!--popmenu-->
					<ul>
						<li><a href="#"><img src="../resources/include/twb_images/m_quick_01.png" alt="수험표출력"></a></li>
						<li><a href="#"><img src="../resources/include/twb_images/m_quick_02.png" alt="합격자조회"></a></li>
						<li><a href="#"><img src="../resources/include/twb_images/m_quick_03.png" alt="문의전화안내"></a></li>
						<li><a href="#"><img src="../resources/include/twb_images/m_quick_04.png" alt="계좌번호안내"></a></li>
					</ul>
				</div><!--popmenu-->
			</div>
		</div><!--m_vusual-->

		<div class="boardbox"><!--boardbox-->

			<div class="board_latest" id="notice"><!-- /notice -->
				<div class="title"><!-- /title -->
					<div class="left"><img src="../resources/include/twb_images/m_title_notice.jpg" alt="공지사항"></div>
					<div class="right"><a href="#"><img src="../resources/include/twb_images/m_more.jpg" alt="more"></a></div>
				</div><!-- /title -->
				<div class="latest"><!-- /latest -->
					<ul>
						<!-- recentlist '(1)' --> 
					</ul>
				</div><!-- /latest -->
			</div><!-- /notice -->

			<div class="board_latest" id="archive"><!-- /archive -->
				<div class="title"><!-- /title -->
					<div class="left"><img src="../resources/include/twb_images/m_title_archive.jpg" alt="자료실"></div>
					<div class="right"><a href="#"><img src="../resources/include/twb_images/m_more.jpg" alt="more"></a></div>
				</div><!-- /title -->
				<div class="latest">
					<ul>
						<!-- recentlist '(2)' --> 
					</ul>
				</div><!-- /latest -->
			</div><!-- /archive -->

			<div class="board_latest2" id="q&a"><!-- /q&a -->
				<div class="title"><!-- /title -->
					<div class="left"><img src="../resources/include/twb_images/m_title_qna.jpg" alt="자주하는 질문"></div>
					<div class="right"><a href="#"><img src="../resources/include/twb_images/m_more.jpg" alt="more"></a></div>
				</div><!-- /title -->
				<div class="latest">
					<ul>
						<!-- recentlist '(3)' --> 					
                                        </ul>
				</div><!-- /latest -->
			</div><!-- /q&a -->

		</div><!-- /boardbox -->

		<div class="pop"><!--pop-->
			<div class="callender"><!--callender-->
				<div class="c_title"><img src="../resources/include/twb_images/m_title_cal.png" alt="검정일정"><div class="right"><a href="#"><img src="../resources/include/twb_images/m_more_cal.png" alt="달력"></a></div></div>
				<div class="cal_bg"> <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
      
          <tr style="padding-top:100px;">
            <th colspan="7"><span class="titlecolor">2014.</span><span> 08.</span></th>
          </tr>
		  <tr>
			<td></td><td></td><td></td><td></td><td></td><td class='check'>1</td>  <td class='blue'>2</td> </tr> <tr><td class='red'>3</td><td class=''>4</td><td class=' '>5</td><td class=' '>6</td><td class=' '>7</td><td class=''>8</td>  <td class='blue'>9</td> </tr> <tr><td class='red'>10</td><td class=''>11</td><td class=' check'>12</td><td class=''>13</td><td class=' '>14</td><td class=''>15</td>  <td class='blue'>16</td> </tr> <tr><td class='red'>17</td><td class=''>18</td><td class=' '>19</td><td class=''>20</td><td class='ctoday sche '>21</td><td class=' '>22</td>  <td class='blue'>23</td> </tr> <tr><td class='red'>24</td><td class=''>25</td><td class=' '>26</td><td class=' '>27</td><td class='check'>28</td><td class=''>29</td>  <td class='blue'>30</td> </tr> <tr><td class='red'>31</td> <td></td> <td></td> <td></td> <td></td> <td></td>  <td class='blue'></td>
		  </tr>
        </table>
</div>			
			</div><!--callender-->

			 <div class="joint_list">
				 <div class="roll_le"><a href="#left"><img src="../resources/include/twb_images/m_pop_left.png" alt="leftpop"></a> </div>
				 <div class="roll_ri"><a href="#right"> <img src="../resources/include/twb_images/m_pop_right.png" alt="rightpop"></a> </div>
				    <div class="rolling">
					  <ul>
						 <li><a href="#"><img src="../resources/include/twb_images/m_pop_01.jpg" alt="pop1"></a></li>
						 <li><a href="#"><img src="../resources/include/twb_images/m_pop_01.jpg" alt="pop2"></a></li>
						 <li><a href="#"><img src="../resources/include/twb_images/m_pop_01.jpg" alt="pop3"></a></li>
					  </ul>
				 </div>
					
			</div>
 
      <script type="text/javascript">
$(document).ready(function(){
	// 맞춤서비스 - 롤링배너
	$(window).load(function() {
		$(".rolling").jCarouselLite({
		btnNext: ".roll_le",
		btnPrev: ".roll_ri",
		visible: 1,
		speed: 600,
		auto: 3000,

		});
	});
});

</script> 	
		</div><!--pop-->
	</div><!-- /contents -->

