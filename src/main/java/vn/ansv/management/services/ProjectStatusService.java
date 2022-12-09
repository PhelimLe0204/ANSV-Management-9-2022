package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.ProjectStatus;
import vn.ansv.management.repositories.ProjectStatusReposiroty;

@Service
public class ProjectStatusService implements Interface_ProjectStatus {
    @Autowired
    private ProjectStatusReposiroty projectStatusReposiroty;

    @Override
    public List<ProjectStatus> findAll_detailProject() {
        return projectStatusReposiroty.findAll_detailProject();
    }
}
