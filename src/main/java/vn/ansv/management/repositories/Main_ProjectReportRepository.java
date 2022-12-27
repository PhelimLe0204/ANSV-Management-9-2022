package vn.ansv.management.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.ansv.management.models.ProjectReport;

@Repository
public interface Main_ProjectReportRepository extends CrudRepository<ProjectReport, Integer> {

}
