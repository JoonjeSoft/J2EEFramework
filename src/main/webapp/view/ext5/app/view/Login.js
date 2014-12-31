Ext.define('JoonjeSoft.view.Login', {
	extend : 'Ext.form.Panel',
	requires : ['JoonjeSoft.view.LoginController'],
	alias : 'widget.loginform',
	controller : 'login',
	autoShow : true,
	title : '用户登录',
	bodyPadding : 10,
	buttonAlign : 'center',
	defaultType : 'textfield',
	items : [{
				fieldLabel : '用户名',
				name : 'name',
				allowBlank : false,
				blankText : '请输入用户名'

			}, {
				fieldLabel : '密码',
				name : 'password',
				allowBlank : false,
				blankText : '请输入密码',
				inputType : 'password'
			}, {
				xtype : 'fieldcontainer',
				fieldLabel : '验证码',
				layout : {
					type : 'hbox',
					align : 'middle'
				},
				items : [{
							xtype : 'textfield',
							width : 100,
							flex : 1
						}, {
							xtype : 'splitter'
						}, {
							xtype : 'image',
							id : 'captchaImage',
							src : '/joonje/login/captcha?t=' + Math.random(),
							flex : 1,
							height : 22,
							width : 50,
							listeners : {
								click : {
									element : 'el',
									fn : function() {
										Ext
												.getCmp('captchaImage')
												.setSrc('/joonje/login/captcha?t='
														+ Math.random());
									}
								}
							}
						}]
			}, {
				xtype : 'checkboxfield',
				anchor : '100%',
				fieldLabel : ' ',
				boxLabel : '记住我'
			}

	],
	buttons : [{
				text : '重置',
				handler : function() {
					this.up('form').getForm().reset();
				}
			}, {
				text : '提交',
				handler : 'onLogin'
			}]
});