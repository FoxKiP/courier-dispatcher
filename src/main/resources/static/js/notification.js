function successNoty(text) {
    new Noty({
        text: text,
        type: 'success',
        theme: "sunset",
        layout: "top",
        timeout: 2000
    }).show();
}

function infoNoty(text) {
    new Noty({
        text: text,
        type: 'info',
        theme: "sunset",
        layout: "top",
        timeout: 2000
    }).show();
}

function failNoty(jqXHR) {
    new Noty({
        text: "Ошибка: " + jqXHR.responseText,
        type: "error",
        theme: "sunset",
        layout: "top",
        timeout: 4000
    }).show();
}