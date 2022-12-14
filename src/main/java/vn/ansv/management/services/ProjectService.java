package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.Project;
import vn.ansv.management.repositories.ProjectRepository;

@Service
public class ProjectService implements Interface_Project {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllSelectOption() {
        return projectRepository.findAllSelectOption();
    }
}
