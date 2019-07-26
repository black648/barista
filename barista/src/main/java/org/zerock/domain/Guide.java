package org.zerock.domain;

public class Guide {
/*
 * VO»ý¼º Äõ¸®
	 SELECT 'private '|| decode(A.data_type,'VARCHAR2','String','CLOB','String','DATE','Date','NUMBER','long')|| ' '||lower(A.column_name)||'; //'||B.COMMENTS
	 FROM user_tab_columns A, USER_COL_COMMENTS B
	 WHERE 
		A.TABLE_NAME = B.TABLE_NAME
		AND A.COLUMN_NAME = B.COLUMN_NAME
		AND A.table_name='EDU_APPLICANT_ATTACH' 
	 ORDER BY A.COLUMN_ID;
 */
}

