     ///////////////////////// select box 설정 (지역, 매매기간) /////////////////////////
      let date = new Date();
      const root = "../";
      
      var container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
      var options = { // 지도를 생성할 때 필요한 기본 옵션
      	center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표.
      	level: 3 // 지도의 레벨(확대, 축소 정도)
      };

      var map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
      
      window.onload = function () {
        let yearEl = document.querySelector("#year");
        let yearOpt = `<option value="">매매년도선택</option>`;
        let year = date.getFullYear();
        for (let i = year; i > year - 20; i--) {
          yearOpt += `<option value="${i}">${i}년</option>`;
        }
        yearEl.innerHTML = yearOpt;

        // 브라우저가 열리면 시도정보 얻기.
        console.log(root);

    	var dic ={}
    	dic["key"] = "sidoNames";
    	console.log(dic);
        sendRequest("sido", dic);
        // sendRequest("sido",);
      };

      document.querySelector("#year").addEventListener("change", function () {
        let month = date.getMonth() + 1;
        let monthEl = document.querySelector("#month");
        let monthOpt = `<option value="">매매월선택</option>`;
        let yearSel = document.querySelector("#year");
        let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
        for (let i = 1; i < m; i++) {
          monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
        }
        monthEl.innerHTML = monthOpt;
      });

      // https://juso.dev/docs/reg-code-api/
      // let url =
		// "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      // let regcode = "*00000000";
      // 전국 특별/광역시, 도
      // https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

      // 시도가 바뀌면 구군정보 얻기.
      document.querySelector("#sido").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";

      	const sidoDiv = document.querySelector("#sido");
      	const sidoName = sidoDiv[sidoDiv.selectedIndex].value;
	      	var dic ={}
	      	dic["key"] = "gugunNames";
	      	dic["sidoName"] = sidoName;
          sendRequest("gugun", dic);
        } else {
          initOption("gugun");
          initOption("dong");
        }
      });

      // 구군이 바뀌면 동정보 얻기.
      document.querySelector("#gugun").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
// let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
        	const sidoDiv = document.querySelector("#sido");
        	const sidoName = sidoDiv[sidoDiv.selectedIndex].value;
        	const gugunName = this[this.selectedIndex].value;
        	
        	var dic ={}
        	dic["key"] = "dongNames";
        	dic["sidoName"] = sidoName
        	dic["gugunName"] = gugunName;
          sendRequest("dong", dic);
        } else {
          initOption("dong");
        }
      });

