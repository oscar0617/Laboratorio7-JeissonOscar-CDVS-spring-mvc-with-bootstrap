package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ToDoService {
    @Autowired
    private RestTemplate restTemplate;

    static final String URL_API = "https://jsonplaceholder.typicode.com/todos/";

    public ToDoItem getItem(Integer id) {
        String uri = URL_API + id;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ToDoItem> response = restTemplate.getForEntity(uri, ToDoItem.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
