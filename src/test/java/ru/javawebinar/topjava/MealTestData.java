package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_MEAL_1_ID = START_SEQ + 3;
    public static final int ADMIN_MEAL_1_ID = START_SEQ + 10;
    public static final int NOT_FOUND = 10;

    public static final Meal userMeal1 = new Meal(USER_MEAL_1_ID,
            LocalDateTime.of(2021, Month.JANUARY, 31, 0, 0),
            "USER coffee", 50);
    public static final Meal userMeal2 = new Meal(USER_MEAL_1_ID + 1,
            LocalDateTime.of(2021, Month.JANUARY, 30, 10, 0),
            "USER breakfast", 700);
    public static final Meal userMeal3 = new Meal(USER_MEAL_1_ID + 2,
            LocalDateTime.of(2021, Month.JANUARY, 30, 13, 0),
            "USER launch", 1000);
    public static final Meal userMeal4 = new Meal(USER_MEAL_1_ID + 3,
            LocalDateTime.of(2021, Month.JANUARY, 30, 18, 0),
            "USER dinner", 300);
    public static final Meal userMeal5 = new Meal(USER_MEAL_1_ID + 4,
            LocalDateTime.of(2021, Month.JANUARY, 31, 10, 0),
            "USER breakfast", 700);
    public static final Meal userMeal6 = new Meal(USER_MEAL_1_ID + 5,
            LocalDateTime.of(2021, Month.JANUARY, 31, 13, 0),
            "USER launch", 1000);
    public static final Meal userMeal7 = new Meal(USER_MEAL_1_ID + 6,
            LocalDateTime.of(2021, Month.JANUARY, 31, 18, 0),
            "USER dinner", 300);
    public static final Meal adminMeal1 = new Meal(ADMIN_MEAL_1_ID,
            LocalDateTime.of(2022, Month.JANUARY, 30, 10, 0),
            "ADMIN breakfast", 700);
    public static final Meal adminMeal2 = new Meal(ADMIN_MEAL_1_ID + 1,
            LocalDateTime.of(2022, Month.JANUARY, 31, 0, 0),
            "USER tea", 50);

    public static final List<Meal> meals = Arrays.asList(userMeal7, userMeal6, userMeal5,
            userMeal1, userMeal4, userMeal3, userMeal2);

    public static final List<Meal> emptyMeals = Collections.emptyList();

    public static Meal getNew() {
        return new Meal(null,
                LocalDateTime.of(1986, Month.DECEMBER, 1, 12, 0),
                "New meal", 2002);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(userMeal1);
        updated.setDateTime(LocalDateTime.of(1986, Month.DECEMBER, 1, 12, 0));
        updated.setDescription("Updated meal");
        updated.setCalories(2020);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }
}
