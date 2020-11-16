let dataTableApi, url;

$().ready(function() {
    dataTableApi = $('#datatable').DataTable({
        paging: false,
        searching: false,
        bInfo: false,
        bSort: false,
        autoWidth: false,
        fnRowCallback: function(data, row) {
            if(row.completed) {
                $("td", data).css("color", "green");
            } else {
                $("td", data).css("color", "red");
            }
        },
        columns: [
            {
                data: "orderId"
            },
            {
                width: "40%",
                data: "registered",
                render: renderDate
            },
            {
                defaultContent: "Edit",
                render: renderCompleteButton

            },
            {
                defaultContent: "Delete",
                render: renderDeleteButton
            }
        ]
    });

    url = "/dispatcher/task/";

    $('#modalButton').on('click', function () {
        completedTask($('#taskId').val());
        $('#taskModal').modal('hide');
    });

    $('#searchByOrder').on('click', function () {
        searchByOrder($('#searchTask').serialize());
    });

    $('#updateTable').on('click', function () {
        updateTable();
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });

    updateTable();
} );

function renderDate (data) {
    if(data) {
        const dm = moment(data);
        return dm.format('HH:mm  YYYY-MM-DD');
    } else {
        return "";
    }
}

function renderCompleteButton (data, type, row) {
    if(type === "display") {
        if(row.completed) {
            return `<button disabled class='btn btn-xs btn-primary' >выполнено</button>`;
        } else {
            return `<button class='btn btn-xs btn-primary' onclick='completedTask(${row.id})'>выполнено</button>`;
        }
    } else {
        return data;
    }
}

function renderDeleteButton (data, type, row) {
    if(type === "display") {
        if(row.completed) {
            return `<button class='btn btn-xs btn-danger' onclick="deleteTask(${row.id})">удалить</button>`
        } else {
            return `<button disabled class='btn btn-xs btn-danger'>удалить</button>`
        }
    } else {
        return data;
    }
}

function updateTable() {
    $.get(url)
        .done(function (table) {
            dataTableApi.clear();
            dataTableApi.rows.add(table);
            dataTableApi.draw();
        });
}

function completedTask(taskId) {
    $.ajax({
        type: "PUT",
        url: url + "completed/" + taskId
    }).done(function () {
        updateTable();
        successNoty("Задание выполнено");
    });
}

function deleteTask(taskId) {
    $.ajax({
        type: "DELETE",
        url: url + "delete/" + taskId
    }).done(function () {
        updateTable();
        infoNoty("Задание удалено");
    });
}

function searchByOrder(data) {
    $.get({
        url: url + "search",
        data: data,
    }).done(function (task) {
        $('#orderIdInput').val('');
        if(task.completed) {
            $('#modalButton').attr('disabled', true);
        } else {
            $('#modalButton').attr('disabled', false);
        }
        $('#taskId').val(task.id)
        $('#orderId').text(task.orderId);
        $('#registered').text(renderDate(task.registered))
        $('#taskModal').modal('show');
        }
    );
}
