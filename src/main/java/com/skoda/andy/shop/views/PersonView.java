package com.skoda.andy.shop.views;

import io.dropwizard.views.View;

import com.skoda.andy.shop.core.Person;

public class PersonView extends View {
    private final Person person;
    public enum Template{
    	FREEMARKER("freemarker/person.ftl"),
    	MUSTACHE("mustache/person.mustache");
    	
    	private String templateName;
    	private Template(String templateName){
    		this.templateName = templateName;
    	}
    	
    	public String getTemplateName(){
    		return templateName;
    	}
    }

    public PersonView(PersonView.Template template, Person person) {
        super(template.getTemplateName());
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}