$(document).ready(function(){

    var data =[{"telefono":3024477860,"contrasena":"3024477860"},
              {"telefono":3134180071,"contrasena":"3134180071"},
              {"telefono":3116401966,"contrasena":"3116401966"}];

    $('#btninicio').on('click',function(){
        window.location.href = "../index(2).html";
    });

    $('#btnlogin').on('click',function(e){
        e.preventDefault();
        var username = $('#username').val();
        var password = $('#password').val();
        console.log(username);
        console.log(password);
        
        if(username == ""){
            alert("Digite numero de telefono");
        }else{
            if(password == ""){
                alert("Digite contraseña");
            }else{
                console.log("estan llenos ambos campos");
                window.location.href = "menu.html";
            }
        }
    })
})