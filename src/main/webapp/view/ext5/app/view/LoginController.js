/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('JoonjeSoft.view.LoginController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.login',
    onLogin:function() {
        var loginWindow = this.getView();
        loginWindow.mask('正在登录...');
        var loginForm = this.lookupReference('loginForm').getForm();

        var values = loginForm.getFieldValues();
        Ext.callback(function(){loginWindow.unmask();},this,null,2000);
        console.log(values.username);

        //console.log(Ext.util.Cookies);
        var nameInCookie = Ext.util.Cookies.get('username');
        console.log(nameInCookie);
        Ext.util.Cookies.set('username',values.username);
        Ext.toast('登录成功');
        Ext.Msg.alert('提示','登录成功！');
        //Ext.create('Ext.window.Window', {
        //    title: 'Hello',
        //    height: 200,
        //    width: 400,
        //    layout: 'fit',
        //    items: {  // Let's put an empty grid in just to illustrate fit layout
        //        xtype: 'grid',
        //        border: false,
        //        columns: [{header: 'World'}],                 // One header just for show. There's no data,
        //        store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
        //    }
        //}).show();
    },
    resetForm:function() {
        this.lookupReference('loginForm').getForm().reset();
    }
});
