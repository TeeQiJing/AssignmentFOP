package codefornature;
public class SessionManager {
    private static User currentUser;
    public static void setCurrentUser(User user) {currentUser = user;}
    public static User getCurrentUser() {return currentUser;}
    public static boolean isUserLoggedIn() {return currentUser != null;}
}
