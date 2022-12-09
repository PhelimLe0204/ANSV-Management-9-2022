package vn.ansv.management.services;

import java.util.List;

import vn.ansv.management.dto.Dashboard_ProjectDto;
import vn.ansv.management.dto.ProjectDetailDto;

public interface Interface_ProjectReport {
    List<Dashboard_ProjectDto> findAllDashboardProjectStep1(int enabled, int type, int week, int year);

    List<Dashboard_ProjectDto> findAllDashboardProjectStep2(int enabled, int type, int week, int year);

    ProjectDetailDto findByIdEnabled(int id, int enabled);
}
