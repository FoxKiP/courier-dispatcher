let url;

$().ready(function () {
    url = "/courier/task/";

    $('#createTask').on('click', function () {
        createTask($('#inputForm').serialize());
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
});

function createTask(data) {
    $.ajax({
        type: "POST",
        url: url,
        data: data
    }).done(function () {
        $('#orderId').val('');
        successNoty('Принято!');
    });
}