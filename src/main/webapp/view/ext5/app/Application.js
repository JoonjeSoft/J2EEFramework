/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('JoonjeSoft.Application', {
    extend: 'Ext.app.Application',
    requires: [
		        'JoonjeSoft.view.home.Viewport'
    ],
    name: 'JoonjeSoft',

    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
//		Ext.create('JoonjeSoft.view.Login', {renderTo: Ext.getBody()});
		Ext.create('JoonjeSoft.view.home.Viewport');
	}
});
