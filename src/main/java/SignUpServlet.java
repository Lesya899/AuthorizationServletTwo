
//SignUpServlet должен запомнить логин и пароль в AccountService

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private final AccountService account;

    public SignUpServlet(AccountService account) {
        this.account = account;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");  //получаем логин и пароль
        String password = req.getParameter("password");

        //если логин и пароль пустые возвращаем код состояния (400), указывающий, что запрос, отправленный клиентом, был синтаксически неправильным
        if (login == null || password == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        //добавляем в AccountService логин и пароль
        UserProfile user = new UserProfile(login, password);
        account.addUser(user);
    }
}