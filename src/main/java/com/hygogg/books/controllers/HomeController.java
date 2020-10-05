package com.hygogg.books.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hygogg.books.models.Book;


@Controller
public class HomeController{
	
	private static ArrayList<Book> books = new ArrayList<Book>();
	
	public HomeController() {
		books.add(new Book("French Cooking", "Me", 50, 9.95));
		books.add(new Book("Lord of the Rings", "Tolkein", 500, 19.95));
		books.add(new Book("Frankenstein", "Merry Shelly", 500, 11.95));
	}
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		model.addAttribute("title", "Prestige World Wide");
		model.addAttribute("subtitle", "We're going to get so big until someone buys us out!");
		model.addAttribute("books", books);
		Integer views = (Integer) session.getAttribute("pageViews");
		if(views == null) {
			views = 0;
		}
		views++;
		session.setAttribute("pageViews", views);
		model.addAttribute("pageViews", views);
		return "index.jsp";
	}
	
	@PostMapping("/books/add")
	public String addBook(@ModelAttribute("book") Book book, RedirectAttributes flash) {
		Boolean hasErrors = false;
		if(book.title.length() < 5) {
			hasErrors = true;
			flash.addFlashAttribute("titleError", "Title must be 5 characters or longer!");
		} 
//		if(book.author.equals("Will")) {
//			System.out.println("Not again!!!");
//			flash.addFlashAttribute("authorError", "Will is not allowed!");
//		}
		if(book.author.length() < 3) {
			hasErrors = true;
			flash.addFlashAttribute("authorError", "Author must be 3 characters or longer!");
		} 
		if(book.numPages == null) {
			hasErrors = true;
			flash.addFlashAttribute("pagesError", "Number of Pages is required!");
		} else if(book.numPages < 1) {
			hasErrors = true;
			flash.addFlashAttribute("pagesError", "The book must have at least 1 page!");
		}
		if(book.price == null) {
			hasErrors = true;
			flash.addFlashAttribute("priceError", "Price is required!");
		} else if(book.price < 0) {
			hasErrors = true;
			flash.addFlashAttribute("priceError", "The book price cannot be negative!");
		}
		if(!hasErrors) {
			books.add(book);
		}
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("pageViews");
		return "redirect:/";
	}
	
}
