/**
 * ダイアログの初期設定オブジェクトを持つネームスペース
 */
const dialogConfig = {
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
	duplicatedUserName: {
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
	inputUserError: {
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
	inputUserConfirm: {
		autoOpen: false,
		width: 850,
		modal: true,
		buttons: [
			{
				text: '登録',
				click: function() {
					let jsonString = {
						'userName': $('table#register input[name=userName]').val(),
						'password': $('table#register input[name=password]').val(),
						'signature': $('table#register input[name=signature]').val()
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
						$('table#register input[name=userName]').val('');
						$('table#register input[name=password]').val('');
						$('table#register input[name=signature]').val('');
					}, () => {
						alert('Error: ajax connection failed.');
					});
					$(this).dialog('close');
					location.replace('/mailsystem/login/');
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
	resetPassword: {
		autoOpen: false,
		width: 750,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					/* フロントのみで完結できるエラーチェック */
					let newPassword = $('table.resetPassword input[name=newPassword]').val();
					let newPasswordConfirm = $('table.resetPassword input[name=newPasswordConfirm]').val();
					let isError = false;
					if (validator.isEmpty(newPassword) || validator.isEmpty(newPassword) ||
							!validator.isHalfAlphanumeric(newPassword) || !validator.isHalfAlphanumeric(newPasswordConfirm) ||
							validator.overMax(newPassword, 16) || validator.overMax(newPasswordConfirm, 16) ||
							validator.underMin(newPassword, 6) || validator.underMin(newPasswordConfirm, 6)) {
						alert('新パスワード、または新パスワード確認の入力が不正です。');
						$('table.resetPassword input[name=password]').val('');
						$('table.resetPassword input[name=newPassword]').val('');
						$('table.resetPassword input[name=newPasswordConfirm]').val('');
						return;
					}
					
					/* ajaxでのエラーチェック */
					let jsonString = {
								'userName': $('table.resetPassword span').text(),
								'password': $('table.resetPassword input[name=password]').val(),
								'newPassword': newPassword,
								'newPasswordConfirm': newPasswordConfirm
					};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/auth/resetPassword',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						alert(result);
						$('table.resetPassword input[name=password]').val('');
						$('table.resetPassword input[name=newPassword]').val('');
						$('table.resetPassword input[name=newPasswordConfirm]').val('');
						if (result === 'パスワードが再設定されました。') {
							let asters = '';
							for (let i = 0; i < newPassword.length; i ++) {
								asters += '*';
							}
							$('span.password').text(asters);
							$(this).dialog('close');
						}
					}, () => {
						alert('Error: ajax connection failed.');
						$(this).dialog('close');
					});
				}
			},
		]
	},
		
	
		electronicSignature: {
		autoOpen: false,
		width: 750,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					let jsonString = {
						'signature': $('table#update textarea[name=signature]').val(),
						'id': $('table#update textarea[name=id]').val(),
								};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/home/update',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						datatype: 'json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						$('table#update textarea[name=signature]').val('');
						$('table#update textarea[name=id]').val('');
					}, () => {
						alert('Error: ajax connection failed.');
					});
					alert('電子署名が変更されました。');
					$(this).dialog('close');
				}
			},
		]
	},
	
	
	inputDestinationError: {
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
		width: 800,
		height: 600,
		modal: true,
		buttons: [
			{
				text: '登録',
				click: function() {
					let jsonString = {
						'userId': $('table#register input[name=userId]').val(),
						'companyName': $('table#register input[name=companyName]').val(),
						'companyAddress': $('table#register input[name=companyAddress]').val(),
						'corporation': $('table#register input[name=corporation]:checked').val() == '前株' ? '0' : '1',
						'companyNumber': $('table#register input[name=companyNumber]').val(),
						'staffName1': $('table#register input[name=staffName1]').val(),
						'staffMail1': $('table#register input[name=staffMail1]').val(),
						'staffNumber1': $('table#register input[name=staffNumber1]').val(),
						'staffName2': $('table#register input[name=staffName2]').val(),
						'staffMail2': $('table#register input[name=staffMail2]').val(),
						'staffNumber2': $('table#register input[name=staffNumber2]').val(),
						'staffName3': $('table#register input[name=staffName3]').val(),
						'staffMail3': $('table#register input[name=staffMail3]').val(),
						'staffNumber3': $('table#register input[name=staffNumber3]').val(),
						'staffName4': $('table#register input[name=staffName4]').val(),
						'staffMail4': $('table#register input[name=staffMail4]').val(),
						'staffNumber4': $('table#register input[name=staffNumber4]').val(),
						'staffName5': $('table#register input[name=staffName5]').val(),
						'staffMail5': $('table#register input[name=staffMail5]').val(),
						'staffNumber5': $('table#register input[name=staffNumber5]').val(),
						'staffName6': $('table#register input[name=staffName6]').val(),
						'staffMail6': $('table#register input[name=staffMail6]').val(),
						'staffNumber6': $('table#register input[name=staffNumber6]').val(),
						'staffName7': $('table#register input[name=staffName7]').val(),
						'staffMail7': $('table#register input[name=staffMail7]').val(),
						'staffNumber7': $('table#register input[name=staffNumber7]').val(),
						'staffName8': $('table#register input[name=staffName8]').val(),
						'staffMail8': $('table#register input[name=staffMail8]').val(),
						'staffNumber8': $('table#register input[name=staffNumber8]').val(),
						'staffName9': $('table#register input[name=staffName9]').val(),
						'staffMail9': $('table#register input[name=staffMail9]').val(),
						'staffNumber9': $('table#register input[name=staffNumber9]').val(),
						'staffName10': $('table#register input[name=staffName10]').val(),
						'staffMail10': $('table#register input[name=staffMail10]').val(),
						'staffNumber10': $('table#register input[name=staffNumber10]').val(),
								};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/address/register',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						datatype: 'json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						$('.info').removeClass('hidden');
						$('#checkOK').addClass('hidden');
						$('table#register input[name=userId]').val('');
						$('table#register input[name=companyName]').val('');
						$('table#register input[name=companyAddress]').val('');
						($('table#register input[name=corporation]')[0]).checked = true;
						$('table#register input[name=companyNumber]').val('');
						$('table#register input[name=staffName1]').val('');
						$('table#register input[name=staffMail1]').val('');
						$('table#register input[name=staffNumber1]').val('');
						$('table#register input[name=staffName2]').val('');
						$('table#register input[name=staffMail2]').val('');
						$('table#register input[name=staffNumber2]').val('');
						$('table#register input[name=staffName3]').val('');
						$('table#register input[name=staffMail3]').val('');
						$('table#register input[name=staffNumber3]').val('');
						$('table#register input[name=staffName4]').val('');
						$('table#register input[name=staffMail4]').val('');
						$('table#register input[name=staffNumber4]').val('');
						$('table#register input[name=staffName5]').val('');
						$('table#register input[name=staffMail5]').val('');
						$('table#register input[name=staffNumber5]').val('');
						$('table#register input[name=staffName6]').val('');
						$('table#register input[name=staffMail6]').val('');
						$('table#register input[name=staffNumber6]').val('');
						$('table#register input[name=staffName7]').val('');
						$('table#register input[name=staffMail7]').val('');
						$('table#register input[name=staffNumber7]').val('');
						$('table#register input[name=staffName8]').val('');
						$('table#register input[name=staffMail8]').val('');
						$('table#register input[name=staffNumber8]').val('');
						$('table#register input[name=staffName9]').val('');
						$('table#register input[name=staffMail9]').val('');
						$('table#register input[name=staffNumber9]').val('');
						$('table#register input[name=staffName10]').val('');
						$('table#register input[name=staffMail10]').val('');
						$('table#register input[name=staffNumber10]').val('');
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
	daleteAddressConfirm: {
		autoOpen: false,
		width: 650,
		modal: true,
		buttons: [
			{
				text: '削除',
				click: function() {
					
					let checkedList = $('.checkList:checked');
					let checkedIdList = [];
					for (checked of checkedList) {
						checkedIdList.push($(checked).val());
					}
					deleteAddress(checkedList,checkedIdList);
					
					function deleteAddress(checkedList, checkedIdList){
					$.ajax({
						type: 'POST',
						url: '/mailsystem/list/delete',
						data: JSON.stringify({'checkedIdList' : checkedIdList}),
						detatype: 'json',
						contentType: 'application/json',
					})
	
					.then((result) => {
						for (checked of checkedList) {
							$(checked).parent().parent().remove();
							}
					}, () => {
					alert('Error: ajax connection failed.');
					});
					}
					$(this).dialog("close");
					// jQuery-UIダイアログの初期設定
					$('#completeDeleteAddress').dialog(dialogConfig.completeDeleteAddress);
					$("#completeDeleteAddress").dialog("open");
					}
				},
			{
				text: 'キャンセル',
				click: function() {
					$(this).dialog('close');
				}
			},
		]
	},
	completeDeleteAddress: {
		autoOpen: false,
		width: 650,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					location.reload(true)
				}
			},
		]
	},
	updateCompanyConfirm: {
		autoOpen: false,
		width: 800,
		height: 600,
		modal: true,
		buttons: [
			{
				text: '登録',
				click: function() {
					let jsonString = {
						'id': $('table#register input[name=id]').val(),
						'companyName': $('table#register input[name=companyName]').val(),
						'companyAddress': $('table#register input[name=companyAddress]').val(),
						'corporation': $('table#register input[name=corporation]:checked').val() == '前株' ? '0' : '1',
						'companyNumber': $('table#register input[name=companyNumber]').val(),
						'staffName1': $('table#register input[name=staffName1]').val(),
						'staffMail1': $('table#register input[name=staffMail1]').val(),
						'staffNumber1': $('table#register input[name=staffNumber1]').val(),
						'staffName2': $('table#register input[name=staffName2]').val(),
						'staffMail2': $('table#register input[name=staffMail2]').val(),
						'staffNumber2': $('table#register input[name=staffNumber2]').val(),
						'staffName3': $('table#register input[name=staffName3]').val(),
						'staffMail3': $('table#register input[name=staffMail3]').val(),
						'staffNumber3': $('table#register input[name=staffNumber3]').val(),
						'staffName4': $('table#register input[name=staffName4]').val(),
						'staffMail4': $('table#register input[name=staffMail4]').val(),
						'staffNumber4': $('table#register input[name=staffNumber4]').val(),
						'staffName5': $('table#register input[name=staffName5]').val(),
						'staffMail5': $('table#register input[name=staffMail5]').val(),
						'staffNumber5': $('table#register input[name=staffNumber5]').val(),
						'staffName6': $('table#register input[name=staffName6]').val(),
						'staffMail6': $('table#register input[name=staffMail6]').val(),
						'staffNumber6': $('table#register input[name=staffNumber6]').val(),
						'staffName7': $('table#register input[name=staffName7]').val(),
						'staffMail7': $('table#register input[name=staffMail7]').val(),
						'staffNumber7': $('table#register input[name=staffNumber7]').val(),
						'staffName8': $('table#register input[name=staffName8]').val(),
						'staffMail8': $('table#register input[name=staffMail8]').val(),
						'staffNumber8': $('table#register input[name=staffNumber8]').val(),
						'staffName9': $('table#register input[name=staffName9]').val(),
						'staffMail9': $('table#register input[name=staffMail9]').val(),
						'staffNumber9': $('table#register input[name=staffNumber9]').val(),
						'staffName10': $('table#register input[name=staffName10]').val(),
						'staffMail10': $('table#register input[name=staffMail10]').val(),
						'staffNumber10': $('table#register input[name=staffNumber10]').val(),
								};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/edit/update',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						datatype: 'json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						$('.info').removeClass('hidden');
						$('#checkOK').addClass('hidden');
						$('table#register input[name=id]').val('');
						$('table#register input[name=companyName]').val('');
						$('table#register input[name=companyAddress]').val('');
						($('table#register input[name=corporation]')[0]).checked = true;
						$('table#register input[name=companyNumber]').val('');
						$('table#register input[name=staffName1]').val('');
						$('table#register input[name=staffMail1]').val('');
						$('table#register input[name=staffNumber1]').val('');
						$('table#register input[name=staffName2]').val('');
						$('table#register input[name=staffMail2]').val('');
						$('table#register input[name=staffNumber2]').val('');
						$('table#register input[name=staffName3]').val('');
						$('table#register input[name=staffMail3]').val('');
						$('table#register input[name=staffNumber3]').val('');
						$('table#register input[name=staffName4]').val('');
						$('table#register input[name=staffMail4]').val('');
						$('table#register input[name=staffNumber4]').val('');
						$('table#register input[name=staffName5]').val('');
						$('table#register input[name=staffMail5]').val('');
						$('table#register input[name=staffNumber5]').val('');
						$('table#register input[name=staffName6]').val('');
						$('table#register input[name=staffMail6]').val('');
						$('table#register input[name=staffNumber6]').val('');
						$('table#register input[name=staffName7]').val('');
						$('table#register input[name=staffMail7]').val('');
						$('table#register input[name=staffNumber7]').val('');
						$('table#register input[name=staffName8]').val('');
						$('table#register input[name=staffMail8]').val('');
						$('table#register input[name=staffNumber8]').val('');
						$('table#register input[name=staffName9]').val('');
						$('table#register input[name=staffMail9]').val('');
						$('table#register input[name=staffNumber9]').val('');
						$('table#register input[name=staffName10]').val('');
						$('table#register input[name=staffMail10]').val('');
						$('table#register input[name=staffNumber10]').val('');
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
	createMailConfilm: {
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
	selectAddress: {
		autoOpen: true,
		width: 1200,
		modal: true,
		buttons: [
			{
				text: 'OK',
				click: function() {
					location.reload(true)
				}
			},
		]
	},
};


/**
 * 確認ダイアログを作成する
 * @param checkerConfig エラーチェック用の設定オブジェクト
 * @returns なし
 */
function createConfirmDialog(checkerConfig) {
	for ([key, value] of Object.entries(checkerConfig)) {
		let obj = $('table#register input[name=' + key + ']');
		let objConfirm = $('table.confirm span.' + key);
		
		let value = $(obj).val();
		
		if (key === 'companyName') {
			value = $('table#register input[name=corporation]:checked').val() 
						== '前株' ? "株式会社 " + $('table#register input[name=companyName]').val() : $('table#register input[name=companyName]').val() + " 株式会社"
		}
		if (key === 'corporation') {
			value = $('table#register input[name=corporation]:checked').val();
		}
		if (key === 'password') {
			let tmpValue = '';
			for (let i = 0; i < value.length; i ++) {
				tmpValue += '*';
			}
			value = tmpValue;
		}
		
		$(objConfirm).html(value);
	}
	
}