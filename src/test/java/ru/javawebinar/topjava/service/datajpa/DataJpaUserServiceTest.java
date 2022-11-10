package ru.javawebinar.topjava.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserServiceTest;

import static ru.javawebinar.topjava.MealTestData.MEAL_MATCHER;
import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaUserServiceTest extends UserServiceTest {

    @Test
    public void getWithMeals() {
        User userWithMeals = service.getWithMeals(USER_ID);
        USER_MATCHER.assertMatch(userWithMeals, UserTestData.userWithMeals);
        MEAL_MATCHER.assertMatch(userWithMeals.getMeals(), MealTestData.meals);
    }

    @Test
    public void getWithEmptyMeals() {
        User guest = service.getWithMeals(GUEST_ID);
        USER_MATCHER.assertMatch(guest, UserTestData.guest);
        MEAL_MATCHER.assertMatch(guest.getMeals(), MealTestData.emptyMeals);
    }
}