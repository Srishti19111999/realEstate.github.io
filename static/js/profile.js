const add= document.getElementById('add');
add.addEventListener('click',e=>{
    $("#profilepicmodal").modal('show');
});


const showProperties = (properties,lat,lng) => {
    if (properties.length > 0) {
        cont_all_prop.innerHTML = '';
        let i = 0;
        console.log("---",properties);
        properties.forEach((property) => {
            console.log(property);
            if(Math.floor(lat)==Math.floor(property.latitude)&&Math.floor(lng)==Math.floor(property.longitude)){
              i=1;
                cont_all_prop.innerHTML += `<div class="card col-sm-5 mt-2 ml-2" style="box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
          <img src="property_image.do?property_id=${property.propertyId}" alt="" style="height: 250px;" class="card-header">
          <div class="card-body">
          
              <div class="row">
                <h2 class="col-12 col-sm-12">${property.propertyName}</h2>
                <h5 class="col-12 col-sm-4">Type</h5>
                <h6 class="col-12 col-sm-8" style="color:#606060">${property.propertyType.propertyType}</h6>
                <h5 class="col-12 col-sm-4">For</h5>
                <h6 class="col-12 col-sm-8" style="color:#606060">${property.propertyFor.forType}</h6>
                <h5 class="col-12 col-sm-4">Price</h5>
                <h6 class="col-12 col-sm-3" style="color:#606060">&#8377 ${property.propertyPrice}</h6>
                <p class="col-12 col-sm-5" style="color:#606060">&#8377 ${property.perPrice} per sq/ft.</p>
                <h5 class="col-12 col-sm-4">Area</h5>
                <h6 class="col-12 col-sm-7" style="color:#606060">${property.propertyArea} sq.ft.</h6>
                <a class="btn btn-block btn-primary" href="viewproperty.do?property_id=${property.propertyId}" role="button">See Details..</a>
              </div>
           
        </div>
        </div>`;
        }})
        if(i==0) {
          cont_all_prop.innerHTML += `<div class="alert alert-danger alert-dismissible fade show mt-5 mb-7" role="alert" id="myAlert">
        <center>
          <h4 class="alert-heading">Ooops!</h4>
          <strong>No Near By property Found</strong>
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hih4en="true">&times;</span>
          </button>
        </center>
        </div>`;
        }
} else {
  cont_all_prop = `<div class="alert alert-danger alert-dismissible fade show mt-5 mb-7" role="alert" id="myAlert">
<center>
  <h4 class="alert-heading">Ooops!</h4>
  <strong>No Near By property Found</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hih4en="true">&times;</span>
  </button>
</center>
</div>`;
}
};


const items = document.querySelectorAll(".dropdown-item");
var by_items= Array.from(items);
const input_by = document.querySelector("#by");
by_items.forEach((item)=>{
    item.addEventListener('click',by=>{
        console.log(by.target.innerText);
        input_by.value = by.target.innerText;
    });
});

const arrow = document.querySelector("#fa-arrow-right");
const search = document.querySelector("#search");

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


