import com.zoho.supermarket.userinterface.menu.LoginMenu;
import com.zoho.supermarket.ManagerFactory;

public class Main {
    public static void main(String[] args) {
        new LoginMenu(ManagerFactory.getUserDataManager()).printLoginMenu();
    }
}