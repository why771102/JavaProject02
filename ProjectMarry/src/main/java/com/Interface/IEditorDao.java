package com.Interface;

import com.editor.EditorBean;

public interface IEditorDao {
	
	public EditorBean register(EditorBean u);

	public EditorBean updateUserData(EditorBean u);

	public EditorBean userLogin(EditorBean u);
	
	public EditorBean userQuery(String account);
	
	public boolean accountExists(EditorBean u);
	
	public boolean pwdMatch(EditorBean u);

}
