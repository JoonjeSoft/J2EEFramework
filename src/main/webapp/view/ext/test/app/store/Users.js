Ext.define('JoonjeSoft.store.Users', {
			extend : 'Ext.data.Store',
//			fields : ['name', 'password'],
			model:'JoonjeSoft.model.User',
			data : [{
						name : '安俊杰',
						password : '123'
					}, {
						name : '宋娅平',
						password : '456'
					}]

		});