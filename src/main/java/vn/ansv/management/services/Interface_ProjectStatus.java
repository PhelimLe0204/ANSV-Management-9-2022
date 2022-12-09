package vn.ansv.management.services;

import java.util.List;

import vn.ansv.management.models.ProjectStatus;

public interface Interface_ProjectStatus {
    List<ProjectStatus> findAll_detailProject();
}
