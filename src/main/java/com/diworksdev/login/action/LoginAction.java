/*JSPからのページ要求に対して一番最初に実行されるファイル
DB接続の時はDAOを呼び出す
DTOから情報を受け取って処理、表示画面へ渡す*/

package com.diworksdev.login.action;
import java.sql.SQLException;

import com.diworksdev.login.dao.LoginDAO;
import com.diworksdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	//フィールド変数はJSPの定義と同じ名前にする
	private String name;
	private String password;
	
	public String execute() throws SQLException{
		String ret=ERROR;
		
		LoginDAO dao=new LoginDAO();
		LoginDTO dto=new LoginDTO();
		
		//情報をDAOとDTOとやりとりする
		dto=dao.select(name,password);
		
		//ユーザーが入力した値が正しいかどうかを判断する
		if(name.equals(dto.getName())) {
			if(password.equals(dto.getPassword())) {
				ret=SUCCESS;
			}
		}
		return ret;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

}
