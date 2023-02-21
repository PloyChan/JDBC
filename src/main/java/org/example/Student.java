package org.example;

public class Student {
    private int id;
    private String name;
    private String colum;
    private String condition;
    private String columCondition;
    private String value;
    private String predicate;

    private String predicateSet;

    public Student(String predicateSet,String predicate) {
        this.predicate = predicate;
        this.predicateSet = predicateSet;
    }

    public  Student(String predicate){
        this.predicate = predicate;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getPredicateSet() {
        return predicateSet;
    }

    public String getPredicate(){
        return predicate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
