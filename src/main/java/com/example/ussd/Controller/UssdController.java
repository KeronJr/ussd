//package com.example.ussd.Controller;
//////
//import com.example.ussd.Model.UssdRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//
//@RestController
//public class UssdController {
//
//    @PostMapping("/ussd")
//    public String processUssdRequest(@RequestBody UssdRequest ussdRequest) {
////        String sessionId = ussdRequest.getSessionId();
////        String phoneNumber = ussdRequest.getPhoneNumber();
////        String text = ussdRequest.getText();
////        String response = "";
////
////        // Language Selection
////        if (text.equals("")) {
////            response = "CON Choose your language:\n1. English\n2. Spanish";
////        }
////        // Registration Flow
////        else if (text.equals("1")) {
////            response = "CON Please enter your First Name:";
////        } else if (text.equals("2")) {
////            response = "CON Por favor, ingrese su nombre:";
////        }
////        // Handle the rest of the registration steps (First Name, Last Name, DOB, Location)
////        else {
////            // Parse the text to capture user input and continue the registration flow
////            // ...
////        }
////
////        return response;
////    }
//
//        String sessionId = ussdRequest.getSessionId();
//        String phoneNumber = ussdRequest.getPhoneNumber();
//        String text = ussdRequest.getText();
//        String response = "";
//
//        // Language Selection
//        if (text.equals("")) {
//            response = "CON Choose your language:\n1. English\n2. Spanish";
//        }
//        // Registration Flow
//        else if (text.equals("1")) {
//            response = "CON Please enter your First Name:";
//        } else if (text.equals("2")) {
//            response = "CON Por favor, ingrese su nombre:";
//        }
//        // Handle the rest of the registration steps (First Name, Last Name, DOB, Location)
//        else {
//            // Parse the text to capture user input and continue the registration flow
//            // ...
//        }
//
//        return response;
//    }
//}
//////
//////
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RestController;
////import com.example.ussd.Model.UssdRequest;
//
////@RestController
////public class UssdController {
////
////    private enum RegistrationStep {
////        LANGUAGE_SELECTION,
////        FIRST_NAME,
////        LAST_NAME,
////        DATE_OF_BIRTH,
////        LOCATION,
////        END
////    }
////
////    private RegistrationStep getNextStep(String text) {
////        switch (text) {
////            case "":
////                return RegistrationStep.LANGUAGE_SELECTION;
////            case "1":
////                return RegistrationStep.FIRST_NAME;
////            case "2":
////                return RegistrationStep.LAST_NAME;
////            case "3":
////                return RegistrationStep.DATE_OF_BIRTH;
////            case "4":
////                return RegistrationStep.LOCATION;
////            default:
////                return RegistrationStep.END;
////        }
////    }
////
////    @PostMapping("/ussd")
////    public String processUssdRequest(@RequestBody UssdRequest ussdRequest) {
////        String sessionId = ussdRequest.getSessionId();
////        String phoneNumber = ussdRequest.getPhoneNumber();
////        String text = ussdRequest.getText();
////        String response = "";
////
////        RegistrationStep currentStep = getNextStep(text);
////
////        switch (currentStep) {
////            case LANGUAGE_SELECTION:
////                response = "CON Choose your language:\n1. English\n2. Spanish";
////                break;
////            case FIRST_NAME:
////                response = "CON Please enter your First Name:";
////                break;
////            case LAST_NAME:
////                response = "CON Please enter your Last Name:";
////                break;
////            case DATE_OF_BIRTH:
////                response = "CON Please enter your Date of Birth (DD/MM/YYYY):";
////                break;
////            case LOCATION:
////                response = "CON Please enter your Location:";
////                break;
////            case END:
////                // Process the collected information (First Name, Last Name, DOB, and Location)
////                // ...
////                // Here, you can save the data to a database or perform any other actions.
////                response = "END Thank you for registering!";
////                break;
////        }
////
////        return response;
////    }
////}
//
////package com.example.ussd.Controller;
////import com.example.ussd.Model.User;
////import com.example.ussd.Repository.UserRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////import com.example.ussd.Model.UssdRequest;
//////
////import java.text.ParseException;
////import java.text.SimpleDateFormat;
////import java.util.Date;
////import java.util.HashMap;
////import java.util.Map;
////
////////@RestController
////////public class UssdController {
////////
////////    @Autowired
////////    private UserRepository userRepository;
////////
////////    private enum RegistrationStep {
////////        LANGUAGE_SELECTION,
////////        FIRST_NAME,
////////        LAST_NAME,
////////        DATE_OF_BIRTH,
////////        LOCATION,
////////        END
////////    }
////////
////////    private RegistrationStep getNextStep(String text) {
////////        switch (text) {
////////            case "":
////////                return RegistrationStep.LANGUAGE_SELECTION;
////////            case "1":
////////                return RegistrationStep.FIRST_NAME;
////////            case "2":
////////                return RegistrationStep.LAST_NAME;
////////            case "3":
////////                return RegistrationStep.DATE_OF_BIRTH;
////////            case "4":
////////                return RegistrationStep.LOCATION;
////////            default:
////////                return RegistrationStep.END;
////////        }
////////    }
////////
////////    @PostMapping("/ussd")
////////    public String processUssdRequest(@RequestBody UssdRequest ussdRequest) {
////////        String sessionId = ussdRequest.getSessionId();
////////        String phoneNumber = ussdRequest.getPhoneNumber();
////////        String text = ussdRequest.getText();
////////        String response = "";
////////
////////        RegistrationStep currentStep = getNextStep(text);
////////
////////        switch (currentStep) {
////////            case LANGUAGE_SELECTION:
////////                response = "CON Choose your language:\n1. English\n2. Spanish";
////////                break;
////////            case FIRST_NAME:
////////                response = "CON Please enter your First Name:";
////////                break;
////////            case LAST_NAME:
////////                response = "CON Please enter your Last Name:";
////////                break;
////////            case DATE_OF_BIRTH:
////////                response = "CON Please enter your Date of Birth (DD/MM/YYYY):";
////////                break;
////////            case LOCATION:
////////                response = "CON Please enter your Location:";
////////                break;
////////            case END:
////////                // Save the collected information (First Name, Last Name, DOB, and Location) into the database
////////                saveUser(sessionId, phoneNumber, text);
////////                response = "END Thank you for registering!";
////////                break;
////////        }
////////
////////        return response;
////////    }
////////
////////    private void saveUser(String sessionId, String phoneNumber, String text) {
////////        String[] userData = text.split(";");
////////        if (userData.length == 4) {
////////            String firstName = userData[0];
////////            String lastName = userData[1];
////////            String dob = userData[2];
////////            String location = userData[3];
////////
////////            User user = new User();
////////            userRepository.save(user);
////////        }
////////    }
//////}
////
////
////@RestController
////@RequestMapping("/ussd")
////public class USSDController {
////
////    private final UserRepository userRepository;
////    private final Map<String, User> userSessions;
////
////    public USSDController(UserRepository userRepository) {
////        this.userRepository = userRepository;
////        this.userSessions = new HashMap<>();
////    }
////
////    @PostMapping
////    public String handleUSSDRequest(@RequestParam("sessionId") String sessionId,
////                                    @RequestParam("phoneNumber") String phoneNumber,
////                                    @RequestParam("text") String text) {
////        String response;
////
////        if (!userSessions.containsKey(sessionId)) {
////            // New session, start the registration process
////            response = "CON Welcome to the USSD registration. Select your language:\n" +
////                    "1. English\n" +
////                    "2. French";
////            userSessions.put(sessionId, new User());
////        } else {
////            // Continuing registration process based on previous user inputs
////            User user = userSessions.get(sessionId);
////            response = handleRegistrationStep(user, text);
////        }
////
////        return response;
////    }
////
////    private String handleRegistrationStep(User user, String input) {
////        // Get the current step based on user's progress
////        int step = getRegistrationStep(user);
////
////        switch (step) {
////            case 0:
////                return handleLanguageSelection(user, input);
////            case 1:
////                return handleFirstNameRegistration(user, input);
////            case 2:
////                return handleLastNameRegistration(user, input);
////            case 3:
////                return handleDateOfBirthRegistration(user, input);
////            case 4:
////                return handleLocationRegistration(user, input);
////            case 5:
////                return saveUserData(user);
////            default:
////                return "END Thank you for registering!";
////        }
////    }
////
////
////    private int getRegistrationStep(User user) {
////        // Step 0: Language selection step
////        if (isEmpty(user.getLanguage())) {
////            return 0;
////        }
////
////        // Step 1: First name registration step
////        if (isEmpty(user.getFirstName())) {
////            return 1;
////        }
////
////        // Step 2: Last name registration step
////        if (isEmpty(user.getLastName())) {
////            return 2;
////        }
////
////        // Step 3: Date of birth registration step
////        if (user.getDateOfBirth() == null) {
////            return 3;
////        }
////
////        // Step 4: Location registration step
////        if (isEmpty(user.getLocation())) {
////            return 4;
////        }
////
////        // Registration is complete
////        return 5;
////    }
////
////    private boolean isEmpty(String str) {
////        return str == null || str.trim().isEmpty();
////    }
////
////
////
////    private String handleLanguageSelection(User user, String input) {
////        if (input.equals("1")) {
////            // Set user language to English
////            return "CON Enter your first name:";
////        } else if (input.equals("2")) {
////            // Set user language to French
////            return "CON Entrez votre prénom:";
////        } else {
////            return "CON Invalid input. Select your language:\n" +
////                    "1. English\n" +
////                    "2. French";
////        }
////    }
////
////    // Implement other handle methods for different registration steps (e.g., first name, last name, etc.)
////
////    private String saveUserData(User user) {
////        // Save the completed user data to the database
////        userRepository.save(user);
////        userSessions.remove(user.getId()); // Clean up the session data after registration
////        return "END Thank you for registering!";
////    }
////
////
////    private String handleFirstNameRegistration(User user, String input) {
////        // Assuming the user has entered the first name
////        user.setFirstName(input);
////        return "CON Enter your last name:";
////    }
////
////    private String handleLastNameRegistration(User user, String input) {
////        // Assuming the user has entered the last name
////        user.setLastName(input);
////        return "CON Enter your date of birth (YYYY-MM-DD):";
////    }
////
////    private String handleDateOfBirthRegistration(User user, String input) {
////        // Assuming the user has entered the date of birth in the format "YYYY-MM-DD"
////        try {
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            Date dateOfBirth = dateFormat.parse(input);
////            user.setDateOfBirth(dateOfBirth);
////            return "CON Enter your location:";
////        } catch (ParseException e) {
////            return "CON Invalid date format. Please enter your date of birth (YYYY-MM-DD):";
////        }
////    }
////
////    private String handleLocationRegistration(User user, String input) {
////        // Assuming the user has entered the location
////        user.setLocation(input);
////        return saveUserData(user);
////    }
////
////}
//
//
//
//
//
//
//
//
//
//
//
//
////import com.example.ussd.Model.User;
////import com.example.ussd.Service.UserService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////public class UssdController {
////    private final UserService userService;
////    private UserRegistrationState userState = UserRegistrationState.LANGUAGE_SELECTION;
////    private User currentUser = new User();
////
////    @Autowired
////    public UssdController(UserService userService) {
////        this.userService = userService;
////    }
////
////    @PostMapping("/ussd")
////    public String ussdMenu(@RequestBody String input) {
////        String response;
////
////        switch (userState) {
////            case LANGUAGE_SELECTION:
////                response = handleLanguageSelection(input);
////                break;
////            case FIRST_NAME_REGISTRATION:
////                response = handleFirstNameRegistration(input);
////                break;
////            case LAST_NAME_REGISTRATION:
////                response = handleLastNameRegistration(input);
////                break;
////            case DATE_OF_BIRTH_REGISTRATION:
////                response = handleDateOfBirthRegistration(input);
////                break;
////            case LOCATION_REGISTRATION:
////                response = handleLocationRegistration(input);
////                break;
////            case REGISTRATION_COMPLETED:
////                response = handleRegistrationCompleted();
////                break;
////            default:
////                response = "Invalid state. Please start again.";
////                userState = UserRegistrationState.LANGUAGE_SELECTION;
////        }
////
////        return response;
////    }
////
////    private String handleLanguageSelection(String input) {
////        // Implement logic to handle language selection
////        // Update userState and return the appropriate response.
////        // For example:
////        userState = UserRegistrationState.FIRST_NAME_REGISTRATION;
////        return "Welcome! Please enter your first name:";
////    }
////
////    private String handleFirstNameRegistration(String input) {
////        // Implement logic to handle first name registration
////        // Update the currentUser object with the first name.
////        // For example:
////        currentUser.setFirstName(input);
////
////        userState = UserRegistrationState.LAST_NAME_REGISTRATION;
////        return "Great! Now enter your last name:";
////    }
////
////    private String handleLastNameRegistration(String input) {
////        // Implement logic to handle last name registration
////        // Update the currentUser object with the last name.
////        // For example:
////        currentUser.setLastName(input);
////
////        userState = UserRegistrationState.DATE_OF_BIRTH_REGISTRATION;
////        return "Almost there! Please enter your date of birth (DD/MM/YYYY):";
////    }
////
////    private String handleDateOfBirthRegistration(String input) {
////        // Implement logic to handle date of birth registration
////        // Update the currentUser object with the date of birth.
////        // For example:
////        currentUser.setDateOfBirth(input);
////
////        userState = UserRegistrationState.LOCATION_REGISTRATION;
////        return "Finally, enter your location:";
////    }
////
////    private String handleLocationRegistration(String input) {
////        // Implement logic to handle location registration
////        // Update the currentUser object with the location.
////        // For example:
////        currentUser.setLocation(input);
////
////        // Save the user data to the database
////        userService.registerUser(currentUser);
////
////        userState = UserRegistrationState.REGISTRATION_COMPLETED;
////        return "Registration completed! Thank you for registering with us.";
////    }
////
////    private String handleRegistrationCompleted() {
////        // Implement any logic required after registration completion.
////        // For example:
////        userState = UserRegistrationState.LANGUAGE_SELECTION;
////        currentUser = new User(); // Reset currentUser for the next registration.
////
////        return "Welcome back to our USSD application! Please select your language:";
////    }
////
////    private enum UserRegistrationState {
////        LANGUAGE_SELECTION,
////        FIRST_NAME_REGISTRATION,
////        LAST_NAME_REGISTRATION,
////        DATE_OF_BIRTH_REGISTRATION,
////        LOCATION_REGISTRATION,
////        REGISTRATION_COMPLETED
////    }
////}
