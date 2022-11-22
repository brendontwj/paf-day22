package vttp.day22.day22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;
import vttp.day22.day22.repositories.DatabaseRepository;

@Service
public class DatabaseService {

    @Autowired
    private DatabaseRepository userRepo;
    
    public boolean createUser(final User user) throws Exception {
        int count = userRepo.createUser(user);
        System.out.printf("Insert count: %d\n", count);
        return count > 0;
    }

    public boolean createTask(final Task task) throws Exception {
        int count = userRepo.createTask(task);
        System.out.printf("Insert count: %d\n", count);
        return count > 0;
    }

    public boolean checkCred(String username, String password) {
        int count = userRepo.checkCred(username, password);
        System.out.printf("Insert count: %d\n", count);
        return count > 0;
    }
}
