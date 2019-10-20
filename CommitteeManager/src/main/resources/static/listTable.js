// This AJAX request will populate the table whenever the document loads (on ready)
$(document).ready(function() {
  //Once ready, populate tables:
  $.ajax({
    method: "GET",
    url: "/ajax/committee/list",
    cache: false,
  })
  .done(function(txt) {
	  $("#bingo").html(txt);
  })
  .fail( function(jqXHR, err) {
	  alert( "Request failed: " + err +" : "+jqXHR.responseText );
  });
});
