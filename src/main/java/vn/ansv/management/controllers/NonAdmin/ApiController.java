package vn.ansv.management.controllers.NonAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ansv.management.dto.ProjectOptionDto;
import vn.ansv.management.dto.UserOptionDto;
import vn.ansv.management.models.CurrencyUnit;
import vn.ansv.management.models.ProjectReport;
import vn.ansv.management.models.ResponseObject;
import vn.ansv.management.repositories.CurrencyUnitRepository;
import vn.ansv.management.repositories.ProjectOptionRepository;
import vn.ansv.management.repositories.Main_ProjectReportRepository;
import vn.ansv.management.repositories.UserOptionRepository;

@RestController
@RequestMapping(path = "/api")
public class ApiController {
    // DI = Dependency Injection
    @Autowired
    private Main_ProjectReportRepository main_ProjectReportRepository;
    @Autowired
    private ProjectOptionRepository projectOptionRepository;
    @Autowired
    private CurrencyUnitRepository currencyUnitRepository;
    @Autowired
    private UserOptionRepository userOptionRepository;

    @GetMapping("/getAllProject")
    ResponseEntity<ResponseObject> getAllProject() {
        Iterable<ProjectReport> data = main_ProjectReportRepository.findAll();

        if (data.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Dữ liệu tbl_project_report", data));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("success", "null", ""));
        }
    }

    @GetMapping("/getProjectSelectOption")
    ResponseEntity<ResponseObject> getProjectSelectOption() {
        List<ProjectOptionDto> data = projectOptionRepository.findAllSelectOption();

        if (data.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Danh sách dự án sử dụng cho select option", data));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("success", "null", ""));
        }
    }

    @GetMapping("/getCurrencyUnitSelectOption")
    ResponseEntity<ResponseObject> getCurrencyUnitSelectOption() {
        Iterable<CurrencyUnit> data = currencyUnitRepository.findAll();

        if (data.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Danh sách đơn vị tiền tệ dùng cho select option", data));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("success", "null", ""));
        }
    }

    @GetMapping("/getUserSelectOption")
    ResponseEntity<ResponseObject> getUserSelectOption() {
        List<UserOptionDto> data = userOptionRepository.findAllSelectOption();

        if (data.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Danh sách quản lý AM sử dụng cho select option", data));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("success", "null", ""));
        }
    }
}
