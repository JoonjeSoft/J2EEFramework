function refreshCaptcha() {
	var now = new Date();
	var time = now.getTime();
	$('#captchaImg').attr('src', 'login/captcha?time=' + time);
}


$(document).ready(function(){

	function setLoginPanelPosition(){
		var bodyHeight = document.body.clientHeight;
		var loginPanelheight = $('#loginPanel').height();
		$('#loginPanel').css('margin-top',(bodyHeight-loginPanelheight)/2-20);
	}
	setLoginPanelPosition();

	$(window).resize(function() {
		setLoginPanelPosition();
	});
});
