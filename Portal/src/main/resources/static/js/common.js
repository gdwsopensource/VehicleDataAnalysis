/**
 * author:shuifeng
 * data:17/06/21
 */
$(function() {
	nav();
	closePopLayer();
})
function nav(){
	var flag = true;
	$('.nav p').click(function() {
		if(flag) {
			$(this).siblings('ul').css({
				'display': 'block'
			});
		} else {
			$(this).siblings('ul').css({
				'display': 'none'
			});
		}
		flag = !flag;
	});
	$('.sub-nav li').click(function(){
		$('.sub-nav li').removeClass('active');
		$(this).addClass('active');
	});
}
function closePopLayer(){
	$('.title span').on('click',function(){
		$(this).parent().parent().parent().css({
			'display':'none'
		})
	})
}
