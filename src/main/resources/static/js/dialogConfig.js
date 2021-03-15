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
						'password': $('table#register input[name=password]').val()
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
		width: 850,
		modal: true,
		buttons: [
			{
				text: '登録',
				click: function() {
					let jsonString = {
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