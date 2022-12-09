package vn.ansv.management.controllers.NonAdmin;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import vn.ansv.management.models.MenuCategory;
import vn.ansv.management.services.MenuCategoryService;

@Controller
public class BaseController {

    @Autowired // Inject "MenuCategoryService" - Dependency Injection
    private MenuCategoryService menuCategoryService;

    public ModelAndView _mvShare = new ModelAndView();

    public ModelAndView Init() {
        List<MenuCategory> menuCategoryLayout = menuCategoryService.findAllLayout();
        _mvShare.addObject("menuCategoryLayout", menuCategoryLayout);
        return _mvShare;
    }

    // Hàm lấy số tuần
    public int getWeekOfYear(Date date) {

        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        /*
         * Giới hạn tuần đầu tiên có ít nhất 1 ngày (Trong trường hợp ngày đầu năm là
         * THỨ BẢY hoặc CHỦ NHẬT -> vẫn tính là 1 tuần)
         */
        calendar.setMinimalDaysInFirstWeek(1);
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        return week;
    }
}
