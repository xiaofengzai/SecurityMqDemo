package com.enshub.disruptor;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "name:".concat(name).concat(",age:").concat(age.toString());
    }
}
