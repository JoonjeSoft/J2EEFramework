package com.joonje.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

public class MyFilter implements PropertyFilter {

	public void serializeAsField(Object pojo, JsonGenerator jgen,
			SerializerProvider prov, PropertyWriter writer) throws Exception {

	}

	public void serializeAsElement(Object elementValue, JsonGenerator jgen,
			SerializerProvider prov, PropertyWriter writer) throws Exception {

	}

	public void depositSchemaProperty(PropertyWriter writer,
			ObjectNode propertiesNode, SerializerProvider provider)
			throws JsonMappingException {

	}

	public void depositSchemaProperty(PropertyWriter writer,
			JsonObjectFormatVisitor objectVisitor, SerializerProvider provider)
			throws JsonMappingException {

	}


}
