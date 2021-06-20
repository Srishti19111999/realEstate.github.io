
const search = document.querySelector("#search_btn");


const prpty_type = document.querySelector('#prpty-type');

const propCity = document.querySelector('#propCity');
const city = document.querySelector('#city');
const city_id = document.querySelector("#city_id");
const state_id = document.querySelector("#state_id");
const state = document.querySelector("#state");
const country_id = document.querySelector("#country_id");
const country = document.querySelector("#country");
const srch_res = document.querySelector('#scrh_res');

var myRange = document.querySelector('#prpty-range');
var myValue = document.querySelector('#myValue');

var off = myRange.offsetWidth / (parseInt(myRange.max) - parseInt(myRange.min));
var px = ((myRange.valueAsNumber - parseInt(myRange.min)) * off) - (myValue.offsetParent.offsetWidth / 2);

myValue.parentElement.style.left = px + 'px';
myValue.parentElement.style.top = myRange.offsetHeight+30 + 'px';
myValue.innerHTML = myRange.value ;

myRange.oninput = function () {
    let px = ((myRange.valueAsNumber - parseInt(myRange.min)) * off) - (myValue.offsetWidth / 2);
    myValue.innerHTML = myRange.value ;
	myValue.parentElement.style.left = px + 'px';
	console.log(myRange.value);
};


search.addEventListener('click', () => {
	console.log(propCity.value);
    window.location = `search_result.jsp?search=${null}&by=${null}&city=${city.value}&type=${prpty_type.value}&price=${myRange.value}`;
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
						city.value =  e.target.city;
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

const getFilters = async () => {
    const url = 'get_filters.do';

    const response = await fetch(url);

    return response;
};

    getFilters()
        .then((data) => {
            console.log(data);
        })
        .catch((err) => {
			console.log(err);
		});
