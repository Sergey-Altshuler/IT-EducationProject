package com.Altshuler.serviceTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.dao.DAOStats;
import com.Altshuler.dao.DAOStatsImpl;
import com.Altshuler.model.Stats;
import com.Altshuler.servlce.StatsServletService;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsServletServiceTest {
    StatsServletService statsServletService = new StatsServletService();
    DAOStats daoStats = new DAOStatsImpl();

    @Test
    void add() {
        try {
            List<Stats> list1 = daoStats.getAll(Stats.class);
            statsServletService.add(TestDataCreator.createTestAddStats());
            List<Stats> list2 = daoStats.getAll(Stats.class);
            assertEquals(list1.size() + 1, list2.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        try {
            statsServletService.add(TestDataCreator.createTestGetAllStats());
            List<Stats> daoList = daoStats.getAll(Stats.class);
            List<Stats> serviceList = statsServletService.getAll();
            assertEquals(daoList, serviceList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
