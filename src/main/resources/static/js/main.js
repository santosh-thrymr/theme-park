// <![CDATA[
$(document).ready(function() {
	$("#datepicker").datepicker({
		autoclose : true,
		todayHighlight : true
	}).datepicker('update', new Date());
	// $(".country").chosen();
	var noOfChilds = $('#noOfChilds');
	var noOfAdults = $('#noOfAdults');
	var amount = $('.tobe-paid');
	var selTopup = $('#sel-topup');
	var topup = $('#topup');
	var totalAmount = 0;
	noOfChilds.blur(function() {
		if (noOfChilds.val() != '') {
			totalAmount += noOfChilds.val() * 100;
			amount.text("To be paid : " + totalAmount);
		}
	});
	noOfAdults.blur(function() {
		if (noOfAdults.val() != '') {
			totalAmount += noOfAdults.val() * 200;
			amount.text("To be paid : " + totalAmount);
		}
	});

	selTopup.on('change', function() {
		topup.val(selTopup.val());
	});

	$('.select-file').on('click', function() {
		$('#my_file').click();
	});

	$('#my_file').on('change', function(file) {
		if (file && file.target) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('.pro-pic').attr('src', e.target.result);
			}

			reader.readAsDataURL(file.target.files[0]);
		}
	});
	
	$(document).on('keypress', ".numberValidation", function(event) {
						return (event.which >= 48 && event.which <= 57)
					|| event.which == 46 || event.keyCode == 8
					|| event.keyCode == 46
					|| (event.keyCode >= 37 && event.keyCode <= 40)
					|| event.keyCode == 9;
	});
	
	$(document).on('keyup', '.entry-pkg', function() {
		var attrValue = $(this).attr('data-attr');
		var value = $(this).val();
		var calculatedValue;
		if(attrValue!='' && value!=''){
			calculatedValue=attrValue*value;
		$(this).closest('td').next('td').find('input').val(calculatedValue);
		console.log("vall",value);
		}else if(value==''){
			$(this).closest('td').next('td').find('input').val('');
		}
		
	
	});
	
});
// ]]>
