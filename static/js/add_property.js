const form = document.forms;
const property_titles = document.querySelectorAll('.property_title');
const property_id = document.querySelector("#property_id");
//-------------------------------------------------------------------
const propCity = document.querySelector('#propCity');
const city_id = document.querySelector("#city_id");
const state_id = document.querySelector("#state_id");
const state = document.querySelector("#state");
const country_id = document.querySelector("#country_id");
const country = document.querySelector("#country");
const srch_res = document.querySelector('#scrh_res');

const add_more_feature = document.querySelector('#add_more_feature');
const add_feature = document.querySelector('#add_feature');

const add_more_pics = document.querySelector('#add_more_pics');
const add_pics = document.querySelector('#add_pics');



//----------------------------------------------------------------------------

add_more_pics.addEventListener('click',()=>{
	const divi = document.createElement('div');
	const inp = document.createElement('input');
	const ii = document.createElement('i');

	divi.className = "form-group row mt-2";
	divi.id = "add_pics";

	inp.className = "form-control offset-md-1 col-md-8 pics";
	inp.type = "file";
	inp.id = "propPics";
	inp.name = "propPics";

	ii.style.fontSize = "30px";
	ii.id = "add_more_pics";
	ii.className = "fa fa-times col-md-2";

	divi.appendChild(inp);
	divi.appendChild(ii);

	form[3].insertBefore(divi,add_pics);

	ii.addEventListener('click',()=>{
		form[3].removeChild(ii.parentElement);
	});

});


add_more_feature.addEventListener('click',()=>{
	const divi = document.createElement('div');
	const inp = document.createElement('input');
	const ii = document.createElement('i');

	divi.className = "form-group row mt-2";
	divi.id = "add_feature";

	inp.className = "form-control offset-md-1 col-md-8 well well-sm features";
	inp.type = "text";
	inp.id = "propFeatures";
	inp.name = "propFeatures";

	ii.style.fontSize = "30px";
	ii.id = "add_more_feature";
	ii.className = "fa fa-times col-md-2";

	divi.appendChild(inp);
	divi.appendChild(ii);

	form[2].insertBefore(divi,add_feature);

	ii.addEventListener('click',()=>{
		form[2].removeChild(ii.parentElement);
	});

});


propCity.addEventListener('keyup',(ev)=>{
    
    let skey = propCity.value;
    console.log(skey);
    
	if(skey.length>2){
		getCities('city_search.do?skey='+skey)
			.then((data)=>{
				console.log('Data:',data);
				srch_res.innerHTML = '';

				for(i=0;i<data.length;i++){
					let dv = document.createElement('div');
					dv.innerHTML = data[i].city;
					dv.innerHTML += ",";
					dv.innerHTML += data[i].state.state;
					dv.innerHTML += ",";
					dv.innerHTML += data[i].state.country.country;


					dv.cityId = data[i].cityId;
					dv.stateId = data[i].state.stateId;
					dv.countryId = data[i].state.country.countryId;
					dv.city =  data[i].city;
					dv.state = data[i].state.state;
					dv.country = data[i].state.country.country;



					dv.addEventListener('click',(e)=>{
						console.log(e);
						propCity.value = e.target.innerHTML;
						city_id.value = e.target.cityId;
						state.value = e.target.state;
						state_id.value = e.target.stateId;
						country.value = e.target.country;
						country_id.value = e.target.countryId;

                        srch_res.style.display = 'none';
                        srch_res.set = '1px solid black';
					});
					srch_res.append(dv);
				}
				
				srch_res.style.display = 'block';
			})
			.catch((err)=>{
				console.log('Error:',err);
			});
	}else{
		srch_res.style.display = 'none';
	}
});

const getCities = async (url)=>{
	const response = await fetch(url);	
	
	if(response.status!=200){
		throw new Error('No Records Found....');
	}
	
	const data = await response.json();

	return data;
};
//-------------------------------------------------------------------


const savePropertyNextStep = async (request) => {	

	const response = await fetch(request,{method:'post'});
	const data = await response.json();

	return data;
};

//----------------------------------------------------------------------


form[2].addEventListener('submit',(e)=>{
	e.preventDefault();

	const url = 'save_property_features.do?';

	const features = Array.from(document.querySelectorAll('.features'));

	let query = '';
	let i = 0;
	features.forEach((feature)=>{
		if(i==0)
			query += `prop_feature=${feature.value}`;
		else
			query += `&prop_feature=${feature.value}`;
		i++;
	});


	savePropertyNextStep(url+query)
		.then((data)=>{
			if(data.resp==1){
				form[2].style.display="none";
                form[3].style.display="block";
			}else{
			
			}
		})
		.catch((err)=>{
			console.log(err);
		});
});


form[1].addEventListener('submit',e=>{
	e.preventDefault();

	function callbackFn(result) {
		console.log(result.results[0].position.lat);
		console.log(result.results[0].position.lng);
		const url =`save_property_other_details.do?`;
		const query = `propAddress=${form[1].propAddress.value}&propCity=${form[1].propCity.value}&city_id=${form[1].city_id.value}&state=${form[1].state.value}&state_id=${form[1].state_id.value}&country_id=${form[1].country_id.value}&country=${form[1].country.value}&description=${form[1].description.value}&property_id=${property_id.value}&lat=${result.results[0].position.lat}&lng=${result.results[0].position.lng}`;
	
		savePropertyNextStep(url+query)
			.then((data)=>{
				console.log(data);
				if(data.resp===1){
					form[1].style.display="none";
					form[2].style.display="block";
				}else if(data.resp===0){
	
				}else{
					window.location = 'signin.do';
				}
			}).catch((err)=>{
				console.log(err);
			});
	  };

	  tt.services.geocode({
		key: "GmgYGsqvP3JJQVKZ5PrcJUCdltJ8qUpw",
		query: `${form[1].propAddress.value}`,
		ext: "json"
	  })
	  .go()
	  .then(callbackFn);
});
//--------------------------------------------------------------------------------------------------
form[0].addEventListener('submit',(e)=>{
    e.preventDefault();
    const url =`new_property.do?`;
    const query = `sell_rent=${form[0].sell_rent.value}&prpty_type=${form[0].prpty_type.value}&prpty_status=${form[0].prpty_status.value}&propName=${form[0].propName.value}&propPerPrice=${form[0].propPerPrice.value}&proptotalPrice=${form[0].proptotalPrice.value}&propArea=${form[0].propArea.value}`;

    savePropertyNextStep(url+query)
        .then((data)=>{
            console.log(data);
            if(data.propertyId){
                console.log(data);
				property_id.value = data.propertyId;
				console.log(property_id.value) 
                form[0].style.display="none";
                form[1].style.display="block";
                const pro_titles = Array.from(property_titles);
				pro_titles.forEach((title)=>{
					title.innerHTML = data.propertyName;
				});
            }
        }).catch((err)=>{
            console.log(err);
        });
});