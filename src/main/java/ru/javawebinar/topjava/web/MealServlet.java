package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoCollection;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MealServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(MealServlet.class);

    private final static String MEALS = "/meals.jsp";

    private final static String MEALS_EDIT = "/mealEdit.jsp";

    private MealDao mealDao;

    @Override
    public void init() throws ServletException {
        mealDao = new MealDaoCollection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String forward;
        if (action == null) {
            forward = MEALS;
            req.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDao.readAll(),
                    LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES));
        } else {
            switch (action) {
                case "delete":
                    mealDao.delete(getIdOrNull(req));
                    resp.sendRedirect("meals");
                    return;
                case "update":
                    req.setAttribute("meal", mealDao.read(getIdOrNull(req)));
                default:
                    forward = MEALS_EDIT;
            }
        }
        req.getRequestDispatcher(forward).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        mealDao.save(new Meal(getIdOrNull(req),
                LocalDateTime.parse(req.getParameter("dateTime")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("calories"))));
        resp.sendRedirect("meals");
    }

    private Integer getIdOrNull(HttpServletRequest req) {
        String stringId = req.getParameter("mealId");
        return stringId.isEmpty() ? null : Integer.parseInt(stringId);
    }
}
