/**
 * 
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
				text: 'Confirm',
				click: function() {
					let jsonString = {
						'familyName': $('table#register input[name=familyName]').val(),
						'firstName': $('table#register input[name=firstName]').val(),
						'familyNameKana': $('table#register input[name=familyNameKana]').val(),
						'firstNameKana': $('table#register input[name=firstNameKana]').val(),
						'gender': $('table#register input[name=gender]:checked').val() == '�j��' ? '0' : '1',
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
						$('table#register input[name=familyName]').val('');
						$('table#register input[name=firstName]').val('');
						$('table#register input[name=familyNameKana]').val('');
						$('table#register input[name=firstNameKana]').val('');
						($('table#register input[name=gender]')[0]).checked = true;
						$('table#register input[name=userName]').val('');
						$('table#register input[name=password]').val('');
					}, () => {
						alert('Error: ajax connection failed.');
					});
					$(this).dialog('close');
				}
			},
			{
				text: 'Back',
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
					/* �t�����g�݂̂Ŋ����ł���G���[�`�F�b�N */
					let newPassword = $('table.resetPassword input[name=newPassword]').val();
					let newPasswordConfirm = $('table.resetPassword input[name=newPasswordConfirm]').val();
					let isError = false;
					if (validator.isEmpty(newPassword) || validator.isEmpty(newPassword) ||
							!validator.isHalfAlphanumeric(newPassword) || !validator.isHalfAlphanumeric(newPasswordConfirm) ||
							validator.overMax(newPassword, 16) || validator.overMax(newPasswordConfirm, 16) ||
							validator.underMin(newPassword, 6) || validator.underMin(newPasswordConfirm, 6)) {
						alert('�V�p�X���[�h�A�܂��͐V�p�X���[�h�m�F�̓��͂��s���ł��B');
						$('table.resetPassword input[name=password]').val('');
						$('table.resetPassword input[name=newPassword]').val('');
						$('table.resetPassword input[name=newPasswordConfirm]').val('');
						return;
					}
					
					/* ajax�ł̃G���[�`�F�b�N */
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
						if (result === '�p�X���[�h���Đݒ肳��܂����B') {
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
	inputDestinationConfirm: {
		autoOpen: false,
		width: 850,
		modal: true,
		buttons: [
			{
				text: 'Register',
				click: function() {
					let jsonString = {
						'familyName': $('table#register input[name=familyName]').val(),
						'firstName': $('table#register input[name=firstName]').val(),
						'address': $('table#register input[name=address]').val(),
						'telNumber': $('table#register input[name=telNumber]').val()
					};
					$.ajax({
						type: 'POST',
						url: '/mailsystem/destination/register',
						data: JSON.stringify(jsonString),
						contentType: 'application/json',
						datatype: 'json',
						scriptCharset: 'utf-8'
					})
					.then((result) => {
						alert('�o�^���������܂����B');
						// �o�^�����������猈�Ϗ����������Ȃ�
						settlement(result);
						
					}, () => {
						alert('Error: ajax connection failed.');
					});
					$(this).dialog('close');
				},
			},
			{
				text: 'Back',
				click: function() {
					$(this).dialog("close");
				}
			},
		]
	},
};

/**
 * ���Ϗ����������Ȃ�
 * @param destinationId ������ID
 * @returns �Ȃ�
 */
function settlement(destinationId) {
	$.ajax({
		type: 'POST',
		url: '/mailsystem/settlement/complete',
		data: JSON.stringify({'destinationId': destinationId}),
		datatype: 'json',
		contentType: 'application/json',
	})
	.then((result) => {
		location.replace('/mailsystem/history/');
	}, () => {
		alert('Error: ajax connection failed.');
	});
}

/**
 * �m�F�_�C�A���O���쐬����
 * @param checkerConfig �G���[�`�F�b�N�p�̐ݒ�I�u�W�F�N�g
 * @returns �Ȃ�
 */
function createConfirmDialog(checkerConfig) {
	for ([key, value] of Object.entries(checkerConfig)) {
		let obj = $('table#register input[name=' + key + ']');
		let objConfirm = $('table.confirm span.' + key);
		
		let value = $(obj).val();
		
		if (key === 'gender') {
			value = $('table#register input[name=gender]:checked').val();
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