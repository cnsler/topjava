package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.MealDAOConcurrentHashMap;
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

    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    private final static String MEALS = "/meals.jsp";

    private final static String MEALS_EDIT = "/mealEdit.jsp";

    private final MealDAO mealDAO = new MealDAOConcurrentHashMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        log.debug(action);
        String forward = "";
        if (action == null) {
            forward = MEALS;
            req.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDAO.readAll(),
                    LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES));
            /*req.getRequestDispatcher("/meals.jsp").forward(req, resp);*/
        } else if (action.equalsIgnoreCase("delete")) {
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            mealDAO.delete(mealId);
            forward = MEALS;
            req.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDAO.readAll(),
                    LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES));
        } else if (action.equalsIgnoreCase("update")) {
            forward = MEALS_EDIT;
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            Meal meal = mealDAO.read(mealId);
            req.setAttribute("meal", meal);
        } else if (action.equalsIgnoreCase("create")) {
            forward = MEALS_EDIT;
        } else {
            forward = MEALS;
            req.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDAO.readAll(),
                    LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES));
        }
        req.getRequestDispatcher(forward).forward(req, resp);
        /*if (action == null) {
            req.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDAO.readAll(),
                    LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES));
            req.getRequestDispatcher("/meals.jsp").forward(req, resp);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        log.debug(req.getParameter("mealId"));
        if (req.getParameter("mealId").isEmpty()) {
            mealDAO.create(new Meal(LocalDateTime.parse(req.getParameter("dateTime")),
                    req.getParameter("description"), Integer.parseInt(req.getParameter("calories"))));
        } else {
            log.debug("mealId not null");
            mealDAO.update(new Meal(Integer.parseInt(req.getParameter("mealId")), LocalDateTime.parse(req.getParameter("dateTime")),
                    req.getParameter("description"), Integer.parseInt(req.getParameter("calories"))));
        }
        resp.sendRedirect("meals");
        /*mealDAO.create(new Meal(LocalDateTime.parse(req.getParameter("dateTime")),
                req.getParameter("description"), Integer.parseInt(req.getParameter("calories"))));
        resp.sendRedirect("meals");*/
    }

    /*@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

    }*/
}
