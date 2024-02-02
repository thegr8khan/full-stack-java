package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor, equals, h and to String are automatically created.
//Released in JDK 16

record Person (String name, int age, Address address) { }

//Address - firstLine & city
record  Address(String firstLine, String city) { }


@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Nayab";
    }

    @Bean
    public int age() {
        return 30;
    }

    @Bean
    public Person person() {
        return new Person("Peter", 20, new Address("1st Street", "Dallas"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); //name, age
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) { //name, age, address2
        return new Person(name, age, address3); //name, age
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) { //name, age, address2
        return new Person(name, age, address); //name, age
    }
    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { //name, age, address2
        return new Person(name, age, address); //name, age
    }

    @Bean(name =  "address2")
    @Primary
    public Address address() {

        return new Address("Main Street", "New York");
    }

    @Bean(name =  "address3")
    @Qualifier("address3qualifier")
    public Address address3() {

        return new Address("Negra Arroyo", "New Mexico");
    }
}
