const form = document.querySelector('form');

const username = form.username;
const email = form.email;
const password = form.password;
const repassword = form.repassword;

username.onblur = checkUniqueKey;
email.onblur = checkUniqueKey;

let request;
let curFld;

function checkUniqueKey() {
  if (this.value.length!=0) {
    curFld = this;
    request = new XMLHttpRequest();

    request.open('GET','unique_check.do?key='+this.value,true);
    request.onreadystatechange = uniqueCheckResult;
    request.send();
  }
}

let flag1 = true, flag2 = true;
function uniqueCheckResult(){
  if (request.readyState==4&&request.status==200) {
    const resp = request.responseText;

    if (resp=='true') {
      console.log(1);

      let fld;
      if (curFld.id == 'username'){
        fld = 'Username';
        flag1 = false;
        document.getElementById('uninvalid').style.display = "block";
        document.getElementById('uninvalid').innerHTML = `${fld} with the given name already exists`;
        document.getElementById('unvalid').style.display = "none";
       
      }
      else {
        fld = 'Email';
        flag1 = false;
        document.getElementById('einvalid').style.display = "block";
        document.getElementById('einvalid').innerHTML = `${fld} with the given name already exists`;
        document.getElementById('evalid').style.display = "none";
        email.style.border = "2px solid #d60233";
      }
    }
    else {
      console.log(2);
      if (curFld.id == 'username') {
        flag1 = true;
        document.getElementById('uninvalid').style.display = "none";

      } else {
        flag2 = true;
        document.getElementById('einvalid').style.display = "none";

      }
    }
  }
}


form.addEventListener('submit', e => {
  let flag = true;

  const unamePattern = /^[a-zA-Z0-9_\-\.][a-zA-Z0-9_\-\.]{4,29}$/;

  if (!unamePattern.test(username.value)) {
    flag = false;
    document.getElementById('uninvalid').style.display = "block";
    document.getElementById('uninvalid').innerHTML = "Use appropriate username";
    document.getElementById('unvalid').style.display = "none";
    username.style.border = "2px solid #d60233";
  }
  else {
    document.getElementById('unvalid').style.display = "block";
    document.getElementById('unvalid').innerHTML = "valid";
    document.getElementById('uninvalid').style.display = "none";
    username.style.border = "2px solid rgb(1, 155, 70)";
  }


  const emailPattern = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
  if (!emailPattern.test(email.value)) {
    flag = false;
    document.getElementById('einvalid').style.display = "block";
    document.getElementById('einvalid').innerHTML = "Use appropriate email";
    document.getElementById('evalid').style.display = "none";
    email.style.border = "2px solid #d60233";

  }
  else {
    document.getElementById('evalid').style.display = "block";
    document.getElementById('evalid').innerHTML = "valid";
    document.getElementById('einvalid').style.display = "none";
    email.style.border = "2px solid rgb(1, 155, 70)";
  }

  if (password.value.length >= 8) {
    document.getElementById('pinvalid').style.display = "none";

    if (password.value != repassword.value) {
      flag = false;
      document.getElementById('pinvalid').style.display = "block";
      document.getElementById('repinvalid').style.display = "block";

      document.getElementById('pinvalid').innerHTML = "password does not match with the repassword";
      document.getElementById('repinvalid').innerHTML = "repassword does not match with the password";

      document.getElementById('pvalid').style.display = "none";
      document.getElementById('repvalid').style.display = "none";

      password.style.border = "2px solid #d60233";
      repassword.style.border = "2px solid #d60233";
    }
    else {
      document.getElementById('pvalid').style.display = "block";
      document.getElementById('repvalid').style.display = "block";

      document.getElementById('pvalid').innerHTML = "valid";
      document.getElementById('repvalid').innerHTML = "valid";

      document.getElementById('pinvalid').style.display = "none";
      document.getElementById('repinvalid').style.display = "none";

      password.style.border = "2px solid rgb(1, 155, 70)";
      repassword.style.border = "2px solid rgb(1, 155, 70)";

    }
  } else {
    flag = false;
    document.getElementById('pinvalid').style.display = "block";
    document.getElementById('pinvalid').innerHTML = "password must be of atleast 8 characters";
    document.getElementById('pvalid').style.display = "none";
    password.style.border = "2px solid #d60233";

  }

  if (flag) {
    form.submit();
  } else {
    e.preventDefault();
    e.stopPropagation();
  }
});
