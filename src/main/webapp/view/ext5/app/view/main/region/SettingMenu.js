/**
 * 显示在顶部的按钮菜单，可以切换至标准菜单，菜单树
 */
Ext.define('JoonjeSoft.view.main.region.SettingMenu', {
			extend : 'JoonjeSoft.ux.ButtonTransparent',
			alias : 'widget.settingmenu',
			tooltip : '偏好设置',
			text : '设置',
			initComponent : function() {
				this.menu = [];
				this.menu.push({
							text : '菜单样式',
							menu : [{
										xtype : 'segmentedbutton',
										reference : 'menuType',
										value : 'toolbar',
										items : [{
													text : '标准菜单',
													value : 'toolbar'
												}, { 
													text : '树形菜单',
													value : 'tree'
												}, {
													text : '按钮菜单',
													value : 'button'
												}]
									}]
						})

				this.listeners = {
					menushow : function(button, menu) {
						// 设置当前的菜单类型为已选中的类型，本来应该是自动setValue的，不知道为什么没有自动赋值。
//						var menuTypeValue = this.up('app-main').getViewModel().get('menuType.value');
//						alert(menuTypeValue);
//						button.down('segmentedbutton').setValue(value);
					}
				},
				this.callParent();
			},
			listeners:{
					menushow : function(button, menu) {
						var menuTypeValue = this.up('app-main').getViewModel().get('menuType.value');
						button.down('segmentedbutton').setValue(menuTypeValue);
					}
				}
		})