package vttp.day22.day22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;
import vttp.day22.day22.services.DatabaseService;

@Controller
@RequestMapping
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/user") 
    public String showUserPage() {
        return "user";
    }

    @GetMapping("/task")
    public String showTaskPage() {
        return "task";
    }
    
    @PostMapping("/postUser")
    public String postUser(@RequestBody MultiValueMap<String, String> form, Model model) {

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String email = form.getFirst("email");
        String phone = form.getFirst("phone");
        String dob = form.getFirst("dob");

        System.out.printf("username: %s, password: %s, email: %s, phone: %s, dob: %s\n"
                , username, password, email, phone, dob);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setDob(dob);

        try {
            if (!databaseService.createUser(user))
                System.out.println(">>>>>>>>>>>>>>> Error! User not created!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("ErrorMsg", e.getMessage());
            return "error";
        }

        model.addAttribute("username", username);

        return "userCreated";
    }

    @PostMapping("/postTask")
    public String postTask(@RequestBody MultiValueMap<String, String> form, Model model) {

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String task_name = form.getFirst("task_name");
        String priority = form.getFirst("priority");
        String completion_date = form.getFirst("completion_date");

        System.out.printf("username: %s, password: %s, task_name: %s, priority: %s, completion_date: %s\n"
                , username, password, task_name, priority, completion_date);

        Task task = new Task();
        task.setAssign_to(username);
        task.setCompletion_date(completion_date);
        task.setPriority(priority);
        task.setTask_name(task_name);

        try {
            if (!databaseService.checkCred(username, password)) {
                System.out.println(">>>>>>>>>>>>>>> Error! User doesn't exist!");
                model.addAttribute("ErrorMsg", "No such user");
                return "error";
            } else {
                databaseService.createTask(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("ErrorMsg", e.getMessage());
            return "error";
        }

        model.addAttribute("task_name", task_name);

        return "taskCreated";
    }
}
