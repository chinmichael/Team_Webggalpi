
 function checkAll() {
     if(!checkUserId(form.frm.user_id.value)){
         return false;
     }
     if(!checkPassword(form.frm.user_id.value, form.frm.user_pw.value, form.frm.confrim_pw.value)){
         return false;
     }
     if(!checkMail(form.frm.e_mail.value)){
         return false;
     }
     if(!checkName(form.frm.user_name.value)){
         return false;
     }
      return true;
 }
function checkUserId(user_id) {
    if(!checkExistData(user_id,"아이디를"))
    return false;

    var idRegExp = /^[a-zA-z0-9]{4,12}$/;
    if(!idRegExp.test(user_id)) {
    alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
    form.frm.user_id.value = "";
    form.frm.user_id.focuse();
    return false;

}
 return true;
}
 function checkMail(e_mail){
    if(!checkExistData(e_mail,"이메일을")){
        return false;
        var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
       if(!emailRegExp.test(e_mail)){
       alert("이메일 형식이 올바르지않습니다!");
       form.frm.e_mail.value= "";
       form.frm.e_mail.focus();
       return false;
    }
    return true;
}
function checkName(user_name) {
    if(!checkExistData(user_name,"이름을"))
    return false;
    var nameRegExp = /^[가-힣]{2,4}$/;
    if(!nameRegExp.test(user_name)){
        alert("이름이 올바르지 않습니다");
        return false;
    }
   return true;
}
function checkPassWord(user_id, user_pw, confrim_pw) {
    if(!checkExistData(user_pw,"비밀번호를"))
    return false;

    if(!checkExistData(confrim_pw,"비밀번호 확인을"))
    return false;
    
    var password1RegExp = /^[a-zA-z0-9]{4,12}$/;
    if(!passoword1RegExp.test(user_pw)){
   alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
    form.frm.user_pw.value = "";
    form.frm.user_pw.focus();
    return false;
}
  if(user_pw != confrim_pw) {
      form.frm.user_pw.value = "";
      form.frm.confrim_pw.value = "";
      form.frm.user_pw.focus();
      return false;
  }
  if(user_id == user_pw){
      alert("아이디와 비밀번호는 같을수 없습니다!");
      form.frm.user_pw.value ="";
      form.frm.confrim_pw.value ="";
      form.frm.confrim_pw.focus();
      return false;

  }
  return true;
}

 

}
