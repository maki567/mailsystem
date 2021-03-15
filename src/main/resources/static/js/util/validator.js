/**
 * バリデーション用の定数を持つオブジェクトネームスペース
 */
const validateConstants = {
	ERR_MSG: {
		EMPTY: 'が空欄です。',
		OVER_MAX: 'の文字数が最大値を超えています。',
		UNDER_MIN: 'の文字数が最小値未満です。',
		NOT_ONLY_HIRAGANA: 'に平仮名以外の文字が含まれています。',
		NOT_ONLY_ALPHANUMERIC: 'に半角英数字以外の文字が含まれています。',
		NOT_ONLY_NUMERIC: 'に半角数字以外の文字が含まれています。',
		INVALID_FORMAT: 'の書式が不正です。',
	},
	USER_NAME_MIN: 3,
	USER_NAME_MAX: 32,
	PASSWORD_MIN: 6,
	PASSWORD_MAX: 16,
	
	COMPANY_NAME_MAX: 32,
	COMPANY_ADDRESS_MAX: 64,
	COMPANY_NUMBER_MAX: 16,
	STAFF_NAME_MAX: 16,
	STAFF_MAIL_MAX: 32,
	STAFF_NUMBER_MAX: 16
}

/**
 * バリデーション用の汎用メソッドを持つオブジェクトネームスペース
 */
const validator = {
	// 引数 target が半角英数字か判定する
	isHalfAlphanumeric: (target) => {
		target = (target === null) ? '' : target;
		target = target.trim();
		return target.match(/^[0-9a-zA-Z]+$/);
	},
	// 引数 target がひらがなか判定する
	isHiragana: (target) => {
		target = (target === null) ? '' : target;
		target = target.trim();
		return target.match(/^[ぁ-んー]+$/);
	},
	// 引数 target が空か判定する
	isEmpty: (target) => {
		return target === null || target === '' || typeof target === 'undefined';
	},
	// 引数 target のbyte数が最大値を超えているか判定する
	overMax: (target, max) => {
		if (validator.isEmpty(target)) {
			return false;
		}
//		return bytes(target) > max;
		return target.length > max;
	},
	// 引数 target のbyte数が最小値未満か判定する
	underMin(target, min) {
		if (validator.isEmpty(target)) {
			return true;
		}
//		return bytes(target) < min;
		return target.length < min;
	},
	// 引数 target がメールアドレスの書式か判定する
	isMailAddress: (target) => {
		target = (target === null) ? '' : target;
		return target.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);
	},
	// 引数 target が電話番号の書式か判定する
	isHalfNumeric: (target) => {
		target = (target === null) ? '' : target;
		return target.match(/^[0-9]*$/);
	},
};


/**
 * 汎用バリデーターを使用して各入力項目をチェックし
 * 結果としてエラーメッセージ（Array）を返却するメソッド群のネームスペース
 */
