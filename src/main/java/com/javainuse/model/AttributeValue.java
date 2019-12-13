package com.javainuse.model;

public class AttributeValue {
	String attribute,value;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AttributeValue [attribute=" + attribute + ", value=" + value + "]";
	}
	

}
