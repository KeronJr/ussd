package com.example.ussd.Controller;
import com.example.ussd.Model.Userussd;
import com.example.ussd.Model.Userz;
import com.example.ussd.Model.UssdRequest;
import com.example.ussd.Model.UssdSession;
import com.example.ussd.Repository.UserRepository;
import com.example.ussd.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@RestController
//public class Ussdcontroller2 {
//
//    private final UserService userService;
//
//    private enum RegistrationStep {
//        LANGUAGE_SELECTION,
//        FIRST_NAME,
//        LAST_NAME,
//        DATE_OF_BIRTH,
//        LOCATION,
//        CONFIRMATION,
//        END
//    }
//
//    public Ussdcontroller2(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/ussd")
//    public String processUssdRequest(@RequestBody UssdRequest ussdRequest, HttpSession httpSession) {
//        String sessionId = ussdRequest.getSessionId();
//        String phoneNumber = ussdRequest.getPhoneNumber();
//        String text = ussdRequest.getText();
//        String response = "";
//
//        // Retrieve the current step from the session
//        RegistrationStep currentStep = (RegistrationStep) httpSession.getAttribute("currentStep");
//
//        if (currentStep == null) {
//            // If the current step is not set in the session, it means the user is starting the registration.
//            // So, we set it to the first step, i.e., LANGUAGE_SELECTION.
//            currentStep = RegistrationStep.LANGUAGE_SELECTION;
//            httpSession.setAttribute("currentStep", currentStep);
//        }
//
//        switch (currentStep) {
//            case LANGUAGE_SELECTION:
//                if (text.equals("1")) {
//                    // Language selection is English, set language to English
//                    httpSession.setAttribute("language", "English");
//                } else if (text.equals("2")) {
//                    // Language selection is Kinyarwanda, set language to Kinyarwanda
//                    httpSession.setAttribute("language", "Kinyarwanda");
//                }
//
//                // Move to the next step (asking for First Name)
//                httpSession.setAttribute("currentStep", RegistrationStep.FIRST_NAME);
//                response = "Please enter your First Name:";
//                break;
//            case FIRST_NAME:
//                httpSession.setAttribute("firstName", text); // Save the first name to the session
//                httpSession.setAttribute("currentStep", RegistrationStep.LAST_NAME);
//                response = "Please enter your Last Name:";
//                break;
//            case LAST_NAME:
//                httpSession.setAttribute("lastName", text); // Save the last name to the session
//                httpSession.setAttribute("currentStep", RegistrationStep.DATE_OF_BIRTH);
//                response = "Please enter your Date of Birth (DD/MM/YYYY):";
//                break;
//            case DATE_OF_BIRTH:
//                httpSession.setAttribute("dateOfBirth", parseDate(text)); // Save the date of birth to the session
//                httpSession.setAttribute("currentStep", RegistrationStep.LOCATION);
//                response = "Please enter your Location:";
//                break;
//            case LOCATION:
//                httpSession.setAttribute("location", text); // Save the location to the session
//                httpSession.setAttribute("currentStep", RegistrationStep.CONFIRMATION);
//                response = "Confirm your information:\nFirst Name: " + httpSession.getAttribute("firstName") +
//                        "\nLast Name: " + httpSession.getAttribute("lastName") +
//                        "\nDate of Birth: " + httpSession.getAttribute("dateOfBirth") +
//                        "\nLocation: " + httpSession.getAttribute("location") +
//                        "\n\nReply with 'Y' to confirm or 'N' to start over.";
//                break;
//            case CONFIRMATION:
//                if (text.equalsIgnoreCase("Y")) {
//                    // Create a new User object with the registration data
//                    Userussd newUser = new Userussd();
//                    newUser.setLanguage((String) httpSession.getAttribute("language"));
//                    newUser.setFirstName((String) httpSession.getAttribute("firstName"));
//                    newUser.setLastName((String) httpSession.getAttribute("lastName"));
//                    newUser.setDateOfBirth((String) httpSession.getAttribute("dateOfBirth"));
//                    newUser.setLocation((String) httpSession.getAttribute("location"));
//
//                    // Save the user registration data to the database
//                    Userussd savedUser = userService.saveUser(newUser);
//
//                    // Clear the session data after registration is completed
//                    httpSession.removeAttribute("currentStep");
//                    httpSession.removeAttribute("language");
//                    httpSession.removeAttribute("firstName");
//                    httpSession.removeAttribute("lastName");
//                    httpSession.removeAttribute("dateOfBirth");
//                    httpSession.removeAttribute("location");
//
//                    response = "END Registration completed. Your information has been saved.";
//                } else if (text.equalsIgnoreCase("N")) {
//                    // Start over by setting the current step back to the language selection
//                    httpSession.setAttribute("currentStep", RegistrationStep.LANGUAGE_SELECTION);
//                    response = "Choose your language:\n1. English\n2. Spanish";
//                } else {
//                    // Invalid response, ask for confirmation again
//                    response = "Invalid input. Reply with 'Y' to confirm or 'N' to start over.";
//                }
//                break;
//            case END:
//                response = "END Thank you for registering!";
//                break;
//        }
//
//        // Move to the next step if not already at the end
//        if (currentStep != RegistrationStep.END) {
//            currentStep = RegistrationStep.values()[currentStep.ordinal() + 1];
//            httpSession.setAttribute("currentStep", currentStep);
//        }
//
//        return response;
//    }
//
//    // Implement the parseDate method to convert the user input to a Date object
//    private String parseDate(String text) {
//        // Implement the logic to parse the date from the text (DD/MM/YYYY format)
//        // For example:
//        // return text;
//        return text;
//    }
//}


