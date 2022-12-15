package vn.ansv.management.services;

import java.util.List;

import vn.ansv.management.dto.ProjectOptionDto;

public interface Interface_Project {
    List<ProjectOptionDto> findAllSelectOption();
}
