package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoCollection implements MealDao {

    private final Map<Integer, Meal> meals = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.getId() == null) meal.setId(counter.incrementAndGet());
        return meals.put(meal.getId(), meal);
    }

    @Override
    public Meal read(int id) {
        return meals.get(id);
    }

    @Override
    public Collection<Meal> readAll() {
        return meals.values();
    }

    @Override
    public void delete(int id) {
        meals.remove(id);
    }
}
