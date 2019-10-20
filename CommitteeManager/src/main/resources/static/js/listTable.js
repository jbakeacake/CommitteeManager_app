const addComm = (comm) => {
	var titleStr = $(comm.title).val();
	var numberStr = $(comm.number).val();
	var typeStr = $(comm.type).val();
	var memberStr = $(comm.member).val();
	var startStr = $(comm.start).val();
	var endStr = $(comm.end).val();
	
	$.ajax({
		method: "GET",
		url: "/ajax/committee/add",
		cache: false,
		data: {
			title: titleStr,
			number: numberStr,
			type: typeStr,
			member: memberStr,
			start: startStr,
			end: endStr
		}
	})
	.done(function(txt) {
		$("#commTable").html(txt);
	})
	.fail(function(jqXHR, err) {
		alert("Request Failed: " + err + " : " + jqXHR.responseText);
	});
}

// This AJAX request will populate the table whenever the document loads (on ready)
$(document).ready(function() {
  //Once ready, populate tables:
  $.ajax({
    method: "GET",
    url: "/ajax/committee/list",
    cache: false,
  })
  .done(function(txt) {
	  $("#commTable").html(txt);
  })
  .fail( function(jqXHR, err) {
	  alert( "Request failed: " + err +" : "+jqXHR.responseText );
  });
  
  $("#btn_addComm").on("click", () =>{
	  //TODO : Add Validity Checks
	  var comm = {
			  title : "#mod_txtTitle",
			  number : "#mod_txtNum",
			  type : "#mod_txtType",
			  member : "#mod_txtMember",
			  start : "#mod_txtStart",
			  end : "#mod_txtEnd",
	  };
	  addComm(comm);
	  $('.modal-backdrop').remove();
	  $("#addMod").modal('toggle');
	  return false;
  });
  
});
