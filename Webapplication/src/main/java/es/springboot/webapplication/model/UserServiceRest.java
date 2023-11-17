package es.springboot.webapplication.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import es.springboot.webapplication.model.User;
 
 
@RestController
public class UserServiceRest {
     
    /**
    * Lista de ejemplo de usuarios
    */
    private static List<User> listaUsuarios = new ArrayList<User>() {
        {
            add(new User("Rosa", "Marfil"));
            add(new User("Pepito", "Grillo"));
            add(new User("Manuela", "Lago"));
        }
		};
     
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User>  getUsers(){
        return listaUsuarios;
    }

User.java

package es.springboot.webapplication.model;
 
import java.io.Serializable;
 
public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String name;
 
    public String username;
 
    public User() {
        super();
    }
     
    public User(String name, String username) {
        super();
        this.name = name;
        this.username = username;
    }
 
    public String getName() {
        return name;
    }
	public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
}
