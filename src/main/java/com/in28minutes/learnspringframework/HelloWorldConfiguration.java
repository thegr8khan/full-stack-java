package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new Person("Peter", 20, new Address("1st Street", "New York"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); //name, age
    }

    @Bean(name =  "address2")
    public Address address() {
        return new Address("Main Street", "New York");
    }
}
