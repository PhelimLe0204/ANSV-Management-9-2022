package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.dto.ProjectOptionDto;
import vn.ansv.management.repositories.ProjectOptionRepository;

@Service
public class ProjectService implements Interface_Project {
    @Autowired
    private ProjectOptionRepository projectOptionRepository;

    @Override
    public List<ProjectOptionDto> findAllSelectOption() {
        return projectOptionRepository.findAllSelectOption();
    }
}
