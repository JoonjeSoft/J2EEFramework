Ext.define('JoonjeSoft.view.Login', {
    extend: 'Ext.window.Window',
    requires: ['JoonjeSoft.view.LoginController'],
    alias: 'widget.loginform',
    controller: 'login',
    autoShow: true,
    title: '用户登录',
    glyph: 0xf007,
    bodyPadding: 10,
    buttonAlign: 'center',
    closable: false,
    //modal:true,
    //draggable: false,
    resizable: false,
    animateTarget: Ext.getBody(),
    items: {
        xtype: 'form',
        reference: 'loginForm',
        defaultType: 'textfield',
        items: [{
            fieldLabel: '用户名',
            name: 'name',
            allowBlank: false,
            blankText: '请输入用户名'

        }, {
            fieldLabel: '密码',
            name: 'password',
            allowBlank: false,
            blankText: '请输入密码',
            inputType: 'password'
        }, {
            xtype: 'fieldcontainer',
            fieldLabel: '验证码',
            layout: {
                type: 'hbox',
                align: 'middle'
            },
            items: [{
                xtype: 'textfield',
                width: 100,
                flex: 1
            }, {
                xtype: 'splitter'
            }, {
                xtype: 'image',
                id: 'captchaImage',
                src: '/joonje/login/captcha?t=' + Math.random(),
                flex: 1,
                height: 22,
                width: 50,
                listeners: {
                    click: {
                        element: 'el',
                        fn: function () {
                            Ext
                                .getCmp('captchaImage')
                                .setSrc('/joonje/login/captcha?t='
                                + Math.random());
                        }
                    }
                }
            }]
        }, {
            xtype: 'checkboxfield',
            anchor: '100%',
            //fieldLabel : ' ',
            boxLabel: '记住我',
            style: {
                'text-align':'right'
            }
        }]
    },

    buttons: [{
        text: '重置',
        handler: 'resetForm'
    }, {
        text: '提交',
        handler: 'onLogin'
    }],
    initComponent : function() {
        Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性
        this.callParent();
    }
});