const prop_id = document.querySelector("#property_id");
const cont_all_prop = document.querySelector("#cont_all_prop");
var colors = ["#ffe6e6", "#e6f7ff", "#e6ffee", "#ffffe6"];

const getAllBidders = async () => {
	const url = 'get_all_bidders.do?';
	const query = `property_id=${prop_id.value}`;

	const response = await fetch(url + query);
	const data = await response.json();

	return data;
};


const showBidders = (bidders) => {
	if (bidders.length > 0) {
		cont_all_prop.innerHTML = '';
		let i = 0;
		bidders.forEach((bidder) => {
			var profpic = bidder.user.profpic;
			console.log(profpic);
			if (typeof bidder.user.profpic === 'undefined') {
				profpic = "../../static/images/default.jpg";
			}
			document.getElementById("pp").src = `show_bidder_pic.do?picPath=${profpic}`;
			cont_all_prop.innerHTML += `

				<div class="card col-md-5 m-4"
				  style="box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
				  <div class="card-body">
					<div class=" d-flex justify-content-center">
					  <img src="show_bidder_pic.do?picPath=${profpic}" alt="" class=""
						style="width:125px; height:125px; border-radius: 50%;">
					</div>
					<div class="col-12 mt-4">
					  <div class="row">
						<div class="col-md-12">${bidder.user.firstName} ${bidder.user.lastName}</div>
						<div class="col-md-4"><strong>Username:</strong></div><div class="col-md-8">${bidder.user.username}</div>
						<div class="col-md-4"><strong>Contact via: </strong></div>
						<div class="col-md-8">${bidder.user.email}</div>
						<div class="col-md-4"><Strong>Bid Amount: </Strong></div>
						<div class="col-md-8">&#8377 ${bidder.bidAmount}</div>
					  </div>
					</div>
				  </div>
				  <div class="card-footer">
					<button data-chat=${bidder.user.username} data-usrid=${bidder.user.userId} class="btn btn-warning" id="chat_btn">Chat Now</button>
				  </div>
				</div>`;
			if (i == 3)
				i = 0;
			else
				i++;
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

				let chats;

				const addToChats = async () => {
					const url = 'add_to_chats.do?';
					const query = `reciever_id=${user_id}&message=${message.value}&reciever_name=${user_name.innerHTML}`;

					const response = await fetch(url + query);
					const data = await response.json();

					return data;
				};
				const getChats = async (chats) => {
					console.log(chats);
					console.log(chats.recieverId);
					const url = 'get_chats.do?';
					const query = `reciever_id=${chats.recieverId}&sender_id=${chats.senderId}`;

					const response = await fetch(url + query)
					const data = await response.json();
					showChats(data);
					setTimeout(() => getChats(chats), 1000);
				}
				

				const showChats = (resp) => {
					chat_box.innerHTML = "";
					console.log(resp.length);
					console.log("resp",resp);
					console.log("chats", chats)

					if (resp.length > 0) {
						resp.forEach((res) => {

							let div = document.createElement('div');
							let divi = document.createElement('div');
							let idivi = document.createElement('div');

							let pp = document.createElement('p');
							console.log(res.sender);
							console.log(chats.sender);
							console.log(chats.sender===res.sender);
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
				
				

				mic.addEventListener('click', ev => {
					console.log(ev);
					if(message.value==""){
						console.log("no value");
					}else{
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
					if(message.value==""){
						console.log("no value");
					}else{
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

	}
};


getAllBidders()
	.then((data) => {
		console.log(data);
		showBidders(data);
	})
	.catch((err) => { });




