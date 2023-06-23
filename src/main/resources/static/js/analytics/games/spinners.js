var myAnalyticsSpinnersTable = "";

$(document).ready( function (){
	console.log("executing ready function");
	//alert("inside js/analytics/games/spinners.js");
	myAnalyticsSpinnersTable = $('#SpinnersAnalyticsTable')
	.DataTable(
		{
			"autoWidth" : false,
			"serverSide" : false,
			"stateSave" : true,
			"language" : {"emptyTable" : "No results found."},
			"deferRender" : true,
	        "ajax" : {
	        	 "url" : "/spinnersAnalyticsTable",
	             "type" : "GET"
	         },
	        "sDom": 'B<"H"lfr>t<"F"ip>',
	        //"buttons" : getButtonConfig([CSV_BUTTON]),
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
				  //{ "data": "suuid", "visible" : false, "searchable" : false, "sortable" : false},
			      { "data": "player", "visible" : true, "searchable" : true, "sortable" : true },
		          { "data": "games", "visible" : true, "searchable" : true, "sortable" : true, "className": "text-center"},
				  { "data": "total_score", "visible" : true, "searchable" : true, "sortable" : true, "className": "text-center"},
				  { "data": "average_score", "visible" : true, "searchable" : true, "sortable" : true, "className": "text-center"},
				  { "data": "round_victories", "visible" : true, "searchable" : true, "sortable" : true, "className": "text-center"},
				  { "data": "wins", "visible" : true, "searchable" : true, "sortable" : true, "className": "text-center"}
			]
			
	 })
	 <!-- console.log("player313Metrics: " + player313Metrics); -->
});

