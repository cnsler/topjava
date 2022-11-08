package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    Meal findMealByIdAndUserId(int id, int userId);

    List<Meal> findMealsByUserId(Sort sort, int userId);

    List<Meal> findMealsByUserIdAndDateTimeAfterAndDateTimeBefore(Sort sort, int userId, LocalDateTime start, LocalDateTime end);
}
