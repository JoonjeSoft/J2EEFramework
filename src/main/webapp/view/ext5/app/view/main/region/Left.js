Ext.define('JoonjeSoft.view.main.region.Left',{
	extend:'Ext.panel.Panel',
	alias:'widget.mainmenuregion',
	uses:['JoonjeSoft.view.main.region.MainMenuTree',
	      'JoonjeSoft.view.main.region.AccordionMainMenu'],
	layout:{
		type:'accordion',
		animate:true
	},
	glyph : 0xf0c9,
	tools : [{
						type : 'pin',
						tooltip : '层叠方式显示菜单',
						listeners : {
							click : function(tool) {
								var panel = tool.up('mainmenuregion');
								panel.insert(0, {
											xtype : 'mainmenuaccordion'
										});
								panel.items.items[0].expand();
								panel.remove(panel.down('mainmenutree'), true);
								tool.hide();
								tool.nextSibling().show();
							}
						}
					}, {
						type : 'unpin',
						tooltip : '树状方式显示菜单',
						hidden : true,
						listeners : {
							click : function(tool) {
								var panel = tool.up('mainmenuregion');
								panel.insert(0, {
											xtype : 'mainmenutree'
										});

								panel.items.items[0].expand();
								Ext.each(panel.query('mainmenuaccordion'), function(
												accordion) {
											panel.remove(accordion, true)
										})
								tool.hide();
								tool.previousSibling().show();
							}
						}
					}, {
						itemId : 'up',
						type : 'up',
						tooltip : '在上面显示菜单条',
						handler : 'showMainMenuToolbar'
					}],

			initComponent : function() {

				this.items = [{
							xtype : 'mainmenutree'
						}];
				this.callParent();
			}
});