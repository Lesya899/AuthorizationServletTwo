
public class AccountService {

    DBService dbService = new DBService();

    public void addUser(UserProfile user) {

        try {
            long userId = dbService.addUser(user.getUser(), user.getPassword());
        } catch (DBException e) {
            e.printStackTrace();
        }
    }


    public UserProfile getUser(String user) {
        try {
            UserDataSet dataSet =  dbService.getUser(user);
            UserProfile result = new UserProfile(dataSet.getName(), dataSet.getPwd());
            return result;
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;

    }

}
