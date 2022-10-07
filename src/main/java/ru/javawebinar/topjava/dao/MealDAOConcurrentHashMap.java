package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAOConcurrentHashMap implements MealDAO {

    private final Map<Integer, Meal> mealsMap = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::create);
    }

    @Override
    public void create(Meal meal) {
        meal.setId(counter.incrementAndGet());
        mealsMap.put(meal.getId(), meal);
    }

    @Override
    public Meal read(Integer id) {
        return mealsMap.get(id);
    }

    @Override
    public Collection<Meal> readAll() {
        return mealsMap.values();
    }

    @Override
    public void update(Meal meal) {
        mealsMap.put(meal.getId(), meal);
    }

    @Override
    public void delete(Integer id) {
        mealsMap.remove(id);
    }
}
