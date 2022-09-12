package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping()
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users/allUsers";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("newUser", new User());
		return "users/newUser";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id) {
		System.out.println("Мы в EDIT");
		model.addAttribute("user", userService.getUserById(id));
		return "users/edit";
	}

	@PatchMapping("/{id}")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/users";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}


}