/**
 * 系统主页的顶部区域，主要放置系统名称，菜单，和一些快捷按钮
 */
Ext.define('JoonjeSoft.view.main.region.Top', {

			extend : 'Ext.toolbar.Toolbar',

			alias : 'widget.maintop', // 定义了这个组件的xtype类型为maintop
			uses : ['JoonjeSoft.ux.ButtonTransparent',
			        'JoonjeSoft.view.main.region.ButtonMainMenu',
			        'JoonjeSoft.view.main.region.SettingMenu'],
			defaults : {
    			xtype : 'buttontransparent'
			},
			style : 'background-color : #cde6c7',
			items : [{
						xtype : 'image',
						bind : { // 数据绑定到MainModel中data的ystem.iconUrl
							hidden : '{!system.iconUrl}', // 如果system.iconUrl未设置，则此image不显示
							src : '{system.iconUrl}' // 根据system.iconUrl的设置来加载图片
						}
					}, {
						xtype : 'label',
						bind : {
							text : '{system.name}' // text值绑定到system.name
						},
						style : 'font-size : 20px; color : blue;'
					}, {
						xtype : 'label',
						bind : {
							text : '{system.version}'
						}
					}, '->',{
					    xtype: 'buttonmainmenu',
					    hidden : true,
						bind : {
							hidden : '{!isButtonMenu}'
						}
					}, ' ', ' ', {
						text : '主页',
						glyph: 0xf015
					}, {
						text : '帮助',
						glyph: 0xf059
					}, {
						text : '关于',
						glyph: 0xf06a
					}, {
						text : '设置',
						glyph : 0xf013,
						xtype:'settingmenu'
					},'->', '->', {
	        			text: '搜索',
	        			glyph: 0xf002
    				},{
						text : '注销',
						glyph: 0xf011
					}, '->', {
					    glyph : 0xf102,
					    handler : 'hiddenTopBottom',
					    tooltip : '隐藏顶部和底部区域'
					}]

		});