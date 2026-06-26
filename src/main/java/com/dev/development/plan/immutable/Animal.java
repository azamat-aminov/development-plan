package com.dev.development.plan.immutable;

import java.util.ArrayList;
import java.util.List;

public final class Animal { // An immutable object declaration

  private final List<String> favoriteFoods;

  public Animal(List<String> favoriteFoods) {
    //defensive copy
    this.favoriteFoods = new ArrayList<>(favoriteFoods);
//    this.favoriteFoods = favoriteFoods;
  }

  public int getFavoriteFoodsCount() {
    return favoriteFoods.size();
  }

  public String getFavoriteFoodsItem(int index) {
    return favoriteFoods.get(index);
  }

  public static void main(String[] args) {

    var favorites = new ArrayList<String>();
    favorites.add("Apples");
    var zebra = new Animal(favorites); // Caller still has access to favorites
    System.out.println(zebra.getFavoriteFoodsItem(0)); // [Apples]

    favorites.clear();
    favorites.add("Chocolate Chip Cookies");
    System.out.println(zebra.getFavoriteFoodsItem(0)); // [Chocolate Chip Cookies]
  }

}
