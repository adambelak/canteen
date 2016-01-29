$(document).ready(function() {
	$('body').on('hidden.bs.modal', '.modal', function() {
		$(this).removeData('bs.modal');
	});
	$('#alerts').bind("DOMSubtreeModified", function() {
		function isEmpty( el ){
			return !$.trim(el.html())
		}
		if (!isEmpty($('#alerts'))) {
			setTimeout(function() {
				$(".alert", $('#alerts')).each(function(element) {
					$(this).alert('close');
				});
				setTimeout(function() {
					$('#alerts').empty();
				}, 600);
			}, 3000);
		}
	});
});