package vn.ansv.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.dto.DetailTab1Dto;
import vn.ansv.management.repositories.DetailTab1Repository;

@Service
public class DetailTab1Service implements Interface_DetailTab1 {

    @Autowired
    private DetailTab1Repository detailTab1Repository;

    @Override
    public Boolean update(int id, DetailTab1Dto detailTab1Dto) {
        try {
            detailTab1Repository.update(id, detailTab1Dto.getProject_id(), detailTab1Dto.getProject_type_id(),
                    detailTab1Dto.getProject_priority_id(), detailTab1Dto.getProject_status_id(),
                    detailTab1Dto.getWeek(), detailTab1Dto.getYear(), detailTab1Dto.getMa_hop_dong(),
                    detailTab1Dto.getMa_ke_toan(), detailTab1Dto.getCurrency_unit_id());
        } catch (Exception e) {
            System.out.println("----- Error ----- DetailTab1Service.update(): " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
