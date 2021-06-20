const cont_all_prop = document.querySelector("#cont_all_prop");
var colors = ["#ffe6e6", "#e6f7ff", "#e6ffee", "#ffffe6"];

const showBids = (bids) => {
	if (bids.length > 0) {
		cont_all_prop.innerHTML = '';
		let i = 0;
		bids.forEach((bid) => {
			console.log("bid",bid);
			var profpic = bid.property.user.profpic;
			console.log(profpic);
			if (typeof bid.property.user.profpic === 'undefined') {
				profpic = "../../static/images/default.jpg";
			}
			document.getElementById("pp").src = `show_bidder_pic.do?picPath=${profpic}`;
			cont_all_prop.innerHTML += `<div class="card col-12 col-md-10 offset-md-1 mt-2" style="background-color: ` + colors[i] + `;">
				<div class="card-body">
				<div class="row">
					<img src="property_image.do?property_id=${bid.property.propertyId}" alt="" class="col-3 col-md-3 mt-3">

					<div class="col-9 col-md-9">
					<div class="row">
					
						<h2 class="col-10 col-md-10">${bid.property.propertyName}</h2>
						
						<span class="fa fa-trash col-1 col-md-1 offset-md-1" style="font-size:20px;" data-del=${bid.property.propertyId}></span> 
						 
					</div>	  
					<hr>
					<h4 style="color:#606060">${bid.property.propertyType.propertyType} <em>in</em> ${bid.property.city.city} </h4>

					<div class="row mt-4">
						<p style="margin-left:2em;">For :</p> <h5 class="col-4 col-md-2"> ${bid.property.propertyFor.forType}</h5>
						<p>Price : </p><h5 class="col-4 col-md-4"> &#8377 ${bid.property.propertyPrice}</h5>  
						<h6 class="col-4 col-md-4 mt-1" style="color:#606060">${bid.property.perPrice} <em style="font-size:14px;">per sq/ft.</em></h6> 
					</div>
					<div class="row">
						<h6 style="margin-left:1em;" class=" col-8 col-sm-8">Area Covered : ${bid.property.propertyArea} <em style="font-size:14px;">sq.ft.</em></h6>  
						
						<a class="btn btn-link" href="viewproperty.do?property_id=${bid.property.propertyId}" role="button">See Details..</a>
					</div>
				</div>
				<h4 style="margin-left:0px; color:#04b" class=" col-8 col-sm-3">You Bidded For :&#8377 ${bid.bidAmount}</h4>  
			</div>

				</div>
				<div class="card-footer">

						
                <button data-chat=${bid.property.user.username} data-usrid=${bid.property.user.userId} class="btn btn-warning " id="chat_btn"><b> Chat Now</b></button>
					<a data-bnb="${bid.property.propertyId}" class="btn btn-sm bg-dark text-white offset-md-8"  id="buy"><i class="fa fa-money"></i> Buy Property</a>
				</div>
		  </div>`;
			if (i == 3)
				i = 0;
			else
				i++;
		});


		const del_box = Array.from(document.querySelectorAll('.fa-trash'));

const deleteCartRecord = async (propertyId)=>{
	const url = 'delete_bid_record.do?';
	const param = `property_id=${propertyId}`;

	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

del_box.forEach((del)=>{
	del.addEventListener('click',(e)=>{
		console.log(e)
		let prodId = e.target.getAttribute('data-del');
		console.log(e,prodId)
		deleteCartRecord(prodId)
			.then((data)=>{
				console.log(data)
				if(data.resp==1){						
					cont_all_prop.removeChild(e.target.parentNode.parentNode.parentNode.parentNode.parentNode);
				}
			})
			.catch((err)=>{
			
			});
	});
});



		Array.from(document.querySelectorAll("#chat_btn")).forEach((e) => {
			e.addEventListener('click', (chat) => {


				document.getElementById("mychat").style.width = "400px";

				const mic = document.querySelector(".mic");
				const message = document.querySelector("#message");
				const chat_box = document.querySelector("#chat-box");
				const user_name = document.querySelector("#user_name");
				user_name.innerHTML = chat.target.getAttribute('data-chat');
				console.log(user_name.innerHTML);
				let user_id = chat.target.getAttribute('data-usrid');



				const addToChats = async () => {
					const url = 'add_to_chats.do?';
					const query = `reciever_id=${user_id}&message=${message.value}&reciever_name=${user_name.innerHTML}`;

					const response = await fetch(url + query);
					const data = await response.json();

					return data;
				};
				const getChats = async (chats) => {
					console.log(chats.recieverId);
					const url = 'get_chats.do?';
					const query = `reciever_id=${chats.recieverId}&sender_id=${chats.senderId}`;

					const response = await fetch(url + query);
					const data = await response.json();
					showChats(data);
					setTimeout(() => getChats(chats), 1000)
					//return data;
				};
				getChats(chats)
					.then((resp) => {
						showChats(resp);
					}).catch(() => { })
				const showChats = (resp) => {
					chat_box.innerHTML = "";
					console.log(resp);
					if (resp.length > 0) {
						resp.forEach((res) => {
							let div = document.createElement('div');
							let divi = document.createElement('div');
							let idivi = document.createElement('div');

							let pp = document.createElement('p');

							if (res.sender == chats.sender) {
								div.className = "chat-r";
								divi.className = "sp";
								idivi.className = "mess mess-r";

								idivi.appendChild(pp);
								div.appendChild(divi);
								div.appendChild(idivi);
							} else {
								div.className = "chat-l";
								divi.className = "sp";
								idivi.className = "mess";

								idivi.appendChild(pp);
								div.appendChild(idivi);
								div.appendChild(divi);
							}
							chat_box.appendChild(div);
							pp.innerHTML = res.message;
							chat_box.scrollTop = chat_box.scrollHeight;
						});
					}
				}
				var chats;
				mic.addEventListener('click', ev => {
					console.log(ev);
					if (message.value == "") {
						console.log("no value");
					} else {
						addToChats()
							.then((data) => {
								chats = data;
								console.log("chats", chats)
								message.value = "";
								getChats(data)
							}).catch((err) => { });
					}
				});
				message.addEventListener('keyup', ev => {
					console.log(ev);
					if (message.value == "") {
						console.log("no value");
					} else {
						if (ev.keyCode === 13) {
							addToChats()
								.then((data) => {
									chats = data;
									console.log("chats", chats)
									message.value = "";
									getChats(data)
								}).catch((err) => { });
						}
					}

				});

			})

		});



	} else {
		cont_all_prop.innerHTML = `<div class="alert alert-danger alert-dismissible fade show mt-5 mb-7" role="alert" id="myAlert">
        <center>
          <h4 class="alert-heading">Ooops!</h4>
          <strong>No Such property Found</strong>
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </center>
      </div>`;
	}
};



const allBids = async () => {
	const url = 'show_bids.do?';
	const query = `user_id=${usr_id.value}`;

	const response = await fetch(url + query);
	const data = await response.json();

	return data;
};

const usr_id = document.querySelector("#usr_id");


















window.addEventListener('load', (e) => {

	allBids()
		.then((data) => {
			console.log(data);
			showBids(data);
		})
		.catch((err) => { });


});



const itemss = document.querySelectorAll(".dropdown-item");
var by_items = Array.from(itemss);
const input_by = document.querySelector("#by");
by_items.forEach((item) => {
	item.addEventListener('click', by => {
		console.log(by.target.innerText);
		input_by.value = by.target.innerText;
	});
});





const arrow = document.querySelector("#fa-arrow-right");
const search = document.querySelector("#search");

arrow.addEventListener('click', () => {
	let searchKey = search.value;
	window.location = `search_result.jsp?search=${searchKey}&by=${input_by.value}`;
});
search.addEventListener("keyup", function (event) {
	if (event.keyCode === 13) {
		let searchKey = search.value;
		window.location = `search_result.jsp?search=${searchKey}&by=${input_by.value}`;
	}
});

