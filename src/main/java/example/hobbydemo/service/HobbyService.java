package example.hobbydemo.service;

import example.hobbydemo.model.Hobby;
import example.hobbydemo.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HobbyService {
    @Autowired
    private HobbyRepository userRepository;

    private boolean existsById(Long id) {
        return HobbyRepository.existsById(id);
    }

    public Hobby findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public Hobby save(Hobby hobby) throws Exception {
        if (StringUtils.isEmpty(hobby.getType())) {
            throw new Exception("Type is required");
        }
        if (StringUtils.isEmpty(hobby.getText())) {
            throw new Exception("Name is required");
        }
        if (hobby.getId()  null && existsById(hobby.getId())) {
            throw new Exception("Hobby with id: " + hobby.getId() + " already exists");
        }
        return HobbyRepository.save(hobby);
    }

    public void update(Hobby hobby) throws Exception {
        if (StringUtils.isEmpty(hobby.getType())) {
            throw new Exception("Type is required");
        }
        if (StringUtils.isEmpty(hobby.getText())) {
            throw new Exception("Name is required");
        }
        if (!existsById(hobby.getId())) {
            throw new Exception("Cannot find hobby with id: " + hobby.getId());
        }
        HobbyRepository.save(hobby);
    }

    public void deleteById(Long id) throws Exception {
        if (!existsById(id)) {
            throw new Exception("Cannot find hobby with id: " + id);
        }
        else {
            HobbyRepository.deleteById(id);
        }
    }
}
