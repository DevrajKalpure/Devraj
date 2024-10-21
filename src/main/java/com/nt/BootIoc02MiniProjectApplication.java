package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.controller.PatientController;
import com.nt.model.Patient;
//@PropertySource("/src/main/resources/dev.properties")
@SpringBootApplication
public class BootIoc02MiniProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootIoc02MiniProjectApplication.class, args);
		
		
		
		//ApplicationContext ctx = SpringApplication.run(BootIoc01MiniProjectApplication.class, args);

		PatientController controller = ctx.getBean("patientController", PatientController.class);

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter loca1");
		String loca1 = scn.next();
		System.out.println("Enter loca2");
		String loca2 = scn.next();
		System.out.println("Enter loca3");
		String Loca3 = scn.next();
		scn.close();
		try {
			List<Patient> list = controller.processPatienyByLoca(loca1, loca2, Loca3);
			list.forEach(p1 -> {
				System.out.println(p1);
			});
		} catch (Exception e) {
			 e.printStackTrace();
			System.out.println("try again");
		}

	}

}