//@RestController
//@SessionAttributes("ussdSession")
//public class Ussdcontroller2 {
//
//    private final UserRepository userRepository;
//
//    public Ussdcontroller2(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("/ussd")
//    public ResponseEntity<String> handleUssdRequest(@RequestParam("sessionId") String sessionId,
//                                                    @RequestParam("phoneNumber") String phoneNumber,
//                                                    @RequestParam("text") String text,
//                                                    HttpSession session) {
//
//        UssdSession ussdSession = (UssdSession) session.getAttribute("ussdSession");
//        if (ussdSession == null || text.trim().equalsIgnoreCase("1")) {
//            ussdSession = new UssdSession();
//            ussdSession.setSessionId(sessionId);
//            ussdSession.setPhoneNumber(phoneNumber);
//            ussdSession.setLevel(0); // Set the initial level to 0 for a new session
//            session.setAttribute("ussdSession", ussdSession);
//            return ResponseEntity.ok("CON Welcome! Please select a language:\n1. English\n2. French");
//        }
//
//        int currentLevel = ussdSession.getLevel();
//
//        switch (currentLevel) {
//            case 0:
//                if (text.trim().equalsIgnoreCase("1")) {
//                    ussdSession.setLanguage("English");
//                    ussdSession.setLevel(1);
//                    return ResponseEntity.ok("CON Thank you! Please enter your first name:");
//                } else if (text.trim().equalsIgnoreCase("2")) {
//                    ussdSession.setLanguage("French");
//                    ussdSession.setLevel(1);
//                    return ResponseEntity.ok("CON Merci! Veuillez entrer votre prénom:");
//                } else {
//                    return ResponseEntity.ok("CON Invalid input. Please select a valid language:\n1. English\n2. French");
//                }
//            case 1:
//                if (ussdSession.getLanguage().equalsIgnoreCase("French")) {
//                    ussdSession.setFirstName(text.trim());
//                    ussdSession.setLevel(2);
//                    return ResponseEntity.ok("CON Merci! Veuillez entrer votre nom de famille:");
//                } else {
//                    ussdSession.setFirstName(text.trim());
//                    ussdSession.setLevel(2);
//                    return ResponseEntity.ok("CON Thank you! Please enter your last name:");
//                }
//            case 2:
//                ussdSession.setLastName(text.trim());
//                ussdSession.setLevel(3);
//                return ResponseEntity.ok("CON Thank you! Please enter your national ID:");
//            case 3:
//                ussdSession.setNationalId(text.trim());
//                ussdSession.setLevel(4);
//                return ResponseEntity.ok("CON Thank you! Please enter your location:");
//            case 4:
//                ussdSession.setLocation(text.trim());
//                // Save the user data to the database
//                Userz user = new Userz();
//                user.setFirstName(ussdSession.getFirstName());
//                user.setLastName(ussdSession.getLastName());
//                user.setNationalId(ussdSession.getNationalId());
//                user.setLocation(ussdSession.getLocation());
//                userRepository.save(user);
//
//                // Reset the session to start a new registration process
//                session.removeAttribute("ussdSession");
//
//                return ResponseEntity.ok("END Thank you for completing the registration process!");
//            default:
//                // Invalid level, reset the session
//                session.removeAttribute("ussdSession");
//                return ResponseEntity.ok("END Session expired. Please start a new session.");
//        }
//    }
//}


@RestController
public class Ussdcontroller2 {

