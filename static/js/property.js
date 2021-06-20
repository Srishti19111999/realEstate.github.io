const property_id = document.querySelector('#property_id');
const pic_box = document.querySelector('#pic_box');

const getAllPropertyPics = async ()=>{
	const url = 'all_property_pics.do?';
	const params = `property_id=${property_id.value}`

	const response = await fetch(url+params);
	const data = await response.json();

	return data;
};

const showAllPics = (pics)=>{

	let i = 0;
	pics.forEach((pic)=>{
        let dv = document.createElement("div");
            let photo = document.createElement("img");
            photo.className = "d-block img-fluid";
            dv.className = "carousel-item";
            dv.appendChild(photo);
            pic_box.appendChild(dv);

		if(i==0){
            dv.className +=" active";   
        }
        photo.src = `property_pic.do?property_pic=${pic.propertyPic}`;
        i++;
	});
};

const prop_feat = document.querySelector('#prop-feat');

let p = 0;
const showAllPoints = (points)=>{
    let ool = document.createElement("ul");
	points.forEach((point)=>{
        let lii = document.createElement("li");  
        lii.innerHTML = point.descriptionPoint;
        ool.appendChild(lii);
    });
    prop_feat.appendChild(ool);
};

const getAllPropertyPoints = async ()=>{
	const url = 'all_property_points.do?';
	const param = `property_id=${property_id.value}`;

	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

window.addEventListener('load',()=>{
	getAllPropertyPics()
		.then((data)=>{
            console.log(data);
			showAllPics(data);
		})
		.catch((err)=>{
			console.log(err);
		});

	getAllPropertyPoints()
		.then((data)=>{
            console.log(data);
			showAllPoints(data);
		})
		.catch((err)=>{
		
		});
});





	var by_items= Array.from(document.querySelectorAll(".dropdown-item"));
	var input_by = document.querySelector("#by");
	by_items.forEach((item)=>{
		item.addEventListener('click',by=>{
			console.log(by.target.innerText);
			input_by.value = by.target.innerText;
		});
	});
	
	var arrow = document.querySelector("#fa-arrow-right");
	var search = document.querySelector("#search");
	
	arrow.addEventListener('click',()=>{
		 let searchKey = search.value;
		window.location = `search_result.jsp?search=${searchKey}&by=${input_by.value}`;
	});
	search.addEventListener("keyup", function(event) {
		if (event.keyCode === 13) {
			let searchKey = search.value;
			window.location = `search_result.jsp?search=${searchKey}&by=${input_by.value}`;
		}
	  });