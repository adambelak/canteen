$(document).ready(function() {
	$("input, select, textarea").change(function() {
		var $formGroup = $(this).closest(".form-group");
		if ($formGroup.hasClass("has-error")) {
			setTimeout(function(){
				$formGroup.removeClass("has-error");
				$(".help-block", $formGroup).text(" ");
			}, 1000);
		}
	});
	$( "form" ).submit(function( event ) {
		event.preventDefault();
		var $form = $( this ), 
			url = $form.attr( "action" );
	    $.ajax({
	           type: "POST",
	           url: url,
	           dataType : 'json',
	           data: $form.serialize(),
	           error: function(data) {
	        	   if (data.status == 200) {
					   var parser = new DOMParser(),
						   doc = parser.parseFromString(data.responseText, "text/html"),
						   pageContent = doc.getElementById("page-content").innerHTML,
	        		   	   alertContent = doc.getElementById("alerts").innerHTML;
	        		   $form.closest(".modal").modal("hide");
	        		   setTimeout(function() { 
	        			   $("#page-content").html(pageContent);
	        			   $("#alerts").html(alertContent);
	        		   }, 300);
	        	   }
	        	   if (data.status == 422 && data.responseJSON && data.responseJSON.fieldErrors) {
	        		   $.each(data.responseJSON.fieldErrors, function(i, value){
	        			   var groupIdSelector = "#input-" + value.field + "-group";
	        			   $(".help-block", groupIdSelector).html(value.message);
	        			   $(groupIdSelector).addClass("has-error");
		               });
				   }
	           }
         });
	});
});