$("#phan-loai-open-modal-edit").click(function () {
    var $selected = $(this).attr("data-id");
    var data_project_select_option;

    $.ajax({
        url: "/api/getProjectSelectOption",
        success: function (result) {
            data_project_select_option = result.data;

            $(".js-example-basic-single").select2({
                dropdownParent: $('#project-name-select2'),
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

                    if (data.project_name) {
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
                    }

                    return $state;
                },
            }).on("select2:selecting", (e) => { }).on("select2:unselecting", (e) => { });

            $(".js-example-basic-single").select2("val", $selected);
        }
    });
});

// $(".js-example-basic-single").select2({
//     dropdownParent: $('#project-name-select2'),
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
//                     console.log(item);
//                     return {
//                         text: item[0].project_name,
//                         id: item[0].id
//                     }
//                 })
//             };
//         }
//     }
// });