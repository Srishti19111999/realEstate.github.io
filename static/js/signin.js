
const form = document.querySelector('form');
const nameemail = form.nameemail;
const password = form.password;

form.addEventListener('click', e => {
  let flag = true;

  const emailPattern = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
  const unamePattern = /^[a-zA-Z0-9_\-\.][a-zA-Z0-9_\-\.]{4,29}$/;
  if (!(emailPattern.test(nameemail.value)||unamePattern.test(nameemail.value))) {
    flag = false;
    document.getElementById('unepinvalid').style.display = "block";
    document.getElementById('unepinvalid').innerHTML = "Use appropriate Username/email";
    document.getElementById('unevalid').style.display = "none";
    email.style.border = "2px solid #d60233";
  }
  else {
    document.getElementById('unevalid').style.display = "block";
    document.getElementById('unevalid').innerHTML = "valid";
    document.getElementById('unepinvalid').style.display = "none";
    email.style.border = "2px solid rgb(1, 155, 70)";
  }

  if (!(password.value.length >= 8)) {
    flag = false;
    document.getElementById('unepinvalid').style.display = "block";
    document.getElementById('unepinvalid').innerHTML = "Incorrect Password";
    document.getElementById('pvalid').style.display = "none";
    password.style.border = "2px solid #d60233";
  }else{
    document.getElementById('pvalid').style.display = "block";
    document.getElementById('pvalid').innerHTML = "Incorrect Password";
    document.getElementById('unepinvalid').style.display = "none";
    password.style.border = "2px solid #d60233";
  }

  if(flag){
   form.submit();

  }else{
    e.preventDefault();
  e.stopPropagation();
  }

});
