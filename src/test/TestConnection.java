package test;

import dao.BaseDao;
import dao.RainManageDao;
import entity.RainQuality;
import service.RainMangerService;

public class TestConnection {
    public static void main(String[] args) {
        RainManageDao dao = new RainManageDao();
        dao.getAllInfo();
        System.out.println(dao.getAllInfo().size());
//        RainMangerService service = new RainMangerService();
//        System.out.println(service.getAllInfo());
    }
}
