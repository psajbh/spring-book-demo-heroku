const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hours = date.getHours();
    const minutes = date.getMinutes();
    
    document.getElementById("current_date").value = 
        	month + "/" + day + "/" + year;
    
    document.getElementById("gameId").value = hours + "." + minutes; 
    
    document.getElementById("save_total_scores").style.visibility = 'hidden';
        
	function findTotalForUser1(){
 		var element = document.getElementById("player1");
 		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}
		
	    var arr = document.getElementsByName('user_1');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
        	
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
            	 rvTot += 1;
              }
          }
        }
        document.getElementById('user_1_tot').value = tot;
        document.getElementById('rv_1_tot').value = rvTot;
      }

    function findTotalForUser2(){
    	var element = document.getElementById("player2");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}
		
        var arr = document.getElementsByName('user_2');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
             	 rvTot += 1;
               }
          }
        }
        document.getElementById('user_2_tot').value = tot;
        document.getElementById('rv_2_tot').value = rvTot;
      }

      function findTotalForUser3(){
      	var element = document.getElementById("player3");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}

        var arr = document.getElementsByName('user_3');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
              	 rvTot += 1;
              }
          }
        }
        document.getElementById('user_3_tot').value = tot;
        document.getElementById('rv_3_tot').value = rvTot;
      }

      function findTotalForUser4(){
      	var element = document.getElementById("player4");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}

        var arr = document.getElementsByName('user_4');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
               	 rvTot += 1;
               }
          }
        }
        document.getElementById('user_4_tot').value = tot;
        document.getElementById('rv_4_tot').value = rvTot;
      }

      function findTotalForUser5(){
      	var element = document.getElementById("player5");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}

        var arr = document.getElementsByName('user_5');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
                 rvTot += 1;
              }
          }
        }
        document.getElementById('user_5_tot').value = tot;
        document.getElementById('rv_5_tot').value = rvTot;
      }

      function findTotalForUser6(){
      	var element = document.getElementById("player6");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}

        var arr = document.getElementsByName('user_6');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
                  rvTot += 1;
               }
          }
        }
        document.getElementById('user_6_tot').value = tot;
        document.getElementById('rv_6_tot').value = rvTot;
      }

      function findTotalForUser7(){
      	var element = document.getElementById("player7");
		if (typeof element !== "undefined" && element.value == '') {
			return; 
 		}

        var arr = document.getElementsByName('user_7');
        var tot=0;
        var rvTot = 0;
        for(var i=0;i<arr.length;i++){
          if(parseInt(arr[i].value)){
              tot += parseInt(arr[i].value);
              if (-1 == parseInt(arr[i].value)){
                  rvTot += 1;
               }
          }
        }
        document.getElementById('user_7_tot').value = tot;
        document.getElementById('rv_7_tot').value = rvTot;

      }
    
      //not being used currently, conflicts with Enter key
/*       function onlyNumberKey(evt) {
    	  alert("caller is " + onlyNumberKey.caller);
    	  var hyphen = 0;
          var ASCIICode = (evt.which) ? evt.which : evt.keyCode;
          
          if (ASCIICode == 45){
        	  hyphen++;
          }
          else if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57)){
        	  return false; 
          }
          
          if (hyphen > 1){
        	  return false;
          }
          return true;
      }
 */      
      function showElement() {
    	  element = document.querySelector('.save');
    	  element.style.visibility = 'visible';
      }
    	   
      function hideElement() {
      	  element = document.querySelector('.save');
    	  element.style.visibility = 'hidden';
   	  }
   	  
   	  function showAnalytics() {
   	  	window.open('../../analytics/games/spinners/index', '_blank');
   	  }

   	  