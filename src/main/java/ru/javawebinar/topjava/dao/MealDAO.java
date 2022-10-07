package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealDAO {

    void create(Meal meal);

    Meal read(Integer id);

    Collection<Meal> readAll();

    void update(Meal meal);

    void delete(Integer id);
}
