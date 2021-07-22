package com.Altshuler.servlce;

import com.Altshuler.dao.DAOStats;
import com.Altshuler.dao.DAOStatsImpl;
import com.Altshuler.model.Stats;

import java.sql.SQLException;
import java.util.List;

public class StatsServletService {
    private final DAOStats daoStats = new DAOStatsImpl();

    public void add(Stats stats) {
        try {
            daoStats.save(stats);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stats> getAll() {
        List<Stats> statsList = null;
        try {
            statsList = daoStats.getAll(Stats.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statsList;
    }
}
