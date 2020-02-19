package service;

import dao.RainManageDao;
import entity.RainQuality;

import java.util.List;

public class RainMangerService {
    private RainManageDao rainManageDao=new RainManageDao();
    public List<RainQuality>getAllInfo(){
        return rainManageDao.getAllInfo();
    }
}
