package com.radiotherapy.model.conditionModel;

import java.util.Date;

/*
 * Dao层查找对应User时需要的条件
 * @author peach
 * @time 2017年09月20日10:44:53
 * @version 0.1
 */
public class UserCondition {
	private String number;

    private String name;

    private String gender;

    private Date birthday;

    private String contact;

    private String office;
    
    private Boolean activate;
    
    /*
     * 默认构造器
     */
    public UserCondition(){
    	
    }
    
    /*
     * 利用创建者实例化UserCondition对象
     * @param builder the Builder 用来对域赋值
     */
    public UserCondition(Builder builder){
    		number = builder.number;
    		name = builder.name;
    		gender = builder.gender;
    		birthday = builder.birthday;
    		contact = builder.contact;
    		office = builder.office;
    		activate = builder.activate;
    }
    
    /*
     * 建造者模式，用于创建UserCondition类
     */
    public static class Builder {
    	    private String number = null;

        private String name = null;

        private String gender = null;

        private Date birthday = null;

        private String contact = null;

        private String office = null;
        
        private Boolean activate = null;
        
        public Builder number(String number){
        	    this.number = number;
        	    return this;
        }
        
        public Builder name(String name){
        		this.name = name;
        		return this;
        }
        
        public Builder gender(String gender){
        	    this.gender = gender;
        	    return this;
        }
        
        public Builder birthday(Date birthday){
        	    this.birthday = birthday;
        	    return this;
        }
        
        public Builder contact(String contact){
        	    this.contact = contact;
        	    return this;
        }
        
        public Builder office(String office){
        	    this.office = office;
        	    return this;
        }
        
        public Builder activate(Boolean activate){
        	    this.activate = activate;
        	    return this;
        }
    }
    
    /*
     * 生成一个创建者实例并返回
     * @return a Builder
     */
    public static Builder createBuilder(){
    	    return new Builder();
    }
}
