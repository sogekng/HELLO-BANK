<?php

// Verifica se houve POST e se o usuário ou a senha é(são) vazio(s)
if (!empty($_POST) AND empty($_POST['name']) OR (empty($_POST['cpf']) OR empty($_POST['password']))) {
    echo "<script>alert('Usuário ou senha inválido(s)')</script>";
}else{

    $name = $_POST['name'];
    $cpf = $_POST['cpf'];
    $password = $_POST['password'];
    
    header("Location: ../home/home.html");
    echo "<script>alert('Registrado com sucesso')</script>";
}

?>