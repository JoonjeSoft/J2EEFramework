Ext.require(['Ext.grid.*', 'Ext.data.*']);

Ext.onReady(function() {
			Ext.define('MyData', {
						extend : 'Ext.data.Model',
						fields : [{
									name : 'name',
									mapping : 'name'
								}, 'age', 'sex', 'email']
					});
			var store = Ext.create('Ext.data.Store', {
						model : 'MyData',
						pageSize : 10,
						data : [{
									name : '安俊杰',
									age : 22,
									sex : '男'
								}, {
									name : '宋娅平',
									age : 20,
									sex : '女'
								}]
					});
			var selMode = Ext.create('Ext.selection.CheckboxModel');
			var grid = Ext.create('Ext.grid.Panel', {
						store : store,
						selType:'checkboxmodel',
						columnLines : true,
						columns : [{
									text : '基本信息',
									columns : [{
												text : '姓名',
												width : 200,
												dataIndex : 'name',
												sortable : true
											}, {
												text : '年龄',
												width : 200,
												dataIndex : 'age',
												sortable : true
											}, {
												text : '性别',
												width : 200,
												dataIndex : 'sex',
												sortable : true
											}

									]
								}, {
									text : '年龄',
									width : 200,
									dataIndex : 'age',
									sortable : true
								}, {
									text : '性别',
									width : 200,
									dataIndex : 'sex',
									sortable : true
								}

						],
						height : 400,
						width : 480,
						x : 20,
						y : 40,
						title : 'grid 示例',
						renderTo : Ext.getBody(),
						viewConfig : {
							stackOver : false,
							stripteRows : false
						},
						tbar :['查找',{
				                 xtype: 'textfield',
				                 name: 'searchField',
				                 hideLabel: true,
				                 width: 200}],
                 
						bbar : Ext.create('Ext.PagingToolbar', {
									store : store,
									displayInfo : true,
									displayMsg : '显示{0}-{1}条，共{2}条',
									emptyMsg : '没有数据'
								})

					});
		});