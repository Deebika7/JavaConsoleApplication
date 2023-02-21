import com.zoho.supermarket.userinterface.menu.LoginMenu;
import com.zoho.supermarket.userinterface.util.ManagerFactory;

public class Main {
    public static void main(String[] args) {
                new LoginMenu(ManagerFactory.getUserDataManager()).start();
    }
}