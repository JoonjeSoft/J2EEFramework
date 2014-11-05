/**
 * This class is the main view for the application. It is specified in app.js as
 * the "autoCreateViewport" property. That setting automatically applies the
 * "viewport" plugin to promote that instance of this class to the body element.
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('JoonjeSoft.view.main.Main', {
	extend : 'Ext.container.Container',
	xtype : 'app-main',
	uses : ['JoonjeSoft.view.main.region.Top',
			'JoonjeSoft.view.main.region.Bottom',
			'JoonjeSoft.view.main.region.MainMenuToolbar',
			'JoonjeSoft.view.main.region.Left'],
	controller : 'main',
	viewModel : {
		type : 'main'
	},

	layout : {
		type : 'border'
	},
	listeners : {
		resize : function(container) {
			container.getController().onMainResize();
		}
	},
	initComponent : function() {
    	Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性
    	this.callParent();
	},
	items : [{
				xtype : 'maintop',
				region : 'north' // 把他放在最顶上
			}, {
			    xtype: 'mainmenutoolbar',
			    region: 'north', // 把他放在maintop的下面
			    bind : {
							hidden : '{!isToolbarMenu}'
				}
			}, {
				xtype : 'mainbottom',
				region : 'south' // 把他放在最底下
			}, {  
			    xtype : 'mainmenuregion',
				region : 'west', // 左边面板
				title : '导航菜单',
			    width : 250,  
			    split : true,
			    hidden : true,
			    collapsible : true,
				bind : {
					hidden : '{!isTreeMenu}'
				}
			}, {
				region : 'center',
				xtype : 'tabpanel',
				items : [{
					title : 'Tab 1',
					html : '<h2>Content appropriate for the current navigation.</h2>'
				}]
			}]
});
