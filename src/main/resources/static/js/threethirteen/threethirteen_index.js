   
    const date = new Date();
    year = date.getFullYear();
    month = date.getMonth() + 1;
    day = date.getDate();
    hours = date.getHours();
    minutes = date.getMinutes();
    
    /*
    var player1;
    var player2;
    var player3;
    var player4;
    var player5;
    var player6;
    var player7;
    */
    
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
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
              if (-5 == parseInt(arr[i].value)){
                  rvTot += 1;
               }
          }
        }
        document.getElementById('user_7_tot').value = tot;
        document.getElementById('rv_7_tot').value = rvTot;

      }
      
      function showElement() {
    	  element = document.querySelector('.save');
    	  element.style.visibility = 'visible';
      }
    	   
      function hideElement() {
      	  element = document.querySelector('.save');
    	  element.style.visibility = 'hidden';
   	  }
   	  
   	  function showAnalytics() {
   	  	window.open('../../analytics/games/threethirteen/index', '_blank');
   	  }
   	 
   	    	  
   	  /*
   	  function setPlayer1(select){
   	     player1 = select.options[selectedIndex].value;
   	     document.getElementById("player1").setValue(player1);
   	  }
   	  
   	 function getPlayer1(){
   	  	 return player1;
   	 }
   
     function setPlayer2(select){
   	     player2 = select.options[selectedIndex].value;
   	     document.getElementById("player2").setValue(player2);
   	  }
   	  
   	  function getPlayer2(){
   	  	return player2;
   	  }
   	  
     function setPlayer3(select){
   	     player3 = select.options[selectedIndex].value;
   	     document.getElementById("player3").setValue(player3);
   	  }
   	  
   	  function getPlayer3(){
   	  	return player3;
   	  }
   	  
     function setPlayer4(select){
   	     player4 = select.options[selectedIndex].value;
   	     document.getElementById("player3").setValue(player4);
   	  }
   	  
   	  function getPlayer4(){
   	  	return player4;
   	  }

     function setPlayer5(select){
   	     player5 = select.options[selectedIndex].value;
   	     document.getElementById("player3").setValue(player5);
   	  }
   	  
   	  function getPlayer5(){
   	  	return player5;
   	  }
   	  
     function setPlayer6(select){
   	     player6 = select.options[selectedIndex].value;
   	     document.getElementById("player6").setValue(player6);
   	  }
   	  
   	  function getPlayer6(){
   	  	return player6;
   	  }
   	  
     function setPlayer7(select){
   	     player7 = select.options[selectedIndex].value;
   	     document.getElementById("player7").setValue(player7);
   	  }
   	  
   	  function getPlayer7(){
   	  	return player7;
   	  }
   	  */