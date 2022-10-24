import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {

        AccountService account = new AccountService();
        Server server = new Server(8080);
        //создаем контейнер
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //в контейнер добавляем то, что будет обрабатывать запрос
        context.addServlet(new ServletHolder(new SignInServlet(account)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(account)), "/signup");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
