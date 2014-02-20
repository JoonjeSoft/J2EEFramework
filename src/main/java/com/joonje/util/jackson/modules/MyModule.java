package com.joonje.util.jackson.modules;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.joonje.domain.User;
import com.joonje.domain.UserFilter;

public class MyModule extends Module {

	@Override
	public String getModuleName() {
		String name = "myModule";
		return name;
	}

	@Override
	public Version version() {
		Version ver = new Version(0, 0, 0, "","","");
		return ver;
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(User.class, UserFilter.class);
	}
	
}
