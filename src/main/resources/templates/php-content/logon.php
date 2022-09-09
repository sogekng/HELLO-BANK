<?php

if (!empty($_POST) AND (empty($_POST['cpf']) OR empty($_POST['password']))) {
    echo "<script>alert('Usuário ou senha inválido(s)')</script>";
}else{

    $cpf = $_POST['cpf'];
    $password = $_POST['password'];
    
    if ($password == 'admin'){
        header("Location: ../system/systemAdmin.html");
    }else if ($password == 'client'){
       
        header("Location: ../system/systemClient.html");
    }else{
        echo "<script>alert('Usuário ou senha inválido(s)')</script>";
    }
}

?>