/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Library;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import View.Menu;
import View.Validation;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Xuan Vinh
 */
public class CandidatesManager extends Menu<String>{
    private static ArrayList<Candidate> candidates = new ArrayList();
    static String[] mc = new String[]{"Experience", "Fresher", "Internship", "Searching", "Exit"};

    public CandidatesManager() {
        super("\nManage Candidate:", mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createNewCandidate(candidates, 0);
                break;
            case 2:
                createNewCandidate(candidates, 1);
                break;
            case 3:
                createNewCandidate(candidates, 2);
                break;
            case 4:
                searchCandidate(candidates);
                break;
            case 5:
                System.out.println("Exit!!!");
                System.exit(0);
                return;
            default:
                System.err.println("Please choose from 1 to 5");
        }
    }
    
    public static void createNewCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            
            if (Validation.checkIdExist(candidates, id)) {//check id
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            
            if (!Validation.checkInputYN()) {//check user want to keep create new candidate or not
                return;
            }
        }
    }

    public static void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.checkInputString();
        String graduationRank = inputGraduationRank();
        
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        candidates.add(new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }
    
    public static String inputGraduationRank(){
        System.out.print("Enter graduation rank(1: Excellence,2: Good,3: Fair,4: Poor): ");
        int input = Validation.checkInputIntLimit(1, 4);
        String graduationRank;
        switch (input) {
            case 1:
                return graduationRank = "Excellence";
            case 2:
                return graduationRank = "Good";
            case 3:
                return graduationRank = "Fair";
            case 4:
                return graduationRank = "Poor";
            default:
                return "";
        }
    }
    
    public static void searchCandidate(ArrayList<Candidate> candidates) {
        displayListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate(0: Experience, 1: Fresher, 2:Internship): ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                System.out.println(candidate.toString());
            }
        }
    }

    public static void displayListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate:");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 0) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate:");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 1) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate:");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 2) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}
