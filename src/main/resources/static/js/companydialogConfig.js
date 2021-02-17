/**
 * �_�C�A���O�̏����ݒ�I�u�W�F�N�g�����l�[���X�y�[�X
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
				text: '�o�^',
				click: function() {
					let jsonString = {
						'companyName': $('table#register input[name=companyName]').val(),
						'staffName': $('table#register input[name=staffName]').val(),
						'mailAddress': $('table#register input[name=mailAddress]').val(),
						'companyAddress': $('table#register input[name=companyAddress]').val(),
						'phoneNumber': $('table#register input[name=phoneNumber]').val(),
						
						
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
						$('table#register input[name=companyName]').val('');
						$('table#register input[name=staffName]').val('');
						$('table#register input[name=mailAddress]').val('');
						$('table#register input[name=companyAddress]').val('');
						($('table#register input[name=phoneNumber]').val(''));
						
						
						
					}, () => {
						alert('Error: ajax connection failed.');
					});
					$(this).dialog('close');
				}
			},
			{
				text: '�߂��ďC��',
				click: function() {
					$(this).dialog("close");
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
				text: '�o�^',
				click: function() {
					let jsonString = {
						'companyName': $('table#register input[name=companyName]').val(),
						'staffName': $('table#register input[name=staffName]').val(),
						'mailAddress': $('table#register input[name=mailAddress]').val(),
						'companyAddress': $('table#register input[name=companyAddress]').val(),						
						'phoneNumber': $('table#register input[name=phoneNumber]').val(),

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
				text: '�߂��ďC��',
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