function getSubmitElement(){
    let btn = document.getElementById("btn-submit");
    btn.addEventListener("click", (para) => {
        getNameElement();
        getEmailElement();
        getPasswordElement();
    });
}

function getNameElement(){
    let name = document.getElementById("username");
    console.log(name);
    name = name.value.trim.length;
    if (name <= 0){
        alert("이름을 입력해주세요.");
        return false;
    }
}

function getEmailElement(){
    let email = document.getElementById("email");
    email = email.value.trim.length;
    if (email.length <= 0){
        alert("이메일을 입력해주세요.");
        return false;
    }
}

function getPasswordElement(){
    let password = document.getElementById("password");
    password = password.value.trim.length;
    if (password.length <= 0){
        alert("패스워드를 입력해주세요.");
        return false;
    }
}

window.addEventListener("load", getSubmitElement);