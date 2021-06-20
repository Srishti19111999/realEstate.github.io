const form = document.forms[0];

const loader = document.getElementById("loader");

const mobile = form.mob;

const otpsubmit = document.getElementById("otpsubmit");

const otpButton = document.getElementById("otp");

const otpform = document.getElementById("otpform");

mobile.addEventListener('keydown',e=>{
  updateUI();
  console.log(mobile.value.length);
  if (mobile.value.trim().length == 9) {
    console.log(mobile.value.length);
    otpButton.disabled = false;
  }
  else {
    otpButton.disabled = true;
  }   
});

const sendOTP = async () => {
  const mobileNo = mobile.value.trim();

  const data = await fetch('sendotp.do?mobile='+mobile.value);
  //const data = await response.json();
  return data;
}

otpform.addEventListener('submit',e=>{
  if(otpform.otp.value.trim().length==6){
    console.log('doneeeeee');
  }else{
    console.log("enter correct otp");
  }
});

const updateUI = () =>{
  loader.style.display="none";
  otpform.style.display="block";
}

otpButton.addEventListener('click',e=>{
  e.preventDefault();

  sendOTP()
  .then((data)=>{
    console.log(data); 
     updateUI();
  })
  .catch((err)=>{
    console.log(err);
  });
});

otpsubmit.addEventListener('click',e=>{
  $("#otpmodal").modal('toggle');
})