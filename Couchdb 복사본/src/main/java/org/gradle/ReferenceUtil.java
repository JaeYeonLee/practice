package org.gradle;

import java.util.List;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;

public class ReferenceUtil {

	CloudantClient client;
	Database db;
	
	public ReferenceUtil (String dbName) 
	{
		client = new CloudantClient("http://somareport.cloudant.com", "somareport", "somasoma");
		db = client.database(dbName, true);
	}
	
	List<JsonObject> getMyProjects (String user_id)
    {
        //멘토, 멘티
        //자신이 속한 프로젝트 조회
		return db.view("user_view/all_my_project")
				.key(user_id).includeDocs(true).reduce(false)
				.query(JsonObject.class);
    }

    List<JsonObject> getReports (String project_id)
    {
        //프로젝트에 속한 모든 레포트 조회    
    	return db.view("project_view/all_report")
    			.key(project_id).includeDocs(true).reduce(false)
    			.query(JsonObject.class);
    }
    
    int calTotalMentoring (String project_id) 
    {
    	//프로젝트의 총 멘토링 시간 합
    	JsonObject totalTime = db.view("project_view/calculate_total_time")
    			.key(project_id).includeDocs(false).reduce(true)
    			.query(JsonObject.class).get(0);
    	return totalTime.get("value").getAsInt();
    }

    List<JsonObject> getAllMentor ()
    {
        //사무국
        //모든 멘토 리스트 불러오기
    	return db.view("admin_view/all_docs")
    			.key("mentor").includeDocs(true).reduce(false)
    			.query(JsonObject.class);
    }

    List<JsonObject> getAllMentee ()
    {
        //사무국
        //모든 멘티 리스트 불러오기  
    	return db.view("admin_view/all_docs")
    			.key("mentee").includeDocs(true).reduce(false)
    			.query(JsonObject.class);
    }

    List<JsonObject> getCurrentProjects (int[] current)
    {
        //사무국
        //현재 기수, 단계, 차수에 해당하는 모든 프로젝트 조회
    	return db.view("admin_view/current_project")
    			.key(current).includeDocs(true).reduce(false)
    			.query(JsonObject.class);
    }
}
