Ext.application({
	name:'JoonjeSoft',
	appFolder:'app',
	controllers:[
	  'User'
	],
	launch:function() {
		console.log('Application launch');
//		Ext.create('Ext.container.Viewport',{
//			layout:'fit',
//			items:[{
//				xtype:'userList'
//			}]
//			layout:'border',
//			items:[{
//				region:'north',
//				html:'welcome'
//			},{
//				region:'center',
//				html:'center'
//			},{
//				region:'south',
//				html:'south'
//			},{
//				region:'west',
//				html:'west'
//			},{
//				region:'east',
//				html:'east'
//			}]
			
//		});
		Ext.create('Ext.panel.Panel',{
			renderTo:Ext.getBody(),
			title:'布局',
			layout:'column',
			height:200,
			width:400,
			items:[
			{xtype:'panel',height:100,width:'50%',title:'panel1',html:'test'},
			{xtype:'panel',height:100,width:'50%',title:'panel2',hteml:'test'}
			]
		});
	}
	
});