package web;

import entity.RainQuality;
import service.RainMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet",urlPatterns = {"/index"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet调用service层的数据
        RainMangerService service = new RainMangerService();
        List<RainQuality> allInfo = service.getAllInfo();
        //把数据存储的request作用域(a-b)
        request.setAttribute("allinfo",allInfo);
        //跳转页面
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
