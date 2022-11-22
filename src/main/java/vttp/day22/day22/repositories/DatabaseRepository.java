package vttp.day22.day22.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;

import static vttp.day22.day22.repositories.Queries.*;

@Repository
public class DatabaseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createUser(User user) throws Exception {

        return jdbcTemplate.update(SQL_INSERT_USER,
        user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone(), user.getDob());

    }

    public Integer createTask(Task task) throws Exception {
        return jdbcTemplate.update(SQL_INSERT_TASK,
        task.getTask_name(), task.getPriority(), task.getAssign_to(), task.getCompletion_date());
    }

    public Integer checkCred(String username, String password) {
        Integer outcome = 0;
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_CHECK_CRED, username, password);
        while(rs.next()) {
            outcome = rs.getInt("outcome");
        }
        return outcome;
    }
}
