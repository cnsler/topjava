package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(int userId, Meal meal) {
        return repository.save(userId, meal);
    }

    public void delete(int userId, int id) {
        checkNotFoundWithId(repository.delete(userId, id), id);
    }

    public Meal get(int userId, int id) {
        return checkNotFoundWithId(repository.get(userId, id), id);
    }

    public List<Meal> getAll(int userId) {
        /*return repository.getAll(userId);*/
        return getFiltered(userId, null, null);
    }

    public List<Meal> getFiltered(int userId, LocalDate dateFrom, LocalDate dateTo) {
        return repository.getFiltered(userId, dateFrom, dateTo);
    }

    public void update(int userId, Meal meal) {
        checkNotFoundWithId(repository.save(userId, meal), meal.getId());
    }
}