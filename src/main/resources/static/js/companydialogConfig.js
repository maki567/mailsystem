/**
 * ダイアログの初期設定オブジェクトを持つネームスペース
 */
const companydialogConfig = {
	loginError: {
		autoOpen: false,
		width: 550,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					$(this).dialog('close');
				}
			},
		]
	},
	duplicatedCompanyName: {
		autoOpen: false,
		width: 650,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					$(this).dialog('close');
				}
			},
		]
	},
	inputCompanyError: {
		autoOpen: false,
		width: 650,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					$(this).dialog('close');
				}
			},
		]
	},
	inputCompanyConfirm: {
		autoOpen: false,
		width: 850,
		modal: true,
		buttons: [
			{
				text: '登録',
				click: function() {
					let jsonString = {
						'companyName': $('table#company input[name=companyName]').val(),
						'staffName': $('table#company input[name=staffName]').val(),
						'mailAddress': $('table#company input[name=mailAddress]').val(),
						'companyAddress': $('table#company input[name=companyAddress]').val(),
						'phoneNumber': $('table#company input[name=phoneNumber]').val(),
						
						
								};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/user/register',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						datatype: 'json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						$('.info').removeClass('hidden');
						$('#checkOK').addClass('hidden');
						$('table#company input[name=companyName]').val('');
						$('table#company input[name=staffName]').val('');
						$('table#company input[name=mailAddress]').val('');
						$('table#company input[name=companyAddress]').val('');
						($('table#company input[name=phoneNumber]').val(''));
						
						
						
					}, () => {
						alert('Error: ajax connection failed.');
					});
					$(this).dialog('close');
				}
			},
			{
				text: '戻って修正',
				click: function() {
					$(this).dialog("close");
				}
			},
		]
	},


};



