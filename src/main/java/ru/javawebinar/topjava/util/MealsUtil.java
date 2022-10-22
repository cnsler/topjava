package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static final List<Meal> meals = Arrays.asList(
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 30, 10, 0), "ADMIN Завтрак", 500, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 30, 13, 0), "ADMIN Обед", 1000, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 30, 20, 0), "ADMIN Ужин", 500, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 31, 0, 0), "ADMIN Еда на граничное значение", 100, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 31, 10, 0), "ADMIN Завтрак", 1000, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 31, 13, 0), "ADMIN Обед", 500, 1),
            new Meal(LocalDateTime.of(2021, Month.JANUARY, 31, 20, 0), "ADMIN Ужин", 410, 1),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 30, 10, 0), "USER Завтрак", 500, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 30, 13, 0), "USER Обед", 1000, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 30, 20, 0), "USER Ужин", 500, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 31, 0, 0), "USER Еда на граничное значение", 100, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 31, 10, 0), "USER Завтрак", 1000, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 31, 13, 0), "USER Обед", 500, 2),
            new Meal(LocalDateTime.of(2022, Month.JANUARY, 31, 20, 0), "USER Ужин", 410, 2)
    );

    public static final List<User> users = Arrays.asList(
            new User(null, "admin", "admin@gmail.com", "admin", Role.ADMIN),
            new User(null, "user", "user@gmail.com", "user", Role.USER)
    );

    public static List<MealTo> getTos(Collection<Meal> meals, int caloriesPerDay) {
        return filterByPredicate(meals, caloriesPerDay, meal -> true);
    }

    public static List<MealTo> getFilteredTos(Collection<Meal> meals, int caloriesPerDay, LocalTime startTime, LocalTime endTime) {
        return filterByPredicate(meals, caloriesPerDay, meal -> DateTimeUtil.isBetweenTime(meal.getTime(), startTime, endTime));
    }

    private static List<MealTo> filterByPredicate(Collection<Meal> meals, int caloriesPerDay, Predicate<Meal> filter) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
//                      Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum)
                );

        return meals.stream()
                .filter(filter)
                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    private static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}
