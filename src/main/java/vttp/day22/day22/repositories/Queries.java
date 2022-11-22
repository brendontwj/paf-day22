package vttp.day22.day22.repositories;

public class Queries {
    public static final String SQL_INSERT_USER = "insert into user(username, password, email, phone, dob) values(?, sha(?), ?, ?, ?)";

    public static final String SQL_INSERT_TASK = "insert into task(task_name, priority, assign_to, completion_date) values(?, ?, ?, ?)";

    public static final String SQL_CHECK_CRED  = "select count(*) as outcome from user where username = ? and password = sha(?)";
}
