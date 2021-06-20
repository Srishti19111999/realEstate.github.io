
const user_property_propId = document.querySelector("#user_property_propId");
const cont_all_prop = document.querySelector("#cont_all_prop");
var colors = ["#ffe6e6", "#e6f7ff", "#e6ffee", "#ffffe6"];

const showProperties = (properties) => {
	if (properties.length > 0) {

		cont_all_prop.innerHTML = '';
		let i = 0;
		console.log(user_property_propId.value);

		properties.forEach((property) => {
		console.log(property.propertyId);

			if(user_property_propId.value == property.propertyId){
				return;
			}else{
			cont_all_prop.innerHTML += `<div class="card col-12 col-md-10 offset-md-1 mt-2" style="background-color: ` + colors[i] + `; box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
				<div class="card-body">
				<div class="row">
					<img src="property_image.do?property_id=${property.propertyId}" alt="" class="col-3 col-md-3 mt-3">

					<div class="col-9 col-md-9">
					<div class="row">
					
						<h2 class="col-10 col-md-10">${property.propertyName}</h2>
						 
					</div>	  
					<hr>
					<h4 style="color:#606060">${property.propertyType.propertyType} <em>in</em> ${property.city.city} </h4>

					<div class="row mt-4">
						<p style="margin-left:2em;">For :</p> <h5 class="col-4 col-md-2"> ${property.propertyFor.forType}</h5>
						<p>Price : </p><h5 class="col-4 col-md-4"> &#8377 ${property.propertyPrice}</h5>  
						<h6 class="col-4 col-md-4 mt-1" style="color:#606060">${property.perPrice} <em style="font-size:14px;">per sq/ft.</em></h6> 
					</div>
					<div class="row">
						<h6 style="margin-left:1em;" class=" col-8 col-sm-8">Area Covered : ${property.propertyArea} <em style="font-size:14px;">sq.ft.</em></h6>  
						
						<a class="btn btn-link" href="viewproperty.do?property_id=${property.propertyId}" role="button">See Details..</a>
					</div>
				</div>
			</div>
				</div>
				<div class="card-footer">
							<button  data-bb="${property.propertyId}" class="btn btn-sm  offset-sm-7 text-white" id="bid" style="background-color:#66B032;"><i class="fa fa-hand-paper-o"></i> Bid </button>
							<button data-atwb="${property.propertyId}" class="btn btn-sm btn-info text-white ml-2 " role="button" id="wishlist"  style="background-color:#C62168;"><i class="fa fa-heart-o"></i>Add to Wishlist</button>
							<button data-bnb="${property.propertyId}" class="btn btn-sm bg-dark text-white ml-2"  id="buy"><i class="fa fa-money"></i> Buy Property</button>
				</div>
		  </div>

		  <div id="bidmodal" class="modal fade" role="dialog">
		  <div class="modal-dialog modal-sm" role="content"  id="bidform" >
			  <!-- Modal content-->
			  <div class="modal-content">
				  <div class="modal-header" style="  background: linear-gradient(to bottom, #476cd1 0%, #03024b 100%);">                      
					  <h4 class="modal-title ml-2 text-white ">Bid</h4>
					  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  </div>
				  <div class="modal-body col-12 ">
					  
						  <div class="form-group row">
							  <label class="col-xs-10 offset-sm-1 col-form-lable bid-lable align-self-center"
								  for="bid"><b>Enter Amount(in Rs)</b></label>
							  <div class="col-sm-10 ml-2">
								  <input type="text" class="form-control" name="bid_amount" id="bid_amount">
							  </div>
						  </div>
						  <div class="form-group row ">
							  <div class="col-12 mt-2">
								  <button type="submit" data-bb="${property.propertyId}" data-dismiss="modal" id="bidsubmit" class="btn  btn-block btn-primary">Submit</button>
							  </div>
						  </div>
				  </div>
			  </div>
		  </div>
	  </div>
`;
			}

			if (i == 3)
				i = 0;
			else
				i++;
			
		});


		const buy = Array.from(document.querySelectorAll("#buy"));
		const wishlist = Array.from(document.querySelectorAll("#wishlist"));
		

		wishlist.forEach((atwb) => {
			console.log(atwb);
			atwb.addEventListener('click', e => {
				
				e.target.disabled = true;
				let propertyId = e.target.getAttribute('data-atwb');
				addToWishlist(propertyId)
					.then((data) => {
						e.target.innerHTML = "<i class='fa fa-heart'>Added to wishlist";
					}).catch((err) => {

					});
			});
		});

		const addToWishlist = async (propertyId) => {

			const url = 'addToWishlist.do?';
			const param = `property_id=${propertyId}`;

			const response = await fetch(url + param);
			const data = await response.json();

			return data;
		};



        const bid = Array.from(document.querySelectorAll("#bid"));
        const bidsubmit = Array.from(document.querySelectorAll("#bidsubmit"));

        console.log(bid);
        $('#bid').click(function(){
            $('#bidmodal').modal('show');
            $('#bid').prop('disabled',true);
            $('#bid').html("Added in your bids");
        });


        bidsubmit.forEach((atbb) => {
            console.log(atbb);
            atbb.addEventListener('click', e => {
                console.log(e);
                
                let propertyId = e.target.getAttribute('data-bb');
                let bid_amt = document.querySelector("#bid_amount").value;
                console.log(bid_amt);
                addToBid(propertyId,bid_amt)
                    .then((data) => {
                        console.log(data);
                       
                       bid.innerHTML = "<i class='fa fa-paper-hand'>Added in your Bids";
                    }).catch((err) => {

                    });
            });
        });



        const addToBid = async (propertyId,bid_amt) => {

            const url = 'addToBid.do?';
            const param = `property_id=${propertyId}&bid_amt=${bid_amt}`;

            const response = await fetch(url + param);
            const data = await response.json();

            return data;
        };




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

const search_key = document.querySelector("#search_key");
const by = document.querySelector("#by");
const city = document.querySelector("#city");
const type = document.querySelector("#type");
const price = document.querySelector("#price");



const allProperties = async () => {
	const url = 'search.do?';
	const query = `search=${search_key.value}&by=${by.value}&city=""&type=0&price=0`;

	const response = await fetch(url + query);
	const data = await response.json();

	return data;
};

const allPropertiesIndex = async () => {
	console.log("ohyesss");
	const url = 'search.do?';
	const query = `city=${city.value}&type=${type.value}&price=${price.value}&search=""&by=""`;

	const response = await fetch(url + query);
	const data = await response.json();

	return data;
};

window.addEventListener('load', (e) => {

	if(search_key.value=="null"){
		console.log("yes");
		allPropertiesIndex()
		.then((data) => {
			showProperties(data);
		})
		.catch((err) => { });
	}
	else{allProperties()
		.then((data) => {
			showProperties(data);
		})
		.catch((err) => { });
	}
});



const itemss = document.querySelectorAll(".dropdown-item");
var by_items = Array.from(itemss);
const input_by = document.querySelector("#by");
by_items.forEach((item) => {
	item.addEventListener('click', by => {
		
		input_by.value = by.target.innerText;
	});
});







//---------------------------------------------------------------------









//----------------------------------------------------------------------


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

