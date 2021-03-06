package com.myapp.library.menu;

import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.library.entity.Subject;
import com.myapp.library.menu.service.LibraryService;

/**
 * 
 * @author Admin
 *
 */
@Component
public class AddSubjectMenu {

	@Autowired
	private LibraryService catalogueService;

	public void menu(Scanner scanInput) {
		System.out.println("\nYou have selected to add a new Subject ... ");
		scanInput.nextLine();

		System.out.println("\nPlease provide a Subject title:");
		String title = scanInput.nextLine();

		System.out.println("\nPlease provide Subject duration in hrs:");
		int duration = scanInput.nextInt();

		Random random = new Random();

		Subject subject = new Subject(random.nextLong(), title, duration, null);

		addSubject(subject);
	}

	/**
	 * 
	 * @param book
	 */
	public void addSubject(Subject subject) {

		Subject addedSubject = null;
		try {
			addedSubject = catalogueService.createSubject(subject);
			System.out.println("\nNew Subject added Sucessfully ..");
		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println(addedSubject);
	}

}
