$(function(){
	$('.tsList').each(function(){$(this).find('li').last().addClass('noBorder');});
	$(document).on('click','.cCsmallClose', function(){closeSmallMsg();});
	$(document).on('mouseover','.cCsmallClose', function(){$(this).addClass('cCsmallCloseH');});
	$(document).on('mouseout' ,'.cCsmallClose', function(){$(this).removeClass('cCsmallCloseH');});
	$(document).on('click','.cFrameClose', function(){closeCFrame();});
	$('#dMenu').click(function(){
		$('#HUI_Nav_Menus').show();
	});
});
function closeNavMenu(){
	$('#HUI_Nav_Menus').hide();
}

// ---- | 小消息框 | -------------------------------------------------------
function autoMsg(msg, cWidth, type, isAutoClose){
	if(typeof(cWidth) == 'undefined'){cWidth = 168;}
	if(typeof(isAutoClose) == 'undefined'){isAutoClose = true;}
	if(typeof(type) == 'undefined'){type = 1;}
	var htmlStr = '<div class="cCsmall" style="width:'+cWidth+'px;"><div class="cCsmallClose"></div><div class="cCsmallIn">'+msg+'</div></div>';
	$(htmlStr).appendTo('body');
	var lWidth  = $('.cCsmall').outerWidth();
	var lHeight = $('.cCsmall').outerHeight();
	var wWidth  = $(window).width();
	var wHeight = $(window).height();
	if(type != 1){$('.cCsmallIn').addClass('cCsmallInE');}
	$('.cCsmall').css({'left':(wWidth - lWidth)/2, top:(wHeight - lHeight)/2 + $(window).scrollTop()});
	$('.cCsmall').fadeIn(100);
	if(isAutoClose){
		setTimeout(function(){closeSmallMsg();}, 2000);
	}
}
function closeSmallMsg(){$('.cCsmall').fadeOut().remove();}

// ---- | 通用遮罩 | ------------------------------------------------------
function cShade(){
	if($('#cShade').size() < 1){$('<div id="cShade"></div>').appendTo('body');}
	var bodyHeight = $('body').height();
	var wHeight    = $(window).height();
	if(bodyHeight < wHeight){bodyHeight = wHeight;}
	$('#cShade').css({'opacity':0.6, 'height':bodyHeight}).show();
}
function closeShade(){$('#cShade').fadeOut(100);}

// ---- | 轮播广告 | ------------------------------------------------------
function slideBox(){
	this.slide_speed     = 500;
	this.delay           = 6000;
	this.startIndex      = 0;
	this.li_width        = 0;
	this.main_box_id     = '';
	this.point_box_id    = '';
	this.next_box_id     = '';
	this.point_width     = 20;
	this.total_li        = 0;
	this.set_time_id     = null;
	this.point_style     = '';
	this.next_button_id  = '';
	this.start = function(){
		var winWidth     = $(window).width();
		this.li_width    =  winWidth;
		$(this.main_box_id).find('li').css({width:winWidth});
		if($(this.point_box_id).find('div').size() < 1){
			this.total_li  =  $(this.main_box_id).find('li').size();
			$(this.main_box_id).find('li').eq(0).clone().appendTo(this.main_box_id+' ul');
			var insert_str = '';
			for(i=1; i<=this.total_li; i++){
				insert_str += '<div></div>';
			}
			insert_str += '<input type="hidden" value="0" />';
			$(this.point_box_id).html(insert_str);
			$(this.main_box_id).find('ul').css({'width':500000});
			this.point_width =  $(this.point_box_id).find('div').outerWidth(true);
			$(this.point_box_id).css({'width':this.point_width*this.total_li+2});
		}else{
			this.total_li  =  $(this.main_box_id).find('li').size() - 1;
			$(this.main_box_id).find('ul').css({'width':(this.total_li) * this.li_width + 500000});
			
		}
		var this_obj = this;
		$(this.point_box_id).find('div').click(function(){
			$(this_obj.main_box_id).find('ul').stop();
			clearTimeout(this_obj.set_time_id);
			this_obj.slide_it($(this).index());
		});
		this.slide_it(0);
	}
	
	this.slide_it = function (index){
		if(this.set_time_id != null){
			clearTimeout(this.set_time_id);
		}
		var this_obj = this;
		$(this.main_box_id).find('ul').animate(
			{'margin-left': index * this.li_width * -1},
			this.slide_speed,
			function(){
				if(index < this_obj.total_li){
					this_obj.point_select(index);
					$(this_obj.point_box_id).find(':hidden').val(index);
					this_obj.set_time_id = setTimeout(function(){this_obj.slide_it(index+1)},this_obj.delay);
				}else{
					this_obj.point_select(0);
					$(this_obj.point_box_id).find(':hidden').val(0);
					$(this_obj.main_box_id).find('ul').css({'margin-left':0});
					this_obj.set_time_id = setTimeout(function(){this_obj.slide_it(1)},this_obj.delay);
				}
			}
		);
	}
	this.point_select = function (index){
		$(this.point_box_id).find('div').removeClass(this.point_style);
		$(this.point_box_id).find('div').eq(index).addClass(this.point_style);
	}
}

function setAuth(name){
	$.post(
		'/setAuth',
		{authName:name},
		function(msg){
			if($('#sAuth').size() < 1){
				$('<input type="hidden" id="sAuth" value="'+msg+'" />').appendTo('body');
			}else{
				$('#sAuth').val(msg);
			}
		}
	);
}

function cFrame(title, msg, width, padding){
	$('.cFrame').remove();
	cShade();
	if(typeof(width) == 'undefined'){width = 398;}
	if(typeof(padding) == 'undefined'){padding = '15px';}
var innerHtml = ''+
	'<div class="cFrame" style="width:'+width+'px;">'+
		'<div class="cFrameWrap">'+
			'<div class="cFrameT">'+
				'<div class="cFrameText">'+title+'</div><div class="cFrameClose" id="cFrameClose"></div>'+
			'</div>'+
			'<div class="cFrameMain" style="padding:'+padding+';">'+msg+'</div>'+
		'</div>'+
	'</div>';
	$(innerHtml).appendTo('body');
	var lWidth  = $('.cFrame').outerWidth();
	var lHeight = $('.cFrame').outerHeight();
	var wWidth  = $(window).width();
	var wHeight = $(window).height();
	$('.cFrame').css({'left':(wWidth - lWidth)/2, top:(wHeight - lHeight)/2 + $(window).scrollTop()});
	$('.cFrame').show();
}

function closeCFrame(){
	$('.cFrame').remove();
	closeShade();
}

function sLogin(){cFrame('请登录','<iframe src="/lg/login" frameborder="0" width="100%" height="222" scrolling="no"></iframe>');}
function sReg(){cFrame('会员注册','<iframe src="/common/reg" frameborder="0" width="100%" height="350" scrolling="no"></iframe>',398,'5px 15px');}
function sRePwd(){cFrame('找回密码','<iframe src="/reSetPwd" frameborder="0" width="100%" height="158" scrolling="no"></iframe>',398,'5px 15px');}
function sQqLogin(){cFrame('QQ登录','<iframe src="/qqLogin" frameborder="0" width="100%" height="358" scrolling="no"></iframe>',398,'5px 15px');}

function butRegIn(){$(window.parent.document).find('#regHeader').click();}
function butLoginIn(){$(window.parent.document).find('#loginHeader').click();}
function butRePwdIn(){$(window.parent.document).find('#sRePwd').click();}
function qqLogin(){$(window.parent.document).find('#qqLogin').click();}
