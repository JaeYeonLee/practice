#SOMA Report DB api 

Couchdb-java api 

- [cloudant-couchdb link](https://somareport.cloudant.com/dashboard.html)
   - password: somasoma
- Document model
- Design documents
- Methods



##Document model
---

####mentor
	{
	  "_id": "00ba0ab1632c9538faecce5087e30e42",
	  "_rev": "2-ff28f701ac2899e018d84a0ecef41150",
	  "type": "mentor",
	  "name": "김태완",
	  "section": "web",
	  "belong": "Oracle",
	  "birth_date": [
	    1974,
	    5,
	    4
	  ],
	  "phone_num": "010-0000-0000",
	  "account": "okcode@gmail.com"
	}

key: _id, type, account


####mentee
	{
	  "_id": "91d6d79e630bcd52ba25829a334ed457",
	  "_rev": "3-2148c0c5db62ff68a4d90a0d99de3e11",
	  "type": "mentee",
	  "name": "이재연",
	  "year": 2015,	
	  "sex": "female",
	  "birth_date": [
	    1990,
	    7,
	    13
	  ],
	  "belong": "Ewha Womans univ.",
	  "phone_num": "010-0000-0000",
	  "account": "jyegglee@gmail.com"
	  "project_list": []
	}

key: _id, type, year, account

####project
	{
	  "_id": "91d6d79e630bcd52ba25829a3357c520",
	  "_rev": "2-c184eea6e20885cd31b97fa085c4c8ac",
	  "type": "project",
	  "project_type": "regular",
	  "stage": [
	    6,
	    1,
	    1
	  ],
	  "field": "web, mobile",
	  "title": "SOMA Report System",
	  "mentor": "00ba0ab1632c9538faecce5087e30e42",
	  "mentee": [
	    "91d6d79e630bcd52ba25829a334ed457",
	    "",
	    ""
	  ]
	}

####report

	 {
	  "_id": "5e9f05f667364abba459f06cdabc3b05",
		  "_rev": "1-2bf7013eff5de91d47cf3951624e3533",
	  "type": "report",
	  "project": "91d6d79e630bcd52ba25829a3357c520",
	  "report_info": {
	    "mentoring_num": 1,
	    "date": "2015-07-20",
	    "place": "aram7-8",
	    "start_time": [
	      2015,
	      7,
	      20,
	      18,
	      0
	    ],
	    "end_time": [
	      2015,
	      7,
	      20,
	      23,
	      0
	    ],
	    "whole_time": 4,
	    "excep_time": 0,
	    "total_time": 0
	  },
	  "attendance": [
	    {
	      "id": "91d6d79e630bcd52ba25829a334ed457",
	      "attend": false,
	      "absense_reason": "family"
	    },
	    {
	      "id": "0eb343a9a9f608c3f227cac5224ce611",
	      "attend": true
	    },
	    {
	      "id": "00ba0ab1632c9538faecce5087e41201",
	      "attend": true
	    }
	  ],
	  "report_details": {
	    "topic": "주제",
	    "goal": "향후계획",
	    "issue": "추진내용",
	    "opinion": "의견"
	  },
	  "report_attachments": {
	    "photo": "linklinklink",
	    "reference": "refrefref"
	  }
	}

##Design documents
---




##methods
---

####insertDoc(String fileName) : String


- 멘토, 멘티에 해당하는 fileName(json 파일명)을 입력받아 해당 json document를 couchdb에 넣는다 (PUT request)

- 저장된 document의 _id값을 리턴 (UUID)

- 추가예정
  - 엑셀을 json으로 변환하여 멘토, 멘티의 모든 인적정보를 한번에 저장할 수 있도록 한다 ([excel2json](https://github.com/coolengineer/excel2json) 등 활용)
  - json파일 parsing 조건에 "" 추가
  - 이름 중복 체크 (이름 검색 view에서 검색하여 중복시 기존/신규 document에 {"overlap":"_alphabet"} 추가)


####viewAllLists() : boolean

- 소속된 모든 멘토, 멘티의 이름 및 속성이 포함된 리스트 출력

- 추가예정
   - 멘토, 멘티의 각 속성에 따른 분류/정렬 기능 (query조건으로 넣기)
   - 각 구성원이 포함된and현재 진행중인 프로젝트 함께 나열
   - 멘토의 경우 총 멘토링 시간 합산하여 표시


####viewMyProjects(String) : List<JsonObject>

- 사용자 계정 정보를 받아 현재 사용자가 속한 프로젝트 리스트 리턴

- 추가예정
   - 계정 정보는 무엇으로? (현재는 name -> UUID)
   - 프로젝트의 현재 상태(진행중/종료/대기 등) 정보


####insertProjectInfo() : String



####insertReport() : String







ㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹ

#제목 
####그냥쓰고
---