    private enum RegistrationStep {
        LANGUAGE_SELECTION,
        FIRST_NAME,
        LAST_NAME,
        NATIONAL_ID,
        LOCATION,
        CONFIRMATION,
        END
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/ussd")
    public String processUssdRequest(@RequestBody UssdRequest ussdRequest, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String sessionId = ussdRequest.getSessionId();
        String text = ussdRequest.getText();
        String response = "";

        // Check if the session is new or continuous
        boolean newSession = sessionId.equals("1");

        if (newSession) {
            // If it's a new session, initialize the USSD flow from the beginning
            httpSession.invalidate(); // Invalidate any existing session
            httpSession = request.getSession(true); // Create a new session
            httpSession.setAttribute("currentStep", RegistrationStep.LANGUAGE_SELECTION);
            httpSession.setAttribute("level", 1); // Set the initial level to 1
        } else {
            // For continuous session, retrieve the current step and level from the session
            RegistrationStep currentStep = (RegistrationStep) httpSession.getAttribute("currentStep");
            Integer level = (Integer) httpSession.getAttribute("level");
            int currentLevel = (level != null) ? level.intValue() : 1; // Default to 1 if level is null

            if (currentStep == null) {
                // If the current step is not set in the session, start the flow from the beginning
                httpSession.setAttribute("currentStep", RegistrationStep.LANGUAGE_SELECTION);
                httpSession.setAttribute("level", 1); // Set the initial level to 1
                currentStep = RegistrationStep.LANGUAGE_SELECTION;
                currentLevel = 1;
            }

            switch (currentStep) {
                case LANGUAGE_SELECTION:
                    // Check if the user has selected a language
                    if (text.equalsIgnoreCase("1")) {
                        // Set the language in the session and move to the next step (asking for First Name)
                        httpSession.setAttribute("language", "English");
                        httpSession.setAttribute("currentStep", RegistrationStep.FIRST_NAME);
                        response = "CON Please enter your First Name:";
                    } else if (text.equalsIgnoreCase("2")) {
                        // Set the language in the session and move to the next step (asking for First Name)
                        httpSession.setAttribute("language", "French");
                        httpSession.setAttribute("currentStep", RegistrationStep.FIRST_NAME);
                        response = "CON Please enter your First Name:";
                    } else {
                        // Invalid selection, prompt again for language selection
                        response = "CON Invalid input. Select your preferred language:\n";
                        response += "1. English\n";
                        response += "2. French";
                    }
                    break;
                case FIRST_NAME:
                    // Your first name registration logic here
                    // Move to the next step (asking for Last Name)
                    httpSession.setAttribute("firstName", text);
                    httpSession.setAttribute("currentStep", RegistrationStep.LAST_NAME);
                    response = "CON Please enter your Last Name:";
                    break;
                case LAST_NAME:
                    // Your last name registration logic here
                    // Move to the next step (asking for National ID)
                    httpSession.setAttribute("lastName", text);
                    httpSession.setAttribute("currentStep", RegistrationStep.NATIONAL_ID);
                    response = "CON Please enter your National ID:";
                    break;
                case NATIONAL_ID:
                    // Your national ID registration logic here
                    // Move to the next step (asking for Location)
                    httpSession.setAttribute("nationalId", text);
                    httpSession.setAttribute("currentStep", RegistrationStep.LOCATION);
                    response = "CON Please enter your Location:";
                    break;
                case LOCATION:
                    // Your location registration logic here
                    // Save the user information to the database
                    httpSession.setAttribute("location", text);

                    // Move to the next step (asking for confirmation)
                    httpSession.setAttribute("currentStep", RegistrationStep.CONFIRMATION);
                    response = "CON Please confirm your information:\n";
                    response += "First Name: " + httpSession.getAttribute("firstName") + "\n";
                    response += "Last Name: " + httpSession.getAttribute("lastName") + "\n";
                    response += "National ID: " + httpSession.getAttribute("nationalId") + "\n";
                    response += "Location: " + text + "\n";
                    response += "Reply with 1 to confirm or 2 to cancel.";
                    break;
                case CONFIRMATION:
                    // Your confirmation logic here
                    if (text.equals("1")) {
                        // Save the user information to the database
                        Userz newUser = new Userz();
                        newUser.setLanguage((String) httpSession.getAttribute("language"));
                        newUser.setFirstName((String) httpSession.getAttribute("firstName"));
                        newUser.setLastName((String) httpSession.getAttribute("lastName"));
                        newUser.setNationalId((String) httpSession.getAttribute("nationalId"));
                        newUser.setLocation((String) httpSession.getAttribute("location"));
                        newUser.setLevel(currentLevel); // Set the current level
                        userRepository.save(newUser);

                        // Clear the session after successful registration
                        httpSession.removeAttribute("currentStep");
                        httpSession.removeAttribute("language");
                        httpSession.removeAttribute("firstName");
                        httpSession.removeAttribute("lastName");
                        httpSession.removeAttribute("nationalId");
                        httpSession.removeAttribute("location");

                        response = "END Registration completed. Your information has been saved.";
                    } else if (text.equals("2")) {
                        // If the user cancels, end the session
                        httpSession.setAttribute("currentStep", RegistrationStep.END);
                        response = "END Registration canceled.";
                    } else {
                        // If the user enters an invalid response, prompt again for confirmation
                        response = "CON Invalid input. Reply with 1 to confirm or 2 to cancel.";
                    }
                    break;
                case END:
                    response = "END Thank you for registering!";
                    break;
            }

            // Update the user's level in the session for the next interaction
            currentLevel++;
            httpSession.setAttribute("level", currentLevel);
        }

        return response;
    }
}
