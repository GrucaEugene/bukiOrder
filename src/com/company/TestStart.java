package com.company;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestStart {
    public static void main(String[] args) {
      int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println(numOfCores);
    }
}

class Person {
    private String name;
    private List<Pet> pets;

    public Person(String name, List<Pet> pets) {
        this.name = name;
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(pets, person.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pets);
    }
}

class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
