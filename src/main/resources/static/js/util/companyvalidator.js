/**
 * �o���f�[�V�����p�̒萔�����I�u�W�F�N�g�l�[���X�y�[�X
 */
const companyvalidateConstants = {
	ERR_MSG: {
		EMPTY: '���󗓂ł��B',
		OVER_MAX: '�̕��������ő�l�𒴂��Ă��܂��B',
		UNDER_MIN: '�̕��������ŏ��l�����ł��B',
		NOT_ONLY_HIRAGANA: '�ɕ������ȊO�̕������܂܂�Ă��܂��B',
		NOT_ONLY_ALPHANUMERIC: '�ɔ��p�p�����ȊO�̕������܂܂�Ă��܂��B',
		NOT_ONLY_NUMERIC: '�ɔ��p�����ȊO�̕������܂܂�Ă��܂��B',
		INVALID_FORMAT: '�̏������s���ł��B',
	},
	COMPANY_NAME_MAX: 32,
	STAFF_NAME_MAX: 16,
	STAFF_MAIL_MAX: 32,
	COMPANY_ADDRESS_MAX: 32,
	STAFF_PHONE_MAX: 16,

}

/**
 * �o���f�[�V�����p�̔ėp���\�b�h�����I�u�W�F�N�g�l�[���X�y�[�X
 */
const companyvalidator = {
	// ���� target �����p�p���������肷��
	isHalfAlphanumeric: (target) => {
		target = (target === null) ? '' : target;
		target = target.trim();
		return target.match(/^[0-9a-zA-Z]+$/);
	},
	// ���� target ���Ђ炪�Ȃ����肷��
	isHiragana: (target) => {
		target = (target === null) ? '' : target;
		target = target.trim();
		return target.match(/^[��-��[]+$/);
	},
	// ���� target ���󂩔��肷��
	isEmpty: (target) => {
		return target === null || target === '' || typeof target === 'undefined';
	},
	// ���� target ��byte�����ő�l�𒴂��Ă��邩���肷��
	overMax: (target, max) => {
		if (validator.isEmpty(target)) {
			return false;
		}
//		return bytes(target) > max;
		return target.length > max;
	},
	// ���� target ��byte�����ŏ��l���������肷��
	underMin(target, min) {
		if (validator.isEmpty(target)) {
			return true;
		}
//		return bytes(target) < min;
		return target.length < min;
	},
	// ���� target �����[���A�h���X�̏��������肷��
	isMailAddress: (target) => {
		target = (target === null) ? '' : target;
		return target.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);
	},
	// ���� target ���d�b�ԍ��̏��������肷��
	isHalfNumeric: (target) => {
		target = (target === null) ? '' : target;
		return target.match(/^[0-9]+$/);
	},
};


/**
 * �ėp�o���f�[�^�[���g�p���Ċe���͍��ڂ��`�F�b�N��
 * ���ʂƂ��ăG���[���b�Z�[�W�iArray�j��ԋp���郁�\�b�h�Q�̃l�[���X�y�[�X
 */
const companychecker = {
	// ��Ж��`�F�b�N
	companyName: (target) => {
		const title = '�u��Ж��v';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.CAMPANY_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// �S���Җ��`�F�b�N
	staffName: (target) => {
		const title = '�u�S���Җ��v';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// ���[���A�h���X�i�S���ҁj�`�F�b�N
	mailAddress: (target) => {
		const title = '�u���[���A�h���X�v';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.STAFF_MAIL_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.STAFF_MAIL_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// ���ݒn�`�F�b�N
	companyAddress: (target) => {
		const title = '�u���ݒn�v';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.COMPANY_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},

	// �d�b�ԍ��i�S���ҁj�`�F�b�N
	phoneNumber: (target) => {
		const title = '�u�d�b�ԍ��v';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.STAFF_PHONE_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		if (validator.underMin(target, validateConstants.STAFF_PHONE_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		return errMsg;
	},	
}

/**
 * ���̓`�F�b�N����
 * @param checkerConfig �G���[�`�F�b�N�p�̐ݒ�I�u�W�F�N�g
 * @returns errInfo isError:�G���[���b�Z�[�W�����邩�Ȃ����̃t���O,errMsg�F�G���[���b�Z�[�W
 */
function validate(checkerConfig) {
	// �G���[���I�u�W�F�N�g
	let errInfo = {
		isError: false,
		errMsg: new Array()
	};
	
	for ([key, value] of Object.entries(checkerConfig)) {
		if (key === 'gender') {
			continue;
		}
		let obj = $('table#register input[name=' + key + ']');
		value($(obj).val()).forEach((v, i) => {
			errInfo.errMsg.push(v);
		});
	}
	
	if (errInfo.errMsg.length > 0) {
		errInfo.isError = true;
	}
	
	return errInfo;
}

/**
 * �G���[���b�Z�[�W�_�C�A���O���쐬����
 * @param errMsg �G���[���b�Z�[�W
 * @returns �Ȃ�
 */
function createErrorDialog(errMsg) {
	clearErrorDialog();
	
	errMsg.forEach(function(v, i) {
		for ([key, value] of Object.entries(companyerrorSelector)) {
			if (v.indexOf(`�u${key}�v`) > -1) {
				$(value).removeClass('hidden');
				let s = $(value).html();
				$(value).html(s + v + '<br />');
			}
		}
	});
}

/**
 * �G���[���b�Z�[�W�_�C�A���O������������
 * @returns	�Ȃ�
 */
function clearErrorDialog() {
	for (let value of Object.values(companyerrorSelector)) {
		$(value).html('');
		if (!$(value).hasClass('hidden')) {
			$(value).addClass('hidden');
		}
	}
}