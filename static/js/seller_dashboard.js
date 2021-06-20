const all_props = document.querySelector("#all_props");
const usr_id = document.querySelector("#usr_id");
const cont_all_prop = document.querySelector("#cont_all_prop");
var colors = ["#ffe6e6", "#e6f7ff", "#e6ffee", "#ffffe6"];

const allProperty = async () => {
	const url = 'allproperty.do?';
	const query = `user_id=${usr_id.value}`;

	const response = await fetch(url + query);
	const data = await response.json();

	return data;
};


const showProperties = (properties) => {
	if (properties.length > 0) {
		cont_all_prop.innerHTML = '';
		let i = 0;
		properties.forEach((property) => {
			var bCount; var wCount;
			const getCounts = async () => {
				const url = 'get_counts.do?';
				const query = `property_id=${property.propertyId}`;

				const response = await fetch(url + query);
				const data = await response.json();

				return data;
			};
			getCounts().then((data) => {
				console.log(data);
				bCount = data.bCount;
				wCount = data.wCount;
				console.log(bCount)


				cont_all_prop.innerHTML += `<div class="card col-12 col-md-10 offset-md-1 mt-2" style="background-color: ` + colors[i] + `;">
						<div class="card-body">
							<div class="row">
								<img src="property_image.do?property_id=${property.propertyId}" alt="" class="col-3 col-md-3 mt-3">

								<div class="col-9 col-md-9">
								<div class="row">
									<h2 class="col-10 col-md-10">${property.propertyName}</h2>
									<i class="fa fa-trash col-1 col-md-1 offset-md-1" data-del="${property.propertyId}" style="font-size:20px;"></i> 
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
								<a href="get_all_bidders.jsp?property_id=${property.propertyId}"  id="bid" class="btn btn-sm  offset-sm-7 text-white" style="background-color:#66B032;"><i class="fa fa-hand-paper-o"> ${bCount} </i> Bids</a>
								<button class="btn btn-sm text-white ml-2" style="background-color:#C62168;"><i class="fa fa-heart"> ${wCount}</i> Wishlists</button>
								<button class="btn btn-sm bg-dark text-white ml-2">Edit Property</button>
						</div>
					</div>`;
							if (i == 3)
								i = 0;
							else
								i++;


								
		
const del_box = Array.from(document.querySelectorAll('.fa-trash'));

const deleteCartRecord = async (propertyId)=>{
	const url = 'delete_property.do?';
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
			}).catch((err) => { console.log(err); });
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

all_props.addEventListener('click', () => {

	allProperty()
		.then((data) => {
			showProperties(data);
		})
		.catch((err) => { });
});

allProperty()
	.then((data) => {
		showProperties(data);
	})
	.catch((err) => { });


