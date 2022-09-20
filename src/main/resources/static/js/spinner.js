$(document).ready(() => {
    $("#form").on("submit", () => {
        var spinner = '<div class="spinner-border" role="status"><span class="sr-only"></span></div>Aguarde...'
        $("#submitBtn").html(spinner);
        var formData = new FormData(document.getElementById("form"))
        var requisicao = window.location.href
        $.ajax({
            url: requisicao,
            type: "POST",
            data: formData,
            processData: false,
            contentType: false
        }).done((response) => {
            $("#submitBtn").text("Criar");
        });
    });

    $("#formLogin").on("submit", () => {
        var spinner = '<div class="spinner-border" role="status"><span class="sr-only"></span></div>'
        $("#submitBtn").html(spinner);
        var formData = new FormData(document.getElementById("formLogin"))
        var requisicao = window.location.href
        $.ajax({
            url: requisicao,
            type: "POST",
            data: formData,
            processData: false,
            contentType: false
        }).done((response) => {
            $("#submitBtn").text("Login");
        });
    });

    $("#register").on("submit", () => {
        var spinner = '<div class="spinner-border" role="status"><span class="sr-only"></span></div>'
        $("#submitRegister").html(spinner);
        var formData = new FormData(document.getElementById("register"))
        var requisicao = window.location.href
        $.ajax({
            url: requisicao,
            type: "POST",
            data: formData,
            processData: false,
            contentType: false
        }).done((response) => {
            $("#submitRegister").text("Cadastrar");
        });
    });
});