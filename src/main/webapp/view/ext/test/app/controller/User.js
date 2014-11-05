Ext.define('JoonjeSoft.controller.User',{
	extend:'Ext.app.Controller',
	views:[
		'user.List',
		'user.Edit'
	],
	stores:['Users'],
	models:['User'],
	init:function() {
		console.log('UserController init');
		this.control(
			{
				'userList' : {
					itemdblclick:this.editUser
				},
				'userEdit button[action=save]' : {
					click:this.updateUser
				}
			}
		);
	},
	updateUser:function(button) {
		console.log('click save button');
		var win = button.up('window');
		var form = win.down('form');
		var record = form.getRecord();
		var values = form.getValues();
		record.set(values);
		win.close();
	},
	editUser:function(grid,record) {
		console.log('grid dbclick record:' + record.get('name'));
		var view = Ext.widget('userEdit');
		view.down('form').loadRecord(record);
	},
	onLaunch:function() {
		console.log('UserController launch');
	},
	onPanelRendered :function() {
		console.log('panel rendered');
	}
});

