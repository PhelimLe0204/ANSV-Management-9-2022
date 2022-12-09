package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.dto.Dashboard_ProjectDto;
import vn.ansv.management.dto.ProjectDetailDto;
import vn.ansv.management.repositories.Dashboard_ProjectRepository;
import vn.ansv.management.repositories.ProjectReportRepository;

@Service
public class ProjectReportService implements Interface_ProjectReport {
    @Autowired
    private Dashboard_ProjectRepository dashboard_ProjectRepository;

    @Autowired
    private ProjectReportRepository projectReportRepository;

    @Override
    public List<Dashboard_ProjectDto> findAllDashboardProjectStep1(int enabled, int type, int week, int year) {
        return dashboard_ProjectRepository.findAllDashboardProjectStep1(enabled, type, week, year);
    }

    @Override
    public List<Dashboard_ProjectDto> findAllDashboardProjectStep2(int enabled, int type, int week, int year) {
        return dashboard_ProjectRepository.findAllDashboardProjectStep2(enabled, type, week, year);
    }

    @Override
    public ProjectDetailDto findByIdEnabled(int id, int enabled) {
        return projectReportRepository.findByIdEnabled(id, enabled);
    }
}
