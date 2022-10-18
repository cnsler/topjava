package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealDao {

    Meal save(Meal meal);

    Meal read(int id);

    Collection<Meal> readAll();

    void delete(int id);
}
