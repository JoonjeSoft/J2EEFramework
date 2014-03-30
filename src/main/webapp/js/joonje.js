function refreshCaptcha() {
	var now = new Date();
	var time = now.getTime();
	$('#captchaImg').attr('src', 'login/captcha?time=' + time);
}