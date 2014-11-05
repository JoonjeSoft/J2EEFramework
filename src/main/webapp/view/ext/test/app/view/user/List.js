Ext.define('JoonjeSoft.view.user.List', {
			extend : 'Ext.grid.Panel',
			alias : 'widget.userList',
			title : '所有用户',
			store:'Users',
			initComponent:function() {
//				this.store={
//					fields : ['name','password'],
//					data : [
//						{name:'安俊杰',password:'123'},
//						{name:'宋娅平',password:'456'}
//					]
//				};
				this.columns = [
					{header:'Name',dataIndex:'name',flex:1},
					{header:'Password',dataIndex:'password',flex:1}
				];
				this.callParent(arguments);
			}
			
		});