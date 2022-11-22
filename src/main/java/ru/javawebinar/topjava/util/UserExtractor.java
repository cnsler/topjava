package ru.javawebinar.topjava.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserExtractor implements ResultSetExtractor<List<User>> {
    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, User> result = new LinkedHashMap<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            User user = result.get(id);
            if (user == null) {
                User newUser = new User(id,
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("calories_per_day"),
                        rs.getBoolean("enabled"),
                        rs.getDate("registered"),
                        new HashSet<>());
                user = newUser;
                result.computeIfAbsent(id, s -> newUser);
            }
            String role = rs.getString("role");
            if (role != null && !role.isEmpty()) {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        return new ArrayList<>(result.values());
    }
}