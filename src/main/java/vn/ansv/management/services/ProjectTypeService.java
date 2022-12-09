package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.ProjectType;
import vn.ansv.management.repositories.ProjectTypeRepository;

@Service
public class ProjectTypeService implements Interface_ProjectType {
    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Override
    public List<ProjectType> findAll_detailProject() {
        return projectTypeRepository.findAll_detailProject();
    }
}
