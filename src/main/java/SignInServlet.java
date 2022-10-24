
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final AccountService account;

    public SignInServlet(AccountService account) {
        this.account = account;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        //если логин и пароль пустые возвращаем код состояния (400), указывающий, что запрос, отправленный клиентом, был синтаксически неправильным
        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }


        UserProfile user = account.getUser(login); //получаем логин пользователя из БД
        if (user.getUser().equals(login)) { //если полученный из БД равен введенному пользователем
            response.getWriter().print("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK); //status code 200
        } else {
            response.getWriter().print("Unauthorized");
            response.setStatus(401);
        }
    }
}