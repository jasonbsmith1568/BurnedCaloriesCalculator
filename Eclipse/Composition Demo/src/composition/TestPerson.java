package composition;

/*
Notice that above test program is not affected by any change in the Job object. 
If you are looking for code reuse and the relationship between two classes 
is has-a then you should use composition rather than inheritance.

Benefit of using composition is that we can control the visibility of 
other object to client classes and reuse only what we need.

Also if there is any change in the other class implementation,
 for example getSalary returning String, we need to change Person 
 class to accomodate it but client classes doesn’t need to change.

Composition allows creation of back-end class when it’s needed,
 for example we can change Person getSalary method to initialize 
 the Job object.
 */
public class TestPerson {
 
    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
    }
 
}