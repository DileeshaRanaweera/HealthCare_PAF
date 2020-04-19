package com.healthcare.User;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserResourse {

	UserRepository repo = new UserRepository();

	//list of users
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> geUsers() {
		return repo.getUsers();
	}

	//one user
	@GET
	@Path("user/{nic}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User getUser(@PathParam("nic") String nic) {
		return repo.getUser(nic);
	}

	//create user account
	@POST
	@Path("user")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createUser(User user) {
		repo.create(user);
		System.out.println(user);
		return user;
	}

	//update user account
	@PUT
	@Path("user")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(User user) {
		repo.update(user);
		System.out.println(user);
		return user;
	}

	//delete user account
	@DELETE
	@Path("user/{nic}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_XML })
	public User deleteUser(@PathParam("nic") String nic) {
		User a = repo.getUser(nic);

		if (a.getNic() != null) {

			repo.deleteUser(nic);

		}
		return a;
	}

	//update user account pwd 
	@PUT
	@Path("userpwd")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUserPwd(User user) {

		repo.updateUserPwdandName(user);
		System.out.println(user);

		return user;

	}
}
