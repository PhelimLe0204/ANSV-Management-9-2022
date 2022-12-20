var $first_week = $("#week").attr("data-first");
var $first_year = $("#year").attr("data-first");
var $first_ma_hop_dong = $("#ma_hop_dong").attr("data-first");
var $first_ma_ke_toan = $("#ma_ke_toan").attr("data-first");
var $first_currency_unit_id = $("#currency_unit_id").attr("data-first");
var $week = null;
var $current_year = null;

$(document).ready(function () {
    var currentYear = new Date().getFullYear();
    $current_year = currentYear;
    theLastDayOfYear = new Date(currentYear, 11, 31);
    var year = new Date(theLastDayOfYear.getFullYear(), 0, 1);
    var days = Math.floor((theLastDayOfYear - year) / (24 * 60 * 60 * 1000));
    var week = Math.ceil((theLastDayOfYear.getDay() + 1 + days) / 7);
    console.log("The current year (" + currentYear + ") has " + (week + 1) + " week.");
    $week = week + 1;
});

$("#phan-loai-open-modal-edit").click(function () {
    var $first_project_id = $("#project_id").attr("data-first");
    var $first_project_type_id = $("#project_type_id").attr("data-first");
    var $first_project_priority_id = $("#project_priority_id").attr("data-first");
    var $first_project_status_id = $("#project_status_id").attr("data-first");

    var data_project_select_option;

    // Ajax get data for project's selection
    $.ajax({
        url: "/api/getProjectSelectOption",
        success: function (result) {
            data_project_select_option = result.data;

            $("#project_id").select2({
                dropdownParent: $('#project-name-selection'),
                placeholder: 'Group Category',
                data: data_project_select_option,
                allowClear: true,
                selectOnClose: true,
                templateResult: function (data, container) {
                    var $state = $(
                        '<div class="row">'
                        + '<div class="col-md-2">'
                        + '<img src="/images/logo/'
                        + (data.customer_avatar ? data.customer_avatar : 'image_undefined.jpg')
                        + '" class="img-flag" style="width: 45px; height: 45px; margin-left: 10px;" />'
                        + '</div>'
                        + '<div class="col-md-10">'
                        + '<span class="font-weight-bold">'
                        + (data.project_name ? data.project_name : '. . . . .')
                        + '</span><br>'
                        + '<span>'
                        + (data.customer_name ? data.customer_name : '. . . . .')
                        + '</span>'
                        + '</div>'
                        + '</div>'
                    );

                    return $state;
                },
                templateSelection: function (data, container) {
                    var $state = $(
                        '<div class="row">'
                        + '<div class="col-md-2 pb-1">'
                        + '<img src="/images/logo/image_undefined.jpg" class="img-flag" style="width: 54px; height: 54px; margin-left: 5px; padding-top: 5px;" />'
                        + '</div>'
                        + '<div class="col-md-10 pt-3">'
                        + '<span class="font-weight-bold">Mời chọn dự án...</span>'
                        + '</div>'
                        + '</div>'
                    );

                    if (data.id && data.project_name) {
                        var $state = $(
                            '<div class="row">'
                            + '<div class="col-md-2 pb-1">'
                            + '<img src="/images/logo/'
                            + (data.customer_avatar ? data.customer_avatar : 'image_undefined.jpg')
                            + '" class="img-flag" style="width: 54px; height: 54px; margin-left: 5px; padding-top: 5px;" />'
                            + '</div>'
                            + '<div class="col-md-10">'
                            + '<span class="font-weight-bold">' + data.project_name + '</span><br>'
                            + '<span>' + (data.customer_name ? data.customer_name : '. . . . .') + '</span>'
                            + '</div>'
                            + '</div>'
                        );
                        return $state;
                    }

                    return $state;
                },
            }).on("select2:selecting", (e) => { }).on("select2:unselecting", (e) => { });

            $("#project_id").select2("val", $first_project_id);
        }
    });

    // Form input: project_type_id
    $(".project-step").click(function () {
        var onFocus = $(this).hasClass("btn-primary");

        if (onFocus == true) {
            return;
        }

        var find_data = $(this).closest('.step-class').find('div[data-status="active"]');
        find_data.removeClass("btn-primary").addClass("disabled btn-outline-secondary");
        find_data.attr('data-status', 'notActive');
        $(this).removeClass("disabled btn-outline-secondary").addClass("btn-primary");
        $(this).attr('data-status', 'active');
        $("#project_type_id").val($(this).attr("id"));
    });

    // Form input: project_priority_id
    $(".project-priority").click(function () {
        var onFocus = $(this).hasClass("btn-primary");

        if (onFocus == true) {
            return;
        }

        var find_data = $(this).closest('.priority-class').find('div[data-status="active"]');
        find_data.removeClass("btn-primary").addClass("disabled btn-outline-secondary");
        find_data.attr('data-status', 'notActive');
        $(this).removeClass("disabled btn-outline-secondary").addClass("btn-primary");
        $(this).attr('data-status', 'active');
        $("#project_priority_id").val($(this).attr("id"));
    });

    // Form input: project_status_id
    $(".project-status").click(function () {
        var onFocus = $(this).hasClass("disabled");

        if (onFocus != true) {
            return;
        }

        var find_data = $(this).closest('.status-class').find('div[data-status="active"]');
        var old_color = find_data.attr("data-color");
        var old_color_class_active = "btn-" + old_color;
        var old_color_class_not_active = "disabled btn-outline-" + old_color;
        find_data.removeClass(old_color_class_active).addClass(old_color_class_not_active);
        find_data.attr('data-status', 'notActive');
        $(this).removeClass("disabled btn-outline-" + $(this).attr("data-color")).addClass("btn-" + $(this).attr("data-color"));
        $(this).attr('data-status', 'active');
        $("#project_status_id").val($(this).attr("id"));
    });

    var htmlSelectWeek = null;
    for (let i = 1; i <= $week; i++) {
        if (i == $first_week) {
            htmlSelectWeek += '<option value="' + i + '" class="text-white bg-secondary font-weight-bold" selected>' + i + '</option>';
        } else {
            htmlSelectWeek += '<option value="' + i + '">' + i + '</option>';
        }
    }
    $("#week").html(htmlSelectWeek);

    var htmlSelectYear = null;
    for (let i = 2021; i <= $current_year; i++) {
        if (i == $first_year) {
            htmlSelectYear += '<option value="' + i + '" class="text-white bg-secondary font-weight-bold" selected>' + i + '</option>';
        } else {
            htmlSelectYear += '<option value="' + i + '">' + i + '</option>';
        }
    }
    $("#year").html(htmlSelectYear);

    // Form input: currency_unit_id
    $.ajax({
        url: "/api/getCurrencyUnitSelectOption",
        success: function (result) {
            var htmlSelectCurrencyUnit = null;
            for (let i = 0; i < result.data.length; i++) {
                if (result.data[i].id == $first_currency_unit_id) {
                    htmlSelectCurrencyUnit += '<option value="' + result.data[i].id
                        + '" class="text-white bg-secondary font-weight-bold" selected>'
                        + result.data[i].currency_unit + '</option>';
                } else {
                    htmlSelectCurrencyUnit += '<option value="' + result.data[i].id + '">'
                        + result.data[i].currency_unit + '</option>';
                }
            }
            $("#currency_unit_id").html(htmlSelectCurrencyUnit);
        }
    });

    // $(".tab-phan-loai-edit-modal-close").click(function () {
    //     $count_open++;
    //     if ($count_open > 1) {
    //         return;
    //     }
    //     if ($("#project_name").val() != $first_project_name) {
    //         return alertify.confirm(
    //             'Thông báo', 'Dữ liệu đã thay đổi sẽ được hoàn tác, bạn chắc chứ!',
    //             function () { alertify.success('Dữ liệu hoàn tác!') },
    //             function () { }
    //         );
    //     }
    // });

    $(".tab-phan-loai-edit-modal-close").click(function () {
        // if ($("#project_id").val() == $first_project_id) {
        //     $('#tabPhanLoaiEditModal').modal('hide');
        // }
        $('#tabPhanLoaiEditModal').modal('hide');
    });
});

// $("#project_name").select2({
//     dropdownParent: $('#project-name-selection'),
//     ajax: {
//         url: "/api/getProjectSelectOption",
//         dataType: "json",
//         type: "GET",
//         data: function (params) {
//             var queryParameters = {
//                 term: params.term
//             }
//             return queryParameters;
//         },
//         processResults: function (data) {
//             return {
//                 results: $.map(data, function (item) {
//                     return {
//                         text: item[0].project_name,
//                         id: item[0].id
//                     }
//                 })
//             };
//         }
//     }
// });