const checker = {
	// ユーザー名（メールアドレス）チェック
	userName: (target) => {
		const title = '「ユーザー名」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.USER_NAME_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.USER_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	password: (target) => {
		const title = '「パスワード」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isHalfAlphanumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_ALPHANUMERIC);
		}
		if (validator.overMax(target, validateConstants.PASSWORD_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		if (validator.underMin(target, validateConstants.PASSWORD_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		return errMsg;
	},
	// 会社名チェック
	companyName: (target) => {
		const title = '「会社名」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.CAMPANY_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 所在地チェック
	companyAddress: (target) => {
		const title = '「所在地」';
		let errMsg = new Array();
		if (validator.overMax(target, validateConstants.COMPANY_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（会社）チェック
	companyNumber: (target) => {
		const title = '「電話番号(会社)」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名1チェック
	staffName1: (target) => {
		const title = '「担当者名1」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）1チェック
	staffMail1: (target) => {
		const title = '「メールアドレス1」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）1チェック
	staffNumber1: (target) => {
		const title = '「電話番号(担当者)1」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名2チェック
	staffName2: (target) => {
		const title = '「担当者名2」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）2チェック
	staffMail2: (target) => {
		const title = '「メールアドレス2」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）2チェック
	staffNumber2: (target) => {
		const title = '「電話番号(担当者)2」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名3チェック
	staffName3: (target) => {
		const title = '「担当者名3」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）3チェック
	staffMail3: (target) => {
		const title = '「メールアドレス3」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）3チェック
	staffNumber3: (target) => {
		const title = '「電話番号(担当者)3」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名4チェック
	staffName4: (target) => {
		const title = '「担当者名4」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）4チェック
	staffMail4: (target) => {
		const title = '「メールアドレス4」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）4チェック
	staffNumber4: (target) => {
		const title = '「電話番号(担当者)4」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名5チェック
	staffName5: (target) => {
		const title = '「担当者名5」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）5チェック
	staffMail5: (target) => {
		const title = '「メールアドレス5」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）5チェック
	staffNumber5: (target) => {
		const title = '「電話番号(担当者)5」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名6チェック
	staffName6: (target) => {
		const title = '「担当者名6」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）6チェック
	staffMail6: (target) => {
		const title = '「メールアドレス6」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）6チェック
	staffNumber6: (target) => {
		const title = '「電話番号(担当者)6」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名7チェック
	staffName7: (target) => {
		const title = '「担当者名7」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）7チェック
	staffMail7: (target) => {
		const title = '「メールアドレス7」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）7チェック
	staffNumber7: (target) => {
		const title = '「電話番号(担当者)7」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名8チェック
	staffName8: (target) => {
		const title = '「担当者名8」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）8チェック
	staffMail8: (target) => {
		const title = '「メールアドレス8」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）8チェック
	staffNumber8: (target) => {
		const title = '「電話番号(担当者)8」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名9チェック
	staffName9: (target) => {
		const title = '「担当者名9」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）9チェック
	staffMail9: (target) => {
		const title = '「メールアドレス9」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）9チェック
	staffNumber9: (target) => {
		const title = '「電話番号(担当者)9」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名10チェック
	staffName10: (target) => {
		const title = '「担当者名10」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, validateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）10チェック
	staffMail10: (target) => {
		const title = '「メールアドレス10」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, validateConstants.MAIL_ADDRESS_MIN)) {
			errMsg.push(title + validateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, validateConstants.MAIL_ADDRESS_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 電話番号（担当者）10チェック
	staffNumber10: (target) => {
		const title = '「電話番号(担当者)10」';
		let errMsg = new Array();
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + validateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, validateConstants.PHONE_NUMBER_MAX)) {
			errMsg.push(title + validateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
}

/**
 * 入力チェックする
 * @param checkerConfig エラーチェック用の設定オブジェクト
 * @returns errInfo　isError:エラーメッセージがあるかないかのフラグ,errMsg：エラーメッセージ
 */
function validate(checkerConfig) {
	// エラー情報オブジェクト
	let errInfo = {
		isError: false,
		errMsg: new Array()
	};
	
	for ([key, value] of Object.entries(checkerConfig)) {
		if (key === 'corporation') {
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
 * エラーメッセージダイアログを作成する
 * @param errMsg エラーメッセージ
 * @returns なし
 */
function createErrorDialog(errMsg) {
	clearErrorDialog();
	
	errMsg.forEach(function(v, i) {
		for ([key, value] of Object.entries(errorSelector)) {
			if (v.indexOf(`「${key}」`) > -1) {
				$(value).removeClass('hidden');
				let s = $(value).html();
				$(value).html(s + v + '<br />');
			}
		}
	});
}

/**
 * エラーメッセージダイアログを初期化する
 * @returns	なし
 */
function clearErrorDialog() {
	for (let value of Object.values(errorSelector)) {
		$(value).html('');
		if (!$(value).hasClass('hidden')) {
			$(value).addClass('hidden');
		}
	}
}