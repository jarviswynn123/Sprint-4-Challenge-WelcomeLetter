package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Company;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(Employee employee) throws IOException {
        //TODO: Get template text from resources
        String output = fileManager.getTextFromFile("LetterTemplate");

        //TODO: Replace []ed text with correct info
        String newOutput = output.replace("[company name]", employee.getCompany().getCompanyname())
                .replace("[fullname]", employee.getFirstname() + " " + employee.getLastname())
                .replace("[startdate]", employee.getStartdate().toString())
                .replace("[startingsalary]", String.valueOf(employee.getSalary()))
                .replace("[company starttime]", employee.getCompany().getCompanyname());

        //TODO: Write finalized String to file
        fileManager.writeTextToFile("Welcome" + employee.getFirstname() + employee.getLastname(), newOutput);
    }
}