//      function sendRequest(selid, param) {
//    	  console.log(location);
//    	  const url = root+"ajax/"+param["key"];
//    	  console.log('u',url);
//        fetch(url,{
//        	method : "post",
//        	body : param
//        })
//          .then((response) => response.json())
//          .then((data) => addOption(selid, data));
//      }
      
      function sendRequest(selid, param) {
       	  console.log(location);
       	  const url = "../ajax/"+param["key"];
       	  console.log('u',url);
       	  console.log(JSON.stringify(param));
       	  
       	  var config={
       	           	method : "post",
       	            headers: {
       	                'Content-Type': 'application/json'
       	            },
       	           	body : JSON.stringify(param)
       	           };
       	  
       	  if(param["key"]=="sidoNames"){
       		  config = {
       	           	method : "get",
       	           }
       	  }
       	  
       	  console.log(param["key"]=="sidoNames")

           fetch(url,config)
             .then((response) => response.json())
             .then((data) =>{
             console.log(data);
             addOption(selid, data);
      		});
       	  
         
      }
      

      function addOption(selid, data) {
        let opt = ``;
        initOption(selid);
        console.log(data);
        switch (selid) {
          case "sido":
            opt += `<option value="">시도선택</option>`;
            opt += data.reduce((cur,val)=>{
            	return cur + `
                  <option value="${val}">${val}</option>
                  `
            },``);
            break;
          case "gugun":
            opt += `<option value="">구군선택</option>`;
            opt += data.reduce((cur,val)=>{
            	return cur + `
                  <option value="${val}">${val}</option>
                  `
            },``);
            break;
          case "dong":
            opt += `<option value="">동선택</option>`;
            opt += data.reduce((cur,val)=>{
            	return cur + `
                  <option value="${val.dongCode}">${val.dongName}</option>
                  `
            },``);
            break;
        }
        document.querySelector(`#${selid}`).innerHTML += opt;
      }

      function initOption(selid) {
        let options = document.querySelector(`#${selid}`);
        options.length = 0;
        // let len = options.length;
        // for (let i = len - 1; i >= 0; i--) {
        // options.remove(i);
        // }
      }

      // /////////////////////// 아파트 매매 정보 /////////////////////////
      document.querySelector("#list-btn").addEventListener("click", function () {
        
        const sidoSel = document.querySelector("#sido");
        console.log(sidoSel);
        const sido = sidoSel[sidoSel.selectedIndex].value;
        
        const gugunSel = document.querySelector("#gugun");
        const gugun = gugunSel[gugunSel.selectedIndex].value;
        
        const dongSel = document.querySelector("#dong");
        const dong = dongSel[dongSel.selectedIndex].value;
        
        console.log(sido, gugun, dong);
// const codeResult = fetch(codeUrl);
// let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
        const yearSel = document.querySelector("#year");
        const year = yearSel[yearSel.selectedIndex].value;
        const monthSel = document.querySelector("#month");
        const month = monthSel[monthSel.selectedIndex].value;
        console.log(year, month);
        
        var param ={};
        if(year=="" || month == ""){
        	param["fullCode"] = dong;
            
        }
        else{
	        param["fullCode"] = dong;
	        param["dealYear"] = year;
	        param["dealMonth"] = month;
        }
     	  var config={
     	           	method : "post",
     	            headers: {
     	                'Content-Type': 'application/json'
     	            },
     	           	body : JSON.stringify(param)
     	           };
     	  
        let url = "../ajax/searchHouseDealInfo" 
        console.log(url,JSON.stringify(param));
        fetch(url,config)
        	.then(res=>res.json())
        	.then(data=> makeList(data,sido));
        
// let queryParams =
// encodeURIComponent("serviceKey") + "=" +
// "bqzjqmyovq9%2BQFN5gASO%2BI2PwzuhStM%2BJIH6vrIlRqWi1%2F8remcuh%2FVzMs2JmVBaLedHx4c9jH98XCQ0xcv%2BZQ%3D%3D";
// /*Service Key*/
// queryParams +=
// "&" +
// encodeURIComponent("LAWD_CD") +
// "=" +
// encodeURIComponent(regCode); /*아파트소재 구군*/
// queryParams +=
// "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM);
// /*조회년월*/
// queryParams +=
// "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
// queryParams +=
// "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("30");
// /*페이지당건수*/
//
// fetch(`${url}?${queryParams}`)
// .then((response) => response.text())
// .then((data) => makeList(data));
      });

      function makeList(data,sido) {
    	console.log(data);
        document.querySelector("table").setAttribute("style", "display: ;");
        let tbody = document.querySelector("#aptlist");
// let parser = new DOMParser();
// const xml = parser.parseFromString(data, "application/xml");
        // console.log(xml);

        var dong= document.querySelector("#dong")
        var dongName=dong.options[dong.selectedIndex].textContent
        var aptName= document.querySelector("#aptName").value;

        initTable();
// let apts = xml.querySelectorAll("item");
        data.forEach(({apartName,floor,area,dong,dealAmount,lng,lat}) => {
          let tr = document.createElement("tr");

          console.log(apartName);
          if(true ){ 
        	  /*
				 * (apt.querySelector("법정동").textContent.includes(dongName) ||
				 * dongName=="동선택" )&& (aptName == "" ||
				 * apt.querySelector("아파트").textContent.includes(aptName))
				 */
        	  
	          let nameTd = document.createElement("td");
	          nameTd.appendChild(document.createTextNode(apartName));
	          nameTd.addEventListener('click', function(){
	        	  goToPoint(lat,lng);
	        	  subways(lat,lng,sido);
	          });
	          tr.appendChild(nameTd);
	          
	          let floorTd = document.createElement("td");
	          floorTd.appendChild(document.createTextNode(floor));
	          tr.appendChild(floorTd);
	
	          let areaTd = document.createElement("td");
	          areaTd.appendChild(document.createTextNode(area));
	          tr.appendChild(areaTd);
	
	          let dongTd = document.createElement("td");
	          dongTd.appendChild(document.createTextNode(dong));
	          tr.appendChild(dongTd);
	
	          let priceTd = document.createElement("td");
	          priceTd.appendChild( document.createTextNode(dealAmount + "만원"));
	          priceTd.classList.add("text-end");
	          tr.appendChild(priceTd);
          }
          tbody.appendChild(tr);
        });
        makeMap(data);
      }

      function initTable() {
        let tbody = document.querySelector("#aptlist");
        let len = tbody.rows.length;
        for (let i = len - 1; i >= 0; i--) {
          tbody.deleteRow(i);
        }
      }
      function makeMap(data) {
    	  let parser = new DOMParser();
    	  // console.log(data);
    	  // xml 파싱하는부분
// const xml = parser.parseFromString(data, "application/xml");
// let apts = xml.querySelectorAll("item");
// const sidoString = first_area[first_area.selectedIndex].textContent;
// const guString = sec_area[sec_area.selectedIndex].textContent;
// const selectedAddress = sidoString + " " + guString;

    	  // 너무 많이 가져오면 보이지 않아 15개만 찍음
    	  // 원하는 갯수만큼 for 수정하면됨
    	  
// const geocoder = new kakao.maps.services.Geocoder();
    	  data.forEach(({lng,lat})=>{
    		var coords = new kakao.maps.LatLng(lat, lng);
  	        console.log(coords); // 변환된 자표

  	        // 결과값으로 받은 위치를 마커로 표시합니다
  	        var marker = new kakao.maps.Marker({
  	          map: map,
  	          position: coords,
  	        });

  	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
  	        map.setCenter(coords);
    	  });
    	  /*
			 * for (let i = 0; i < apts.length; i++) { const apt = apts[i]; //
			 * 지번 법정동 아파트는 xml 에서 추출한 데이터 로부터 가져옴 // 나머지는 select 테그에서 가져옴 시, 구 ,
			 * 동은 select에서 안가져옴 let jibun = apt.hasAttribute("지번") ?
			 * apt.querySelector("지번").textContent : ""; let address =
			 * `${selectedAddress} ${ apt.querySelector("법정동").textContent }
			 * ${jibun} ${apt.querySelector("아파트").textContent}`;
			 * console.log(address); // 디버깅 geocoder.addressSearch(address,
			 * function (result, status) { if (status ===
			 * kakao.maps.services.Status.OK) { var coords = new
			 * kakao.maps.LatLng(result[0].y, result[0].x); console.log(coords); //
			 * 변환된 자표
			 *  // 결과값으로 받은 위치를 마커로 표시합니다 var marker = new kakao.maps.Marker({
			 * map: map, position: coords, });
			 *  // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 map.setCenter(coords); } }); }
			 */
    	}
      
      function goToPoint(lat,lng){
    	  var moveLatLon = new kakao.maps.LatLng(lat,lng);
    	  map.panTo(moveLatLon);
      }
      function subways(lat,lng,sido){
          let url = root+"ajax?command=searchSubway"+`&lat=`+lat+`&lng=`+lng+`&sido=`+sido; 
          console.log("subway url ="+url);
          fetch(url)
          	.then(res=>res.json())
          	.then(data=> compareLength(lat,lng,data));
      }
      
      function compareLength(lat,lng,data){
          data.forEach(({kakaoBunji}) => {
        	  var geocoder = new kakao.maps.services.Geocoder();
// console.log(lat +"/"+lng+"/"+ kakaoBunji);
        	  
        	  geocoder.addressSearch(kakaoBunji, function(result, status) {
      		    // 정상적으로 검색이 완료됐으면
      		     if (status === kakao.maps.services.Status.OK) {
      		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					  var polyline=new kakao.maps.Polyline({
					    	/* map:map, */
						path : [
						new kakao.maps.LatLng(lat,lng),
						new kakao.maps.LatLng(result[0].y,result[0].x)
						],
					 strokeWeight: 2,
					 strokeColor: '#FF00FF',
					 strokeOpacity: 0.8,
					 strokeStyle: 'dashed'
					  });
					  if(polyline.getLength()<1000){
//					  console.log("길이"+polyline.getLength());
						  var marker = new kakao.maps.Marker({
							  	map:map,
							    position: coords
							});
						  marker.setMap(map);
					  }
      		    } 
      		});
        	  
          });
      }
      document.querySelector("#test").addEventListener("click", function () {
    	  var geocoder = new kakao.maps.services.Geocoder();
    	  
    	  geocoder.addressSearch('대전광역시 서구 둔산동 1420', function(result, status) {
    		  	console.log("geocoder 들어옴");
    		    // 정상적으로 검색이 완료됐으면
    		     if (status === kakao.maps.services.Status.OK) {

    		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
    		        console.log(result[0].y+"//"+result[0].x)
    		        // 결과값으로 받은 위치를 마커로 표시합니다
    		        var marker = new kakao.maps.Marker({
    		            map: map,
    		            position: coords
    		        });

    		        // 인포윈도우로 장소에 대한 설명을 표시합니다
    		        var infowindow = new kakao.maps.InfoWindow({
    		            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
    		        });
    		        infowindow.open(map, marker);

    		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    		        map.setCenter(coords);
    		    } 
    		});
      });
      
      