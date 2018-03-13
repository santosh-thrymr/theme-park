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
		}else if(value==''){
			$(this).closest('td').next('td').find('input').val('');
		}
		
	
	});
	$(document).on('keyup', '.annualPass', function() {
		var attrValue = $(this).attr('data-attr');
		var value = $(this).val();
		var calculatedValue;
		if(attrValue!='' && value!=''){
			calculatedValue=attrValue*value;
		$(this).closest('td').next('td').find('input').val(calculatedValue);
		}else if(value==''){
			$(this).closest('td').next('td').find('input').val('');
		}
		
	
	});
	$(document).on('keyup', '.single-entry', function() {
		var myk = $(this).attr('myk');
		var std = $(this).attr('std');
		var value = $(this).val();
		var nationality=$(".nationality").val();
		var calculatedValue;
		if((myk!='' || std!='') && value!=''){
			if(nationality !='' && nationality=='malaysian'){
				calculatedValue=myk*value;
			} else {
				calculatedValue=std*value;
			}
			
		$(this).closest('td').next('td').find('input').val(calculatedValue);
		}else if(value==''){
			$(this).closest('td').next('td').find('input').val('');
		}
		
	
	});
	$(document).on('change', '.nationality', function() {
		$(".single-entry").each(function(){
			var myk = $(this).attr('myk');
			var std = $(this).attr('std');
			var value = $(this).val();
			var nationality=$(".nationality").val();
			var calculatedValue;
			if((myk!='' || std!='') && value!=''){
				if(nationality !='' && nationality=='malaysian'){
					calculatedValue=myk*value;
				} else {
					calculatedValue=std*value;
				}
				
			$(this).closest('td').next('td').find('input').val(calculatedValue);
			}else if(value==''){
				$(this).closest('td').next('td').find('input').val('');
			}
		});
		
		
		//BigLondal Admission fee
		$(".adult-qua").each(function(){
			var myk = $(this).attr('myk');
			var std = $(this).attr('std');
			var value = $(this).val();
			var nextmyk=$(this).closest('td').next('td').find('input').attr('myk-kid');
			var nextstd=$(this).closest('td').next('td').find('input').attr('std-kid');
			var nextvalue=$(this).closest('td').next('td').find('input').val();
			var nationality=$(".nationality").val();
			console.log("nationality",nationality);
			var calculatedValue;
			var nextcalculatedValue;
			if((myk!='' || std!='') && value!=''){
				if(nationality !='' && nationality=='malaysian'){
					calculatedValue=myk*value;
				} else {
					calculatedValue=std*value;
				}
			}
			if((nextmyk!='' || nextstd!='') && nextvalue!=''){
				if(nationality !='' && nationality=='malaysian'){
					nextcalculatedValue=nextmyk*nextvalue;
				} else {
					nextcalculatedValue=nextstd*nextvalue;
				}
			}
			var finalCalculation;
			if(nextcalculatedValue!=null && calculatedValue!=null){
				finalCalculation=nextcalculatedValue+calculatedValue;			
			}else if(nextcalculatedValue!=null && calculatedValue==null){
				finalCalculation=nextcalculatedValue;
			}else{
				finalCalculation=calculatedValue;
			}
			
			if(finalCalculation!=''){
				$(this).closest('td').next('td').next('td').find('input').val(finalCalculation);
			}
			else{
				$(this).closest('td').next('td').next('td').find('input').val('');
			}
		});
		
		$(".kids-qua").each(function(){
			var myk = $(this).attr('myk-kid');
			var std = $(this).attr('std-kid');
			var value = $(this).val();
			var prevmyk=$(this).closest('td').prev('td').find('input').attr('myk');
			var prevstd=$(this).closest('td').prev('td').find('input').attr('std');
			var prevvalue=$(this).closest('td').prev('td').find('input').val();
			var nationality=$(".nationality").val();
			var calculatedValue;
			var prevcalculatedValue;
			if((myk!='' || std!='') && value!=''){
				if(nationality !='' && nationality=='malaysian'){
					calculatedValue=myk*value;
				} else {
					calculatedValue=std*value;
				}
			}
			if((prevmyk!='' || prevstd!='') && prevvalue!=''){
				if(nationality !='' && nationality=='malaysian'){
					
					prevcalculatedValue=prevmyk*prevvalue;
				} else {
					prevcalculatedValue=prevstd*prevvalue;
				}
			}
			var finalCalculation;
			if(prevcalculatedValue!=null && calculatedValue!=null){
				finalCalculation=prevcalculatedValue+calculatedValue;
				
			}else if(prevcalculatedValue!=null && calculatedValue==null){
				finalCalculation=prevcalculatedValue;
				
			}else{
				finalCalculation=calculatedValue;
			}
			
			if(finalCalculation!=''){
				$(this).closest('td').next('td').find('input').val(finalCalculation);
			}
			else{
				$(this).closest('td').next('td').find('input').val('');
			}
			
		});
		
      
	});
	
	$(document).on('keyup', '.adult-qua', function() {
		var myk = $(this).attr('myk');
		var std = $(this).attr('std');
		var value = $(this).val();
		var nextmyk=$(this).closest('td').next('td').find('input').attr('myk-kid');
		var nextstd=$(this).closest('td').next('td').find('input').attr('std-kid');
		var nextvalue=$(this).closest('td').next('td').find('input').val();
		var nationality=$(".nationality").val();
		var calculatedValue;
		var nextcalculatedValue;
		if((myk!='' || std!='') && value!=''){
			if(nationality !='' && nationality=='malaysian'){
				calculatedValue=myk*value;
			} else {
				calculatedValue=std*value;
			}
		}
		if((nextmyk!='' || nextstd!='') && nextvalue!=''){
			if(nationality !='' && nationality=='malaysian'){
				nextcalculatedValue=nextmyk*nextvalue;
			} else {
				nextcalculatedValue=nextstd*nextvalue;
			}
		}
		var finalCalculation;
		if(nextcalculatedValue!=null && calculatedValue!=null){
			finalCalculation=nextcalculatedValue+calculatedValue;			
		}else if(nextcalculatedValue!=null && calculatedValue==null){
			finalCalculation=nextcalculatedValue;
		}else{
			finalCalculation=calculatedValue;
		}
		
		if(finalCalculation!=''){
			$(this).closest('td').next('td').next('td').find('input').val(finalCalculation);
		}
		else{
			$(this).closest('td').next('td').next('td').find('input').val('');
		}
	
	});
	$(document).on('keyup', '.kids-qua', function() {
		var myk = $(this).attr('myk-kid');
		var std = $(this).attr('std-kid');
		var value = $(this).val();
		var prevmyk=$(this).closest('td').prev('td').find('input').attr('myk');
		var prevstd=$(this).closest('td').prev('td').find('input').attr('std');
		var prevvalue=$(this).closest('td').prev('td').find('input').val();
		var nationality=$(".nationality").val();
		var calculatedValue;
		var prevcalculatedValue;
		if((myk!='' || std!='') && value!=''){
			if(nationality !='' && nationality=='malaysian'){
				calculatedValue=myk*value;
			} else {
				calculatedValue=std*value;
			}
		}
		if((prevmyk!='' || prevstd!='') && prevvalue!=''){
			if(nationality !='' && nationality=='malaysian'){
				
				prevcalculatedValue=prevmyk*prevvalue;
			} else {
				prevcalculatedValue=prevstd*prevvalue;
			}
		}
		var finalCalculation;
		if(prevcalculatedValue!=null && calculatedValue!=null){
			finalCalculation=prevcalculatedValue+calculatedValue;
			
		}else if(prevcalculatedValue!=null && calculatedValue==null){
			finalCalculation=prevcalculatedValue;
			
		}else{
			finalCalculation=calculatedValue;
		}
		
		if(finalCalculation!=''){
			$(this).closest('td').next('td').find('input').val(finalCalculation);
		}
		else{
			$(this).closest('td').next('td').find('input').val('');
		}
	
	});
	
	$(document).on('change', '.nationality', function() {
		

	});
	
         });
// ]]>
