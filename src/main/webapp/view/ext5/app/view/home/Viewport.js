Ext.define('JoonjeSoft.view.home.Viewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.homeviewport',
	uses : ['JoonjeSoft.view.Login'],
    layout: {
        type: 'hbox',
        align: 'middle',
        pack: 'center'
    },
    items: [
        {
            xtype: 'loginform'
        } 
    ]
});