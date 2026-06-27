package com.dev.development.plan.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public final class Person {

  private final String name;
  private final List<String> favoriteMovies;

  Person(String name, List<String> favoriteMovies) {
    this.name = name;
    // this.favoriteMovies = favoriteMovies;
    // Defensive coping...
    // this.favoriteMovies = new ArrayList<>(favoriteMovies);
    //use unmodifiableList/copyOf to avoid accidental modification
    this.favoriteMovies = List.copyOf(favoriteMovies);
//    this.favoriteMovies = Collections.unmodifiableList(new ArrayList<>(favoriteMovies));
  }

  public static void main(String[] args) {
    List<String> favoriteMovies = new ArrayList<>();
    favoriteMovies.add("Forest Gump");
    Person person = new Person("Aziz", favoriteMovies);
    favoriteMovies.add("Titanic");
    System.out.println(person.getFavoriteMovies());
  }
}
