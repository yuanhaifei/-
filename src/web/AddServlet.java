package web;

import entity.RainQuality;
import service.RainMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddServlet",urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //����service������������Ϣ�ķ���
        RainMangerService rainMangerService = new RainMangerService();

        //��ȡ����
         String districtName=request.getParameter("districtName");
         String monitorTime=request.getParameter("monitorTime");
         int rainNum=Integer.valueOf(request.getParameter("rain"));
         String monitoringStation=request.getParameter("monitoringStation");
         String monitoringAddress=request.getParameter("monitoringAddress");

         //�Ѳ�����װ��������
        RainQuality rain = new RainQuality();
        //Stringת��ΪDate
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date date = sdf.parse(monitorTime);
            rain.setMonitorTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        rain.setMonitoringAddress(monitoringAddress);
        rain.setMonitoringStation(monitoringStation);
        rain.setDistrictName(districtName);
        rain.setRain(rainNum);

        //ִ����ӵķ���
        int i = rainMangerService.addNewRainInfo(rain);
        if (i==1){
            System.out.println("ok");
            //��תҳ��
            request.getRequestDispatcher("index").forward(request,response);
        }else {
            System.out.println("error");
            response.sendRedirect("add.jsp");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
