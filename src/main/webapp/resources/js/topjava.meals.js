const mealAjaxUrl = "profile/meals/";
const filter = $("#filterForm");

const ctx = {
    ajaxUrl: mealAjaxUrl,
    updateTable: function () {
        $.get(mealAjaxUrl + "filter", filter.serialize(), updateTableByData);
    }
};

$(function () {
    makeEditable(
        $("#datatable").DataTable({
            "paging": false,
            "info": true,
            "columns": [
                {
                    "data": "dateTime"
                },
                {
                    "data": "description"
                },
                {
                    "data": "calories"
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false
                }
            ],
            "order": [
                [
                    0,
                    "desc"
                ]
            ]
        })
    );
});

function resetFilter() {
    filter.get(0).reset();
    ctx.updateTable();
}