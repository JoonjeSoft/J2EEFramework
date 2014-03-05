function refreshCaptcha() {
	var now = new Date();
	var time = now.getTime();
	$('#captchaImg').attr('src', 'login/code?time=' + time);
}