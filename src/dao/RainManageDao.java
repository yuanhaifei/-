package dao;

import entity.RainQuality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RainManageDao extends BaseDao{
    /**
     * 查询所有的雨量监测信息，并且按照时间倒序排列
     * @return
     */
    public List<RainQuality>getAllInfo(){
        Connection conn=null;

        List<RainQuality>rainQualityList =new ArrayList<RainQuality>();
        RainQuality rainQuality=null;
        try {
            //编写Sql语句
            String Sql = "select id,districtName,monitorTime,rain,monitoringStation,monitoringAddress from rainquality ORDER BY monitorTime DESC ";
            //获取数据库连接
            conn = BaseDao.getConn();
            //创建执行Sql的对象
            PreparedStatement pstmt =conn.prepareStatement(Sql);
            //执行Sql
            rs =pstmt.executeQuery();
            //处理结果集对象
            while (rs.next()) {
                //实例化对象
                rainQuality = new RainQuality();
                rainQuality.setId(rs.getInt("id"));
                rainQuality.setDistrictName(rs.getString("districtName"));
                rainQuality.setMonitorTime(rs.getDate("monitorTime"));
                rainQuality.setRain(rs.getInt("rain"));
                rainQuality.setMonitoringStation(rs.getString("monitoringStation"));
                rainQuality.setMonitoringAddress(rs.getString("monitoringAddress"));
                //将rainQuality对象添加到集合中
                rainQualityList.add(rainQuality);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rainQualityList;
    }
}
