/**
 * バリデーション用の定数を持つオブジェクトネームスペース
 */
const companyvalidateConstants = {
	ERR_MSG: {
		EMPTY: 'が空欄です。',
		OVER_MAX: 'の文字数が最大値を超えています。',
		UNDER_MIN: 'の文字数が最小値未満です。',
		NOT_ONLY_HIRAGANA: 'に平仮名以外の文字が含まれています。',
		NOT_ONLY_ALPHANUMERIC: 'に半角英数字以外の文字が含まれています。',
		NOT_ONLY_NUMERIC: 'に半角数字以外の文字が含まれています。',
		INVALID_FORMAT: 'の書式が不正です。',
	},
	COMPANY_NAME_MAX: 32,
	STAFF_NAME_MAX: 16,
	STAFF_MAIL_MAX: 32,
	COMPANY_ADDRESS_MAX: 32,
	STAFF_PHONE_MAX: 16,

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
		return target.match(/^[0-9]+$/);
	},
};


/**
 * 汎用バリデーターを使用して各入力項目をチェックし
 * 結果としてエラーメッセージ（Array）を返却するメソッド群のネームスペース
 */
const companychecker = {
	// 会社名チェック
	companyName: (target) => {
		const title = '「会社名」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, companyvalidateConstants.CAMPANY_NAME_MAX)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 担当者名チェック
	staffName: (target) => {
		const title = '「担当者名」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, companyvalidateConstants.STAFF_NAME_MAX)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// メールアドレス（担当者）チェック
	mailAddress: (target) => {
		const title = '「メールアドレス」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isMailAddress(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.INVALID_FORMAT);
		}
		if (validator.underMin(target, companyvalidateConstants.STAFF_MAIL_MIN)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.UNDER_MIN);
		}
		if (validator.overMax(target, companyvalidateConstants.STAFF_MAIL_MAX)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},
	// 所在地チェック
	companyAddress: (target) => {
		const title = '「所在地」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.EMPTY);
		}
		if (validator.overMax(target, companyvalidateConstants.COMPANY_ADDRESS_MAX)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.OVER_MAX);
		}
		return errMsg;
	},

	// 電話番号（担当者）チェック
	phoneNumber: (target) => {
		const title = '「電話番号」';
		let errMsg = new Array();
		if (validator.isEmpty(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.EMPTY);
		}
		if (!validator.isHalfNumeric(target)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.NOT_ONLY_NUMERIC);
		}
		if (validator.overMax(target, companyvalidateConstants.STAFF_PHONE_MAX)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.OVER_MAX);
		}
		if (validator.underMin(target, companyvalidateConstants.STAFF_PHONE_MIN)) {
			errMsg.push(title + companyvalidateConstants.ERR_MSG.UNDER_MIN);
		}
		return errMsg;
	},	
}

/**
 * 入力チェックする
 * @param checkerConfig エラーチェック用の設定オブジェクト
 * @returns errInfo isError:エラーメッセージがあるかないかのフラグ,errMsg：エラーメッセージ
 */
function validate(companycheckerConfig) {
	// エラー情報オブジェクト
	let companyerrInfo = {
		isError: false,
		errMsg: new Array()
	};
	
	
		let obj = $('table#company input[name=' + key + ']');
		value($(obj).val()).forEach((v, i) => {
			companyerrInfo.errMsg.push(v);
		});
	}
	
	if (companyerrInfo.errMsg.length > 0) {
		companyerrInfo.isError = true;
	}
	
	return companyerrInfo;


/**
 * エラーメッセージダイアログを作成する
 * @param errMsg エラーメッセージ
 * @returns なし
 */
function createErrorDialog(errMsg) {
	clearErrorDialog();
	
	errMsg.forEach(function(v, i) {
		for ([key, value] of Object.entries(companyerrorSelector)) {
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
	for (let value of Object.values(companyerrorSelector)) {
		$(value).html('');
		if (!$(value).hasClass('hidden')) {
			$(value).addClass('hidden');
		}
	}
}