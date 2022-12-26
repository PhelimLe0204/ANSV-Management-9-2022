package vn.ansv.management.controllers.NonAdmin;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.ansv.management.dto.Dashboard_ProjectDto;
import vn.ansv.management.dto.DetailTab1Dto;
import vn.ansv.management.dto.ProjectDetailDto;
import vn.ansv.management.models.ProjectPriority;
import vn.ansv.management.models.ProjectStatus;
import vn.ansv.management.models.ProjectType;
import vn.ansv.management.services.DetailTab1Service;
import vn.ansv.management.services.ProjectPriorityService;
import vn.ansv.management.services.ProjectReportService;
import vn.ansv.management.services.ProjectStatusService;
import vn.ansv.management.services.ProjectTypeService;

@Controller
@RequestMapping(path = "")
// http:localhost:8083
public class HomeController extends BaseController {

    @Autowired // Inject "ProjectReportService" - Dependency Injection
    private ProjectReportService projectReportService;

    @Autowired // Inject "ProjectTypeService" - Dependency Injection
    private ProjectTypeService projectTypeService;

    @Autowired // Inject "ProjectPriorityService" - Dependency Injection
    private ProjectPriorityService projectPriorityService;

    @Autowired // Inject "ProjectStatusService" - Dependency Injection
    private ProjectStatusService projectStatusService;

    @Autowired // Inject "DetailTab1Service" - Dependency Injection
    private DetailTab1Service detailTab1Service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String firstPage() {
        Date trialTime = new Date();
        int current_week = getWeekOfYear(trialTime); // Gọi hàm lấy số tuần => Lấy số tuần hiện tại
        int current_year = Calendar.getInstance().get(Calendar.YEAR); // Get the curent year
        // return "index";

        return "redirect:/dashboard?week=" + current_week + "&year=" + current_year;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView viewDashboard(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("week") == null || request.getParameter("year") == null) {
            return new ModelAndView("redirect:/");
        }
        int week = Integer.parseInt(request.getParameter("week"));
        int year = Integer.parseInt(request.getParameter("year"));
        session.setAttribute("thisWeek", week);
        session.setAttribute("thisYear", year);

        List<Dashboard_ProjectDto> telecomProject = projectReportService.findAllDashboardProjectStep1(
                1, 1, week, year);
        List<Dashboard_ProjectDto> digitalTransferProject = projectReportService.findAllDashboardProjectStep1(
                1, 2, week, year);
        List<Dashboard_ProjectDto> deploymentProject = projectReportService.findAllDashboardProjectStep2(
                1, 3, week, year);

        Init(); // Lấy dữ liệu cơ bản
        _mvShare.addObject("telecomProject", telecomProject); // Du an kinh doanh Vien thong
        _mvShare.addObject("digitalTransferProject", digitalTransferProject); // Du an kinh doanh Chuyen doi so
        _mvShare.addObject("deploymentProject", deploymentProject); // Du an Trien khai
        _mvShare.setViewName("non-admin/dashboard");
        return _mvShare;
    }

    @RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
    public ModelAndView viewDetail(HttpServletRequest request) {
        if (request.getParameter("id") == null) {
            return new ModelAndView("redirect:/");
        }
        int project_id = Integer.parseInt(request.getParameter("id"));
        ProjectDetailDto projectDetail = projectReportService.findByIdEnabled(project_id, 1);
        List<ProjectType> projectType = projectTypeService.findAll_detailProject();
        List<ProjectPriority> projectPriority = projectPriorityService.findAll_detailProject();
        List<ProjectStatus> projectStatus = projectStatusService.findAll_detailProject();

        Init(); // Lấy dữ liệu cơ bản
        _mvShare.addObject("projectDetail", projectDetail);
        _mvShare.addObject("projectType", projectType);
        _mvShare.addObject("projectPriority", projectPriority);
        _mvShare.addObject("projectStatus", projectStatus);
        _mvShare.setViewName("non-admin/project-detail/main-detail");
        return _mvShare;
    }

    @PostMapping("/chi-tiet/update/{id}")
    public String addUser(@PathVariable int id, @ModelAttribute DetailTab1Dto detailTab1Dto, Model model,
            HttpServletRequest request) {
        String tab = request.getParameter("tab");
        if (tab == null) {
            return "redirect:/chi-tiet?id=" + id + "&updateSuccess=false";
        }
        if (!detailTab1Service.update(id, detailTab1Dto)) {
            return "redirect:/chi-tiet?id=" + id + "&updateSuccess=false&tab=" + tab;
        }

        // System.out.println("=== URL thành công ID - " + id);
        // System.out.println("=== URL thành công: project_id - " +
        // detailTab1Dto.getProject_id());
        return "redirect:/chi-tiet?id=" + id + "&updateSuccess=true&tab=" + tab;
    }

    @RequestMapping(value = "/test/highchart", method = RequestMethod.GET)
    public String testHighchart() {
        return "non-admin/test-highchart";
    }
}
