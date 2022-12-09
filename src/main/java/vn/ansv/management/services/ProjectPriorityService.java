package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.ProjectPriority;
import vn.ansv.management.repositories.ProjectPriorityRepository;

@Service
public class ProjectPriorityService implements Interface_ProjectPriority {
    @Autowired
    private ProjectPriorityRepository projectPriorityRepository;

    @Override
    public List<ProjectPriority> findAll_detailProject() {
        return projectPriorityRepository.findAll_detailProject();
    }
}
