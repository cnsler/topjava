const mealAjaxUrl = "profile/meals/";

// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: mealAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: mealAjaxUrl + "filter",
            data: $("#filter").serialize()
        }).done(updateTableByData);
    }
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get(mealAjaxUrl, updateTableByData);
}

$(function () {
    $.datetimepicker.setLocale(navigator.language);
    $("#dateTime").datetimepicker({
        format: 'Y-m-d H:m'
    });
    $("#startDate").datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });
    $("#endDate").datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });
    $('#startTime').datetimepicker({
        datepicker: false,
        format: 'H:i'
    });
    $('#endTime').datetimepicker({
        datepicker: false,
        format: 'H:i'
    });
    makeEditable(
        $("#datatable").DataTable({
            "ajax": {
                "url": mealAjaxUrl,
                "dataSrc": "",
            },
            "language": {
                "search": i18n["common.search"],
                "info": i18n["common.info"]
            },
            "paging": false,
            "info": true,
            "columns": [
                {
                    "data": "dateTime",
                    "render": function (date, type, row) {
                        if (type === "display") {
                            return formatDateTime(date);
                        }
                        return date;
                    }
                },
                {
                    "data": "description"
                },
                {
                    "data": "calories"
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false,
                    "render": renderEditBtn
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false,
                    "render": renderDeleteBtn
                }
            ],
            "order": [
                [
                    0,
                    "desc"
                ]
            ],
            "createdRow": function (row, data, dataIndex) {
                $(row).attr("data-meal-excess", data.excess);
            }
        })
    );
});