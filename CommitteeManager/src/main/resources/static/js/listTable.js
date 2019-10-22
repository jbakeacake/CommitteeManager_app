const fillUpdateForm = (id, title, number, type, member, start, end) => {
	$('#upmod_txtID').val(id);
	$('#upmod_txtTitle').val(title);
	$('#upmod_txtNum').val(number);
	$('#upmod_txtType').val(type);
	$('#upmod_txtMember').val(member);
	$('#upmod_txtStart').val(start);
	$('#upmod_txtEnd').val(end);
}

const fillIDonForm = (id) => {
	$('#deletemod_txtID').val(id);
}

const emptyForm = (formLbls) => {
	$(formLbls.title).val('');
	$(formLbls.number).val('');
	$(formLbls.type).val('');
	$(formLbls.member).val('');
	$(formLbls.start).val('');
	$(formLbls.end).val('');
}

const validateEntries = (entries) => {
	for(var key in entries) {
		if(entries[key] == "" || entries[key] === undefined) {
			return false;
		}
	}
	
	return true;
}

const removeComm = (comm) => {
	var idStr = $(comm.id).val();
	
	$.ajax({
		method: "GET",
		url: "/ajax/committee/remove",
		cache: false,
		data: { id: idStr }
	})
	.done(function(txt) {
		$("#commTable").html(txt);
	})
	.fail(function(jqXHR, err) {
		alert("Request Failed: " + err + " : " + jqXHR.responseText);
	});
}

const updateComm = (comm) => {
	var idStr = $(comm.id).val();
	var titleStr = $(comm.title).val();
	var numberStr = $(comm.number).val();
	var typeStr = $(comm.type).val();
	var memberStr = $(comm.member).val();
	var startStr = $(comm.start).val();
	var endStr = $(comm.end).val();
	
	var entries = {
			title: titleStr,
			number: numberStr,
			type: typeStr,
			member: memberStr,
			start: startStr,
			end: endStr
	}
	
	if(!validateEntries(entries)) {
		alert("Invalid entries. Please make sure you have entered ALL values.");
		return;
	}
	
	$.ajax({
		method: "GET",
		url: "/ajax/committee/update",
		cache: false,
		data: {
			id: idStr,
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

const addComm = (comm) => {
	var titleStr = $(comm.title).val();
	var numberStr = $(comm.number).val();
	var typeStr = $(comm.type).val();
	var memberStr = $(comm.member).val();
	var startStr = $(comm.start).val();
	var endStr = $(comm.end).val();
	
	var entries = {
			title: titleStr,
			number: numberStr,
			type: typeStr,
			member: memberStr,
			start: startStr,
			end: endStr
	}
	
	if(!validateEntries(entries)) {
		alert("Invalid entries. Please make sure you have entered ALL values.");
		return;
	}
	
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
		emptyForm(comm);
		$('.modal-backdrop').remove();
		$("#addMod").modal('toggle');
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
	  return false;
  });
  
  $("#btn_updateComm").on("click", () =>{
	  //TODO : Add Validity Checks
	  var comm = {
			  id : "#upmod_txtID",
			  title : "#upmod_txtTitle",
			  number : "#upmod_txtNum",
			  type : "#upmod_txtType",
			  member : "#upmod_txtMember",
			  start : "#upmod_txtStart",
			  end : "#upmod_txtEnd",
	  };
	  updateComm(comm);
	  $('.modal-backdrop').remove();
	  $("#updateMod").modal('toggle');
	  return false;
  });
  
  $("#btn_deleteComm").on("click", () => {
	  var comm = {
			  id: "#deletemod_txtID",
	  };
	  removeComm(comm);
	  $('.modal-backdrop').remove();
	  $("#deleteMod").modal('toggle');
  })
});
